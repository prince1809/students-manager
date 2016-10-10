package com.princekr.students.serviceimpl;

import com.princekr.students.query.RemoveStudentQuery;
import com.princekr.students.model.Student;
import com.princekr.students.service.RemoveStudentFormService;

import java.util.List;

/**
 * Created by prince on 10/10/16.
 */
public class RemoveStudentFormServiceImpl implements RemoveStudentFormService{

    private RemoveStudentQuery  removeStudentQuery;

    public RemoveStudentFormServiceImpl() {
        this.removeStudentQuery = new RemoveStudentQuery();
    }
    public List<Student> getAllStudents() {
        return this.removeStudentQuery.getAllStudents();
    }

    public void removeStudent(Student student) {
        this.removeStudentQuery.removeStudent(student);
    }
}
