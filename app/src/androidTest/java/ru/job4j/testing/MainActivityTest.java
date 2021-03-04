package ru.job4j.testing;

import org.junit.Rule;
import org.junit.Test;
import androidx.test.rule.ActivityTestRule;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);
    @Test
    public void checkResultText() {
        onView(withId(R.id.result_textView)).check(matches(withText("")));
    }
    @Test
    public void checkButtonIsClickable() {
        onView(withId(R.id.button)).check(matches(isClickable()));
    }
    @Test
    public void checkResultWithError() {
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.result_textView)).check(matches(withText(R.string.Validation_error)));
    }
    @Test
    public void checkResultWithEmptyMessage() {
        onView(withId(R.id.email_editText)).perform(replaceText("email@email.xx"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.result_textView)).check(matches(withText(R.string.message_is_empty)));
    }
    @Test
    public void checkResultWithSuccess() {
        onView(withId(R.id.email_editText)).perform(replaceText("email@email.xx"));
        onView(withId(R.id.message_editText))
                .perform(replaceText("Hello, dude. how are you?"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.result_textView)).check(matches(withText(R.string.success)));
    }
}