package com.princekr.students.query;

import com.princekr.students.model.EntityManagerHandler;

/**
 * Created by prince on 10/10/16.
 */
public class AbstractQuery {

    public void open() {
        EntityManagerHandler.INSTANCE.open();
    }

    public void shutdown(){
        EntityManagerHandler.INSTANCE.shutdown();
    }

}
