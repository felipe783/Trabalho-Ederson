package Telas_QF;

import QuartosFiltro.Quartos;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TelaReserva extends JFrame {

    public TelaReserva() {
        setTitle("Reserva");
        setSize(1280, 1080);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel painelCards = new JPanel(new GridLayout(0, 2, 20, 20));
        JScrollPane scroll = new JScrollPane(painelCards);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        add(scroll, BorderLayout.CENTER);

        JButton btSair = new JButton("Voltar");
        JPanel painelTopo = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        painelTopo.add(btSair);
        add(painelTopo, BorderLayout.NORTH);

        ArrayList<Quartos> quartos = Quartos.sampleList();

        for (Quartos q : quartos) {
            JPanel card = new JPanel(new BorderLayout());
            card.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.GRAY, 2, true),
                    BorderFactory.createEmptyBorder(10, 10, 10, 10)
            ));

            // imagem
            ImageIcon icon = new ImageIcon("ImagensQuartos/quarto" + q.getNumero() + ".png");
            if (icon.getIconWidth() <= 0) {
                icon = new ImageIcon("ImagensQuartos/placeholder.png");
            }
            Image img = icon.getImage().getScaledInstance(500, 400, Image.SCALE_SMOOTH);
            JLabel imgLabel = new JLabel(new ImageIcon(img));
            card.add(imgLabel, BorderLayout.CENTER);

            // info
            JPanel info = new JPanel(new GridLayout(3, 1, 5, 5));
            JLabel qualidade = new JLabel("Qualidade: " + q.getQualidade(), SwingConstants.CENTER);
            JLabel preco = new JLabel("Preço: R$ " + q.getPreco(), SwingConstants.CENTER);
            JButton btReservar = new JButton("Reservar");

            info.add(qualidade);
            info.add(preco);
            info.add(btReservar);

            card.add(info, BorderLayout.SOUTH);
            painelCards.add(card);

            btReservar.addActionListener(_ -> {
                JOptionPane.showMessageDialog(this,
                        "Você selecionou o quarto nº " + q.getNumero() +
                                "\nQualidade: " + q.getQualidade() +
                                "\nPreço: R$ " + q.getPreco(),
                        "Reserva",
                        JOptionPane.INFORMATION_MESSAGE
                );
            });
        }

        btSair.addActionListener(_ -> dispose());
    }
}
