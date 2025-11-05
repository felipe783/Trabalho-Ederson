package QuartosFiltro;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.*;
import java.awt.*;


public class Filtro {
    public static void Comparar(List<String> Escolha) {
        ArrayList<Quartos> filtrados = new ArrayList<>();
        ArrayList<Quartos> quartos = Quartos.sampleList();
        for (Quartos q : quartos) {
            for(int i=0;i<Escolha.size();i++){
                if(Escolha.get(i).equals(q.getQualidade()) || Escolha.get(i).equals(q.getPreco())){
                    filtrados.add(q);
                    break;
                }
            }
        }
        // Cria uma janela para mostrar as imagens dos quartos filtrados
        JFrame frame = new JFrame("Quartos Filtrados");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1200, 800);

        JPanel painel = new JPanel();
        painel.setLayout(new FlowLayout());

        for (Quartos q : filtrados) {
            // Carrega a imagem do quarto
            ImageIcon icon = new ImageIcon("ImagensQuartos/quarto" + q.getNumero() + ".png");
            // Redimensiona (opcional)
            Image img = icon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(img);

            JLabel imgLabel = new JLabel(resizedIcon);
            imgLabel.setText(q.getQualidade() + " - " + q.getPreco());
            imgLabel.setHorizontalTextPosition(JLabel.CENTER);
            imgLabel.setVerticalTextPosition(JLabel.BOTTOM);

            painel.add(imgLabel);
        }

        frame.add(new JScrollPane(painel));
        frame.setVisible(true);
    }
}


