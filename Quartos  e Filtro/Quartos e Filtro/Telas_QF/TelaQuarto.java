package Telas_QF;

import QuartosFiltro.Quartos;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TelaQuarto extends JFrame {

    public TelaQuarto(){
        // Config da janela
        setTitle("Quartos");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(0, 2)); // cria 2 por linha

        // Puxar os quartos
        ArrayList<Quartos> quartos = Quartos.sampleList();

        for (Quartos q : quartos) {
            JPanel card = new JPanel(new BorderLayout());
            // imagem
            JLabel img = new JLabel(new ImageIcon("ImagensQuartos/quarto" + q.getNumero() + ".png"));
            card.add(img, BorderLayout.CENTER);

            // info (qualidade e preço)
            JPanel info = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
            JLabel qualidade = new JLabel(q.getQualidade());
            JLabel preco = new JLabel(String.valueOf(q.getPreco()));

            info.add(qualidade);
            info.add(preco);
            card.add(info, BorderLayout.SOUTH);

            add(card);
        }

        setVisible(true); // mostra a janela no final
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaQuarto());
    }
}
