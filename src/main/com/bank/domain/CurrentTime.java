package com.bank.domain;

import org.omg.CORBA.Current;

import java.time.LocalTime;

public class CurrentTime {

    private String specificTime = null;
    public CurrentTime(String initial){
        this.specificTime = initial;
    }

    public CurrentTime() {

    }

    public LocalTime getCurrentTime() {
        if(this.specificTime != null)
            return LocalTime.parse(this.specificTime);
        return LocalTime.now();
    }
}
