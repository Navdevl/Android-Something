package com.example.dellpc.logginregister;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dell Pc on 17-10-2016.
 */
public class RegisterRequest extends StringRequest {
    private static final String REGISTER_URL= "http://192.168.1.5/Register.php";
    private Map<String,String> params;

    public RegisterRequest(String name, int age,String username,String password,Response.Listener<String> listener){
        super(Method.POST,REGISTER_URL,listener,null);
        params= new HashMap<>();
        params.put("name", name);
        params.put("age",age + "");
        params.put("username",username);
        params.put("password",password);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
