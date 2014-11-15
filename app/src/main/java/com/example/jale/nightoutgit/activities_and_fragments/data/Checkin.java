package com.example.jale.nightoutgit.activities_and_fragments.data;

import java.util.Date;

/**
 * Created by Jale on 04-Nov-14.
 */
public class Checkin {
    Date date;
    String place;
    public Checkin(){

    }
    public Checkin(Date checkin, String place){
        this.date = checkin;
        this.place = place;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

}
