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
import static org.hamcrest.Matchers.instanceOf;
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

        onView(withId(R.id.coursesButton)).perform(click());
        onView(withId(R.id.spinner)).perform(click());

        //The following 3 lines of code were referenced from this Stack Overflow article:
        //https://stackoverflow.com/questions/31420839/android-espresso-check-selected-spinner-text
        onData(allOf(is(instanceOf(String.class)), is("Department"))).perform(click());
        onView(withId(R.id.spinner)).check(matches(withSpinnerText(containsString("Department"))));
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
    public void timeConflictTest() throws InterruptedException {
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

        String tag = "1reg";
        String tag2="3reg";
        onView(withTagValue(is((Object) tag2))).perform(click());
        onView(withTagValue(is((Object) tag))).perform(click());
        Thread.sleep(500);

        //Will be the message when time conflict happens.
        onView(allOf(withId(android.support.design.R.id.snackbar_text)))
                .check(matches(withText("Time conflict with current courses.")));
        onView(withTagValue(is((Object) tag))).check(matches(isNotChecked()));

        Thread.sleep(500);

        //Clicks on the snackbar button to register despite the time conflict
        onView(allOf(withId(android.support.design.R.id.snackbar_action))).perform(click());
        Thread.sleep(500);
        onView(withTagValue(is((Object) tag))).check(matches(isChecked()));

        //Drop course to reset for next test
        onView(withTagValue(is((Object) tag))).perform(click());
        onView(withTagValue(is((Object) tag2))).perform(click());

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
        Espresso.onView(withId(R.id.Year)).check(matches(withText("2018-2019")));
        Espresso.onView(withId(R.id.Enrolment)).check(matches(withText("0/30")));
        Espresso.onView(withId(R.id.Prereqs)).check(matches(withText("There are no prerequisites for this course")));

        Thread.sleep(1000);
        Espresso.pressBack();

        String tag2 = "1det";
        onView(withTagValue(is((Object) tag2))).perform(click());
        Espresso.onView(withId(R.id.Description)).check(matches(withText("Advance your spanish " +
                "skills in intermediate spanish with Christine Mayor")));
        Espresso.onView(withId(R.id.Department)).check(matches(withText("Spanish")));
        Espresso.onView(withId(R.id.Instructor)).check(matches(withText("Christine Mayor")));
        Espresso.onView(withId(R.id.Name)).check(matches(withText("Intermediate Spanish")));
        Espresso.onView(withId(R.id.Number)).check(matches(withText("2000")));
        Espresso.onView(withId(R.id.Semester)).check(matches(withText("winter")));
        Espresso.onView(withId(R.id.Year)).check(matches(withText("2018-2019")));
        Espresso.onView(withId(R.id.Enrolment)).check(matches(withText("2/30")));
        Espresso.onView(withId(R.id.Prereqs)).check(matches(withText("Spanish 1000")));

        Intents.release();
    }
}
