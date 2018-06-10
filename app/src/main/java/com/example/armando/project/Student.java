package com.example.armando.project;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Display;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Student {
    //Firebase.setAndroidContext(this);
    //private FirebaseDatabase db=FirebaseDatabase.getInstance();
    //private DatabaseReference ref=db.getReference("Test");

    private String firstName = new String();
    private String lastName = new String();
    private int id;
    public  Student(int id) {
        //this.db = FirebaseDatabase.getInstance();
        // or find the student with the given id
    }

    public Student() {
        //this.db = FirebaseDatabase.getInstance();
        //this.ref = db.getReference("Test");
        //FirebaseApp.initializeApp()});
        System.out.println("Made a student");
        //create a new student in the database
    }

    void setFirstName(String fn) {
        FirebaseDatabase db=FirebaseDatabase.getInstance();
        DatabaseReference ref=db.getReference("Test");
        //set the first name in the database
        ref.setValue(fn);


    }

    String getFirstName() {
        return "";
    }


}
