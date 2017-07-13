package com.example.mvaguimaraes.session;

/**
 * Created by Mvaguimaraes on 3/11/16.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText txtUsername, txtPassword;
    Button btnLogin;
    SessionManager session;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        session = new SessionManager(getApplicationContext());

        txtUsername = (EditText) findViewById(R.id.uname);
        txtPassword = (EditText) findViewById(R.id.pwd);

        displayToad("User Login Status: " + session.isLoggedIn());

        btnLogin = (Button) findViewById(R.id.login);
        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                String username = txtUsername.getText().toString();
                String password = txtPassword.getText().toString();

                // Check if username, password is filled
                if (username.trim().length() > 0 && password.trim().length() > 0) {

                    if (username.equals("java4you") && password.equals("java4you")) {

                        // Creating user login session
                        // For testing i am storing name, email as follow
                        // Use user real data
                        session.createLoginSession(username, password);

                        // Staring MainActivity
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();

                    } else {
                        // username / password doesn't match
                        displayToad("Login failed. Username/Password is incorrect");
                    }
                } else {
                    // user didn't entered username or password
                    // Show alert asking him to enter the details
                    displayToad("Login failed.. Please enter username and password");
                }

            }
        });
    }

    private void displayToad(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }
}


