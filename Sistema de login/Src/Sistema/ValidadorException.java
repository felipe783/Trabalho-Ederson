package Sistema;

import CPF.ValidadorCPF;

import java.util.ArrayList;
import java.util.List;

import static Sistema.Cadastro.usuarios;

public class ValidadorException {

    public static boolean cpfJaExiste(String cpf) {
        String novo = cpf.replaceAll("\\D", "");
        return usuarios.stream()
                .map(u -> u.getCpf().replaceAll("\\D", ""))
                .anyMatch(c -> c.equals(novo));
    }


    public static void validarCampos(String nome, String email, String senha, String cpf, String telefone, String endereco) {
        List<String> erros = new ArrayList<>();

        if (nome == null || nome.isBlank())
            erros.add("O nome não pode estar vazio.");

        if (email == null || email.isBlank() || !email.contains("@") || !email.contains("."))
            erros.add("Email inválido.");

        if (senha == null || senha.length() < 6)
            erros.add("A senha deve ter pelo menos 6 caracteres.");

        if (cpf == null || cpf.isBlank() || !ValidadorCPF.isValidCPF(cpf) || cpfJaExiste(cpf))
            erros.add("CPF Inválido|CPF já cadastrado.");

        if (telefone == null || telefone.isBlank())
            erros.add("O telefone não pode estar vazio.");

        if (endereco == null || endereco.isBlank())
            erros.add("O endereço não pode estar vazio.");

        if (!erros.isEmpty()) {
            StringBuilder sb = new StringBuilder("Foram encontrados os seguintes erros:\n");
            for (String e : erros) sb.append("- ").append(e).append("\n");
            throw new IllegalArgumentException(sb.toString());
        }
    }
}