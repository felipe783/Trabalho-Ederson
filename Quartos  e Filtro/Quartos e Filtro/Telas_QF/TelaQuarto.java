package Telas_QF;
import QuartosFiltro.Quartos;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import Reserva.TelaCheckout;

public class TelaQuarto extends JFrame {

    public TelaQuarto() {
        // Config da janela
        setTitle("Quartos");
        setSize(1920, 1080);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Fecha apenas esta tela
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Painel principal com grade de cards
        JPanel painelCards = new JPanel(new GridLayout(0, 2, 20, 20)); // 2 colunas, espaçamento
        JScrollPane scroll = new JScrollPane(painelCards);
        scroll.getVerticalScrollBar().setUnitIncrement(16); // rolagem mais suave
        add(scroll, BorderLayout.CENTER);

        // Botão de saída no topo
        JButton btSair = new JButton("Voltar");
        JPanel painelTopo = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        painelTopo.add(btSair);
        add(painelTopo, BorderLayout.NORTH);

        // Puxar os quartos
        ArrayList<Quartos> quartos = Quartos.sampleList();

        for (Quartos q : quartos) {
            JPanel card = new JPanel(new BorderLayout());
            card.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2, true));

            // imagem
            ImageIcon icon = new ImageIcon("ImagensQuartos/quarto" + q.getNumero() + ".png");
            Image img = icon.getImage().getScaledInstance(500, 400, Image.SCALE_SMOOTH);
            JLabel imgLabel = new JLabel(new ImageIcon(img));
            card.add(imgLabel, BorderLayout.CENTER);

            // info (qualidade e preço)
            JPanel info = new JPanel(new GridLayout(3, 1));
            JLabel qualidade = new JLabel("Qualidade: " + q.getQualidade(), SwingConstants.CENTER);
            JLabel preco = new JLabel("Preço: R$ " + q.getPreco(), SwingConstants.CENTER);

            // --- NOVO COMPONENTE: BOTÃO DE RESERVA ---
            JButton btReservar = new JButton("Reservar " + q.getQualidade());
            btReservar.setBackground(new Color(60, 179, 113)); // Cor verde para destaque
            btReservar.setForeground(Color.WHITE);
            btReservar.setFocusPainted(false); // Remove o destaque de foco

            // Ação do botão de reserva (lambda expression)
            btReservar.addActionListener(e -> {
                // Ao invés de um JOptionPane, abra a nova tela de checkout
                TelaCheckout checkout = new TelaCheckout(q);
                checkout.setVisible(true);
            });


            info.add(qualidade);
            info.add(preco);
            info.add(btReservar);
            card.add(info, BorderLayout.SOUTH);

            painelCards.add(card);



        }

        // Ação do botão sair
        btSair.addActionListener(e -> dispose()); // fecha esta tela
    }
}
