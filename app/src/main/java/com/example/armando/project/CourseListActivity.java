package com.example.armando.project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CourseListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter listAdapter;
    private RecyclerView.LayoutManager layoutManager;

    //Hard coded until login functionality is ironed out.
    private final String studentId = "5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        final FirebaseDatabase db=FirebaseDatabase.getInstance();
        final DatabaseReference ref = db.getReference("Courses");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Course> input = new ArrayList();
                Course course;
                //Reads in courses from firebase and saves them in a list
                for(DataSnapshot snap : dataSnapshot.getChildren()){
                    course = snap.getValue(Course.class);
                    course.setKey(snap.getKey());
                    input.add(course);
                }
                listAdapter = new CourseListAdapter(input, studentId, db, findViewById(android.R.id.content));
                recyclerView.setAdapter(listAdapter);
            }

            @Override
            public void onCancelled(DatabaseError error) { } //needed for the listener
        });
    }
}
