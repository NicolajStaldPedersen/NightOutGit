package com.example.jale.nightoutgit.activities_and_fragments.data;

import android.location.Location;

/**
 * Created by Jale on 04-Nov-14.
 */
public class Friend {
    String name;
    Checkin checkin;
    boolean female;
    Location location;

    public Friend(String name,String bar,Checkin checkin,boolean male, Location location){
        this.name=name;
        this.checkin = checkin;
        this.female = male;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public Checkin getCheckin() {
        return checkin;
    }

    public boolean isFemale() {
        return female;
    }

    public Location getLocation() {
        return location;
    }
}
