package ru.job4j.testing;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(RobolectricTestRunner.class)
public class IntegrationTest {
    private MainActivity activity;
    private TextView label;
    private Button button;
    @Before
    public void before() {
        activity = Robolectric.setupActivity(MainActivity.class);
        label = activity.findViewById(R.id.result_textView);
        button = activity.findViewById(R.id.button);
    }
    @Test
    public void checkStatusError() {
        button.performClick();
        String status = label.getText().toString();
        assertThat(status).isEqualTo(activity.getString(R.string.Validation_error));
    }
    @Test
    public void whenMessageEmpty() {
        EditText email = activity.findViewById(R.id.email_editText);
        email.setText("12345@mail.678");
        button.performClick();
        String status = label.getText().toString();
        assertThat(status).isEqualTo(activity.getString(R.string.message_is_empty));
    }
    @Test
    public void whenEmailSuccess() {
        EditText email = activity.findViewById(R.id.email_editText);
        EditText message = activity.findViewById(R.id.message_editText);
        email.setText("12345@mail.678");
        message.setText("123456789");
        button.performClick();
        String status = label.getText().toString();
        assertThat(status).isEqualTo(activity.getString(R.string.success));
    }
}
