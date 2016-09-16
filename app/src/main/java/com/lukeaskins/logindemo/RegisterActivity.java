package com.lukeaskins.logindemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.etAge)TextView etAge;
    @BindView(R.id.etName)TextView etName;
    @BindView(R.id.etUsername) TextView etUsername;
    @BindView(R.id.etPassword) TextView etPassword;
    @BindView(R.id.buttonRegister) Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //This tells the java file which layout xml file it is working with
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

//        final EditText etAge = (EditText) findViewById(R.id.etAge);
//        final EditText etName = (EditText) findViewById(R.id.etName);
//        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
//        final EditText etPassword = (EditText) findViewById(R.id.etPassword);



    }
}
