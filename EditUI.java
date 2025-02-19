import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class EditUI {

    public JPanel createPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        String[] columnNames = {"Mã NV", "Họ Tên", "Ngày Sinh", "Giới Tính", "CCCD", "Phòng Ban", "Lương Cơ Bản", "Giờ Làm", "Thưởng"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);

        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM nhanvien";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int maNV = rs.getInt("MaNV");
                String hoTen = rs.getString("HoTen");
                String ngaySinh = rs.getString("NgaySinh");
                String gioiTinh = rs.getString("GioiTinh");
                String cccd = rs.getString("CCCD");
                String phongBan = rs.getString("PhongBan");
                double luongCoBan = rs.getDouble("LuongCoBan");
                int gioLam = rs.getInt("GioLam");
                double thuong = rs.getDouble("Thuong");

                Object[] row = {maNV, hoTen, ngaySinh, gioiTinh, cccd, phongBan, luongCoBan, gioLam, thuong};
                tableModel.addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(panel, "Lỗi khi tải dữ liệu: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }

        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton editButton = new JButton("Chỉnh Sửa");
        JButton updateButton = new JButton("Cập Nhật");
        JButton deleteButton = new JButton("Xóa");
        JButton closeButton = new JButton("Đóng");

        buttonPanel.add(editButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(closeButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Edit button functionality
        editButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(panel, "Vui lòng chọn một nhân viên để chỉnh sửa!", "Thông Báo", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int maNV = (int) tableModel.getValueAt(selectedRow, 0);
            String hoTen = (String) tableModel.getValueAt(selectedRow, 1);
            String ngaySinh = (String) tableModel.getValueAt(selectedRow, 2);
            String gioiTinh = (String) tableModel.getValueAt(selectedRow, 3);
            String cccd = (String) tableModel.getValueAt(selectedRow, 4);
            String phongBan = (String) tableModel.getValueAt(selectedRow, 5);
            double luongCoBan = (double) tableModel.getValueAt(selectedRow, 6);
            int gioLam = (int) tableModel.getValueAt(selectedRow, 7);
            double thuong = (double) tableModel.getValueAt(selectedRow, 8);

            JPanel editPanel = new JPanel(new GridLayout(10, 2, 10, 10));
            JTextField hoTenField = new JTextField(hoTen);
            JTextField ngaySinhField = new JTextField(ngaySinh);
            JComboBox<String> gioiTinhBox = new JComboBox<>(new String[]{"Nam", "Nữ", "Khác"});
            gioiTinhBox.setSelectedItem(gioiTinh);
            JTextField cccdField = new JTextField(cccd);
            JTextField phongBanField = new JTextField(phongBan);
            JTextField luongCoBanField = new JTextField(String.valueOf(luongCoBan));
            JTextField gioLamField = new JTextField(String.valueOf(gioLam));
            JTextField thuongField = new JTextField(String.valueOf(thuong));

            editPanel.add(new JLabel("Họ Tên:"));
            editPanel.add(hoTenField);
            editPanel.add(new JLabel("Ngày Sinh (yyyy-MM-dd):"));
            editPanel.add(ngaySinhField);
            editPanel.add(new JLabel("Giới Tính:"));
            editPanel.add(gioiTinhBox);
            editPanel.add(new JLabel("CCCD:"));
            editPanel.add(cccdField);
            editPanel.add(new JLabel("Phòng Ban:"));
            editPanel.add(phongBanField);
            editPanel.add(new JLabel("Lương Cơ Bản:"));
            editPanel.add(luongCoBanField);
            editPanel.add(new JLabel("Giờ Làm:"));
            editPanel.add(gioLamField);
            editPanel.add(new JLabel("Thưởng:"));
            editPanel.add(thuongField);

            JButton saveButton = new JButton("Lưu");
            editPanel.add(saveButton);
            panel.add(editPanel, BorderLayout.EAST);
            panel.revalidate();
            panel.repaint();

            saveButton.addActionListener(saveEvent -> {
                try {
                    String newHoTen = hoTenField.getText().trim();
                    String newNgaySinh = ngaySinhField.getText().trim();
                    String newGioiTinh = (String) gioiTinhBox.getSelectedItem();
                    String newCCCD = cccdField.getText().trim();
                    String newPhongBan = phongBanField.getText().trim();
                    double newLuongCoBan = Double.parseDouble(luongCoBanField.getText().trim());
                    int newGioLam = Integer.parseInt(gioLamField.getText().trim());
                    double newThuong = Double.parseDouble(thuongField.getText().trim());

                    try (Connection conn = DatabaseConnection.getConnection()) {
                        String query = "UPDATE nhanvien SET HoTen = ?, NgaySinh = ?, GioiTinh = ?, CCCD = ?, PhongBan = ?, LuongCoBan = ?, GioLam = ?, Thuong = ? WHERE MaNV = ?";
                        PreparedStatement stmt = conn.prepareStatement(query);
                        stmt.setString(1, newHoTen);
                        stmt.setString(2, newNgaySinh);
                        stmt.setString(3, newGioiTinh);
                        stmt.setString(4, newCCCD);
                        stmt.setString(5, newPhongBan);
                        stmt.setDouble(6, newLuongCoBan);
                        stmt.setInt(7, newGioLam);
                        stmt.setDouble(8, newThuong);
                        stmt.setInt(9, maNV);

                        stmt.executeUpdate();
                        JOptionPane.showMessageDialog(panel, "Lưu thông tin nhân viên thành công!");

                        panel.remove(editPanel);
                        panel.revalidate();
                        panel.repaint();
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(panel, "Lỗi khi cập nhật: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            });
        });

        // Update button functionality
        updateButton.addActionListener(e -> {
            try (Connection conn = DatabaseConnection.getConnection()) {
                String query = "SELECT * FROM nhanvien";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                tableModel.setRowCount(0);

                while (rs.next()) {
                    int maNV = rs.getInt("MaNV");
                    String hoTen = rs.getString("HoTen");
                    String ngaySinh = rs.getString("NgaySinh");
                    String gioiTinh = rs.getString("GioiTinh");
                    String cccd = rs.getString("CCCD");
                    String phongBan = rs.getString("PhongBan");
                    double luongCoBan = rs.getDouble("LuongCoBan");
                    int gioLam = rs.getInt("GioLam");
                    double thuong = rs.getDouble("Thuong");

                    Object[] row = {maNV, hoTen, ngaySinh, gioiTinh, cccd, phongBan, luongCoBan, gioLam, thuong};
                    tableModel.addRow(row);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(panel, "Lỗi khi tải lại dữ liệu: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Delete button functionality
        deleteButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(panel, "Vui lòng chọn một nhân viên để xóa!", "Thông Báo", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int maNV = (int) tableModel.getValueAt(selectedRow, 0);
            int confirm = JOptionPane.showConfirmDialog(panel, "Bạn có chắc chắn muốn xóa nhân viên này?", "Xác Nhận", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try (Connection conn = DatabaseConnection.getConnection()) {
                    String query = "DELETE FROM nhanvien WHERE MaNV = ?";
                    PreparedStatement stmt = conn.prepareStatement(query);
                    stmt.setInt(1, maNV);
                    stmt.executeUpdate();

                    JOptionPane.showMessageDialog(panel, "Nhân viên đã được xóa thành công!");

                    // Remove row from table
                    tableModel.removeRow(selectedRow);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(panel, "Lỗi khi xóa nhân viên: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Close button functionality
        closeButton.addActionListener(e -> panel.setVisible(false));

        return panel;
    }
}
