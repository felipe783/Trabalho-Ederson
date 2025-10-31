package Telas_QF;

import QuartosFiltro.*;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaFiltro extends JFrame{
    //Qualidade
    private JCheckBox QlBasica = new JCheckBox("Básica");
    private JCheckBox QlMedia = new JCheckBox("Média");
    private JCheckBox QlVip = new JCheckBox("Vip");
    private JCheckBox QlSuite = new JCheckBox("Suíte");

    //Preço
    private JCheckBox PrBasica = new JCheckBox("119.90");
    private JCheckBox PrMedia = new JCheckBox("349.90");
    private JCheckBox PrVip = new JCheckBox("689.90");
    private JCheckBox PrSuite = new JCheckBox("1245.90");

    //Faz as listas
    private ArrayList<String> Qualidade = new ArrayList<>();
    private ArrayList<String> Preco = new ArrayList<>();

    public TelaFiltro(){
        setTitle("Tela Filtro");
        initComponents();
        //Ajusta o tamanho dos componentes quando ce muda o tamanho da tela
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initComponents(){
        JButton btSair = new JButton("Sair");
        JButton btFiltrar = new JButton("Filtro");

        JPanel painelPrincipal = new JPanel();
        JFrame frame = new JFrame();
        frame.setTitle("Filtro");

        painelPrincipal.setSize(400,300);
        painelPrincipal.setLayout(new BorderLayout());

        painelPrincipal.add(btFiltrar);
        painelPrincipal.add(btSair);
        /** ------------------------QUALIDADE------------------------  **/
        JPanel painelQL = new JPanel();
        painelQL.setBorder(BorderFactory.createTitledBorder("Qualidade")); //Cria o painel qualidade com borda e tudo
        painelQL.setLayout(new BoxLayout(painelQL,BoxLayout.Y_AXIS)); //Organiza eles no eixo Y
        //ADD CHECKBOX
        painelQL.add(QlBasica);
        painelQL.add(QlMedia);
        painelQL.add(QlVip);
        painelQL.add(QlSuite);

        /*----------Seleção dos filtros(Qualidade)----------*/
        btSair.addActionListener(e -> System.exit(0)); //SAIR
        btFiltrar.addActionListener(e->{ //QUALIDADE
            if(QlBasica.isSelected()) Qualidade.add("Básica");
            if(QlMedia.isSelected()) Qualidade.add("Média");
            if(QlVip.isSelected()) Qualidade.add("Vip");
            if(QlSuite.isSelected()) Qualidade.add("Suite");
        });

        /** ------------------------Preço------------------------  **/
        JPanel painelPR = new JPanel();
        painelPR.setBorder(BorderFactory.createTitledBorder("Preço"));
        painelPR.setLayout(new BoxLayout(painelPR,BoxLayout.Y_AXIS));

        painelPR.add(PrBasica);
        painelPR.add(PrMedia);
        painelPR.add(PrVip);
        painelPR.add(PrSuite);

        /*----------Seleção dos filtros(Preço)----------*/
        btFiltrar.addActionListener(e->{ //Preço
            if(PrBasica.isSelected()) Preco.add("199.90");
            if(PrMedia.isSelected()) Preco.add("349.90");
            if(PrVip.isSelected()) Preco.add("689.90");
            if(PrSuite.isSelected()) Preco.add("1245.90");
        });
        /*------------------------Filtro------------------------*/
        Filtro.Comparar(Qualidade,Preco);

        /*--Mostra Filtrar e Sair em baixo um do lado do outro-*/
        JPanel botoes = new JPanel();
        botoes.setLayout(new FlowLayout(FlowLayout.CENTER,10,0));
        botoes.add(btSair);
        botoes.add(btFiltrar);

        /*--Final pra mostrar tudo-*/
        JPanel Centro = new JPanel(new GridLayout(1, 2, 16, 16));
        Centro.add(painelPR);
        Centro.add(painelQL);

        painelPrincipal.add(botoes, BorderLayout.SOUTH);
        painelPrincipal.add(Centro, BorderLayout.CENTER);

        this.setContentPane(painelPrincipal);
    }
}

