package com.bank.domain;

import java.time.LocalTime;

public class CurrentTime {
    private String specificTime = null;
    public CurrentTime(String initial){
        this.specificTime = initial;
    }

    public LocalTime getCurrentTime() {
        if(this.specificTime != null)
            return LocalTime.parse(this.specificTime);
        return LocalTime.now();
    }
}
