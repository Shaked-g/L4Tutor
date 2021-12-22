package com.example.l4tutor2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginPage extends AppCompatActivity {
    private static final String USERS = "users";
    private DatabaseReference mDatabase;
    private FirebaseDatabase database;
    private FirebaseAuth mAuth;
    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        database = FirebaseDatabase.getInstance("https://l4tutor2-default-rtdb.europe-west1.firebasedatabase.app/");
        mDatabase = database.getReference(USERS);
        mAuth = FirebaseAuth.getInstance();

    }

    public void LoginButton(View view) {

        EditText emailEditText = findViewById(R.id.loginEmail);
        EditText passwordEditText = findViewById(R.id.loginPassword);

        mAuth.signInWithEmailAndPassword(emailEditText.getText().toString(), passwordEditText.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            String userid = user.getUid();
//                            Toast.makeText(LoginPage.this,"Login works "+user,Toast.LENGTH_LONG).show();
//                            Toast.makeText(LoginPage.this,"User ID "+userid,Toast.LENGTH_LONG).show();

                            // filter screen by userType from database
                            mDatabase.child(userid).child("userType").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DataSnapshot> task) {
                                    if (!task.isSuccessful()) {
                                        Log.e("firebase", "Error getting data", task.getException());
                                    }
                                    else {

                                       // Toast.makeText(LoginPage.this,"User Type "+ task.getResult().getValue(),Toast.LENGTH_LONG).show();
                                        if ( task.getResult().getValue() == "student") {
                                            Intent FilterFeed = new Intent(LoginPage.this, FilterFeed.class);
                                            startActivity(FilterFeed);
                                        }
                                        else{
                                            Intent intentFeed = new Intent(LoginPage.this, Feed.class);
                                            startActivity(intentFeed);
                                        }



                                    }
                                }
                            });





                        } else {
                            // If sign in fails, display a message to the user.
                            // Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginPage.this,"Login does NOT work",Toast.LENGTH_LONG).show();


                        }
                    }
                });


    }
}