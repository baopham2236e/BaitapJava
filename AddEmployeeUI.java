import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddEmployeeUI {

    public JPanel createPanel() {
        JFrame frame = new JFrame();
//        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new GridLayout(11, 2, 10, 10));

        JLabel maNVLabel = new JLabel("Mã NV:");
        JTextField maNVField = new JTextField();

        JLabel hoTenLabel = new JLabel("Họ Tên:");
        JTextField hoTenField = new JTextField();

        JLabel ngaySinhLabel = new JLabel("Ngày Sinh (yyyy-MM-dd):");
        JTextField ngaySinhField = new JTextField();

        JLabel gioiTinhLabel = new JLabel("Giới Tính:");
        JComboBox<String> gioiTinhBox = new JComboBox<>(new String[]{"Nam", "Nữ", "Khác"});

        JLabel cccdLabel = new JLabel("Số căn cước công dân:");
        JTextField cccdField = new JTextField();

        JLabel phongBanLabel = new JLabel("Phòng Ban:");
        JTextField phongBanField = new JTextField();

        JLabel luongCoBanLabel = new JLabel("Lương Cơ Bản:");
        JTextField luongCoBanField = new JTextField();

        JLabel gioLamLabel = new JLabel("Giờ Làm:");
        JTextField gioLamField = new JTextField();

        JLabel thuongLabel = new JLabel("Thưởng:");
        JTextField thuongField = new JTextField();

        JLabel thanhTienLabel = new JLabel("Thành Tiền:");
        JTextField thanhTienField = new JTextField();
        thanhTienField.setEditable(false);

        JButton saveButton = new JButton("Lưu");
        JButton cancelButton = new JButton("Hủy");

        mainPanel.add(maNVLabel);
        mainPanel.add(maNVField);
        mainPanel.add(hoTenLabel);
        mainPanel.add(hoTenField);
        mainPanel.add(ngaySinhLabel);
        mainPanel.add(ngaySinhField);
        mainPanel.add(gioiTinhLabel);
        mainPanel.add(gioiTinhBox);
        mainPanel.add(cccdLabel);
        mainPanel.add(cccdField);
        mainPanel.add(phongBanLabel);
        mainPanel.add(phongBanField);
        mainPanel.add(luongCoBanLabel);
        mainPanel.add(luongCoBanField);
        mainPanel.add(gioLamLabel);
        mainPanel.add(gioLamField);
        mainPanel.add(thuongLabel);
        mainPanel.add(thuongField);
        mainPanel.add(thanhTienLabel);
        mainPanel.add(thanhTienField);
        mainPanel.add(saveButton);
        mainPanel.add(cancelButton);

        frame.add(mainPanel);
        frame.setVisible(true);

        saveButton.addActionListener((ActionEvent e) -> {
            try {
                String maNV = maNVField.getText().trim();
                String hoTen = hoTenField.getText().trim();
                String ngaySinh = ngaySinhField.getText().trim();
                String gioiTinh = (String) gioiTinhBox.getSelectedItem();
                String cccd = cccdField.getText().trim();
                String phongBan = phongBanField.getText().trim();
                String luongCoBan = luongCoBanField.getText().trim();
                String gioLam = gioLamField.getText().trim();
                String thuong = thuongField.getText().trim();

                if (hoTen.isEmpty() || ngaySinh.isEmpty() || cccd.isEmpty() || phongBan.isEmpty() ||
                        luongCoBan.isEmpty() || gioLam.isEmpty() || thuong.isEmpty() || maNV.isEmpty()) {
                    JOptionPane.showMessageDialog(mainPanel, "Vui lòng nhập đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }
//regex:
                if (!ngaySinh.matches("\\d{4}-\\d{2}-\\d{2}")) {
                    JOptionPane.showMessageDialog(mainPanel, "Ngày sinh không đúng định dạng (yyyy-MM-dd)!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!cccd.matches("\\d+")) {
                    JOptionPane.showMessageDialog(mainPanel, "Số CCCD phải là số!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Tính Thành Tiền
                double luongCoBanValue = Double.parseDouble(luongCoBan);
                int gioLamValue = Integer.parseInt(gioLam);
                double thuongValue = Double.parseDouble(thuong);
                double thanhTienValue = luongCoBanValue * gioLamValue * 20 + thuongValue; // Giả sử Thành Tiền = Lương Cơ Bản * Giờ Làm * 20 + Thưởng
                thanhTienField.setText(String.format("%.2f", thanhTienValue));  // Hiển thị Thành Tiền

                try (Connection conn = DatabaseConnection.getConnection()) {
                    String checkQuery = "SELECT * FROM nhanvien WHERE MaNV = ?";
                    PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
                    checkStmt.setString(1, maNV);

                    var rs = checkStmt.executeQuery();
                    if (rs.next() && rs.getInt(1) > 0) {
                        JOptionPane.showMessageDialog(mainPanel, "Mã nhân viên đã tồn tại, vui lòng nhập mã khác!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    String insertQuery = "INSERT INTO nhanvien (MaNV, HoTen, NgaySinh, GioiTinh, CCCD, PhongBan, LuongCoBan, GioLam, Thuong, ThanhTien) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
                    insertStmt.setString(1, maNV);
                    insertStmt.setString(2, hoTen);
                    insertStmt.setString(3, ngaySinh);
                    insertStmt.setString(4, gioiTinh);
                    insertStmt.setString(5, cccd);
                    insertStmt.setString(6, phongBan);
                    insertStmt.setString(7, luongCoBan);
                    insertStmt.setString(8, gioLam);
                    insertStmt.setString(9, thuong);
                    insertStmt.setDouble(10, thanhTienValue);  // Lưu Thành Tiền vào cơ sở dữ liệu

                    insertStmt.executeUpdate();
                    JOptionPane.showMessageDialog(mainPanel, "Thêm nhân viên thành công!");

                    maNVField.setText("");
                    hoTenField.setText("");
                    ngaySinhField.setText("");
                    gioiTinhBox.setSelectedIndex(0);
                    cccdField.setText("");
                    phongBanField.setText("");
                    luongCoBanField.setText("");
                    gioLamField.setText("");
                    thuongField.setText("");
                    thanhTienField.setText("0");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(mainPanel, "Lỗi khi lưu vào cơ sở dữ liệu: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(mainPanel, "Lỗi: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        });

        cancelButton.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(mainPanel, "Bạn có chắc muốn xóa toàn bộ dữ liệu đã nhập không?",
                    "Xác Nhận", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                maNVField.setText("");
                hoTenField.setText("");
                ngaySinhField.setText("");
                gioiTinhBox.setSelectedIndex(0);
                cccdField.setText("");
                phongBanField.setText("");
                luongCoBanField.setText("");
                gioLamField.setText("");
                thuongField.setText("");
                thanhTienField.setText("0");
            }
        });

        return mainPanel;
    }
}
