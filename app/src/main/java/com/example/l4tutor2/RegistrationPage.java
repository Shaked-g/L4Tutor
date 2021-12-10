package com.example.l4tutor2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationPage extends AppCompatActivity {
    private FirebaseAuth mAuth;
    CheckBox cb1,cb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);
        mAuth = FirebaseAuth.getInstance();
        cb1 = findViewById(R.id.checkBox);
        cb2 = findViewById(R.id.checkBox2);

    }



    public void RegisterFormBtn(View view) {
        EditText emailEditText = findViewById(R.id.EmailInput);
        EditText passwordEditText = findViewById(R.id.PassInput);
        mAuth.createUserWithEmailAndPassword(emailEditText.getText().toString(), passwordEditText.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(RegistrationPage.this, "Registration works", Toast.LENGTH_LONG).show();


                        } else {
                            Toast.makeText(RegistrationPage.this, "Registration Failed", Toast.LENGTH_LONG).show();

                        }
                    }
                });

    }

    // Back Button
    public void BackBtnReg(View view) {

        Intent intentRegister = new Intent(RegistrationPage.this, MainActivity.class);
        startActivity(intentRegister);
    }
}