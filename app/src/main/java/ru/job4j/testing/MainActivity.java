package ru.job4j.testing;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView resultText;
    private EditText emailField;
    private EditText messageField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultText = findViewById(R.id.result_textView);
        emailField = findViewById(R.id.email_editText);
        messageField = findViewById(R.id.message_editText);
        Button sendButton = findViewById(R.id.button);
        sendButton.setOnClickListener(this::onClick);
    }
    @SuppressLint("SetTextI18n")
    private void onClick(View view) {
        String email = emailField.getText().toString();
        String message = messageField.getText().toString();
        Validator<String> emailValidator = new EmailValidator();
        if (emailValidator.validate(email) && emailValidator.counter(message) > 0) {
            resultText.setText("Success");
        }
        else if (emailValidator.validate(email) && emailValidator.counter(message) == 0) {
            resultText.setText("Message is empty");
        } else {
            resultText.setText("Validation error");
        }
    }
}