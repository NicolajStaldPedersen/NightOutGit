package com.example.jale.nightoutgit.activities_and_fragments.activitiesFragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.jale.nightoutgit.R;

/**
 * Created by Jale on 15-Nov-14.
 */
public class BarPreferencesFragment extends Fragment implements View.OnClickListener {

    CheckBox bar, cafe,cocktail,sportsbar;
    CheckBox young,old,crowed;
    CheckBox music80,music90,music00,musicRock,musicTechno,musicLatest;
    CheckBox pool,soccerTable,dice;
    Button search;
    View barPreferenceView;

    @Override
    public View onCreateView(LayoutInflater i, ViewGroup container, Bundle savedInstanceState) {
        barPreferenceView = i.inflate(R.layout.fragment_bar_preferences,container,false);

        bar = (CheckBox) barPreferenceView.findViewById(R.id.barCheckb);
        cafe = (CheckBox) barPreferenceView.findViewById(R.id.cafeCheckb);
        cocktail = (CheckBox) barPreferenceView.findViewById(R.id.cocktailCheckb);
        sportsbar = (CheckBox) barPreferenceView.findViewById(R.id.sportsbarCheckb);

        young = (CheckBox) barPreferenceView.findViewById(R.id.ycrowdCheckb);
        old = (CheckBox) barPreferenceView.findViewById(R.id.ocrowdCheckb);
        crowed = (CheckBox) barPreferenceView.findViewById(R.id.crowdedCheckb);

        music80 = (CheckBox) barPreferenceView.findViewById(R.id.Checkb80);
        music90 = (CheckBox) barPreferenceView.findViewById(R.id.Checkb90);
        music00 = (CheckBox) barPreferenceView.findViewById(R.id.Checkb00);
        musicRock = (CheckBox) barPreferenceView.findViewById(R.id.CheckbRock);
        musicTechno = (CheckBox) barPreferenceView.findViewById(R.id.Checkbtechno);
        musicLatest = (CheckBox) barPreferenceView.findViewById(R.id.CheckbLatest);

        pool = (CheckBox) barPreferenceView.findViewById(R.id.CheckbPool);
        soccerTable = (CheckBox) barPreferenceView.findViewById(R.id.CheckbTSoccer);
        dice = (CheckBox) barPreferenceView.findViewById(R.id.CheckbDice);

        search = (Button) barPreferenceView.findViewById(R.id.btnSearch);
        search.setOnClickListener(this);


        return barPreferenceView;
    }


    @Override
    public void onClick(View v) {

    }
}
