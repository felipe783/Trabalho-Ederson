import QuartosFiltro.*;
import Telas_QF.MainTelasQF;
import Telas_QF.TelaQuarto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaReserva extends JFrame {

    public TelaReserva() {

        setTitle("Menu de Gerenciamento de Reservas");
        setSize(400, 450); // Tamanho ideal para um menu
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela


        setLayout(new BorderLayout(10, 10));


        JLabel titulo = new JLabel("Menu", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        add(titulo, BorderLayout.NORTH);

        // Painel para os Botões (Organizado em uma grade de 4 linhas, 1 coluna)
        JPanel painelBotoes = new JPanel(new GridLayout(4, 1, 15, 15)); // 4 linhas, 1 coluna, com espaçamento
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Margem interna

        // --- Criação e Configuração dos Botões ---

        JButton btNovaReserva = criarBotao("Iniciar Nova Reserva", new Color(60, 179, 113));
        JButton btConsultar = criarBotao("Consultar Reservas Ativas", new Color(60, 179, 113));
        JButton btCancelar = criarBotao("Cancelar Reserva", new Color(60, 179, 113));
        JButton btSair = criarBotao("Sair", Color.LIGHT_GRAY);

        // --- Adicionar Ações (ActionListeners) ---

        // 1. Nova Reserva (Abrir TelaQuarto)
        btNovaReserva.addActionListener(e -> {
            new MainTelasQF().setVisible(true);
            // dispose(); // Opcional: Fechar o menu ao abrir a próxima tela
        });

        // 2. Consultar Reservas Ativas
        btConsultar.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Funcionalidade: Abrir tela de consulta de reservas.",
                    "Consulta", JOptionPane.INFORMATION_MESSAGE);
            // Aqui você chamaria: new TelaConsultaReservas().setVisible(true);
        });

        // 3. Cancelar Reserva
        btCancelar.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Funcionalidade: Abrir tela de cancelamento.",
                    "Cancelamento", JOptionPane.WARNING_MESSAGE);
            // Aqui você chamaria: new TelaCancelarReserva().setVisible(true);
        });

        // 4. Sair
        btSair.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this,
                    "Tem certeza que deseja sair?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0); // Encerra a aplicação
            }
        });

        // --- Adicionar Botões ao Painel ---
        painelBotoes.add(btNovaReserva);
        painelBotoes.add(btConsultar);
        painelBotoes.add(btCancelar);
        painelBotoes.add(btSair);

        add(painelBotoes, BorderLayout.CENTER);

        setVisible(true);
    }

    /** Método auxiliar para padronizar a criação dos botões. */
    private JButton criarBotao(String texto, Color corFundo) {
        JButton botao = new JButton(texto);
        botao.setFont(new Font("Arial", Font.BOLD, 16));
        botao.setBackground(corFundo);
        botao.setForeground(Color.WHITE);
        botao.setFocusPainted(false);
        return botao;
    }

    public static void main(String[] args) {
        // Inicia a aplicação na Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> new TelaReserva());
    }
}
