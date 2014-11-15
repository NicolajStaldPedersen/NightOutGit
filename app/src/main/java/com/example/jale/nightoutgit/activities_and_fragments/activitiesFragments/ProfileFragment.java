package com.example.jale.nightoutgit.activities_and_fragments.activitiesFragments;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jale.nightoutgit.R;

/**
 * Created by Jale on 15-Nov-14.
 */
public class ProfileFragment extends Fragment implements View.OnClickListener {

    ImageView profilePic;
    Button btnchangePicture;
    TextView profileName,profileEmail;
    View profileView;
    boolean nextImg;
    @Override
    public View onCreateView(LayoutInflater i, ViewGroup container, Bundle savedInstanceState) {
        profileView = i.inflate(R.layout.fragment_profile,container,false);
        nextImg =false;
        profileName = (TextView) profileView.findViewById(R.id.profileName);
        profileEmail = (TextView) profileView.findViewById(R.id.profileEmail);
        btnchangePicture = (Button) profileView.findViewById(R.id.btnChangePic);
        btnchangePicture.setOnClickListener(this);
        profilePic = (ImageView) profileView.findViewById(R.id.imgvwProfilePic);

        return profileView;
    }


    @Override
    public void onClick(View v) {
        if(v == btnchangePicture){
            if(nextImg){
                Drawable d = Drawable.createFromPath("drawable/male1.png");
                profilePic.setImageDrawable(d);
            }else{
                Drawable d = Drawable.createFromPath("drawable/male2.png");
                profilePic.setImageDrawable(d);
            }
            nextImg = !nextImg;
        }
    }
}
