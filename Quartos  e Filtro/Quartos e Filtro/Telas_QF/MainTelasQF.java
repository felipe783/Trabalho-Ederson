package Telas_QF;

import QuartosFiltro.*;
import javax.swing.*;
import java.awt.*;

public class MainTelasQF extends JFrame {

    public MainTelasQF(){
        setTitle("Tela Filtro e Quarto");
        setSize(400,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3,1,10,10));

        JButton btFiltro = new JButton("Filtro");
        JButton btQuarto = new JButton("Quartos");
        JButton btSair = new JButton("Sair");

        add(btFiltro);
        add(btQuarto);
        add(btSair);

        btSair.addActionListener(e -> dispose());
        btFiltro.addActionListener(e->new TelaFiltro().setVisible(true));
        btQuarto.addActionListener(e->new TelaQuarto().setVisible(true));
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(()-> new MainTelasQF().setVisible(true));
    }

}
