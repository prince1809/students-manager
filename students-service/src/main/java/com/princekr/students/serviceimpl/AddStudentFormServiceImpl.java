package com.princekr.students.serviceimpl;

import com.princekr.students.query.AddStudentQuery;
import com.princekr.students.model.Student;
import com.princekr.students.service.AddStudentFormService;

/**
 * Created by prince on 10/10/16.
 */
public class AddStudentFormServiceImpl implements AddStudentFormService {

    private AddStudentQuery addStudentQuery;

    public AddStudentFormServiceImpl() {
        this.addStudentQuery = new AddStudentQuery();
    }

    public void insertStudent(Student student) {
        this.addStudentQuery.insertStudent(student);
    }
}
