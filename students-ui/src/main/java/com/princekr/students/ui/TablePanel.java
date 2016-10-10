package com.princekr.students.ui;

import com.princekr.students.model.Student;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.List;

/**
 * Created by prince on 10/8/16.
 */
public class TablePanel extends JPanel {

    private JTable studentsTable;
    private TableModel tableModel;

    public TablePanel() {

        initializeVariables();
        initializeLayout();
        initializeHeaderAlignment();
        initializeTableAlignment();
    }

    private void initializeTableAlignment() {
        DefaultTableCellRenderer tableCellRenderer = new DefaultTableCellRenderer();
        tableCellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        this.studentsTable.getColumnModel().getColumn(0).setCellRenderer(tableCellRenderer);
        this.studentsTable.getColumnModel().getColumn(1).setCellRenderer(tableCellRenderer);
        this.studentsTable.getColumnModel().getColumn(2).setCellRenderer(tableCellRenderer);
        this.studentsTable.getColumnModel().getColumn(3).setCellRenderer(tableCellRenderer);
        this.studentsTable.getColumnModel().getColumn(4).setCellRenderer(tableCellRenderer);
    }

    private void initializeHeaderAlignment() {
        DefaultTableCellRenderer headerCellRenderer = new DefaultTableCellRenderer();
        headerCellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        this.studentsTable.getTableHeader().setDefaultRenderer(headerCellRenderer);
    }

    private void initializeVariables() {
        this.tableModel = new TableModel();
        this.studentsTable = new JTable(tableModel);
    }

    private void initializeLayout() {
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(10, 30, 10, 30));
        add(new JScrollPane(studentsTable), BorderLayout.CENTER);
    }

    public void setTableModel(List<Student> studentList) {
        this.tableModel.setStudentsList(studentList);
    }

    public void updateTable() {
        this.tableModel.updateTable();
    }

}
