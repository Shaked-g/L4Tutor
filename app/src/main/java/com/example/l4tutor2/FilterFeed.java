package com.example.l4tutor2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

// filter by courses to show for students.
// returns only teachers that teach those courses.
public class FilterFeed extends AppCompatActivity {
    Button searchButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_feed);
         Toast.makeText(FilterFeed.this,"inside FilterFeed ",Toast.LENGTH_LONG).show();
        searchButton = findViewById(R.id.searchBtn);


    }

// moves to feed
    public void SearchBTN(View view) {
        Intent Feed = new Intent(FilterFeed.this, Feed.class);
        startActivity(Feed);
    }
}