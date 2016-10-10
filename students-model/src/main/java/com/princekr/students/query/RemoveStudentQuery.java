package com.princekr.students.query;

import com.princekr.students.model.EntityManagerHandler;
import com.princekr.students.model.Student;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by prince on 10/10/16.
 */
public class RemoveStudentQuery extends AbstractQuery {

    public RemoveStudentQuery() {
    }

    public List<Student> getAllStudents() {
        open();
        Query query = EntityManagerHandler.INSTANCE.getEntityManager().createQuery("SELECT s from Student s");
        List<Student> studentList = query.getResultList();
        return studentList;
    }

    public void removeStudent(Student student) {
        open();
        EntityManagerHandler.INSTANCE.getEntityManager().remove(student);
        EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
    }
}
