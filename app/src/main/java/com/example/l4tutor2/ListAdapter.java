package com.example.l4tutor2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<User> {

    private DatabaseReference mDatabase;
    private FirebaseDatabase database;
    private static final String USERS = "users";
    public String keyid;
    private FirebaseAuth mAuth;

    public ListAdapter(Context context, ArrayList<User> userArrayList){
        super(context,R.layout.list_item,userArrayList);


        database = FirebaseDatabase.getInstance("https://l4tutor2-default-rtdb.europe-west1.firebasedatabase.app/");
        mDatabase = database.getReference(USERS);
        mAuth = FirebaseAuth.getInstance();

        /**
         * TODO Not sure where i need to declare the DB - So we need to find out !!
         */

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        User user = getItem(position);

        if(convertView == null){

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);

        }

        ImageView image = convertView.findViewById(R.id.Profile_pic);
        TextView firstName = convertView.findViewById(R.id.TutorFirstName);
        TextView lastName = convertView.findViewById(R.id.TutorLastName);
        TextView course = convertView.findViewById(R.id.courses);
        TextView price = convertView.findViewById(R.id.Payment);

        /**
         * TODO Get Tutor Info from DB to these views
         */


        return super.getView(position,convertView,parent);
    }
}
