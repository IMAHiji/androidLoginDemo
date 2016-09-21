package com.lukeaskins.logindemo.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lukeaskins.logindemo.R;
import com.lukeaskins.logindemo.model.UserLoginResponse;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserActivity extends AppCompatActivity {
    @BindView(R.id.userName) TextView userName;
    @BindView(R.id.phoneNumber) TextView phoneNumber;
    String mUsername;
    String mPhoneNumber;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ButterKnife.bind(this);
        Intent intent = getIntent();

        UserLoginResponse deSerializedData = deSerializeBooty(intent.getStringExtra("users"));

        mUsername = deSerializedData.getUsers().getEmail();
        mPhoneNumber = deSerializedData.getUsers().getFirstName();
        userName.setText(mUsername);
        phoneNumber.setText(mPhoneNumber);
    }

    public UserLoginResponse deSerializeBooty(String s){
        Gson gson = new Gson();
        UserLoginResponse deSerializedData = gson.fromJson(s, UserLoginResponse.class);

        return deSerializedData;
    }

}
