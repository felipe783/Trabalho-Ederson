package Telas_QF;

import QuartosFiltro.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/*
        listaQuarto.add(new Quartos(101, "Basica", "119.90"));
        listaQuarto.add(new Quartos(102, "Media", "349.90"));
        listaQuarto.add(new Quartos(103, "Vip", "689.90"));
        listaQuarto.add(new Quartos(104, "Suite_Vip", "1245.90"));
        listaQuarto.add(new Quartos(105, "Basica", "119.90"));
        listaQuarto.add(new Quartos(201, "Media", "349.90"));
        listaQuarto.add(new Quartos(202, "Vip", "689.90"));
        listaQuarto.add(new Quartos(203, "Suite_Vip", "1245.90"));
        listaQuarto.add(new Quartos(204, "Basica", "119.90"));
        listaQuarto.add(new Quartos(205, "Media", "349.90"));
 */
public class TelaFiltro extends JFrame{
    //Qualidade
    private JCheckBox QlBasica = new JCheckBox("Básica");
    private JCheckBox QlMedia = new JCheckBox("Média");
    private JCheckBox QlVip = new JCheckBox("Vip");
    private JCheckBox QlSuite = new JCheckBox("Suíte Vip");

    //Preço
    private JCheckBox PrBasica = new JCheckBox("119.90");
    private JCheckBox PrMedia = new JCheckBox("349.90");
    private JCheckBox PrVip = new JCheckBox("689.90");
    private JCheckBox PrSuite = new JCheckBox("1245.90");

    public TelaFiltro(){
        setTitle("Tela Filtro");
        initComponents();
        //Ajusta o tamanho dos componentes quando ce muda o tamanho da tela
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private void initComponents(){
        JPanel main = new JPanel(new BorderLayout(8, 8));
        JPanel center = new JPanel(new GridLayout(1, 2, 16, 16));

        //Qualidade painel
        JPanel painelQual = new JPanel();
        painelQual.setBorder(BorderFactory.createTitledBorder("Qualidade"));
        painelQual.setLayout(new BoxLayout(painelQual, BoxLayout.Y_AXIS));
        painelQual.add(QlBasica);
        painelQual.add(QlMedia);
        painelQual.add(QlVip);
        painelQual.add(QlSuite);

        // Painel Preço
        JPanel painelPreco = new JPanel();
        painelPreco.setBorder(BorderFactory.createTitledBorder("Preço (R$)"));
        painelPreco.setLayout(new BoxLayout(painelPreco, BoxLayout.Y_AXIS));
        painelPreco.add(PrBasica);
        painelPreco.add(PrMedia);
        painelPreco.add(PrVip);
        painelPreco.add(PrSuite);

        center.add(painelQual);
        center.add(painelPreco);
        JButton botaoFiltrar = new JButton("Filtrar");
        botaoFiltrar.addActionListener((ActionEvent e) -> {
            // coleta escolhas marcadas
            ArrayList<String> selecionados = new ArrayList<>();

            // Qualidade -> prefixa com "Q:"
            if (QlBasica.isSelected()) selecionados.add("Q:Básica");
            if (QlMedia.isSelected())  selecionados.add("Q:Média");
            if (QlVip.isSelected())    selecionados.add("Q:Vip");
            if (QlSuite.isSelected())  selecionados.add("Q:Suíte Vip");

            // Preço -> prefixa com "P:"
            if (PrBasica.isSelected()) selecionados.add("P:119.90");
            if (PrMedia.isSelected())  selecionados.add("P:349.90");
            if (PrVip.isSelected())    selecionados.add("P:689.90");
            if (PrSuite.isSelected())  selecionados.add("P:1245.90");

            // Converte pra array pra manter a assinatura existente
            String[] escolha = selecionados.toArray(new String[0]);

            // Tipos possíveis (exemplo)
            String[] tipos = {"Básica", "Média", "Vip", "Suíte Vip",
                    "119.90", "349.90", "689.90", "1245.90"};

            // Chama a função existente
            Filtro.Comparar(tipos, escolha);
        });

        JPanel south = new JPanel();
        south.add(botaoFiltrar);

        main.add(center, BorderLayout.CENTER);
        main.add(south, BorderLayout.SOUTH);

        setContentPane(main);
    }
}

