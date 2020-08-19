package com.example.onsite1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Path;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements Fragment1.Fragment1Listener, Fragment2.Fragment2Listener {

    FrameLayout frame1 , frame2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frame1 = findViewById(R.id.fragment1);
        frame2 = findViewById(R.id.fragment2);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment1, new Fragment1())
                .add(R.id.fragment2, new Fragment2())
                .commit();

    }

    @Override
    public void sendPath1(Path path) {
        Fragment2.updatePath2(path);
    }

    @Override
    public void sendPath2(Path path) {
        Fragment1.updatePath1(path);

    }
}