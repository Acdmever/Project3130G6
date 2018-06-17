package com.example.armando.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A login screen that offers login via username/password.
 */
public class LoginActivity extends AppCompatActivity {

    private EditText inputUser;
    private EditText inputPass;
    private TextView statusMessage;
    private logIn logInAttempt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Setting up the login fields
        inputUser = findViewById(R.id.username);
        inputPass = findViewById(R.id.password);
        statusMessage = findViewById(R.id.statusMessage);
        logInAttempt = new logIn();

        //Set button
        final Button validateButton = findViewById(R.id.sign_in_button);
        validateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (logInAttempt.validate(inputUser.getText().toString(), inputPass.getText().toString()) == 1)
                    onClickGoToMainMenu();
                else
                    statusMessage.setText("Invalid username/password");

            }
        });
    }

    private void onClickGoToMainMenu() {
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
        finish();
    }
}

