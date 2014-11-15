package com.example.jale.nightoutgit.activities_and_fragments.activitiesFragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jale.nightoutgit.R;
import com.example.jale.nightoutgit.activities_and_fragments.data.Profile;

/**
 * Created by Jale on 15-Nov-14.
 */
public class FriendsFragment extends Fragment implements AdapterView.OnItemClickListener{

    View friendsView;
    @Override
    public View onCreateView(LayoutInflater i, ViewGroup container, Bundle savedInstanceState) {
        friendsView = i.inflate(R.layout.fragment_friends_list,container,false);

        String[] friends ={"Henning Andersen","Thommas jensen","Lars Petersen","Peter Bjergmand"};

        ArrayAdapter adapter = new ArrayAdapter(getActivity(), R.layout.fragment_friends_list, R.id.txtFriendsName,friends){
            @Override
            public View getView(int position, View cachedView, ViewGroup parent) {
                View view = super.getView(position, cachedView, parent);


                //Getting friends location

//                TextView friendsLocation = (TextView) view.findViewById(R.id.txtFriendsLocation);
//                friendsLocation.setText(Profile.friends(position).getPlace());

                return view;
            }
        };

        ListView listView = new ListView(getActivity());
        listView.setOnItemClickListener(this);
        listView.setAdapter(adapter);


        return friendsView;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
