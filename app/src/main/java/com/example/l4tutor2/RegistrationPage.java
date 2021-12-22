package com.example.l4tutor2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class RegistrationPage extends AppCompatActivity {
    private EditText emailEditText, passwordEditText, userNameEditText, userFamilyNameEditText;
    private CheckBox cb1,cb2;
    private static final String USERS = "users";
    private String userEmail, userPassword, userName, userFamilyName;


    private DatabaseReference mDatabase;
    private FirebaseDatabase database;
    private FirebaseAuth mAuth;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);

        cb1 = findViewById(R.id.checkBox);
        cb2 = findViewById(R.id.checkBox2);
        emailEditText = findViewById(R.id.EmailInput);
        passwordEditText = findViewById(R.id.PassInput);
        userNameEditText = findViewById(R.id.textInputEditText);
        userFamilyNameEditText = findViewById(R.id.textInputEditText2);
        database = FirebaseDatabase.getInstance("https://l4tutor2-default-rtdb.europe-west1.firebasedatabase.app/");
        mDatabase = database.getReference(USERS);
        mAuth = FirebaseAuth.getInstance();

        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    cb1.setChecked(false);
                }
            }
        });
        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    cb2.setChecked(false);
                }
            }
        });

    }


    public void RegisterFormBtn(View view) {
        String userEmail = emailEditText.getText().toString();
        String userPassword = passwordEditText.getText().toString();
        String userName = userNameEditText.getText().toString();
        String userFamilyName = userFamilyNameEditText.getText().toString();

        user = new User(userEmail, userPassword, userName, userFamilyName);

        if(cb1.isChecked()){
            user.setUserType("student");
            user.setDesiredCourses(User.Courses.Linear_Algebra1);
            user.setDesiredCourses(User.Courses.Number_Theory);
        }else user.setUserType("tutor");

        mAuth.createUserWithEmailAndPassword(userEmail, userPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success
                            Toast.makeText(RegistrationPage.this, "Registration works", Toast.LENGTH_LONG).show();
                            FirebaseUser fireUser = mAuth.getCurrentUser();
                            String keyid = fireUser.getUid();
                            mDatabase.child(keyid).setValue(user); //adding user info to database

                            //move to MoreInfo page.
                            Intent intentFeed = new Intent(RegistrationPage.this, MoreInfo.class);
                            startActivity(intentFeed);

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(RegistrationPage.this, "Registration Failed", Toast.LENGTH_LONG).show();
                        }
                    }
                });



    }
    public void onCheckboxClicked(View view) {
        if (cb1.isChecked()){
            if (cb2.isChecked()){
                cb1.setChecked(false);
            }
        }
        if (cb2.isChecked()){
            if (cb1.isChecked()){
                cb2.setChecked(false);
            }
        }
    }


}