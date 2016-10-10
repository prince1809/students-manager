package com.princekr.students.model;

import javax.persistence.*;

/**
 * Created by prince on 10/8/16.
 */
@Entity(name = "Student")
@Table(name = "STUDENT")
public class Student extends AbstractStudent {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    public Student() {

    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public Student(String name, int age, String country, int zipCode) {
        this.name = name;
        this.age = age;
        this.country = country;
        this.zipCode = zipCode;
    }



    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + '-' + age;
    }
}

