package com.example.l4tutor2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Feed extends AppCompatActivity {


    DatabaseReference database;
    ListAdapter listAdapter;
    ArrayList<String> coursesFilter = new ArrayList<>();
    boolean isFilter = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        ArrayList<User> userList = new ArrayList<>();

        if (getIntent().hasExtra("list")) {
            coursesFilter = getIntent().getStringArrayListExtra("list");
            Log.e("size", "is " + coursesFilter.size());
            isFilter = true;
        }
        RecyclerView recyclerView = findViewById(R.id.recyclerview_users);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        //recyclerView.setHasFixedSize(true);
        database = FirebaseDatabase.getInstance("https://l4tutor2-default-rtdb.europe-west1.firebasedatabase.app/")
                .getReference("users");


        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    User user = dataSnapshot.getValue((User.class));
                    if (isFilter) {
                        if (user != null) {
                            for (String course : user.getDesiredCourses()) {
                                if (coursesFilter.contains(course)) {
                                    userList.add(user);
                                    break;
                                }
                            }
                        }

                    } else {
                        if (user.getUserType().equals("student"))
                            userList.add(user);

                    }
                }
                listAdapter = new ListAdapter(Feed.this, userList, isFilter);
                recyclerView.setAdapter(listAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("error", "is " + error.getMessage());
            }
        });


    }
}