import ValidadorCPF;
import FormatTelefone.Formatador;
import Sistema.Cadastro;
import Sistema.Usuario;
import Sistema.GerenciadorDeArquivos;

import javax.swing.*;
import java.awt.*;

public class TelaCadastro extends JFrame {
    private JTextField campoNome, campoEmail, campoCpf, campoTelefone, campoEndereco;
    private JPasswordField campoSenha;

    public TelaCadastro() {
        setTitle("Sistema.Cadastro de Usuário");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(7, 2, 10, 10));

        campoNome = new JTextField();
        campoEmail = new JTextField();
        campoSenha = new JPasswordField();
        campoCpf = new JTextField();
        campoTelefone = new JTextField();
        campoEndereco = new JTextField();

        JButton btnSalvar = new JButton("Salvar");
        JButton btnCancelar = new JButton("Cancelar");

        add(new JLabel("Nome:"));
        add(campoNome);
        add(new JLabel("Email:"));
        add(campoEmail);
        add(new JLabel("Senha:"));
        add(campoSenha);
        add(new JLabel("CPF:"));
        add(campoCpf);
        add(new JLabel("Telefone:"));
        add(campoTelefone);
        add(new JLabel("Endereço:"));
        add(campoEndereco);
        add(btnSalvar);
        add(btnCancelar);

        btnSalvar.addActionListener(e -> salvarUsuario());
        btnCancelar.addActionListener(e -> dispose());
    }

    private void salvarUsuario() {
        try {
            String nome = campoNome.getText().trim();
            String email = campoEmail.getText().trim();
            String senha = new String(campoSenha.getPassword());
            String cpf = campoCpf.getText().trim();
            String telefone = campoTelefone.getText().trim();
            String endereco = campoEndereco.getText().trim();

            if (!ValidadorCPF.isValidCPF(cpf)) {
                JOptionPane.showMessageDialog(this, "CPF inválido!");
                return;
            }
            cpf = ValidadorCPF.formatCPF(cpf);
            telefone = Formatador.formatarTelefone(telefone.replaceAll("\\D", ""));

            Usuario u = new Usuario(0, nome, email, senha, cpf, telefone, endereco);
            int novoId = Cadastro.getUltimoId() + 1;
            u.setId(novoId);

            Cadastro.getUsuarios().add(u);
            Cadastro.setUltimoId(novoId);
            GerenciadorDeArquivos.salvarUsuarios(Cadastro.getUsuarios(), Cadastro.getUltimoId());

            JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso!");
            dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
        }
    }
}
