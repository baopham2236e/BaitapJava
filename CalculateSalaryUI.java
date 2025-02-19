import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.text.DecimalFormat;

public class CalculateSalaryUI {

    public JPanel createPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        String[] columnNames = {"Mã NV", "Họ Tên", "Lương Cơ Bản", "Giờ Làm", "Thưởng", "Thành Tiền"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);

        DecimalFormat decimalFormat = new DecimalFormat("#,###");

        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM nhanvien";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int maNV = rs.getInt("MaNV");
                String hoTen = rs.getString("HoTen");
                double luongCoBan = rs.getDouble("LuongCoBan");
                int gioLam = rs.getInt("GioLam");
                double thuong = rs.getDouble("Thuong");

                long thanhTien = Math.round(luongCoBan + gioLam * 20 + thuong);

                String formattedThanhTien = decimalFormat.format(thanhTien);

                String updateQuery = "UPDATE nhanvien SET ThanhTien = ? WHERE MaNV = ?";
                try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
                    updateStmt.setLong(1, thanhTien);
                    updateStmt.setInt(2, maNV);
                    updateStmt.executeUpdate();
                }

                Object[] row = {maNV, hoTen, luongCoBan, gioLam, thuong, formattedThanhTien};
                tableModel.addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(panel, "Lỗi khi tải dữ liệu: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }

        table.getColumnModel().getColumn(2).setPreferredWidth(150);
        table.getColumnModel().getColumn(5).setPreferredWidth(150);

        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton updateButton = new JButton("Cập Nhật");
        JButton closeButton = new JButton("Đóng");

        updateButton.addActionListener(e -> {
            try (Connection conn = DatabaseConnection.getConnection()) {
                String updateQuery = "SELECT * FROM nhanvien";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(updateQuery);
                tableModel.setRowCount(0);

                while (rs.next()) {
                    int maNV = rs.getInt("MaNV");
                    String hoTen = rs.getString("HoTen");
                    double luongCoBan = rs.getDouble("LuongCoBan");
                    int gioLam = rs.getInt("GioLam");
                    double thuong = rs.getDouble("Thuong");
                    long thanhTien = Math.round(luongCoBan + gioLam * 20 + thuong);

                    String formattedThanhTien = decimalFormat.format(thanhTien);

                    String updateStmtQuery = "UPDATE nhanvien SET ThanhTien = ? WHERE MaNV = ?";
                    try (PreparedStatement updateStmt = conn.prepareStatement(updateStmtQuery)) {
                        updateStmt.setLong(1, thanhTien);
                        updateStmt.setInt(2, maNV);
                        updateStmt.executeUpdate();
                    }

                    Object[] row = {maNV, hoTen, luongCoBan, gioLam, thuong, formattedThanhTien};
                    tableModel.addRow(row);
                }

                JOptionPane.showMessageDialog(panel, "Cập nhật lương thành công!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(panel, "Lỗi khi cập nhật: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        });

        closeButton.addActionListener(e -> panel.setVisible(false));

        buttonPanel.add(updateButton);
        buttonPanel.add(closeButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }
}
