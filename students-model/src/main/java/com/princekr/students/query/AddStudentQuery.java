package com.princekr.students.query;

import com.princekr.students.model.EntityManagerHandler;
import com.princekr.students.model.Student;

/**
 * Created by prince on 10/10/16.
 */
public class AddStudentQuery  extends AbstractQuery{

    public AddStudentQuery() {

    }

    public void insertStudent(Student student) {
        open();
        EntityManagerHandler.INSTANCE.getEntityManager().persist(student);
        EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
    }
}
