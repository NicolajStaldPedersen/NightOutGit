package com.example.jale.nightoutgit.activities_and_fragments.activitiesFragments;
import com.example.jale.nightoutgit.activities_and_fragments.data.*;

import android.app.Activity;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.LabeledIntent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.jale.nightoutgit.R;
import com.example.jale.nightoutgit.activities_and_fragments.data.HTTPLogic;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.UUID;


public class LoginActivity extends Activity implements View.OnClickListener {

    EditText email,password;
    Button logIn;
    TextView signUp;
    HTTPLogic httpLogic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sp =
                PreferenceManager.getDefaultSharedPreferences(this);
        String userEmail = sp.getString("profilePassword", "");
        String userPass = sp.getString("profileEmail", "");
        if(userEmail.length() > 1 && userPass.length() > 1){
            HTTPLogic httpLogic = new HTTPLogic();
            System.out.println("user email = "+userEmail);
            System.out.println("user Password = "+userPass);
            httpLogic.getPersonByLogin(userEmail,userPass,this);
            Intent i = new Intent(this,MainFragmentHandlerActivity.class);

            startActivity(i);

        }
        httpLogic = new HTTPLogic();
        setContentView(R.layout.activity_login);
        email = (EditText) findViewById(R.id.edtxtEmail);
        password = (EditText) findViewById(R.id.edtxtPassword);
        signUp = (TextView) findViewById(R.id.txtvwSignUp);
        logIn =(Button) findViewById(R.id.btnLogIn);
        signUp.setOnClickListener(this);
        logIn.setOnClickListener(this);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if(v == signUp){

        }else if(v == logIn){

            getPerson();
        }
    }

    public void getPerson(){

        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.put("Email", email.getText().toString());
        params.put("Password", password.getText().toString());

        client.addHeader("Content-Type","application/json");
        try{
            JSONObject loginInModel = new JSONObject();

            loginInModel.put("Email", email.getText().toString());
            loginInModel.put("Password", password.getText().toString());
            StringEntity entity = new StringEntity(loginInModel.toString());
            final Context context = this.getApplicationContext();

            entity.setContentType(new BasicHeader(HTTP.CONTENT_TYPE,"application/json"));
            RequestHandle post = client.post(context, httpLogic.getLoginUrl(), entity, "application/json", new JsonHttpResponseHandler() {

                // When the response returned by REST has Http response code '200'
                @Override
                public void onSuccess(int i, Header[] headers, JSONObject response) {
                    new Profile(response);
                    if(Profile.getId() != null) {
                        if (Profile.getId().equals("00000000-0000-0000-0000-000000000000")) {
                            // fail at login
                        } else {
                            Profile.password = password.getText().toString();
                            Intent intent = new Intent(context, MainFragmentHandlerActivity.class);
                            startActivity(intent);
                        }
                    }
                }

                @Override
                public void onFailure(int statusCode,
                                      Header[] headers,
                                      Throwable throwable,
                                      JSONObject errorResponse) {

                }

            });


        }catch (Exception e){
        }
    }
}
