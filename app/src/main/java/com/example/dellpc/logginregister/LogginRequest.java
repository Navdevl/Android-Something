package com.example.dellpc.logginregister;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dell Pc on 17-10-2016.
 */
public class LogginRequest extends StringRequest {

    private static final String LOG_URL= "http://192.168.1.5/FetchUserData.php";
    private Map<String,String> params;

    public LogginRequest(String username,String password,Response.Listener<String> listener){
        super(Method.POST,LOG_URL,listener,null);
        params= new HashMap<>();
        params.put("username",username);
        params.put("password",password);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
