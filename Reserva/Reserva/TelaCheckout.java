package Reserva;

import QuartosFiltro.Quartos;
import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class TelaCheckout extends JFrame {

    private Quartos quartoSelecionado;
    private JLabel labelPrecoTotal;
    // Formata o preço para o padrão brasileiro (R$ X.XXX,XX)
    private static final DecimalFormat df = new DecimalFormat("R$ #,##0.00");

    public TelaCheckout(Quartos quarto) {
        this.quartoSelecionado = quarto;

        // --- Configuração da Janela ---
        setTitle("Reserva do Quarto: " + quarto.getQualidade());
        setSize(450, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // --- Painel Central de Informações ---
        JPanel painelInfo = new JPanel(new GridLayout(4, 1, 5, 5));
        painelInfo.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

        // Título e Preço Diário
        JLabel titulo = new JLabel("Confirmação de Reserva", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));

        JLabel labelDiaria = new JLabel("Diária: " + df.format(quarto.getpreco()), SwingConstants.CENTER);
        labelDiaria.setFont(new Font("Arial", Font.PLAIN, 16));

        // Campo para inserir os dias
        JPanel painelDias = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelDias.add(new JLabel("Quantidade de Dias:"));
        JTextField campoDias = new JTextField(5);
        painelDias.add(campoDias);

        // --- Cálculo e Botão ---
        JButton btCalcular = new JButton("Calcular Preço Total");
        labelPrecoTotal = new JLabel("Total: R$ 0,00", SwingConstants.CENTER);
        labelPrecoTotal.setFont(new Font("Arial", Font.BOLD, 16));

        // Ação do botão de cálculo
        btCalcular.addActionListener(e -> calcularPreco(campoDias.getText()));

        // Adicionando componentes ao painel de informações
        painelInfo.add(titulo);
        painelInfo.add(labelDiaria);
        painelInfo.add(painelDias);
        painelInfo.add(btCalcular);

        add(painelInfo, BorderLayout.CENTER);
        add(labelPrecoTotal, BorderLayout.SOUTH);
    }

    private void calcularPreco(String diasTexto) {
        try {
            // 1. Converte o texto para um número inteiro
            int dias = Integer.parseInt(diasTexto);

            if (dias <= 0) {
                JOptionPane.showMessageDialog(this, "A quantidade de dias deve ser maior que zero.", "Erro", JOptionPane.ERROR_MESSAGE);
                labelPrecoTotal.setText("Total: R$ 0,00");
                return;
            }

            // 2. Cálculo: Preço por dia * Quantidade de dias
            double precoDiario = Double.parseDouble(quartoSelecionado.getPreco());
            double precoTotal = precoDiario * dias;

            // 3. Atualiza o JLabel com o resultado
            labelPrecoTotal.setText("Total da Reserva (" + dias + " dias): " + df.format(precoTotal));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um número válido de dias.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
            labelPrecoTotal.setText("Total: R$ 0,00");
        }
    }
}
