package com.example.filedataprocessing.datamodel.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.List;

public class LaptopTableRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table,
                                                   Object value,
                                                   boolean isSelected,
                                                   boolean hasFocus,
                                                   int row,
                                                   int column) {

        Component renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        Color background = table.getBackground();

        LaptopTableModel tableModel = (LaptopTableModel) table.getModel();
        List<UILaptop> tableLaptops = tableModel.getLaptops();
        UILaptop rowLaptop = tableLaptops.get(row);
        RecordStatus laptopRecordStatus = rowLaptop.getRecordStatus();
        switch (laptopRecordStatus) {
            case DUPLICATE -> background = Color.RED;
            case NEW -> background = Color.GRAY;
            case MODIFIED -> background = Color.WHITE;
        }

        renderer.setBackground(background);
        return renderer;
    }
}
