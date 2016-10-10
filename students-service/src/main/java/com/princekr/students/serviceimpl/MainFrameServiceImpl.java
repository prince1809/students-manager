package com.princekr.students.serviceimpl;

import com.princekr.students.query.MainFrameQuery;
import com.princekr.students.model.Student;
import com.princekr.students.service.MainFrameService;

import java.util.List;

/**
 * Created by prince on 10/8/16.
 */
public class MainFrameServiceImpl implements MainFrameService {

    private MainFrameQuery mainFrameQuery;

    public MainFrameServiceImpl() {
        this.mainFrameQuery = new MainFrameQuery();
    }

    public void shutdown(){
        this.mainFrameQuery.shutdown();
    }

    public List<Student> getAllStudents() {
        return this.mainFrameQuery.getStudents();
    }
}
