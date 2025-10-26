package ListaUsuarios;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeArquivos {

    private static final String CAMINHO_ARQUIVO = "usuarios.dat";

    // Salva a lista de usuários no arquivo binário
    public static void salvarUsuarios(List<Usuario> usuarios) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CAMINHO_ARQUIVO))) {
            oos.writeObject(usuarios);
            System.out.println("✅ Usuários salvos com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar usuários: " + e.getMessage());
        }
    }

    // Carrega os usuários do arquivo binário (se existir)
    @SuppressWarnings("unchecked")
    public static List<Usuario> carregarUsuarios() {
        File arquivo = new File(CAMINHO_ARQUIVO);

        if (!arquivo.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (List<Usuario>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar usuários: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}