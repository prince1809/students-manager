package com.princekr.students.ui;

import com.princekr.students.model.Student;
import com.princekr.utils.NumberConstants;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by prince on 10/8/16.
 */
public class TableModel extends AbstractTableModel {

    private List<Student> studentsList;
    private String[] colName = {"ID","NAME","AGE","COUNTRY","ZIP"};

    public TableModel(List<Student> studentsList) {
        this.studentsList = new ArrayList<Student>();
    }

    public TableModel() {

    }

    @Override
    public String getColumnName(int column) {
        return this.colName[column];
    }

    public int getRowCount() {
        return this.studentsList.size();
    }

    public int getColumnCount() {
        return NumberConstants.NUM_OF_COLUMNS;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {

        Student student = this.studentsList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return student.getId();
            case 1:
                return student.getName();
            case 2:
                return student.getAge();
            case 3:
                return student.getCountry();
            case 4:
                return student.getZipCode();
            default:
                return null;
        }
    }

    public void setStudentsList(List<Student> studentsList) {
        this.studentsList = studentsList;
    }

    public void updateTable() {
        fireTableDataChanged();
    }
}
