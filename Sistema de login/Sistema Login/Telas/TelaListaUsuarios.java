package Telas;

import Sistema.Cadastro;
import Sistema.Usuario;
import Sistema.GerenciadorDeArquivos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TelaListaUsuarios extends JFrame {

    private JTable tabela;
    private DefaultTableModel modelo;

    public TelaListaUsuarios() {
        setTitle("Lista de Usuários - Admin");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        modelo = new DefaultTableModel(new Object[]{"ID", "Nome", "Email", "Telefone", "CPF", "Endereço"}, 0);
        tabela = new JTable(modelo);

        JButton btnRemover = new JButton("Remover Selecionado");
        JButton btnFechar = new JButton("Fechar");

        JPanel painelBotoes = new JPanel();
        painelBotoes.add(btnRemover);
        painelBotoes.add(btnFechar);

        add(new JScrollPane(tabela), BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);

        carregarUsuarios();

        btnRemover.addActionListener(e -> removerSelecionado());
        btnFechar.addActionListener(e -> dispose());
    }

    private void carregarUsuarios() {
        modelo.setRowCount(0);
        List<Usuario> usuarios = Cadastro.getUsuarios();
        for (Usuario u : usuarios) {
            modelo.addRow(new Object[]{u.getId(), u.getNome(), u.getEmail(), u.getTelefone(), u.getCpf(), u.getEndereco()});
        }
    }

    private void removerSelecionado() {
        int linha = tabela.getSelectedRow();
        if (linha >= 0) {
            int id = (int) modelo.getValueAt(linha, 0);
            List<Usuario> usuarios = Cadastro.getUsuarios();
            usuarios.removeIf(u -> u.getId() == id);
            Cadastro.atualizarUltimoId();
            GerenciadorDeArquivos.salvarUsuarios(usuarios, Cadastro.getUltimoId());
            carregarUsuarios();
            JOptionPane.showMessageDialog(this, "Usuário removido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um usuário primeiro!");
        }
    }
}
