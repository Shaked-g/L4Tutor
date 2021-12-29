package com.example.l4tutor2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
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

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    private final ArrayList<User> userList;
    private final boolean isFilter;
    private final Context context;

    public ListAdapter(Context context, ArrayList<User> userList, boolean isFilter) {
        this.userList = userList;
        this.isFilter = isFilter;
        this.context = context;
    }


    @NonNull
    @Override
    public ListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.MyViewHolder holder, int position) {
        User user = userList.get(position);
        //Log.e("user", "is" + user.getDesiredCourses().size());
        holder.firstName.setText(user.getFirstName());
        holder.lastName.setText(user.getLastName());
        StringBuilder builder = new StringBuilder();
        for (String course :
                user.getDesiredCourses()) {
            builder.append(course);
            builder.append(",");
            //holder.courses.append(course + ", ");
        }
        holder.courses.setText(builder.toString());
        holder.price.setText("" + user.getDesiredPayment());
        holder.phoneNumber.setText(user.getPhoneNumber());

        holder.itemView.setOnClickListener(view -> {
            if (isFilter) {
                try {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    String url = "https://api.whatsapp.com/send?phone=" + user.getPhoneNumber();
                    i.setPackage("com.whatsapp");
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                } catch (Exception e) {
                    e.printStackTrace();
                    Uri uri = Uri.parse("market://details?id=com.whatsapp");
                    Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                    context.startActivity(goToMarket);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

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
