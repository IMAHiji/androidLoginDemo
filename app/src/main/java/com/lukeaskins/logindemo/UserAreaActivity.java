package com.lukeaskins.logindemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserAreaActivity extends AppCompatActivity {
    @BindView(R.id.etUsername) EditText etUsername;
    @BindView(R.id.etAge) EditText etAge;
    @BindView(R.id.tvWelcomeMessage) TextView welcomeMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);
        ButterKnife.bind(this);

    }
}
