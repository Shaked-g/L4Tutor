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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class RegistrationPage extends AppCompatActivity {
    private FirebaseAuth mAuth;
    CheckBox cb1,cb2;
    private DatabaseReference mDatabase;
//    ArrayList<User> userArrayyList = new ArrayList<User>();


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
        String UserEmail = emailEditText.getText().toString();
        mAuth.createUserWithEmailAndPassword(UserEmail, passwordEditText.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            EditText UserGivenName = findViewById(R.id.textInputEditText);
                            String UserName = UserGivenName.getText().toString();

                            Toast.makeText(RegistrationPage.this, "Registration works", Toast.LENGTH_LONG).show();

                            //DatabaseReference myRef = database.getReference("message");
                            // this.myRef.setValue("Hello, World!");

                            //mDatabase = FirebaseDatabase.getInstance("https://l4tutor2-default-rtdb.europe-west1.firebasedatabase.app/").getReference();
                            //mDatabase.setValue(UserEmail);

                            //mDatabase = FirebaseDatabase.getInstance("https://l4tutor2-default-rtdb.europe-west1.firebasedatabase.app/").getReference(UserEmail);
//                            User user = new User(UserName, UserEmail);
//
//                            userArrayyList.add(user);
//
//                            mDatabase.setValue(userArrayyList);


                            // writeNewUser(UserName,UserEmail);
                            //mDatabase.setValue("Hello, World!");

                        } else {
                            Toast.makeText(RegistrationPage.this, "Registration Failed", Toast.LENGTH_LONG).show();

                        }
                    }
                });

    }

//    // Back Button
//    public void BackBtnReg(View view) {
//
//        Intent intentRegister = new Intent(RegistrationPage.this, MainActivity.class);
//        startActivity(intentRegister);
//    }

    public void writeNewUser(String name, String email) {
        //User user = new User(name, email); // locally used
       // mDatabase = FirebaseDatabase.getInstance("https://l4tutor2-default-rtdb.europe-west1.firebasedatabase.app/").getReference("message");

        //mDatabase.child("users").child(userId).setValue(user);
       // mDatabase.child("users").child(email).child("username").setValue(name);

    }


    public void registerUser(String name, String email) {

    }

    public void updateUI(FirebaseUser currentUser) {
        String keyid = mDatabase.push().getKey();
        mDatabase.child(keyid).setValue(user); //adding user info to database
        Intent loginIntent = new Intent(this, MainActivity.class);
        startActivity(loginIntent);
    }

}