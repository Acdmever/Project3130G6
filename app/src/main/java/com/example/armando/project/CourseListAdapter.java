package com.example.armando.project;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.firebase.database.FirebaseDatabase;

/************************************************************************************
 *   Code Reference
 *   Title: Using lists and grids in Android with RecyclerView - Tutorial
 *   Author: vogella GmbH
 *   Date: 20.06.2016
 *   Version: Version 1.3
 *   Availability: http://www.vogella.com/tutorials/AndroidRecyclerView/article.html
 ***********************************************************************************/

public class CourseListAdapter extends RecyclerView.Adapter<CourseListAdapter.ViewHolder> {
    private List<Course> values;
    private String studentId;
    private final FirebaseDatabase db;
    final View mainView;
    private List<Course> registered = new ArrayList();

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtHeader;
        public TextView txtFooter;
        public Button detailsButton;
        public ToggleButton courseToggle;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = v.findViewById(R.id.Header);
            txtFooter = v.findViewById(R.id.Footer);
            detailsButton = v.findViewById(R.id.button);
            courseToggle = v.findViewById(R.id.toggleButton);
        }
    }

    public void add(int position, Course item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    public CourseListAdapter(List<Course> myDataset, String studentId, FirebaseDatabase db, View mainView) {
        values = myDataset;
        this.studentId = studentId;
        this.db = db;
        this.mainView = mainView;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public CourseListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.view_layout, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final String header = values.get(position).makeHeaderString();
        final String footer = values.get(position).makeFooterString();
        final Course selectedCourse = values.get(position);
        holder.txtHeader.setText(header);
        holder.txtFooter.setText(footer);

        holder.detailsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ViewCourseDetail.class);
                intent.putExtra("course", selectedCourse.getCourseDetail());
                v.getContext().startActivity(intent);
            }
        });

        holder.courseToggle.setTag(values.get(position).getKey()+"reg");
        holder.detailsButton.setTag(values.get(position).getKey()+"det");
        holder.layout.setTag(values.get(position).getKey()+"item");
        if(values.get(position).getStudents().contains(studentId)){
            holder.courseToggle.setChecked(true);
            registered.add(values.get(position));
        }

        //Toggle button listener to handle when the user registrations or drops for a course
        holder.courseToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(final CompoundButton buttonView, boolean isChecked) {
                final String key = values.get(position).getKey()+"-"+studentId;
                if (isChecked) {
                   for (Course reg: registered) {
                        if(reg.checkForTimeConflict(values.get(position))){
                           buttonView.setChecked(false);
                            Snackbar.make(mainView, "Time conflict with current courses.", Snackbar.LENGTH_LONG)
                                    .setAction("Register", new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                           register(position, buttonView, key);
                                        }
                                    })
                                    .show();
                            return;
                        }
                   }
                   register(position, buttonView, key);
                } else {
                    drop(position, key);
                }
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }

    public void register(int position, CompoundButton buttonView, String key){
        Registration  reg = values.get(position).addStudent(studentId);
        db.getReference("Registrations").child(key).setValue(reg);
        db.getReference("Courses").child(values.get(position).getKey())
                .child("students").setValue(values.get(position).getStudents());
        registered.add(values.get(position));
        buttonView.setChecked(true);
        Snackbar.make(mainView, "Registered for course", Snackbar.LENGTH_LONG)
                .show();

    }

    public void drop(int position, String key){
        ArrayList<String> newList = values.get(position).removeStudent(studentId);
        db.getReference("Registrations").child(key).removeValue();
        db.getReference("Courses").child(values.get(position).getKey())
                .child("students").setValue(newList);
        registered.remove(values.get(position));
        Snackbar.make(mainView, "Dropped from course", Snackbar.LENGTH_LONG)
                .show();
    }
}