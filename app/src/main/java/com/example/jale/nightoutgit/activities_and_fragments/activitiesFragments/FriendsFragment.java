package com.example.jale.nightoutgit.activities_and_fragments.activitiesFragments;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jale.nightoutgit.R;
import com.example.jale.nightoutgit.activities_and_fragments.data.Profile;

import java.text.DateFormat;

/**
 * Created by Nicolaj Pedersen on 15-Nov-14.
 */
public class FriendsFragment extends ListFragment implements AdapterView.OnItemClickListener{

    View friendsView;
    String[] friends ={"Henning Andersen","Thommas jensen","Lars Petersen","Peter Bjergmand", "Børge Ågesen", "Carlos Santamaria", "Knud Hansen", "Michael Kofod"};

    @Override
    public View onCreateView(LayoutInflater i, ViewGroup container, Bundle savedInstanceState) {
        friendsView = i.inflate(R.layout.fragment_friends_list,container,false);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.fragment_friends_list, R.id.txtFriendsName, friends){

            @Override
            public View getView(int position, View cachedView, ViewGroup parent) {
                View view = super.getView(position, cachedView, parent);


                //Getting friends location
                TextView friendsname = (TextView) view.findViewById(R.id.txtFriendsName);
                TextView friendsLocation = (TextView) view.findViewById(R.id.txtFriendsLocation);
                ImageView recentlyActive = (ImageView) view.findViewById(R.id.imgIsFriendCheckIn);
                friendsLocation.setText("Ven nr " + position);
                //friendsLocation.setText(Profile.friends(position).getPlace());
                //if(Profile.friends(position).getCheckIn.getDate > DateFormat.getTimeInstance())

                return view;
            }
        };

        ListView listView = new ListView(getActivity());
        listView.setOnItemClickListener(this);
        listView.setAdapter(adapter);

        return listView;
        //return friendsView;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
