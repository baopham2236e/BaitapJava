import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface {
    public void show() {
        JFrame frame = new JFrame("Quản Lý Lương Nhân Viên");
        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel usernameLabel = new JLabel("Tên Đăng Nhập:");
        JTextField usernameField = new JTextField();

        JLabel passwordLabel = new JLabel("Mật Khẩu:");
        JPasswordField passwordField = new JPasswordField();

        JCheckBox showPasswordCheckBox = new JCheckBox("Hiển thị mật khẩu");

        JButton loginButton = new JButton("Đăng Nhập");

        mainPanel.add(usernameLabel);
        mainPanel.add(usernameField);
        mainPanel.add(passwordLabel);
        mainPanel.add(passwordField);
        mainPanel.add(new JLabel());
        mainPanel.add(showPasswordCheckBox);
        mainPanel.add(new JLabel());
        mainPanel.add(loginButton);

        frame.add(mainPanel);
        frame.setVisible(true);

        showPasswordCheckBox.addActionListener(e -> {
            if (showPasswordCheckBox.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if ("baopham2236e".equals(username) && "admin".equals(password)) {
                     JOptionPane.showMessageDialog(frame, "Đăng nhập thành công!");
                    frame.dispose();
                    MainUI mainUI = new MainUI();
                    mainUI.show();
                } else {
                    JOptionPane.showMessageDialog(frame, "Tên đăng nhập hoặc mật khẩu không đúng, vui lòng thử lại!");
                }
            }
        });
    }
}