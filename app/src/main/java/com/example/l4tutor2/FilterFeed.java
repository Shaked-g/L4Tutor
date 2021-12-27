package com.example.l4tutor2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

// filter by courses to show for students.
// returns only teachers that teach those courses.
public class FilterFeed extends AppCompatActivity {
    private CheckBox cb_algebra1,cb_algebra2,cb_numbers,cb_infi1,cb_infi2,cb_discrete,cb_logic,cb_java,cb_data,cb_oop;
    private User user;
    Button searchButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_feed);
         Toast.makeText(FilterFeed.this,"inside FilterFeed ",Toast.LENGTH_LONG).show();
        searchButton = findViewById(R.id.searchBtn);

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


    }

    public void SearchBTN (View view){
        if(cb_algebra1.isChecked())
            //show only Tutors that teaching algebra1 (Has algebra1 on their Courses)

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

        Intent Feed = new Intent(FilterFeed.this, Feed.class);
        startActivity(Feed);
    }
}