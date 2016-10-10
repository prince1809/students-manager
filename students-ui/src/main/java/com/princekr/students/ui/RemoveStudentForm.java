package com.princekr.students.ui;

import com.princekr.students.callback.RemoveStudentCallback;
import com.princekr.students.model.Student;
import com.princekr.students.service.RemoveStudentFormService;
import com.princekr.students.serviceimpl.RemoveStudentFormServiceImpl;
import com.princekr.utils.NumberConstants;
import com.princekr.utils.StringConstants;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by prince on 10/10/16.
 */
public class RemoveStudentForm extends JDialog implements ActionListener{

    private JButton cancelButton;
    private JButton removeButton;
    private JLabel studentName;
    private JComboBox<Student> studentsComboBox;
    private RemoveStudentFormService removeStudentFormService;
    private RemoveStudentCallback removeStudentCallback;

    public RemoveStudentForm(JFrame parentFrame) {
        super(parentFrame, StringConstants.STUDENT_REMOVE_FORM_TITLE, false);

        initializeVariables();

        loadData();
        constructLayout();
        setWindow(parentFrame);
    }

    public void setCallback(RemoveStudentCallback removeStudentCallback) {
        this.removeStudentCallback = removeStudentCallback;
    }

    public void loadData() {
        this.studentsComboBox.removeAllItems();

        List<Student> students = this.removeStudentFormService.getAllStudents();

        for (Student s: students) {
            this.studentsComboBox.addItem(s);
        }

    }

    private void initializeVariables() {
        this.removeStudentFormService = new RemoveStudentFormServiceImpl();
        this.studentsComboBox = new JComboBox<Student>();
        this.cancelButton = new JButton(StringConstants.STUDENTS_FORM_CANCEL);
        this.removeButton = new JButton(StringConstants.STUDENTS_FORM_REMOVE);
        this.studentName = new JLabel(StringConstants.STUDENTS_FORM_NAME);

        this.cancelButton.addActionListener(this);
        this.removeButton.addActionListener(this);

    }

    private void constructLayout() {
        JPanel studentInfoPanel = new JPanel();
        JPanel buttonsPanel = new JPanel();

        Border spaceBorder = BorderFactory.createEmptyBorder(15, 15, 15, 15);
        Border titleBorder = BorderFactory.createTitledBorder(StringConstants.STUDENT_REMOVE_FORM_SUBTITLE);

        //students info panel
        studentInfoPanel.setBorder(BorderFactory.createCompoundBorder(spaceBorder,titleBorder));
        studentInfoPanel.setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        gc.gridy = 0;
        Insets rightPadding = new Insets(0, 0, 0, 15);
        Insets noPadding = new Insets(0, 0, 0, 0);

        //First row
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.EAST;
        gc.insets = rightPadding;
        studentInfoPanel.add(studentName,gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.WEST;
        gc.insets = noPadding;
        studentInfoPanel.add(studentsComboBox,gc);

        //Buttons panel
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonsPanel.add(removeButton);
        buttonsPanel.add(cancelButton);
        Dimension btnSize = removeButton.getPreferredSize();
        cancelButton.setPreferredSize(btnSize);

        // Add sub panels to dialog
        setLayout(new BorderLayout());
        add(studentInfoPanel,BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);
    }


    private void setWindow(JFrame parentFrame) {
        setSize(NumberConstants.STUDENT_REMOVE_FORM_WINDOW_SIZE_WIDTH,NumberConstants.STUDENT_REMOVE_FORM_WINDOW_SIZE_HEIGHT);
        setLocationRelativeTo(parentFrame);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.cancelButton) {
            setVisible(false);
        } else if (e.getSource() == this.removeButton) {

            Student student = (Student)this.studentsComboBox.getSelectedItem();
            this.removeStudentFormService.removeStudent(student);
            this.removeStudentCallback.studentRemoved();
            setVisible(false);

        }
    }
}
