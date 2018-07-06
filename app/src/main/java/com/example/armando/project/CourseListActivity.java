package com.example.armando.project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Displays courses.
 * Allows user to filter courses by department
 * @author Jessica
 * @author Matt
 */
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

        //Adding drop down items to Spinner
        //Followed an Android App website
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sorting_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        final FirebaseDatabase db=FirebaseDatabase.getInstance();
        final DatabaseReference ref = db.getReference("Courses");
        ref.addValueEventListener(new ValueEventListener() {
            /**
             * Returns courses to be displayed.
             *
             * Grabs all courses from the database, and filters them
             * according to the user's input
             *
             * @param dataSnapshot
             */
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

            /**
             * Does nothing, needed for database listener errors
             * @param error
             */
            @Override
            public void onCancelled(DatabaseError error) { }
        });
    }
}
