package com.example.jale.nightoutgit.activities_and_fragments.data;


import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

import java.util.UUID;

/**
 * Created by Nicolaj Pedersen on 19-Oct-14.
 */
public class HTTPLogic {

    boolean returnValue;
    public void getPersonByLogin(String email, String password, Context context){

        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.put("Email", email);
        params.put("Password", password);

        client.addHeader("Content-Type","application/json");
        try{
            JSONObject loginInModel = new JSONObject();

            loginInModel.put("Email", email);
            loginInModel.put("Password", password);
            StringEntity entity = new StringEntity(loginInModel.toString());

            entity.setContentType(new BasicHeader(HTTP.CONTENT_TYPE,"application/json"));
            client.post(context,getLoginUrl(), entity,"application/json", new JsonHttpResponseHandler() {

                // When the response returned by REST has Http response code '200'
                @Override
                public void onSuccess(int i, Header[] headers, JSONObject response) {
                    Profile person = new Profile(response);
                    if(person.getId().equals(UUID.fromString("00000000-0000-0000-0000-000000000000"))){


//                         login failed

                    }else{
                        // login success


                    }
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

    public boolean getPersonFriendsByLogin(String email,String password, Context context){

        returnValue = false;
        AsyncHttpClient client = new AsyncHttpClient();

        client.addHeader("Content-Type","application/json");
        try{
            JSONObject loginInModel = new JSONObject();

            client.get(context,getFriendsByLoginUrl(), new JsonHttpResponseHandler() {

                // When the response returned by REST has Http response code '200'
                @Override
                public void onSuccess(int i, Header[] headers, JSONObject response) {
                    Profile person = new Profile(response);
                    if(person.getId().equals(UUID.fromString("00000000-0000-0000-0000-000000000000"))){

                        returnValue = false;
                        // login failed

                    }else{
                        // login success

                        returnValue = true;

                    }
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
        return returnValue;
    }







    private String getPersonById(UUID id){
        return "http://nightoutapi.azurewebsites.net/api/persons/"+id.toString();
    }

    public String getCreatePersonUrl(){
        return "http://nightoutapi.azurewebsites.net/api/persons";
    }

    public String getLoginUrl(){
        return "http://nightoutapi.azurewebsites.net/api/persons/login";

    }

    public static String getFriendsByLoginUrl(){
        return "http://10.0.2.2:58001/api/persons/friends";

    }

}
