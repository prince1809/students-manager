package com.princekr.students.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by prince on 10/10/16.
 */

@MappedSuperclass
public class AbstractStudent {

    public AbstractStudent() {
    }

    @Column(name = "country")
    protected String country;

    @Column(name = "zip_code")
    protected int zipCode;

    public void setCountry(String country) {
        this.country = country;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public int getZipCode() {
        return zipCode;
    }
}
