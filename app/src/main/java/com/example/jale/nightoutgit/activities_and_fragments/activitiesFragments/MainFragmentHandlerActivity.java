package com.example.jale.nightoutgit.activities_and_fragments.activitiesFragments;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import com.example.jale.nightoutgit.R;

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
            FragmentTransaction fm = getFragmentManager().beginTransaction();
            fm.add(R.id.frame1,new ProfileFragment()).commit();

        }
    }

    @Override
    public void onClick(View v) {
        if(v == btnBars){
            FragmentTransaction fm = getFragmentManager().beginTransaction();
            fm.add(R.id.frame1,new BarPreferencesFragment()).commit();
        }else if(v == btnFriends){
            FragmentTransaction fm = getFragmentManager().beginTransaction();
            fm.add(R.id.frame1,new FriendsFragment()).commit();
        }else if(v == btnProfile){
            FragmentTransaction fm = getFragmentManager().beginTransaction();
            fm.add(R.id.frame1,new ProfileFragment()).commit();
        }else if(v == btnGetHome){

        }

    }
}
