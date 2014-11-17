package com.example.jale.nightoutgit.activities_and_fragments.activitiesFragments;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Base64;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.example.jale.nightoutgit.R;
import com.example.jale.nightoutgit.activities_and_fragments.data.*;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONObject;

import java.util.UUID;

/**
 * Created by Nicolaj Pedersen on 14-Nov-14.
 */
public class MainFragmentHandlerActivity extends Activity implements View.OnClickListener{

    FrameLayout frameMain;
    ImageButton btnBars,btnFriends,btnProfile,btnGetHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity_frame_handler);
        btnBars = (ImageButton) findViewById(R.id.btnBars);
        btnBars.setOnClickListener(this);
        btnFriends = (ImageButton) findViewById(R.id.btnFriends);
        btnFriends.setOnClickListener(this);
        btnProfile = (ImageButton) findViewById(R.id.btnProfile);
        btnProfile.setOnClickListener(this);
        btnGetHome = (ImageButton) findViewById(R.id.btnGetHome);
        btnGetHome.setOnClickListener(this);
        frameMain = (FrameLayout) findViewById(R.id.frame1);

        if(savedInstanceState == null){

            getPersonFriendsByLogin(Profile.getEmail(),Profile.getPassword());

            FragmentTransaction fm = getFragmentManager().beginTransaction();
            fm.add(R.id.frame1,new ProfileFragment()).commit();

        }
    }

    @Override
    public void onClick(View v) {
        if(v == btnBars){
            FragmentTransaction fm = getFragmentManager().beginTransaction();
            fm.replace(R.id.frame1,new BarPreferencesFragment()).commit();
        }else if(v == btnFriends){
            FragmentTransaction fm = getFragmentManager().beginTransaction();
            fm.replace(R.id.frame1,new FriendsFragment()).commit();
        }else if(v == btnProfile){
            FragmentTransaction fm = getFragmentManager().beginTransaction();
            fm.replace(R.id.frame1,new ProfileFragment()).commit();
        }else if(v == btnGetHome){
            FragmentTransaction fm = getFragmentManager().beginTransaction();
            fm.replace(R.id.frame1,new MapFragment()).commit();
        }

    }

    public void getPersonFriendsByLogin(String email,String password){

        AsyncHttpClient client = new AsyncHttpClient();
        String auth =email+":"+password;
        String encodedAuth = Base64.encodeToString(auth.getBytes(),Base64.DEFAULT);
        encodedAuth = "Tmljb2xhanNwQGxpdmUuZGs6TmlnaHRvdXQ=";
        System.out.println("info : " +auth + "  --  coded : "+encodedAuth);

        client.addHeader("Authorization","Basic "+encodedAuth);
        client.addHeader("Content-Type","application/json");
        try{
            JSONObject loginInModel = new JSONObject();

            client.get(this, HTTPLogic.getFriendsByLoginUrl(), new JsonHttpResponseHandler() {

                // When the response returned by REST has Http response code '200'
                @Override
                public void onSuccess(int i, Header[] headers, JSONObject response) {

                    String s = null;


                }
                @Override
                public void onFailure(int statusCode,
                                      Header[] headers,
                                      Throwable throwable,
                                      JSONObject errorResponse){
//                    login failed

                }

            });


        }catch (Exception e){
        }
    }
}
