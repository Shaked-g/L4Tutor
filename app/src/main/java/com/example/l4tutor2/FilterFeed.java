package com.example.l4tutor2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

// filter by courses to show for students.
// returns only teachers that teach those courses.
public class FilterFeed extends AppCompatActivity {
    private EditText priceInput;
    private DatabaseReference mDatabase;
    private FirebaseDatabase database;
    private FirebaseAuth mAuth;
    private static final String USERS = "users";
    public String keyid;

    private CheckBox cb_algebra1, cb_algebra2, cb_numbers, cb_infi1, cb_infi2, cb_discrete, cb_logic, cb_java, cb_data, cb_oop;
    private User user;
    Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_feed);
        Toast.makeText(FilterFeed.this, "inside FilterFeed ", Toast.LENGTH_LONG).show();
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

        priceInput = findViewById(R.id.PricetextInputEditText2);
        database = FirebaseDatabase.getInstance("https://l4tutor2-default-rtdb.europe-west1.firebasedatabase.app/");
        mDatabase = database.getReference(USERS);
        mAuth = FirebaseAuth.getInstance();

    }

    public void SearchBTN(View view) {

        //        if (priceInput.getText().toString().isEmpty()) {
//            priceInput.setError("Enter Price");
//            return;
//        }
//
//        int studentAskPrice = Integer.parseInt(priceInput.getText().toString());

        ArrayList<String> desiredCourse = new ArrayList<>();

        if (cb_algebra1.isChecked())
            desiredCourse.add(String.valueOf(User.Courses.Linear_Algebra1));

        if (cb_algebra2.isChecked())
            desiredCourse.add(String.valueOf(User.Courses.Linear_Algebra2));

        if (cb_numbers.isChecked())
            desiredCourse.add(String.valueOf(User.Courses.Number_Theory));
        if (cb_infi1.isChecked())
            desiredCourse.add(String.valueOf(User.Courses.Infinitesimal_Calculus1));
        if (cb_infi2.isChecked())
            desiredCourse.add(String.valueOf(User.Courses.Infinitesimal_Calculus2));
        if (cb_discrete.isChecked())
            desiredCourse.add(String.valueOf(User.Courses.Discrete_Mathematics));
        if (cb_logic.isChecked())
            desiredCourse.add(String.valueOf(User.Courses.Logic_and_set_theory));
        if (cb_java.isChecked())
            desiredCourse.add(String.valueOf(User.Courses.Java));
        if (cb_data.isChecked())
            desiredCourse.add(String.valueOf(User.Courses.Data_Structures));
        if (cb_oop.isChecked())
            desiredCourse.add(String.valueOf(User.Courses.Object_Oriented));


        //user.setDesiredCourses(desiredCourse);

        // NEEDS TO BRING BACK TUTOR-USERS FROM FIREBASE WITH DESIRED PAYMENT IN THE RANGE OF USER CHOSEN studentAskPrice

//        Query tutorPriceQuery = mDatabase.orderByChild("desiredPayment");
//       // tutorPriceQuery.equalTo();
//        Toast.makeText(FilterFeed.this,"tutorPriceQuery "+ tutorPriceQuery,Toast.LENGTH_LONG).show();
//
//        tutorPriceQuery.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
//
//                Toast.makeText(FilterFeed.this,"data query result "+ postSnapshot.getValue().toString(),Toast.LENGTH_LONG).show();
//                    Object newUser = postSnapshot.getValue();
//                    newUser
//                    Toast.makeText(FilterFeed.this,"newUser "+ newUser["desiredPayment"],Toast.LENGTH_LONG).show();
//
//                    // TODO: handle the post
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                // Getting Post failed, log a message
//                Toast.makeText(FilterFeed.this,"data query FAILED ",Toast.LENGTH_LONG).show();
//
//                // Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
//                // ...
//            }
//        });

        // TO BE CHANGED
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //Toast.makeText(FilterFeed.this,"data query "+dataSnapshot,Toast.LENGTH_LONG).show();

                for (DataSnapshot datas : dataSnapshot.getChildren()) {
                    //Toast.makeText(FilterFeed.this, "datas " + datas, Toast.LENGTH_LONG).show();
                    String a = datas.getValue().toString();
                    //Toast.makeText(FilterFeed.this, "a: " + a, Toast.LENGTH_LONG).show();


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        Intent Feed = new Intent(FilterFeed.this, Feed.class);
        Feed.putExtra("list", desiredCourse);
        startActivity(Feed);
    }
}