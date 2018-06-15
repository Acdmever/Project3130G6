package com.example.armando.project;

import org.junit.runner.RunWith;
import org.junit.Rule;
import org.junit.Test;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.core.AllOf.allOf;


@RunWith(AndroidJUnit4.class)

public class EspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void onClickRegisterButton() {
        Intents.init();
        onView(withId(R.id.registerButton)).perform(click());
        intended(hasComponent(CourseListActivity.class.getName()));

        onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.scrollToPosition(1))
                .check(matches(hasDescendant(withText("Spanish"))));
        onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.scrollToPosition(1))
                .check(matches(hasDescendant(withText("Fall"))));

        Intents.release();
    }
}
