package com.example.armando.project;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

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
    private String selectedItem, selectedItem2;

    private FirebaseDatabase db;
    private DatabaseReference ref;

    private Spinner spinner2;

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

        db=FirebaseDatabase.getInstance();
        ref = db.getReference("Courses");
        firebaseFunction();

        //Second Spinner
        spinner2 = (Spinner) findViewById(R.id.spinner2);


        //Implemetning Course Filter. Implementing onItemSelectedListener() interface.
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedItem = parent.getItemAtPosition(position).toString();
                System.out.println("Spinner value: " + selectedItem);

                //If the first spinner is set to Department, then populate the second spinner
                //with the list of departments
                if (selectedItem.equals("Department")){
                    spinner2.setOnItemSelectedListener(new CourseFilter());
                    ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getApplicationContext(),
                            R.array.department_array, android.R.layout.simple_spinner_item);
                    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter2);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Filter button. Filtering will not happen until the button is clicked on.
        final Button button = findViewById(R.id.filterButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                selectedItem2 = spinner2.getSelectedItem().toString();
                firebaseFunction();
            }
        });

    }

    //Function that gets the lists of courses from firebase. The filtering queries happen in here.
    public void firebaseFunction() {
        System.out.println("I'm here in Firebase Func.");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Course> input = new ArrayList();
                Course course;
                //Reads in courses from firebase and saves them in a list
                for(DataSnapshot snap : dataSnapshot.getChildren()){
                    course = snap.getValue(Course.class);
                    course.setKey(snap.getKey());
                    //Filtering
                    if (selectedItem!=null && selectedItem.equals("Department")) {
                        System.out.println("IN DEPARTMENT LOOP");
                        if(selectedItem2.equals("Spanish")){
                            if (course.getDepartment().equals("Spanish")) {
                                input.add(course);
                            }
                        }else if (selectedItem2.equals("Sociology")){
                            if (course.getDepartment().equals("Sociology")){
                                input.add(course);
                            }
                        }
                    } else {
                        input.add(course);
                    }

                }
                listAdapter = new CourseListAdapter(input, studentId, db, findViewById(android.R.id.content));
                recyclerView.setAdapter(listAdapter);
            }

            @Override
            public void onCancelled(DatabaseError error) { } //needed for the listener
        });
    }
}