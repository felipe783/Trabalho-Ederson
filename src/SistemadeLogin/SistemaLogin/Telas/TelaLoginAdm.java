import javax.swing.*;
import java.awt.*;

public class TelaLoginAdm extends JFrame {
    private JTextField campoUsuario;
    private JPasswordField campoSenha;

    public TelaLoginAdm() {
        setTitle("Login do Administrador");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 10, 10));

        campoUsuario = new JTextField();
        campoSenha = new JPasswordField();
        JButton btnEntrar = new JButton("Entrar");
        JButton btnCancelar = new JButton("Cancelar");

        add(new JLabel("Usuário ADM:"));
        add(campoUsuario);
        add(new JLabel("Senha:"));
        add(campoSenha);
        add(btnEntrar);
        add(btnCancelar);

        btnEntrar.addActionListener(e -> autenticar());
        btnCancelar.addActionListener(e -> dispose());
    }

    private void autenticar() {
        String user = campoUsuario.getText().trim();
        String pass = new String(campoSenha.getPassword());

        if (user.equals("admin") && pass.equals("1234")) {
            JOptionPane.showMessageDialog(this, "Login do administrador bem-sucedido!");
            new TelaListaUsuarios().setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Usuário ou senha inválidos!");
        }
    }
}
