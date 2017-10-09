package com.github.darsha1509.hw_05102017;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class CalculatorEspressoTest {

    @Rule
    public final ActivityTestRule<CalculatorActivity> activityTestRule = new ActivityTestRule<>(CalculatorActivity.class);

    @Test
    public void MultiplayButtonTest(){
        onView(withId(R.id.left_edit_text))
                .perform(typeText("2"));
        onView(withId(R.id.right_edit_text))
                .perform(typeText("2"));

        onView(withId(R.id.mult_btn))
                .perform(click());

        onView(withId(R.id.result_text_view))
                .check(matches(withText("4.0")));
    }
}
