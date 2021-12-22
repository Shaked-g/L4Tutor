package com.example.l4tutor2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
// filter by courses to show for students.
// returns only teachers that teach those courses.
public class FilterFeed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_feed);
    }
}