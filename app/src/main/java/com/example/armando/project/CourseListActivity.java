package com.example.armando.project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

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
    private TextView warningTextView;

    //Hard coded until login functionality is ironed out.

    private String selectedItem, selectedItem2;
    private Degree degree;

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
        warningTextView = findViewById(R.id.textViewWarning);

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

        //Implementing Course Filter. Implementing onItemSelectedListener() interface.

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedItem = parent.getItemAtPosition(position).toString();

                //If the first spinner is set to Department, then populate the second spinner
                //with the list of departments, then for course level, etc.
                if (selectedItem.equals("Department")){
                    spinner2.setOnItemSelectedListener(new CourseFilter());
                    ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getApplicationContext(),
                            R.array.department_array, android.R.layout.simple_spinner_item);
                    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter2);
                } else if (selectedItem.equals("Course Level")){
                    spinner2.setOnItemSelectedListener(new CourseFilter());
                    ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getApplicationContext(),
                            R.array.courseLevel_array, android.R.layout.simple_spinner_item);
                    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter2);
                } else if (selectedItem.equals("Semester")){
                    spinner2.setOnItemSelectedListener(new CourseFilter());
                    ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getApplicationContext(),
                            R.array.semester_array, android.R.layout.simple_spinner_item);
                    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter2);
                } else {
                    spinner2.setAdapter(null);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Gets student's degree for use
        degreeFromRequirements();

        //Filter button. Filtering will not happen until the button is clicked on.
        final Button button = findViewById(R.id.filterButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (spinner2.getSelectedItem() != null)
                    selectedItem2 = spinner2.getSelectedItem().toString();
                warningTextView.setText("");
                firebaseFunction();
            }
        });

    }

    /**
     * This function gets the students degree object by reading students degree requirements
     */
    public void degreeFromRequirements() {
        db.getReference("Requirements").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //Filtering by hardcoded degree requirements, until student's degree is accessible
                //System.out.println(getIntent().getStringExtra("degree")+"\n");
                degree = dataSnapshot.child(getIntent().getStringExtra("degree")).getValue(Degree.class);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    /**
     * This loops through the list of required courses and checks if a course is in the list
     * @param courses
     * @param courseId
     * @return
     */
    public boolean isCourseIncluded(ArrayList<String> courses, String courseId) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).equals(courseId)) {
                return true;
            }
        }
        return false;
    }

    /**
     * FirebaseFunction() is called when populating the list of courses. It does not return anything
     * but will run the methods to populate the list. This is called by the filtering button to
     * filter the courses.
     */
    public void firebaseFunction() {
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            /**
             * Returns courses to be displayed.
             *
             * Grabs all courses from the database, and filters them
             * according to the user's input
             *
             * @param dataSnapshot
             */
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Course> input = new ArrayList();
                Course course;
                //Reads in courses from firebase and saves them in a list
                for(DataSnapshot snap : dataSnapshot.getChildren()){
                    course = snap.getValue(Course.class);
                    course.setKey(snap.getKey());
                    //Filtering
                    if (selectedItem!=null && selectedItem.equals("Department")) {
                        if(selectedItem2 != null && selectedItem2.equals("Spanish")){
                            if (course.getDepartment().equals("Spanish")) {
                                input.add(course);
                            }
                        }else if (selectedItem2 != null && selectedItem2.equals("Sociology")){
                            if (course.getDepartment().equals("Sociology")){
                                input.add(course);
                            }
                        }
                    } else if (selectedItem!=null && selectedItem.equals("Course Level")) {
                        if(selectedItem2 != null && selectedItem2.equals("1000s")){
                            if ((course.getNum() / 1000) == 1) {
                                input.add(course);
                            }
                        }
                        else if (selectedItem2 != null && selectedItem2.equals("2000s")){
                            if ((course.getNum() / 1000) == 2){
                                input.add(course);
                            }
                        } else if (selectedItem2 != null && selectedItem2.equals("3000s")){
                            if ((course.getNum() / 1000) == 3){
                                input.add(course);
                            }
                        } else if (selectedItem2 != null && selectedItem2.equals("4000s")){
                            if ((course.getNum() / 1000) == 4){
                                input.add(course);
                            }
                            if(input.isEmpty()){
                                warningTextView.setText(R.string.warning);
                            }
                        }
                    } else if (selectedItem!=null && selectedItem.equals("Semester")) {
                        if (selectedItem2 != null && selectedItem2.equals("Fall")) {
                            if (course.getSemester().equals("fall")) {
                                input.add(course);
                            }
                        } else if (selectedItem2 != null && selectedItem2.equals("Winter")) {
                            if (course.getSemester().equals("winter")) {
                                input.add(course);
                            }
                        }
                    } else if(selectedItem!=null && selectedItem.equals("Required Courses")) {
                        if (degree != null && isCourseIncluded(degree.getCourses(), course.getKey())) {
                            input.add(course);
                        }
                    }

                    else {
                        input.add(course);
                    }
                }

                //If no courses are displayed, then show error
                if(input.isEmpty()){
                    warningTextView.setText(R.string.warning);
                }

                //Creates the prerequisite List
                for (Course c:input){
                    c.makePrereqs(dataSnapshot);
                }

                listAdapter = new CourseListAdapter(input, getIntent().getStringExtra("studentId"), db, findViewById(android.R.id.content));
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