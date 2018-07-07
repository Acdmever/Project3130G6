package com.example.armando.project;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withTagValue;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;

import static org.hamcrest.Matchers.is;


@RunWith(AndroidJUnit4.class)

public class FilterEspressoTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule =
            new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void selectSpanishDepartment() throws InterruptedException {
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

        //Selecting the filter
        onView(withId(R.id.spinner)).perform(click());
        onData(anything()).atPosition(4).perform(click());

        onView(withId(R.id.spinner2)).perform(click());
        onData(anything()).atPosition(1).perform(click());

        onView(withId(R.id.filterButton)).perform(click());

        //Checking all courses to see if they are under filter criteria
        int i = 0;
        String tag = i + "det";
        while (i < 10) {
            try {
                onView(withTagValue(is((Object) tag))).check(matches(isDisplayed()));
                onView(withTagValue(is((Object) tag))).perform(click());
                Espresso.onView(withId(R.id.Department)).check(matches(withText("Spanish")));
                Espresso.pressBack();
            } catch (NoMatchingViewException e) {
                System.out.println("Course does not exist");
            }
            i++;
            tag = i + "det";
        }

        Intents.release();
    }

    @Test
    public void selectSociologyDepartment() throws InterruptedException {
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

        //Selecting the filter
        onView(withId(R.id.spinner)).perform(click());
        onData(anything()).atPosition(4).perform(click());

        onView(withId(R.id.spinner2)).perform(click());
        onData(anything()).atPosition(0).perform(click());

        onView(withId(R.id.filterButton)).perform(click());

        //Checking all courses to see if they are under filter criteria
        int i = 0;
        String tag = i + "det";
        while (i < 10) {
            try {
                onView(withTagValue(is((Object) tag))).check(matches(isDisplayed()));
                onView(withTagValue(is((Object) tag))).perform(click());
                Espresso.onView(withId(R.id.Department)).check(matches(withText("Sociology")));
                Espresso.pressBack();
            } catch (NoMatchingViewException e) {
                System.out.println("Course does not exist");
            }
            i++;
            tag = i + "det";
        }

        Intents.release();
    }
}
