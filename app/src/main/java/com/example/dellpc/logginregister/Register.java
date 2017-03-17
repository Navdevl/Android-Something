package com.example.dellpc.logginregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText ename = (EditText) findViewById(R.id.name);
        final EditText eage = (EditText) findViewById(R.id.age);
        final EditText eusername = (EditText) findViewById(R.id.username);
        final EditText epassword = (EditText) findViewById(R.id.password);
        final Button bregister = (Button) findViewById(R.id.register);
        bregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = ename.getText().toString();
                final int age = Integer.parseInt(eage.getText().toString());
                final String username = eusername.getText().toString();
                final String password = epassword.getText().toString();

                Response.Listener<String> responseListener= new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonobj= new JSONObject(response);
                            Boolean success = jsonobj.getBoolean("success");
                            if(success) {
                                Intent re = new Intent(Register.this, Loggin.class);
                                Register.this.startActivity(re);
                            } else {
                                Toast.makeText(getApplicationContext(),"FAILED",Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

               RegisterRequest registerrequest = new RegisterRequest(name,age,username,password,responseListener);
                RequestQueue queue = Volley.newRequestQueue(Register.this);
                queue.add(registerrequest);
            }
        });
    }
}
