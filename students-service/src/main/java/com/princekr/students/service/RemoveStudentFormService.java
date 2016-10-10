package com.princekr.students.service;

import com.princekr.students.model.Student;

import java.util.List;

/**
 * Created by prince on 10/10/16.
 */
public interface RemoveStudentFormService {
    public List<Student> getAllStudents();
    public void removeStudent(Student student);
}
