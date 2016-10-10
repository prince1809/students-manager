package com.princekr.students.ui;

import com.princekr.students.callback.AddStudentCallback;
import com.princekr.students.model.Student;
import com.princekr.students.service.AddStudentFormService;
import com.princekr.students.serviceimpl.AddStudentFormServiceImpl;
import com.princekr.utils.NumberConstants;
import com.princekr.utils.StringConstants;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by prince on 10/9/16.
 */
public class AddStudentsForm extends JDialog implements ActionListener{

    private JButton cancelButton;
    private JButton saveButton;

    private JLabel nameLabel;
    private JLabel ageLabel;
    private JLabel countryLabel;
    private JLabel zipCodeLabel;

    private JTextField nameField;
    private JTextField ageField;
    private JTextField countryField;
    private JTextField zipCodeField;

    private AddStudentFormService addStudentFormService;
    private AddStudentCallback addStudentCallback;


    public AddStudentsForm(JFrame parentFrame) {
        super(parentFrame, StringConstants.STUDENTS_FORM_TITLE, false);

        initializeVariables();
        constructLayout();
        setWindow(parentFrame);
    }

    private void setWindow(JFrame parentFrame) {
        setSize(NumberConstants.STUDENTS_FORM_WINDOW_SIZE_WIDTH, NumberConstants.STUDENTS_FORM_WINDOW_SIZE_HEIGHT);
        setLocationRelativeTo(parentFrame);
    }

    private void initializeVariables() {

        this.addStudentFormService = new AddStudentFormServiceImpl();

        this.cancelButton = new JButton(StringConstants.STUDENTS_FORM_CANCEL);
        this.saveButton = new JButton(StringConstants.STUDENTS_FORM_SAVE);

        this.nameLabel = new JLabel(StringConstants.STUDENTS_FORM_NAME);
        this.ageLabel = new JLabel(StringConstants.STUDENTS_FORM_AGE);
        this.countryLabel = new JLabel(StringConstants.STUDENTS_FORM_COUNTRY);
        this.zipCodeLabel = new JLabel(StringConstants.STUDENTS_FORM_ZIP_CODE);

        this.nameField = new JTextField(NumberConstants.STUDENTS_FORM_WINDOW_FIELD_LENGTH);
        this.ageField = new JTextField(NumberConstants.STUDENTS_FORM_WINDOW_FIELD_LENGTH);
        this.countryField = new JTextField(NumberConstants.STUDENTS_FORM_WINDOW_FIELD_LENGTH);
        this.zipCodeField = new JTextField(NumberConstants.STUDENTS_FORM_WINDOW_FIELD_LENGTH);

        this.cancelButton.addActionListener(this);
        this.saveButton.addActionListener(this);


    }

    private void constructLayout() {

        JPanel studentInfoPanel = new JPanel();
        JPanel buttonsPanel = new JPanel();

        int space = 15;
        Border spaceBorder = BorderFactory.createEmptyBorder(space, space, space, space);
        Border titleBorder = BorderFactory.createTitledBorder(StringConstants.STUDENT_FORM_SUBTITLE);

        studentInfoPanel.setBorder(BorderFactory.createCompoundBorder(spaceBorder, titleBorder));
        studentInfoPanel.setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
        gc.gridy = 0;

        Insets rightPadding = new Insets(0, 0, 0, 15);
        Insets noPadding = new Insets(0, 0, 0, 0);

        //First Row
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.EAST;
        gc.insets = rightPadding;
        studentInfoPanel.add(nameLabel,gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.WEST;
        gc.insets = noPadding;
        studentInfoPanel.add(nameField,gc);

        //Next Row
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.EAST;
        gc.insets = rightPadding;
        studentInfoPanel.add(ageLabel, gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.WEST;
        gc.insets = noPadding;
        studentInfoPanel.add(ageField, gc);

        //Next Row
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.EAST;
        gc.insets = rightPadding;
        studentInfoPanel.add(countryLabel, gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.WEST;
        gc.insets = noPadding;
        studentInfoPanel.add(countryField, gc);

        //Next Row
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.EAST;
        gc.insets = rightPadding;
        studentInfoPanel.add(zipCodeLabel, gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.WEST;
        gc.insets = noPadding;
        studentInfoPanel.add(zipCodeField, gc);


        //Buttons panel
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonsPanel.add(saveButton);
        buttonsPanel.add(cancelButton);

        Dimension btnSize = cancelButton.getPreferredSize();
        saveButton.setPreferredSize(btnSize);

        //Add sub panels to dialog
        setLayout(new BorderLayout());
        add(studentInfoPanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.cancelButton) {
            setVisible(false);
        } else if (e.getSource() == this.saveButton) {

            String name = this.nameField.getText();
            int age = Integer.parseInt(this.ageField.getText());
            String country = this.countryField.getText();
            int zipCode = Integer.parseInt(this.zipCodeField.getText());
            Student student = new Student(name, age, country, zipCode);
            this.addStudentFormService.insertStudent(student);
            this.addStudentCallback.studentSaved();
            setVisible(false);
        }
    }

    public void setCallback(AddStudentCallback addStudentCallback) {
        this.addStudentCallback = addStudentCallback;
    }
}
