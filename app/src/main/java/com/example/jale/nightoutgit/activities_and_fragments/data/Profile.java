package com.example.jale.nightoutgit.activities_and_fragments.data;

import android.location.Location;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.PriorityQueue;

/**
 * Created by Jale on 04-Nov-14.
 */
public class Profile {
    static String name, email, id, password;
    static boolean male;
    static Location location;
    static PriorityQueue<Checkin> checkins = new PriorityQueue<Checkin>();
    static PriorityQueue<Friend> friends = new PriorityQueue<Friend>();


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile(JSONObject response){
        try {
            name = response.getString("FirstName")+" "+response.getString("LastName");
            id = response.getString("Id");
            email = response.getString("Email");
            male =true;
        } catch (JSONException e) {
            e.printStackTrace();
        }



}

    public int compare(Friend friend1,Friend friend2){
        if(location.distanceTo(friend1.getLocation())>location.distanceTo(friend2.getLocation())){
            return 1;
        }else if(location.distanceTo(friend1.getLocation())<location.distanceTo(friend2.getLocation())){
            return -1;
        }else{
            return 0;
        }
    }
    public int compare(Checkin checkins1, Checkin checkins2){
        if(checkins1.getDate().after(checkins2.getDate())){
            return 1;
        }else if(checkins1.getDate().before(checkins2.getDate())){
            return -1;
        }else{
            return 0;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean female) {
        this.male = female;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PriorityQueue<Checkin> getCheckins() {
        return checkins;
    }

    public void setCheckins(PriorityQueue<Checkin> checkins) {
        this.checkins = checkins;
    }

    public PriorityQueue<Friend> getFriends() {
        return friends;
    }

    public void setFriends(PriorityQueue<Friend> friends) {
        this.friends = friends;
    }
}
