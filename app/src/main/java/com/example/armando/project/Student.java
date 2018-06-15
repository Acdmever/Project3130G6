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

    public String firstName;
    public String lastName;
    //private String id;
    public String password;
    public String username;
    public Student(){}
    public Student(String firstName , String lastName, String password, String username){
        this.firstName=firstName;
        this.lastName=lastName;
        this.password=password;
        this.username=username;
    }

    public void setFirstName(String fn) {

        this.firstName=fn;
    }
    public void setLastName(String ln) {

        this.lastName=ln;
    }
    public void setPassword(String pw) {
        this.password=pw;
    }
    public void setUsername(String un) {
        this.username=un;
    }
    /*public void setID(String id){
        this.ID=id;
    }*/
    public String getFirstName() {

        return this.firstName;
    }
    public String getLastName() {

        return this.lastName;
    }
    public String getPassword() {

        return this.password;
    }
    public String getUsername() {

        return this.username;
    }
    /*public String getID() {
        return this.ID;

    }*/
    public static void transfer(Student s1, Student s2){
        s2.setLastName(s1.getLastName());
        s2.setFirstName(s1.getFirstName());
        s2.setUsername(s1.getUsername());
        s2.setPassword(s1.getPassword());

    }

}
