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
        setLayout(new GridLayout(4,1,10,10));

        JButton btFiltro = new JButton("Filtro");
        JButton btQuarto = new JButton("Quartos");
        JButton btReservar = new JButton("Reservas");
        JButton btSair = new JButton("Sair");

        add(btFiltro);
        add(btQuarto);
        add(btReservar);
        add(btSair);

        btSair.addActionListener(_ -> dispose());
        btFiltro.addActionListener(_->new TelaFiltro().setVisible(true));
        btQuarto.addActionListener(_->new TelaQuarto().setVisible(true));
        btReservar.addActionListener(_->new TelaReserva().setVisible(true));
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(()-> new MainTelasQF().setVisible(true));
    }

}
