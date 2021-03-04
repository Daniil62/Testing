package ru.job4j.testing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.host_fragment);
        FragmentManager manager = getSupportFragmentManager();
        if (manager.findFragmentById(R.id.content) == null) {
            manager.beginTransaction().add(R.id.content, new MainFragment()).commit();
        }
    }
}