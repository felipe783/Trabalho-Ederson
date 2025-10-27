import java.io.*;
import java.util.List;

public class GerenciadorDeArquivos {

    private static final String CAMINHO_ARQUIVO = "usuarios.dat";

    /**
     * Salva a lista de usuários e o último ID no arquivo.
     * @param usuarios A lista de usuários a ser salva.
     * @param ultimoId O último ID de usuário gerado.
     */
    public static void salvarUsuarios(List<Usuario> usuarios, int ultimoId) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CAMINHO_ARQUIVO))) {
            oos.writeObject(usuarios);
            oos.writeObject(ultimoId);
        } catch (IOException e) {
            System.out.println("Erro ao salvar usuários: " + e.getMessage());
        }
    }

    /**
     * Carrega os usuários do arquivo para dentro da lista fornecida.
     * @param usuarios A lista (geralmente vazia) que será populada com os dados.
     * @return O último ID de usuário lido do arquivo.
     */
    @SuppressWarnings("unchecked") // Necessário para o casting da lista
    public static int carregarUsuarios(List<Usuario> usuarios) {
        int idCarregado = 0; // Valor padrão caso o arquivo não exista

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CAMINHO_ARQUIVO))) {
            Object objLista = ois.readObject();
            Object objId = ois.readObject();

            if (objLista instanceof List) {
                usuarios.clear(); // Limpa a lista estática vazia
                usuarios.addAll((List<Usuario>) objLista); // Adiciona os usuários carregados
            }
            if (objId instanceof Integer) {
                idCarregado = (Integer) objId; // Restaura o último ID
            }

        } catch (FileNotFoundException e) {
            System.out.println("Nenhum cadastro anterior encontrado. Iniciando novo.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar usuários: " + e.getMessage());
        }

        return idCarregado; // Retorna o ID
    }
}