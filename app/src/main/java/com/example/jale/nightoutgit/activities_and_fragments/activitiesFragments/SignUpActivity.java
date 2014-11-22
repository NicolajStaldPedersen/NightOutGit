package com.example.jale.nightoutgit.activities_and_fragments.activitiesFragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.jale.nightoutgit.R;
import com.example.jale.nightoutgit.activities_and_fragments.data.HTTPLogic;
import com.google.android.gms.plus.model.people.Person;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

import static android.widget.Toast.LENGTH_SHORT;

/**
 * Created by Jale on 22-Nov-14.
 */
public class SignUpActivity extends Activity implements View.OnClickListener {

    EditText firstName,lastName,email,password;
    RadioButton male,female;
    Button signUpbtn;
    HTTPLogic httpLogic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        httpLogic = new HTTPLogic();
        setContentView(R.layout.activity_signup_form);
        firstName = (EditText) findViewById(R.id.edtxtFirstName);
        lastName = (EditText) findViewById(R.id.edtxtLastName);
        email = (EditText) findViewById(R.id.edtxtNewEmail);
        password = (EditText) findViewById(R.id.edtxtNewPassword);
        male = (RadioButton) findViewById(R.id.rbMale);
        female = (RadioButton) findViewById(R.id.rbFemale);
        signUpbtn = (Button) findViewById(R.id.btnSignUp);
        signUpbtn.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if(v == signUpbtn){
            if(male.isChecked() || female.isChecked()){
                signUp();
            }
        }
    }

    public void signUp() {



        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.put("FirstName", firstName.getText());
        params.put("LastName", lastName.getText());
        params.put("Email", email.getText());
        params.put("Password", password.getText());
        params.put("Gender",male.isChecked());

        RequestHandle isSuccess = client.post(httpLogic.getCreatePersonUrl(), params, new JsonHttpResponseHandler() {

            // When the response returned by REST has Http response code '200'
            @Override
            public void onSuccess(int i, Header[] headers, JSONObject response) {
                try {
                    if (response.getBoolean("IsSuccess")) {
                        CharSequence text = "you have been signed up";
                        Toast toast = Toast.makeText(getApplicationContext(),text, LENGTH_SHORT);
                        toast.show();
                        try {
                            Thread.sleep(3000);
                            finish();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }

                } catch (JSONException e) {
                    e.printStackTrace();

                }
            }
        });
    }
}
