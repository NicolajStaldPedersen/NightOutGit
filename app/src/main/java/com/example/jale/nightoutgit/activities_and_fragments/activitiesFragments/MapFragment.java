package com.example.jale.nightoutgit.activities_and_fragments.activitiesFragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jale.nightoutgit.R;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;


/**
 * Created by kristianj on 11/17/2014.
 */
public class MapFragment extends Fragment {

    public View onCreateView(LayoutInflater i, ViewGroup container, Bundle savedInstanceState) {
     View rod = i.inflate(R.layout.mapstest,container,false);

        MapView mapView = (MapView)rod.findViewById(R.id.googlemapView);

        //#IMPORTANT: Without this line, your code will not work
        mapView.onCreate(savedInstanceState);

        GoogleMap map = mapView.getMap();
        MapsInitializer.initialize(getActivity());
        mapView.onResume();
        //map.setMapType(GoogleMap.MAP_TYPE_NORMAL);






    return rod;
    }
}
