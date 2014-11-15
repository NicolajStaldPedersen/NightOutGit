package com.example.jale.nightoutgit.activities_and_fragments.activitiesFragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jale.nightoutgit.R;


/**
 * Created by Nicolaj Pedersen on 14-Nov-14.
 */
public class LoginFragment extends Fragment implements View.OnClickListener {

    TextView signUp;
    Button logIn;
    EditText email,password;
    View loginFragment;
    @Override
    public View onCreateView(LayoutInflater i, ViewGroup container, Bundle savedInstanceState) {
        loginFragment = i.inflate(R.layout.fragment_login,container,false);

        email = (EditText) loginFragment.findViewById(R.id.edtxtEmail);
        password = (EditText) loginFragment.findViewById(R.id.edtxtPassword);
        signUp = (TextView) loginFragment.findViewById(R.id.txtvwSignUp);
        logIn = (Button) loginFragment.findViewById(R.id.btnLogIn);
        signUp.setOnClickListener(this);
        logIn.setOnClickListener(this);


        return loginFragment;
    }

    @Override
    public void onClick(View v) {

        if(v == signUp){



        }else if(v == logIn){

            Intent i = new Intent(getActivity(),MainFragmentHandlerActivity.class);
            i.setFlags(i.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);
            getActivity().startActivity(i);


        }
    }
}
