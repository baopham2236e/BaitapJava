import javax.swing.*;
import java.awt.*;
// object với class
public class MainUI {
    public void show() {
        JFrame frame = new JFrame("Hệ Thống Quản Lý Tiền Lương");
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));

        JLabel welcomeLabel = new JLabel("Chào mừng bạn đến với hệ thống!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
        mainPanel.add(welcomeLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JButton addEmployeeButton = new     JButton(" Thêm Nhân Viên ");
        JButton viewSalaryListButton = new  JButton("     Danh Sách       ");
        JButton editButton = new            JButton("      Chỉnh Sửa      ");
        JButton calculateSalaryButton = new JButton("   Tính Lương       ");
        JButton resultButton = new          JButton("     Kết Quả            ");
        JButton exitButton = new            JButton("      Thoát                ");

        int maxButtonWidth = Math.max(
                Math.max(addEmployeeButton.getPreferredSize().width, viewSalaryListButton.getPreferredSize().width),
                Math.max(Math.max(editButton.getPreferredSize().width, calculateSalaryButton.getPreferredSize().width),
                        Math.max(resultButton.getPreferredSize().width, exitButton.getPreferredSize().width)));

        Dimension buttonSize = new Dimension(maxButtonWidth, 50);

        addEmployeeButton.setPreferredSize(buttonSize);
        viewSalaryListButton.setPreferredSize(buttonSize);
        editButton.setPreferredSize(buttonSize);
        calculateSalaryButton.setPreferredSize(buttonSize);
        resultButton.setPreferredSize(buttonSize);
        exitButton.setPreferredSize(buttonSize);

        addEmployeeButton.setHorizontalAlignment(SwingConstants.CENTER);
        viewSalaryListButton.setHorizontalAlignment(SwingConstants.CENTER);
        editButton.setHorizontalAlignment(SwingConstants.CENTER);
        calculateSalaryButton.setHorizontalAlignment(SwingConstants.CENTER);
        resultButton.setHorizontalAlignment(SwingConstants.CENTER);
        exitButton.setHorizontalAlignment(SwingConstants.CENTER);

        buttonPanel.add(addEmployeeButton);
        buttonPanel.add(viewSalaryListButton);
        buttonPanel.add(editButton);
        buttonPanel.add(calculateSalaryButton);
        buttonPanel.add(resultButton);
        buttonPanel.add(exitButton);

        mainPanel.add(buttonPanel, BorderLayout.WEST);
        JPanel contentPanel = new JPanel(new CardLayout());
        JLabel defaultContent = new JLabel("Chọn chức năng từ menu bên trái.", SwingConstants.CENTER);
        contentPanel.add(defaultContent, "default");
//Chức năng các nút
        AddEmployeeUI addEmployeeUI = new AddEmployeeUI();
        JPanel addEmployeePanel = addEmployeeUI.createPanel();
        contentPanel.add(addEmployeePanel, "addEmployee");

        ViewEmployeesUI viewSalaryListUI = new ViewEmployeesUI();
        JPanel viewSalaryListPanel = viewSalaryListUI.createPanel();
        contentPanel.add(viewSalaryListPanel, "viewSalaryList");

        EditUI editUI = new EditUI();
        JPanel editPanel = editUI.createPanel();
        contentPanel.add(editPanel, "edit");

        CalculateSalaryUI calculateSalaryUI = new CalculateSalaryUI();
        JPanel calculateSalaryPanel = calculateSalaryUI.createPanel();
        contentPanel.add(calculateSalaryPanel, "calculateSalary");

        ResultUI resultUI = new ResultUI();
        JPanel resultPanel = resultUI.createPanel();
        contentPanel.add(resultPanel, "result");

        mainPanel.add(contentPanel, BorderLayout.CENTER);
        frame.add(mainPanel);

        CardLayout cardLayout = (CardLayout) contentPanel.getLayout();

        addEmployeeButton.addActionListener(e -> cardLayout.show(contentPanel, "addEmployee"));
        viewSalaryListButton.addActionListener(e -> cardLayout.show(contentPanel, "viewSalaryList"));
        editButton.addActionListener(e -> cardLayout.show(contentPanel, "edit"));
        calculateSalaryButton.addActionListener(e -> cardLayout.show(contentPanel, "calculateSalary"));
        resultButton.addActionListener(e -> cardLayout.show(contentPanel, "result"));
        resultButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Đây là kết quả!");
        });

        exitButton.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(frame, "Bạn có chắc chắn muốn thoát?", "Thoát", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }
}
