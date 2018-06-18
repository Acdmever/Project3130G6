package com.example.armando.project;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import android.test.suitebuilder.annotation.LargeTest;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class logInEspressoTest {
    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void enterUsername() {
        Espresso.onView(withId(R.id.username)).perform(typeText("username"), closeSoftKeyboard());
        Espresso.onView(withId(R.id.signInButton)).perform(click());
        Espresso.onView(withId(R.id.statusMessage)).check(matches(withText("Invalid username/password")));
    }

    @Test
    public void enterPassword() {
        Espresso.onView(withId(R.id.password)).perform(typeText("password"), closeSoftKeyboard());
        Espresso.onView(withId(R.id.signInButton)).perform(click());
        Espresso.onView(withId(R.id.statusMessage)).check(matches(withText("Invalid username/password")));
    }

    @Test
    public void enterInvalidUsername() {
        Espresso.onView(withId(R.id.username)).perform(typeText("????"), closeSoftKeyboard());
        Espresso.onView(withId(R.id.password)).perform(typeText("password"), closeSoftKeyboard());
        Espresso.onView(withId(R.id.signInButton)).perform(click());
        Espresso.onView(withId(R.id.statusMessage)).check(matches(withText("Invalid username/password")));
    }

    @Test
    public void enterInvalidPassword() {
        Espresso.onView(withId(R.id.username)).perform(typeText("username"), closeSoftKeyboard());
        Espresso.onView(withId(R.id.password)).perform(typeText("1"), closeSoftKeyboard());
        Espresso.onView(withId(R.id.signInButton)).perform(click());
        Espresso.onView(withId(R.id.statusMessage)).check(matches(withText("Invalid username/password")));
    }

    @Test
    public void fullValidation() {
        Espresso.onView(withId(R.id.username)).perform(typeText("user"), closeSoftKeyboard());
        Espresso.onView(withId(R.id.password)).perform(typeText("pass"), closeSoftKeyboard());
        Espresso.onView(withId(R.id.signInButton)).perform(click());
        Espresso.onView(withId(R.id.textView)).check(matches(withText("University of Maximegalon Course Registration")));
    }
}
