package com.example.l4tutor2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    CheckBox cb1, cb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onClickRegister(View view) {

        Intent intentRegister = new Intent(MainActivity.this, RegistrationPage.class);
        startActivity(intentRegister);


    }

    public void studentBtn(View view) {

        Intent intentLogging = new Intent(MainActivity.this, LoginPage.class);
        startActivity(intentLogging);
    }
}