import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.text.DecimalFormat;
import java.io.FileWriter;
import java.io.IOException;

public class ResultUI {

    public JPanel createPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        String[] columnNames = {
                "Mã NV", "Họ Tên", "Ngày Sinh", "Giới Tính",
                "Số Căn Cước Công Dân", "Phòng Ban", "Lương Cơ Bản",
                "Giờ Làm", "Thưởng", "Thành Tiền"
        };

        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        JTable table = new JTable(tableModel);

        DecimalFormat df = new DecimalFormat("#,###");  // Định dạng số với dấu phân cách hàng nghìn

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

                double thanhTien = luongCoBan + gioLam * 20 + thuong;

                // Áp dụng định dạng cho các số
                String formattedLuongCoBan = df.format(luongCoBan);
                String formattedThanhTien = df.format(thanhTien);

                Object[] row = {maNV, hoTen, ngaySinh, gioiTinh, cccd, phongBan, formattedLuongCoBan, gioLam, thuong, formattedThanhTien};
                tableModel.addRow(row);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(panel, "Lỗi khi tải dữ liệu: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }

        table.getColumnModel().getColumn(7).setPreferredWidth(150);
        table.getColumnModel().getColumn(8).setPreferredWidth(100);
        table.getColumnModel().getColumn(9).setPreferredWidth(150);

        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton closeButton = new JButton("Đóng");
        JButton exportButton = new JButton("Xuất Kết Quả");
        JButton updateButton = new JButton("Cập Nhật");

        closeButton.addActionListener(e -> panel.setVisible(false));

        exportButton.addActionListener(e -> {
            try {
                exportToCSV(tableModel);
                JOptionPane.showMessageDialog(panel, "Kết quả đã được xuất thành công!", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(panel, "Lỗi khi xuất file: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        });

        updateButton.addActionListener(e -> {
            try (Connection conn = DatabaseConnection.getConnection()) {
                String updateQuery = "SELECT * FROM nhanvien";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(updateQuery);

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

                    double thanhTien = luongCoBan + gioLam * 20 + thuong;

                    String updateStmtQuery = "UPDATE nhanvien SET ThanhTien = ? WHERE CCCD = ?";
                    try (PreparedStatement updateStmt = conn.prepareStatement(updateStmtQuery)) {
                        updateStmt.setDouble(1, thanhTien);
                        updateStmt.setString(2, cccd);
                        updateStmt.executeUpdate();
                    }

                    // Áp dụng định dạng cho các số
                    String formattedLuongCoBan = df.format(luongCoBan);
                    String formattedThanhTien = df.format(thanhTien);

                    Object[] row = {maNV, hoTen, ngaySinh, gioiTinh, cccd, phongBan, formattedLuongCoBan, gioLam, thuong, formattedThanhTien};
                    tableModel.addRow(row);
                }

                JOptionPane.showMessageDialog(panel, "Cập nhật lương thành công!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(panel, "Lỗi khi cập nhật: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        });

        buttonPanel.add(updateButton);
        buttonPanel.add(exportButton);
        buttonPanel.add(closeButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private void exportToCSV(DefaultTableModel tableModel) throws IOException {
        try (FileWriter writer = new FileWriter("ketqua_luong.csv")) {
            for (int i = 0; i < tableModel.getColumnCount(); i++) {
                writer.write(tableModel.getColumnName(i));
                if (i < tableModel.getColumnCount() - 1) {
                    writer.write(",");
                }
            }
            writer.write("\n");

            for (int i = 0; i < tableModel.getRowCount(); i++) {
                for (int j = 0; j < tableModel.getColumnCount(); j++) {
                    writer.write(tableModel.getValueAt(i, j).toString());
                    if (j < tableModel.getColumnCount() - 1) {
                        writer.write(",");
                    }
                }
                writer.write("\n");
            }
        }
    }
}
