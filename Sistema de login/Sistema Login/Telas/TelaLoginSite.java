package Telas;

import Sistema.Cadastro;
import Sistema.Usuario;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaLoginSite extends JFrame {
    private JTextField campoUsuario;
    private JPasswordField campoSenha;

    public TelaLoginSite() {
        setTitle("Login do Usuário");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 10, 10));

        campoUsuario = new JTextField();
        campoSenha = new JPasswordField();
        JButton btnEntrar = new JButton("Entrar");
        JButton btnCancelar = new JButton("Cancelar");

        add(new JLabel("Usuário:"));
        add(campoUsuario);
        add(new JLabel("Senha:"));
        add(campoSenha);
        add(btnEntrar);
        add(btnCancelar);

        btnEntrar.addActionListener(e -> autenticar());
        btnCancelar.addActionListener(e -> dispose());
    }

    private void autenticar() {
        String nome = campoUsuario.getText().trim();
        String senha = new String(campoSenha.getPassword());

        List<Usuario> usuarios = Cadastro.getUsuarios();
        boolean autenticado = usuarios.stream()
                .anyMatch(u -> u.getNome().equalsIgnoreCase(nome) && u.getSenha().equals(senha));

        if (autenticado) {
            JOptionPane.showMessageDialog(this, "Bem-vindo(a), " + nome + "!");
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Usuário ou senha incorretos.");
        }
    }
}
