package com.example.thirdassignment.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.thirdassignment.MainActivity;
import com.example.thirdassignment.R;

public class LoginPage extends AppCompatActivity {

    Button btnLogin;
    EditText etUsername, etPassword;
    String username, password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btnLogin);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = etUsername.getText().toString();
                password = etPassword.getText().toString();

                if (formValidate()){
                    if (username.equals("softwarica") && password.equals("coventry")){
                        Intent intent = new Intent(LoginPage.this, MainActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginPage.this, "Invalid username or password!", Toast.LENGTH_SHORT).show();
                        etUsername.setError("Invalid username or password");
                        etUsername.requestFocus();
                    }
                }
            }
        });

    }

    public boolean formValidate(){
        if (TextUtils.isEmpty(username)){
            etUsername.setError("Enter Username!");
            etUsername.requestFocus();
            return false;
        }

        if (TextUtils.isEmpty(password)){
            etPassword.setError("Enter Password!");
            etPassword.requestFocus();
            return false;
        }
        return true;
    }
}
