import javax.swing.*;
import java.awt.*;

public class TelaPrincipal extends JFrame {

    public TelaPrincipal() {
        setTitle("Sistema de Sistema.Cadastro e Administração");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1, 10, 10));

        JButton btnCadastrar = new JButton("Cadastrar Usuário");
        JButton btnSite = new JButton("Acessar o Site");
        JButton btnAdm = new JButton("Sistema ADM");
        JButton btnSair = new JButton("Sair");

        add(btnCadastrar);
        add(btnSite);
        add(btnAdm);
        add(btnSair);

        // Eventos de clique
        btnCadastrar.addActionListener(e -> new TelaCadastro().setVisible(true));
        btnSite.addActionListener(e -> new TelaLoginSite().setVisible(true));
        btnAdm.addActionListener(e -> new TelaLoginAdm().setVisible(true));
        btnSair.addActionListener(e -> System.exit(0));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaPrincipal().setVisible(true));
    }
}
