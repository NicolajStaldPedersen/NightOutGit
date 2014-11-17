package com.example.jale.nightoutgit.activities_and_fragments.data;

import android.location.Location;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Nicolaj Pedersen on 04-Nov-14.
 */
public class Friend {
    String firstName, lastName, id, email;
    Checkin checkin;
    boolean male;


    public Friend(JSONObject response) {
        try {
            firstName = response.getString("FirstName");
            lastName = response.getString("LastName");
            id = response.getString("Id");
            email = response.getString("Email");
            male = response.getBoolean("Gender");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCheckin(Checkin checkin) {
        this.checkin = checkin;
    }

    public void setMale(boolean male) {
        this.male = male;
    }


    public Checkin getCheckin() {
        return checkin;
    }

    public boolean isMale() {
        return male;
    }
}
