package com.princekr.students.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prince on 10/8/16.
 */
public class Database {

    private List<Student> students = new ArrayList<Student>();

    public Database(){
        this.students.add(new Student("Prince", 26, "Japan", 1710021));
        this.students.add(new Student("Rahul", 25, "India", 804433));
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public void removeStudent(Student student) {
        this.students.remove(student);
    }
}
