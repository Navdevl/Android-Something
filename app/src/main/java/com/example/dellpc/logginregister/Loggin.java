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

public class Loggin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggin);

        final EditText eusernam = (EditText) findViewById(R.id.name1);
        final EditText epasswor = (EditText) findViewById(R.id.password2);
        final Button bregiste = (Button) findViewById(R.id.register1);
        final Button bloggin = (Button) findViewById(R.id.log);

        bregiste.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent ireg = new Intent(Loggin.this,Register.class);
                Loggin.this.startActivity(ireg);
            }
        });

        assert bloggin != null;
        if (bloggin != null) {
            bloggin.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    final String username = eusernam.getText().toString();
                    final String password = epasswor.getText().toString();
                    Response.Listener<String> response = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonobj = new JSONObject(response);
                                Boolean success = jsonobj.getBoolean("success");

                                if (success) {
                                    String name = jsonobj.getString("name");
                                    int age = jsonobj.getInt("age");
                                    Intent lo = new Intent(Loggin.this, Output.class);
                                    lo.putExtra("username",username);
                                    lo.putExtra("name", name);
                                    lo.putExtra("age", age);

                                    Loggin.this.startActivity(lo);

                                } else {
                                    Toast.makeText(getApplicationContext(), "FAILED", Toast.LENGTH_LONG).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    };

                    LogginRequest logginrequest = new LogginRequest(username, password, response);
                    RequestQueue queue = Volley.newRequestQueue(Loggin.this);
                    queue.add(logginrequest);

                }
            });
        }
    }

        }
