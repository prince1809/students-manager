package com.princekr.students.model;

/**
 * Created by prince on 10/10/16.
 */
public enum  DatabaseHandler {

    INSTANCE;

    private Database database = new Database();

    public Database getInstance() {
        return this.database;
    }

}
