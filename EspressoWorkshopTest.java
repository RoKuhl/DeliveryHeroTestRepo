package de.deliveryhero.mailordercoffeeshop;

import android.app.Activity;

import org.junit.runner.RunWith;
import org.junit.Test;
import org.junit.Rule;
import androidx.test.filters.LargeTest;

import de.deliveryhero.mailordercoffeeshop.order.OrderViewModel;

import androidx.test.runner.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class EspressoWorkshopTest {

    @Rule public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void RunTests()
    {
        CloseOnboarding();
        SetUpOrder();
        FillOrderForm();
        SubmitOrder();
    }

    public void CloseOnboarding()
    {
        // Close the onboarding window
        onView(withId(R.id.close_button)).perform(click());
    }

    public void SetUpOrder()
    {
        // Add two shots of espresso
        onView(withId(R.id.more_espresso)).perform(click());
        onView(withId(R.id.more_espresso)).perform(click());

        // Add chocolate
        onView(withId(R.id.chocolate)).perform(click());

        // Select steamed low fat milk
        onData(withId(R.id.milk_options_container))
                .atPosition(2)
                .perform(click());
        onView(withText("Steamed")).perform(click());

        // Proceed to next page
        onView(withId(R.id.review_order_button)).perform(click());
    }

    public void FillOrderForm()
    {
        // Fill in requested data text boxes
        onData(withId(R.id.name_text_box)).perform(typeText("Ross Kuhlman"));
        onData(withId(R.id.email_text_box)).perform(typeText("ross.kuhlman@gmail.com"));
        onData(withId(R.id.custom_order_name_box)).perform(typeText("Dbl esp with choc and lf steamed milk"));
    }

    public void SubmitOrder()
    {
        // Press the Submit button
        onView(withId(R.id.mail_order_button)).perform(click());
    }
}
