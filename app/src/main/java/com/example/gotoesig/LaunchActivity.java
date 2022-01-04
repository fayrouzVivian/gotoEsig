package com.example.gotoesig;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        Button signUpBtn = findViewById(R.id.signUpLBtn),
        logInBtn = findViewById(R.id.logInLBtn);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextIntent =new Intent(LaunchActivity.this,SignUpActivity.class) ;
                startActivity(nextIntent);
            }
        });
        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextIntent =new Intent(LaunchActivity.this,LogInActivity.class) ;
                startActivity(nextIntent);
            }
        });
    }
}