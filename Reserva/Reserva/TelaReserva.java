package Reserva;

import Telas_QF.MainTelasQF;

import javax.swing.*;
import java.awt.*;

public class TelaReserva extends JFrame {

    public TelaReserva() {

        setTitle("Menu de Gerenciamento de Reservas");
        setSize(400, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela


        setLayout(new BorderLayout(10, 10));


        JLabel titulo = new JLabel("Menu", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        add(titulo, BorderLayout.NORTH);

        // grade de 4 linhas, 1 coluna)
        JPanel painelBotoes = new JPanel(new GridLayout(4, 1, 15, 15)); // 4 linhas, 1 coluna, com espaçamento
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Margem interna



        JButton btNovaReserva = criarBotao("Iniciar Nova Reserva", new Color(60, 179, 113));
        JButton btConsultar = criarBotao("Consultar Reservas Ativas", new Color(60, 179, 113));
        JButton btCancelar = criarBotao("Cancelar Reserva", new Color(60, 179, 113));
        JButton btSair = criarBotao("Sair", Color.LIGHT_GRAY);


        // 1. Nova Reserva (Abrir TelaQuarto)
        btNovaReserva.addActionListener(e -> {
            new MainTelasQF().setVisible(true);
             dispose();
        });

        // 2. Consultar Reservas Ativas
        btConsultar.addActionListener(e -> {
            consultarReservas();
        });

        // 3. Cancelar Reserva
        btCancelar.addActionListener(e -> {
            solicitarCancelamento();
        });

        // 4. Sair
        btSair.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this,
                    "Tem certeza que deseja sair?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0); // Encerra a aplicação
            }
        });


        painelBotoes.add(btNovaReserva);
        painelBotoes.add(btConsultar);
        painelBotoes.add(btCancelar);
        painelBotoes.add(btSair);

        add(painelBotoes, BorderLayout.CENTER);

        setVisible(true);
    }


    private JButton criarBotao(String texto, Color corFundo) {
        JButton botao = new JButton(texto);
        botao.setFont(new Font("Arial", Font.BOLD, 16));
        botao.setBackground(corFundo);
        botao.setForeground(Color.WHITE);
        botao.setFocusPainted(false);
        return botao;
    }



    private void consultarReservas() {
        // 1. Pega a lista de reservas ativas
        java.util.List<Reserva.Dados> reservas = Reserva.GerenciadorReservas.getReservasAtivas();

        // 2. Se a lista estiver vazia
        if (reservas.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Não há reservas ativas no momento.",
                    "Consultar Reservas",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // 3. Constrói a mensagem
        StringBuilder mensagem = new StringBuilder();
        mensagem.append("📋 **RESERVAS ATIVAS**\n\n");

        // Itera sobre cada reserva para formatar a saída
        for (Reserva.Dados r : reservas) {
            // Formato para o valor monetário
            java.text.DecimalFormat df = new java.text.DecimalFormat("R$ #,##0.00");

            mensagem.append("------------------------------------------\n");
            mensagem.append("ID Reserva: **").append(r.getIdReserva()).append("**\n");
            mensagem.append("ID Usuário: ").append(r.getIdUsuario()).append("\n");
            mensagem.append("ID Quarto: ").append(r.getIdQuarto()).append("\n");
            mensagem.append("Dias: ").append(r.getDias()).append("\n");
            mensagem.append("Total: ").append(df.format(r.getValorTotal())).append("\n");
        }
        mensagem.append("------------------------------------------");

        // 4. Exibe a mensagem em um painel que suporta múltiplas linhas
        JTextArea textArea = new JTextArea(mensagem.toString());
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400, 300));

        JOptionPane.showMessageDialog(this, scrollPane, "Consultar Reservas Ativas", JOptionPane.PLAIN_MESSAGE);
    }

// ...


    private void solicitarCancelamento() {
        // Pede ao usuário o ID da reserva a ser cancelada
        String input = JOptionPane.showInputDialog(this,
                "Digite o ID da Reserva que deseja cancelar:",
                "Cancelar Reserva",
                JOptionPane.QUESTION_MESSAGE);

        // Verifica se o usuário digitou algo
        if (input != null && !input.trim().isEmpty()) {
            try {
                int idParaCancelar = Integer.parseInt(input.trim());

                // Chama o método de cancelamento
                boolean sucesso = Reserva.GerenciadorReservas.cancelarReserva(idParaCancelar);

                if (sucesso) {
                    JOptionPane.showMessageDialog(this,
                            "Reserva ID " + idParaCancelar + " cancelada com sucesso!",
                            "Sucesso",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Erro: Reserva ID " + idParaCancelar + " não encontrada ou não pertence a este usuário.",
                            "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, insira um ID de reserva válido (números).", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        // Inicia a aplicação na Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> new TelaReserva());
    }
}
