package ru.job4j.testing;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {
    private TextView resultText;
    private EditText emailField;
    private EditText messageField;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);
        resultText = view.findViewById(R.id.result_textView);
        emailField = view.findViewById(R.id.email_editText);
        messageField = view.findViewById(R.id.message_editText);
        Button sendButton = view.findViewById(R.id.button);
        sendButton.setOnClickListener(this::onClick);
        return view;
    }
    @SuppressLint("SetTextI18n")
    private void onClick(View view) {
        String email = emailField.getText().toString();
        String message = messageField.getText().toString();
        Validator<String> emailValidator = new EmailValidator();
        if (emailValidator.validate(email) && emailValidator.counter(message) > 0) {
            resultText.setText(R.string.success);
        }
        else if (emailValidator.validate(email) && emailValidator.counter(message) == 0) {
            resultText.setText(R.string.message_is_empty);
        } else {
            resultText.setText(R.string.Validation_error);
        }
    }
}
