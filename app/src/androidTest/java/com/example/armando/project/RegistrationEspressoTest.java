package com.example.armando.project;

import org.junit.runner.RunWith;
import org.junit.Rule;
import org.junit.Test;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.AllOf.allOf;

@RunWith(AndroidJUnit4.class)

public class RegistrationEspressoTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule =
            new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void onClickDropDown() throws InterruptedException{
        Intents.init();

        Espresso.onView(withId(R.id.username))
                .perform(typeText("user"), closeSoftKeyboard());
        Espresso.onView(withId(R.id.password))
                .perform(typeText("pass"), closeSoftKeyboard());
        Espresso.onView(withId(R.id.signInButton)).perform(click());

        Thread.sleep(5000);

        //To-Do: Write more espresso tests once we have functionality built into the drop down
        onView(withId(R.id.coursesButton)).perform(click());
        onView(withId(R.id.courses_toolbar)).perform(click());

        Intents.release();
    }

    @Test
    public void onClickCoursesButton() throws InterruptedException {
        Intents.init();
        Espresso.onView(withId(R.id.username))
                .perform(typeText("user"), closeSoftKeyboard());
        Espresso.onView(withId(R.id.password))
                .perform(typeText("pass"), closeSoftKeyboard());
        Espresso.onView(withId(R.id.signInButton)).perform(click());
        Thread.sleep(5000);
        onView(withId(R.id.coursesButton)).perform(click());
        intended(hasComponent(CourseListActivity.class.getName()));

        //wait for list to load
        Thread.sleep(5000);

        //test to see if recyclerView loaded
        String tag = "0item";
        onView(withTagValue(is((Object) tag))).check(matches(hasDescendant(withText("Details"))));

        Intents.release();
    }

    @Test
    public void registrationCheck() throws InterruptedException {
        Intents.init();
        Espresso.onView(withId(R.id.username))
                .perform(typeText("user"), closeSoftKeyboard());
        Espresso.onView(withId(R.id.password))
                .perform(typeText("pass"), closeSoftKeyboard());
        Espresso.onView(withId(R.id.signInButton)).perform(click());
        Thread.sleep(5000);
        onView(withId(R.id.coursesButton)).perform(click());
        intended(hasComponent(CourseListActivity.class.getName()));

        //wait for list to load
        Thread.sleep(5000);

        //test to see if recyclerView loaded
        String tag = "0reg";
        onView(withTagValue(is((Object) tag))).perform(click());
        onView(withTagValue(is((Object) tag))).check(matches(isChecked()));
        //Will be the message when registration is successful
        onView(allOf(withId(android.support.design.R.id.snackbar_text)))
                .check(matches(withText("Registered for course")));

        Thread.sleep(5000);

        onView(withTagValue(is((Object) tag))).perform(click());
        onView(withTagValue(is((Object) tag))).check(matches(isNotChecked()));
        onView(allOf(withId(android.support.design.R.id.snackbar_text)))
                .check(matches(withText("Dropped from course")));

        Intents.release();
    }

    @Test
    public void showCourseDetails() throws InterruptedException {
        Intents.init();
        Espresso.onView(withId(R.id.username))
                .perform(typeText("user"), closeSoftKeyboard());
        Espresso.onView(withId(R.id.password))
                .perform(typeText("pass"), closeSoftKeyboard());
        Espresso.onView(withId(R.id.signInButton)).perform(click());
        Thread.sleep(5000);
        onView(withId(R.id.coursesButton)).perform(click());
        intended(hasComponent(CourseListActivity.class.getName()));

        //wait for list to load
        Thread.sleep(5000);

        //test to see if recyclerView loaded
        String tag = "0det";
        onView(withTagValue(is((Object) tag))).perform(click());
        Espresso.onView(withId(R.id.Description)).check(matches(withText("Learn the basics of spanish with Señor Pedro")));
        Espresso.onView(withId(R.id.Department)).check(matches(withText("Spanish")));
        Espresso.onView(withId(R.id.Instructor)).check(matches(withText("Señor Pedro")));
        Espresso.onView(withId(R.id.Name)).check(matches(withText("Intro to Spanish")));
        Espresso.onView(withId(R.id.Number)).check(matches(withText("1000")));
        Espresso.onView(withId(R.id.Semester)).check(matches(withText("fall")));
        Espresso.onView(withId(R.id.Year)).check(matches(withText("2012-2013")));
        Intents.release();
    }
}
