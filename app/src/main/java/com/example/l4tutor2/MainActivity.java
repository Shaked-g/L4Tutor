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
        cb1 = findViewById(R.id.checkBox);
        cb2 = findViewById(R.id.checkBox2);
//        public void onClick(View v){
//            if (cb1.isChecked()) {
//                if (cb2.isChecked()) {
//                    cb1.setChecked(false);
//                }
//            }
//            if (cb2.isChecked()) {
//                if (cb1.isChecked()) {
//                    cb2.setChecked(false);
//                }
//
//
//            }
//        }
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