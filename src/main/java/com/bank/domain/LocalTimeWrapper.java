package com.bank.domain;

import org.omg.CORBA.Current;

import java.time.LocalTime;

public class LocalTimeWrapper {

    private String specificTime = null;
    public LocalTimeWrapper(String initial){
        this.specificTime = initial;
    }

    public LocalTimeWrapper() {

    }

    public LocalTime getCurrentTime() {
        if(this.specificTime != null)
            return LocalTime.parse(this.specificTime);
        return LocalTime.now();
    }
}
