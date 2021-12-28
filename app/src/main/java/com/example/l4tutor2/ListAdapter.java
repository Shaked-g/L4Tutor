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
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder>{

    private ArrayList<User> userList;

    public ListAdapter(ArrayList<User> userList) {
        this.userList = userList;
    }




    @NonNull
    @Override
    public ListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_feed,parent,false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.MyViewHolder holder, int position) {
        User user = userList.get(position);
        holder.firstName.setText(user.getFirstName());
        holder.lastName.setText(user.getLastName());
        holder.courses.setText((CharSequence) user.getDesiredCourses());
        holder.price.setText(user.getDesiredPayment());
        holder.phoneNumber.setText(user.getPhoneNumber());


    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView firstName, lastName, courses, phoneNumber, price;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            firstName = itemView.findViewById(R.id.textView_firstname);
            lastName = itemView.findViewById(R.id.textView_lastName);
            courses = itemView.findViewById(R.id.textView_courses);
            phoneNumber = itemView.findViewById(R.id.textView_phoneNumber);
            price = itemView.findViewById(R.id.textView_price);
        }
    }
}
