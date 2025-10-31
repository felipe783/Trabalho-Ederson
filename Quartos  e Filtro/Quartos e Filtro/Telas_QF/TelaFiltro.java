package Telas_QF;

import QuartosFiltro.*;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaFiltro extends JFrame{
    JPanel painelPrincipal = new JPanel();
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
    private ArrayList<String> Escolha = new ArrayList<>();
    private ArrayList<String> Preco = new ArrayList<>();

    public TelaFiltro(){
        setTitle("Tela Filtro");
        initComponents();
        painelPrincipal.setPreferredSize(new Dimension(400, 300));//Tamanho do painel
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initComponents(){
        JButton btSair = new JButton("Sair");
        JButton btFiltrar = new JButton("Filtro");

        //JPanel painelPrincipal = new JPanel();
        //painelPrincipal.setSize(400,300);
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

        /** ------------------------Preço------------------------  **/
        JPanel painelPR = new JPanel();
        painelPR.setBorder(BorderFactory.createTitledBorder("Preço"));
        painelPR.setLayout(new BoxLayout(painelPR,BoxLayout.Y_AXIS));

        painelPR.add(PrBasica);
        painelPR.add(PrMedia);
        painelPR.add(PrVip);
        painelPR.add(PrSuite);
        /**==============================Filtro==============================**/
        /*----------Seleção dos filtros(Qualidade)----------*/
        btSair.addActionListener(e -> System.exit(0)); //SAIR

        btFiltrar.addActionListener(e->{
            Escolha.clear();
            //QUALIDADE
            if(QlBasica.isSelected()) Escolha.add("Básica");
            if(QlMedia.isSelected()) Escolha.add("Média");
            if(QlVip.isSelected()) Escolha.add("Vip");
            if(QlSuite.isSelected()) Escolha.add("Suíte");


            //Preço
            if(PrBasica.isSelected()) Escolha.add("199.90");
            if(PrMedia.isSelected()) Escolha.add("349.90");
            if(PrVip.isSelected()) Escolha.add("689.90");
            if(PrSuite.isSelected()) Escolha.add("1245.90");

            /**Aqui filtra realmente**/
            //System.out.println(Escolha);
            Filtro.Comparar(Escolha);
        });

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

