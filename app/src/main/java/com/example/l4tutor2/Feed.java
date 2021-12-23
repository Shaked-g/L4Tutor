package com.example.l4tutor2;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;

public class Feed extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_feed);

        ArrayList<User> userArrayList = new ArrayList<>();

        int[] imageId = {R.drawable.img_avatar, R.drawable.img_avatar2};
        /**
         * TODO same as the class ListAdapter - We need to get the tutor info !
         */

        for (int i = 0; i < 10 ; i++) {

            User user = new User("Tutor@gmail.com"+i,"12345"+i,"Tutor","Tov");
            userArrayList.add(user);
        }

        ListAdapter listAdapter = new ListAdapter(Feed.this,userArrayList);




    }
}