package com.example.l4tutor2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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
import java.util.List;


public class MoreInfo extends AppCompatActivity {
    private EditText PriceEditText, PhoneEditText;
    private CheckBox cb_algebra1,cb_algebra2,cb_numbers,cb_infi1,cb_infi2,cb_discrete,cb_logic,cb_java,cb_data,cb_oop;
    private User user;
    private DatabaseReference mDatabase;
    private FirebaseDatabase database;
    private FirebaseAuth mAuth;
    private static final String USERS = "users";
    public String keyid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);
        this.keyid = getIntent().getStringExtra("keyid");

        database = FirebaseDatabase.getInstance("https://l4tutor2-default-rtdb.europe-west1.firebasedatabase.app/");
        mDatabase = database.getReference(USERS);
        mAuth = FirebaseAuth.getInstance();


        cb_algebra1 = findViewById(R.id.Linear_Algebra1_checkBox);
        cb_algebra2 = findViewById(R.id.linear_Algebra2_checkBox);
        cb_numbers = findViewById(R.id.Number_Theory_checkBox);
        cb_infi1 = findViewById(R.id.infi1_checkBox);
        cb_infi2 = findViewById(R.id.Infi2_checkBox);
        cb_discrete = findViewById(R.id.Discrete_checkBox);
        cb_logic = findViewById(R.id.Logic_checkBox);
        cb_java = findViewById(R.id.Java_checkBox);
        cb_data = findViewById(R.id.Data_checkBox);
        cb_oop = findViewById(R.id.OOP_checkBox);

        PriceEditText = findViewById(R.id.PricetextInputEditText);
        PhoneEditText = findViewById(R.id.PhonetextInputEditText);


    }

    public void RegisterMoreInfo(View view){
        String tutorPhone = PhoneEditText.getText().toString();
        mDatabase.child(keyid).child("phoneNumber").setValue(tutorPhone);
        int tutorPrice = Integer.parseInt(PriceEditText.getText().toString());
        mDatabase.child(keyid).child("desiredPayment").setValue(tutorPrice);
        // List<User.Courses> DesiredCourses = new ArrayList<>(); // can use local desired courses instead.
        // user = new User(user,tutorPhone,tutorPrice);
        user = new User();
        if(cb_algebra1.isChecked())
            user.setDesiredCourses(User.Courses.Linear_Algebra1);
        if(cb_algebra2.isChecked())
            user.setDesiredCourses(User.Courses.Linear_Algebra2);
        if(cb_numbers.isChecked())
            user.setDesiredCourses(User.Courses.Number_Theory);
        if(cb_infi1.isChecked())
            user.setDesiredCourses(User.Courses.Infinitesimal_Calculus1);
        if(cb_infi2.isChecked())
            user.setDesiredCourses(User.Courses.Infinitesimal_Calculus2);
        if(cb_discrete.isChecked())
            user.setDesiredCourses(User.Courses.Discrete_Mathematics);
        if(cb_logic.isChecked())
            user.setDesiredCourses(User.Courses.Logic_and_set_theory);
        if(cb_java.isChecked())
            user.setDesiredCourses(User.Courses.Java);
        if(cb_data.isChecked())
            user.setDesiredCourses(User.Courses.Data_Structures);
        if(cb_oop.isChecked())
            user.setDesiredCourses(User.Courses.Object_Oriented);

        mDatabase.child(keyid).child("desiredCourses").setValue(user.getDesiredCourses());

        //moves to feed
        Intent intentFeed = new Intent(MoreInfo.this, Feed.class);
        intentFeed.putExtra("keyid",this.keyid);
        startActivity(intentFeed);
    }


}




