import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.text.DecimalFormat;

public class ViewEmployeesUI {

    private JTable table;
    private DefaultTableModel tableModel;

    public JPanel createPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        String[] columnNames = {"Mã NV", "Họ Tên", "Ngày Sinh", "Giới Tính", "Số Căn Cước Công Dân", "Phòng Ban", "Lương Cơ Bản", "Giờ Làm", "Thưởng"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton updateButton = new JButton("Cập Nhật");
        updateButton.addActionListener(e -> loadDataToTable());

        JButton closeButton = new JButton("Đóng");
        closeButton.addActionListener(e -> panel.setVisible(false));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(updateButton);
        buttonPanel.add(closeButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        loadDataToTable();

        return panel;
    }

    private void loadDataToTable() {
        // Định dạng số với dấu phân cách hàng nghìn
        DecimalFormat df = new DecimalFormat("#,###");

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

                // Định dạng các số "Lương Cơ Bản" và "Thưởng"
                String formattedLuongCoBan = df.format(luongCoBan);
                String formattedThuong = df.format(thuong);

                // Thêm các giá trị đã định dạng vào bảng
                Object[] row = {maNV, hoTen, ngaySinh, gioiTinh, cccd, phongBan, formattedLuongCoBan, gioLam, formattedThuong};
                tableModel.addRow(row);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi tải dữ liệu: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
}
