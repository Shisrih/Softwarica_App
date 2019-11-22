package com.example.softwaricaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Loginscreen extends AppCompatActivity {
EditText username,password;
Button Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginscreen);


        username = findViewById(R.id.usernamefield);
        password = findViewById(R.id.passwordfield);


        Login = findViewById(R.id.loginbtn);


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });




    }


    public void login(){
        String usernametxt = username.getText().toString();
        String passwordtxt = password.getText().toString();


        if(usernametxt.equals("softwarica")&&passwordtxt.equals("coventry")){
            startActivity(new Intent(this,MainActivity.class));


        }
        else{
            username.requestFocus();
            username.setError("Incorrect username");
            password.setError("Incorrect password");

            Toast.makeText(this, "Incorrect email or password", Toast.LENGTH_SHORT).show();


        }

    }
}
