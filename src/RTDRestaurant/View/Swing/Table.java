package RTDRestaurant.View.Swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Table extends JTable {

    public Table() {
        setShowHorizontalLines(true);
        setGridColor(new Color(230, 230, 230));
        setRowHeight(40);
        //getTableHeader().setResizingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                TableHeader header = new TableHeader(value + "");

                return header;
            }
        });
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                com.setBackground(Color.WHITE);
                setBorder(noFocusBorder);
                com.setFont(new Font("sansserif", 0, 14));
                if (isSelected) {
                    com.setForeground(Color.decode("#414345"));
                    com.setBackground(Color.decode("#E2E2E2"));
                } else {
                    com.setForeground(new Color(102, 102, 102));
                }
                return com;
            }

        });
    }

    public void addRow(Object[] row) {
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.addRow(row);
    }

    public void removeAllRow() {
        DefaultTableModel dm = (DefaultTableModel) getModel();
        dm.getDataVector().removeAllElements();
        revalidate();
    }
    public int getFirstCol_RowSelected(int row){
        row=Math.max(row, 0);
        int id;
        DefaultTableModel dm = (DefaultTableModel) getModel();
        id=(Integer)dm.getValueAt(row, 0);
        return id;
    }
}
