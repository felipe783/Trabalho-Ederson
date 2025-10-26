import CPF.ValidadorCPF;
import FormatTelefone.Formatador;
import ListaUsuarios.GerenciadorDeArquivos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cadastro {
    private static List<Usuario> usuarios = GerenciadorDeArquivos.carregarUsuarios();
    private static int ultimoId = 0;

    private static final String ADM_USER = "admin";
    private static final String ADM_PASS = "1234";

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            exibirMenuPrincipal(input);
        }
    }

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
                    System.out.println("Saindo...");
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    // Função do menu principal
    private static void mostrarMenu() {
        System.out.println("\n=== MENU PRINCIPAL ===");
        System.out.println("1 - Cadastrar usuário");
        System.out.println("2 - Acessar o site");
        System.out.println("3 - Sistema ADM");
        System.out.println("0 - Sair");
    }

    // Função do menu de administrador
    private static void mostrarMenuADM() {
        System.out.println("\n=== MENU ADM ===");
        System.out.println("1 - Listar usuários");
        System.out.println("2 - Buscar usuário por ID");
        System.out.println("3 - Remover usuário por ID");
        System.out.println("0 - Voltar");
    }

    // Verificação de acesso do sistema de adm
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

    // Verifica se o usuário está cadastrado e acessa o site
    private static void acessarSite(Scanner input) {
        System.out.println("\n--- LOGIN SITE ---");

        // Verifica se há usuários cadastrados antes de tentar logar
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado. Cadastre-se primeiro!");
            return;
        }

        System.out.print("Nome de usuário: ");
        String nome = input.nextLine().trim();

        System.out.print("Senha: ");
        String senha = input.nextLine().trim();

        if (autenticadorLogin(nome, senha)) {
            System.out.println("Login bem-sucedido! Bem-vindo, " + nome + "!");
        } else {
            System.out.println("Usuário ou senha incorretos.");
        }
    }

    /**
     *     Verificador de acesso de adm
     */
    private static boolean autenticarAdm(String usuario, String senha) {
        return ADM_USER.equals(usuario) && ADM_PASS.equals(senha);
    }

    /**
     * Verficador de acesso ao site
     */
    private static boolean autenticadorLogin(String usuario, String senha) {
        for (Usuario u : usuarios) {
            if (u.getNome().equalsIgnoreCase(usuario) && u.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Sistema de adm
     */
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

    /**
     *  Função para cadastrar usuarios
     */
    private static void cadastrarUsuario(Scanner input) {
        System.out.println("\n--- CADASTRO ---");
        try {
            System.out.print("Nome: ");
            String nome = input.nextLine();

            System.out.print("Email: ");
            String email = input.nextLine();

            System.out.print("Senha: ");
            String senha = input.nextLine().trim();

            // Bloqueia senha vazia
            if (senha.isEmpty()) {
                System.out.println("A senha não pode ser vazia. Cadastro cancelado.");
                return;
            }

            String cpf;
            // Verificador de CPF, funciona junto do package de ValidadorCPF
            while (true) {
                System.out.print("CPF (somente números ou com pontuação): ");
                cpf = input.nextLine().trim();
                if (ValidadorCPF.isValidCPF(cpf)) {
                    cpf = cpf.replaceAll("\\D", "");
                    break;
                } else {
                    System.out.println("CPF inválido. Deseja tentar novamente? (s/n)");
                    String r = input.nextLine().trim().toLowerCase();
                    if (!r.equals("s") && !r.equals("sim")) {
                        System.out.println("Cadastro cancelado.");
                        return;
                    }
                }
            }

            String telefone;
            while (true) {
                System.out.print("Telefone (somente números): ");
                telefone = input.nextLine().trim();

                // remove qualquer coisa que não seja número
                String numeroLimpo = telefone.replaceAll("\\D", "");

                // valida tamanho (10 = fixo, 11 = celular)
                if (numeroLimpo.length() == 10 || numeroLimpo.length() == 11) {
                    // formata o número antes de salvar
                    telefone = Formatador.formatarTelefone(numeroLimpo);
                    break;
                } else {
                    System.out.println("Telefone inválido. Deseja tentar novamente? (s/n)");
                    String r = input.nextLine().trim().toLowerCase();
                    if (!r.equals("s") && !r.equals("sim")) {
                        System.out.println("Cadastro cancelado.");
                        return;
                    }
                }
            }

            System.out.print("Endereço: ");
            String endereco = input.nextLine().trim();

            // Cria e adiciona novo usuário
            Usuario u = new Usuario(0, nome, email, senha, ValidadorCPF.formatCPF(cpf), telefone, endereco);
            int novoId = ++ultimoId;
            u.setId(novoId);
            usuarios.add(u);
            GerenciadorDeArquivos.salvarUsuarios(usuarios);
            System.out.println("Usuário cadastrado com sucesso! ID = " + novoId);

        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
            System.out.println("Voltando ao menu principal...");
        }
    }

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
                    " | CPF: " + ValidadorCPF.formatCPF(u.getCpf()) +
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

    // Função para remover um cadastro pelo 'id'
    private static void removerPorId(Scanner input) {
        System.out.print("Informe o ID do usuário a remover: ");
        String linha = input.nextLine().trim();
        try {
            int id = Integer.parseInt(linha);
            Usuario u = encontrarPorId(id);
            if (u == null) {
                System.out.println("Usuário não encontrado.");
            } else {
                usuarios.remove(u);
                GerenciadorDeArquivos.salvarUsuarios(usuarios);
                System.out.println("Usuário com ID " + id + " removido.");
            }
        } catch (NumberFormatException e) {
            System.out.println("ID inválido.");
        }
    }

    // Função para encontrar cadastro pelo 'id'
    private static Usuario encontrarPorId(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) return u;
        }
        return null;
    }
}
