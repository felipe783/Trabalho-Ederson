package Sistema;

import CPF.ValidadorCPF;
import FormatTelefone.Formatador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cadastro {
    // =============================
    //    Constantes e atributos
    // =============================
    private static final List<Usuario> usuarios = new ArrayList<>();
    private static int ultimoId = GerenciadorDeArquivos.carregarUsuarios(usuarios);

    private static final String ADM_USER = "admin";
    private static final String ADM_PASS = "1234";

    // =============================
    //              MAIN
    // =============================
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            exibirMenuPrincipal(input);
        }
    }

    // =============================
    //         Menu Principal
    // =============================
    private static void exibirMenuPrincipal(Scanner input) {
        boolean sair = false;
        while (!sair) {
            mostrarMenu();
            System.out.print("Escolha uma opção: ");
            String opcao = input.nextLine().trim();

            switch (opcao) {
                case "1" -> cadastrarUsuario(input);
                case "2" -> acessarSite(input);
                case "3" -> acessarAdm(input);
                case "0" -> {
                    sair = true;
                    GerenciadorDeArquivos.salvarUsuarios(usuarios, ultimoId);
                    System.out.println("Saindo...");
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n=== MENU PRINCIPAL ===");
        System.out.println("1 - Cadastrar usuário");
        System.out.println("2 - Acessar o site");
        System.out.println("3 - Sistema ADM");
        System.out.println("0 - Sair");
    }

    // =============================
    //            Menu ADM
    // =============================
    private static void mostrarMenuADM() {
        System.out.println("\n=== MENU ADM ===");
        System.out.println("1 - Listar usuários");
        System.out.println("2 - Buscar usuário por ID");
        System.out.println("3 - Remover usuário por ID");
        System.out.println("0 - Voltar");
    }

    private static void adm(Scanner input) {
        boolean sairADM = false;
        while (!sairADM) {
            mostrarMenuADM();
            System.out.print("Escolha uma opção: ");
            String opcao = input.nextLine().trim();

            switch (opcao) {
                case "1" -> listarUsuarios();
                case "2" -> buscarPorId(input);
                case "3" -> removerPorId(input);
                case "0" -> {
                    sairADM = true;
                    System.out.println("Voltando ao menu principal...");
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    // =============================
    //     Menu Site / Hospedagem
    // =============================
    private static void mostrarMenuHospedagem() {
        System.out.println("\n=== MENU HOSPEDAGEM ===");
        System.out.println("1 - Quartos Disponíveis");
        System.out.println("2 - Reservas");
        System.out.println("3 - Cancelar Reservas");
        System.out.println("0 - Voltar");
    }

    private static void site(Scanner input) {
        boolean sair = false;
        mostrarMenuHospedagem();
        while (!sair) {
            System.out.print("Escolha uma opção: ");
            String opcao = input.nextLine().trim();

            if (opcao.equals("0")) {
                sair = true;
            }
            /*switch (opcao) {
                case "1" -> quartos(input);
                case "2" -> reservas(input);
                case "3" -> cancelarReservas(input);
                case "0" -> {
                    sair = true;
                    Sistema.GerenciadorDeArquivos.salvarUsuarios(usuarios, ultimoId);
                    System.out.println("Saindo...");
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }*/
        }
    }

    // =============================
    //         Autenticação
    // =============================
    private static void acessarAdm(Scanner input) {
        System.out.println("\n--- LOGIN ADM ---");

        System.out.print("Usuário: ");
        String usuario = input.nextLine().trim();

        System.out.print("Senha: ");
        String senha = input.nextLine().trim();

        if (autenticarAdm(usuario, senha)) {
            System.out.println("Login bem-sucedido! Acessando o menu ADM...");
            adm(input);
        } else {
            System.out.println("Usuário ou senha incorretos. Acesso negado.");
        }
    }

    private static boolean autenticarAdm(String usuario, String senha) {
        return ADM_USER.equals(usuario) && ADM_PASS.equals(senha);
    }

    private static void acessarSite(Scanner input) {
        System.out.println("\n--- LOGIN SITE ---");

        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado. Cadastre-se primeiro!");
            return;
        }

        System.out.print("Nome de usuário: ");
        String nome = input.nextLine().trim();

        System.out.print("Senha: ");
        String senha = input.nextLine().trim();

        if (autenticadorLogin(nome, senha)) {
            System.out.println("Login bem-sucedido! Bem-vindo/a, " + nome + "!");
            site(input);
        } else {
            System.out.println("Usuário ou senha incorretos.");
        }
    }

    private static boolean autenticadorLogin(String usuario, String senha) {
        for (Usuario u : usuarios) {
            if (u.getNome().equalsIgnoreCase(usuario) && u.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }

    // =============================
    //      Sistema.Cadastro de Usuário
    // =============================
    private static void cadastrarUsuario(Scanner input) {
        System.out.println("\n--- CADASTRO ---");
        try {
            System.out.print("Nome: ");
            String nome = input.nextLine().trim();

            System.out.print("Email: ");
            String email = input.nextLine().trim();

            System.out.print("Senha: ");
            String senha = input.nextLine().trim();
            if (senha.isEmpty()) {
                System.out.println("A senha não pode ser vazia. Sistema.Cadastro cancelado.");
                return;
            }

            String cpf;
            while (true) {
                System.out.print("CPF (somente números ou pontuação): ");
                cpf = input.nextLine().trim();
                if (ValidadorCPF.isValidCPF(cpf)) {
                    cpf = cpf.replaceAll("\\D", "");
                    break;
                } else {
                    System.out.println("CPF inválido. Tentar novamente? (s/n)");
                    String r = input.nextLine().trim().toLowerCase();
                    if (!r.equals("s") && !r.equals("sim")) {
                        System.out.println("Sistema.Cadastro cancelado.");
                        return;
                    }
                }
            }

            String telefone;
            while (true) {
                System.out.print("Telefone (somente números): ");
                telefone = input.nextLine().trim();
                String numeroLimpo = telefone.replaceAll("\\D", "");
                if (numeroLimpo.length() == 10 || numeroLimpo.length() == 11) {
                    telefone = Formatador.formatarTelefone(numeroLimpo);
                    break;
                } else {
                    System.out.println("Telefone inválido. Tentar novamente? (s/n)");
                    String r = input.nextLine().trim().toLowerCase();
                    if (!r.equals("s") && !r.equals("sim")) {
                        System.out.println("Sistema.Cadastro cancelado.");
                        return;
                    }
                }
            }

            System.out.print("Endereço: ");
            String endereco = input.nextLine().trim();

            Usuario u = new Usuario(0, nome, email, senha, ValidadorCPF.formatCPF(cpf), telefone, endereco);
            int novoId = ++ultimoId;
            u.setId(novoId);

            usuarios.add(u);
            GerenciadorDeArquivos.salvarUsuarios(usuarios, ultimoId);

            System.out.println("Usuário cadastrado com sucesso! ID = " + novoId);

        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
            System.out.println("Voltando ao menu principal...");
        }
    }

    // =============================
    //  Operações de Administração
    // =============================
    private static void listarUsuarios() {
        System.out.println("\n--- LISTA DE USUÁRIOS ---");

        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }

        for (Usuario u : usuarios) {
            System.out.println("ID: " + u.getId() +
                    " | Nome: " + u.getNome() +
                    " | Email: " + u.getEmail() +
                    " | Telefone: " + u.getTelefone());
        }
    }

    private static void buscarPorId(Scanner input) {
        System.out.print("Informe o ID do usuário: ");
        String linha = input.nextLine().trim();
        try {
            int id = Integer.parseInt(linha);
            Usuario u = encontrarPorId(id);
            if (u == null) {
                System.out.println("Usuário não encontrado.");
            } else {
                System.out.println("Usuário encontrado: " + u);
            }
        } catch (NumberFormatException e) {
            System.out.println("ID inválido.");
        }
    }

    private static void removerPorId(Scanner input) {
        System.out.print("Informe o ID do usuário a remover: ");
        String linha = input.nextLine().trim();
        try {
            int id = Integer.parseInt(linha);
            Usuario u = encontrarPorId(id);
            if (u == null) {
                System.out.println("Usuário não encontrado.");
                return;
            }

            usuarios.remove(u);
            System.out.println("Usuário com ID " + id + " removido.");

            reordenarIds();
            atualizarUltimoId();
            GerenciadorDeArquivos.salvarUsuarios(usuarios, ultimoId);

        } catch (NumberFormatException e) {
            System.out.println("ID inválido.");
        }
    }

    private static Usuario encontrarPorId(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) return u;
        }
        return null;
    }

    // Métodos auxiliares para a interface gráfica
    public static List<Usuario> getUsuarios() {
        return usuarios;
    }

    public static int getUltimoId() {
        return ultimoId;
    }

    public static void setUltimoId(int id) {
        ultimoId = id;
    }

    public static void atualizarUltimoId() {
        int maxId = 0;
        for (Usuario u : usuarios) {
            if (u.getId() > maxId) maxId = u.getId();
        }
        ultimoId = maxId;
    }

    public static void reordenarIds() {
        for (int i = 0; i < usuarios.size(); i++) {
            usuarios.get(i).setId(i + 1); // IDs voltam a ficar 1,2,3,4...
        }
        System.out.println("IDs reorganizados com sucesso.");
    }
}
