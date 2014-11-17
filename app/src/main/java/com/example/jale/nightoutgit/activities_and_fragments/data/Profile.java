package com.example.jale.nightoutgit.activities_and_fragments.data;

import android.location.Location;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by Nicolaj Pedersen on 04-Nov-14.
 */
public class Profile {
    public static String firstName, lastName, email, id, password;
    public static boolean male;
    public static ArrayList<Checkin> checkins = new ArrayList<Checkin>();
    public static ArrayList<Friend> friends = new ArrayList<Friend>();


    public static String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile(JSONObject response) {
        try {
            firstName = response.getString("FirstName");
            lastName = response.getString("LastName");
            id = response.getString("Id");
            email = response.getString("Email");
            male = true;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        Profile.id = id;
    }

    public static String getFirstName() {
        return firstName;
    }

    public static void setFirstName(String firstName) {
        Profile.firstName = firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public static void setLastName(String lastName) {
        Profile.lastName = lastName;
    }

    public static void setCheckins(ArrayList<Checkin> checkins) {
        Profile.checkins = checkins;
    }

    public static void setFriends(ArrayList<Friend> friends) {
        Profile.friends = friends;
    }

    public static String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        Profile.email = email;
    }

    public static boolean isMale() {
        return male;
    }

    public static void setMale(boolean male) {
        Profile.male = male;
    }
}


