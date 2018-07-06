// https://developer.android.com/guide/topics/ui/controls/spinner used to
//Implement spinner interface
package com.example.armando.project;

import android.view.View;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;

public class CourseFilter implements AdapterView.OnItemSelectedListener {

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        parent.getItemAtPosition(position).toString();
        System.out.println("POSITION: " + parent.getItemAtPosition((position)));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
