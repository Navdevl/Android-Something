package com.example.dellpc.logginregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Output extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);
        Intent ou = getIntent();
        String username=ou.getStringExtra("username");
        String name = ou.getStringExtra("name");
        int age  = ou.getIntExtra("age", -1);

        TextView t1= (TextView) findViewById(R.id.textView);
        TextView t2= (TextView) findViewById(R.id.textView2);
        TextView t3= (TextView) findViewById(R.id.textView3);

        String wel = "WELCOME  "+username;
        String us = "NAME: "+name;
        String ag= "AGE: "+String.valueOf(age);

        t1.setText(wel);
        t2.setText(us);
        t3.setText(ag);

    }
}
