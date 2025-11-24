package Reserva;

import Reserva.GerenciadorReservas;
import QuartosFiltro.Quartos;
import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class TelaCheckout extends JFrame {

    private Quartos quartoSelecionado;
    private JLabel labelPrecoTotal;
    private JTextField campoDias;
    private double precoCalculado = 0.0;
    private int diasSelecionados = 0;

    private static final DecimalFormat df = new DecimalFormat("R$ #,##0.00");

    public TelaCheckout(Quartos quarto) {
        this.quartoSelecionado = quarto;

        // --- Configuração da Janela ---
        setTitle("Reserva do Quarto: " + quarto.getQualidade());
        setSize(450, 400); // Aumentei o tamanho
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // --- Painel Central de Informações ---
        JPanel painelInfo = new JPanel(new GridLayout(5, 1, 10, 10));
        painelInfo.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

        // Título e Preço Diário
        JLabel titulo = new JLabel("Confirmação de Reserva", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));

        JLabel labelDiaria = new JLabel("Diária: " + df.format(quarto.getpreco()), SwingConstants.CENTER);

        // Campo para inserir os dias
        JPanel painelDias = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelDias.add(new JLabel("Quantidade de Dias:"));
        campoDias = new JTextField(5);
        painelDias.add(campoDias);

        // --- Botões e Labels ---
        JButton btCalcular = new JButton("Calcular Preço Total");
        labelPrecoTotal = new JLabel("Total: R$ 0,00", SwingConstants.CENTER);
        labelPrecoTotal.setFont(new Font("Arial", Font.BOLD, 18));

        JButton btConfirmar = new JButton("Confirmar Reserva");
        btConfirmar.setEnabled(false); // Inicia desabilitado

        // Ação do botão de cálculo
        btCalcular.addActionListener(e -> {
            calcularPreco();
            // Habilita o botão de confirmação se o cálculo for válido
            btConfirmar.setEnabled(precoCalculado > 0);
        });

        // Ação do botão de confirmação
        btConfirmar.addActionListener(e -> confirmarReserva());

        // Adicionando componentes
        painelInfo.add(titulo);
        painelInfo.add(labelDiaria);
        painelInfo.add(painelDias);
        painelInfo.add(btCalcular);
        painelInfo.add(labelPrecoTotal);

        add(painelInfo, BorderLayout.CENTER);

        JPanel painelConfirmar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelConfirmar.add(btConfirmar);
        add(painelConfirmar, BorderLayout.SOUTH);
    }

    private void calcularPreco() {
        try {
            diasSelecionados = Integer.parseInt(campoDias.getText());

            if (diasSelecionados <= 0) {
                JOptionPane.showMessageDialog(this, "A quantidade de dias deve ser maior que zero.", "Erro", JOptionPane.ERROR_MESSAGE);
                precoCalculado = 0.0;
            } else {
                precoCalculado = quartoSelecionado.getpreco() * diasSelecionados;
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um número válido de dias.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
            precoCalculado = 0.0;
            diasSelecionados = 0;
        }

        labelPrecoTotal.setText("Total da Reserva (" + diasSelecionados + " dias): " + df.format(precoCalculado));
    }

    private void confirmarReserva() {
        if (precoCalculado > 0) {

            // Tenta registrar a reserva
            boolean sucesso = GerenciadorReservas.registrarReserva(
                    quartoSelecionado.getNumero(),
                    precoCalculado,
                    diasSelecionados
            );

            if (sucesso) {
                JOptionPane.showMessageDialog(this,
                        "Reserva Confirmada!\nVocê pode consultar os detalhes no menu principal.",
                        "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                dispose(); // Fecha a tela de checkout
            } else {
                // Mensagem de erro se o usuário já tiver uma reserva
                JOptionPane.showMessageDialog(this,
                        "ERRO: Você já possui uma reserva ativa. Cancele a reserva anterior antes de fazer uma nova.",
                        "Limite de Reserva Atingido", JOptionPane.ERROR_MESSAGE);
                // Não fecha a tela
            }

        } else {
            JOptionPane.showMessageDialog(this, "Calcule o preço antes de confirmar.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
