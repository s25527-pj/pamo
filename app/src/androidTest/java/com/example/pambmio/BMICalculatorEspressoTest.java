package com.example.pambmio;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;

@RunWith(AndroidJUnit4.class)
public class BMICalculatorEspressoTest {

    @Rule
    public ActivityScenarioRule<BMICalculatorActivity> activityRule =
            new ActivityScenarioRule<>(BMICalculatorActivity.class);

    @Test
    public void testBMIResultIsDisplayed() {
        onView(withId(R.id.weightInput))
                .perform(typeText("70"), closeSoftKeyboard());

        onView(withId(R.id.heightInput))
                .perform(typeText("175"), closeSoftKeyboard());

        onView(withId(R.id.calculateButton))
                .perform(click());

        onView(withId(R.id.bmiResult))
                .check(matches(withText(org.hamcrest.Matchers.containsString("BMI"))));
    }
}
