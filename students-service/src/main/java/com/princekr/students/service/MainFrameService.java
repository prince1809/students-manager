package com.princekr.students.service;

import com.princekr.students.model.Student;

import java.util.List;

/**
 * Created by prince on 10/8/16.
 */
public interface MainFrameService {

    public List<Student> getAllStudents();

    public void shutdown();
}
