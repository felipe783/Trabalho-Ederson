package Sistema;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeArquivos {
    private static final String CAMINHO_ARQUIVO = "usuarios.dat";

    // =====================================================
    // SALVAR
    // =====================================================
    public static void salvarUsuarios(List<Usuario> usuarios, int ultimoId) {
        File arquivo = new File(CAMINHO_ARQUIVO);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeInt(ultimoId);
            oos.writeObject(new ArrayList<>(usuarios));
            oos.flush();

            System.out.println("✅ Dados salvos com sucesso em: " + arquivo.getAbsolutePath());
            System.out.println("   Total de usuários: " + usuarios.size());
        } catch (IOException e) {
            System.err.println("❌ Erro ao salvar usuários: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // =====================================================
    // CARREGAR
    // =====================================================
    @SuppressWarnings("unchecked")
    public static int carregarUsuarios(List<Usuario> destino) {
        File arquivo = new File(CAMINHO_ARQUIVO);
        if (!arquivo.exists()) {
            System.out.println("⚠️ Nenhum arquivo encontrado ainda. Será criado em: " + arquivo.getAbsolutePath());
            return 0;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            int ultimoId = ois.readInt();
            Object obj = ois.readObject();

            if (obj instanceof List<?>) {
                destino.clear();
                destino.addAll((List<Usuario>) obj);
            }

            System.out.println("✅ Dados carregados de: " + arquivo.getAbsolutePath());
            System.out.println("   Usuários carregados: " + destino.size());
            return ultimoId;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("❌ Erro ao carregar usuários: " + e.getMessage());
            e.printStackTrace();
            return 0;
        }
    }
}
