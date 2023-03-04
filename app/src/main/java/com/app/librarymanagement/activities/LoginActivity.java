package com.app.librarymanagement.activities;

import static com.app.librarymanagement.helpers.common_helper.getAdminLogin;
import static com.app.librarymanagement.helpers.common_helper.getUserLogin;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.app.librarymanagement.R;
import com.app.librarymanagement.activities.Admin.DashboardAdminActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnLogin;
    TextView tvCreateAccount;
    EditText etEmail, etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.LoginBtn);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        tvCreateAccount = findViewById(R.id.CreateAccount);
        btnLogin.setOnClickListener(this);
        tvCreateAccount.setOnClickListener(this);

    }
    

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.LoginBtn:
                String stEmail = etEmail.getText().toString();
                String stPassword = etPassword.getText().toString();
                if(!stEmail.isEmpty() && !stPassword.isEmpty()){
                    if(getAdminLogin(stEmail,stPassword)) {
                        Toast.makeText(getApplicationContext(),"Login Success!",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), DashboardAdminActivity.class));
                    }
                    else if(getUserLogin(stEmail,stPassword)){
                        //user login
                        Toast.makeText(getApplicationContext(),"Coming soon!",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(),"Invalid credentials!",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"email (or) password should not be empty!",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.CreateAccount:
                startActivity(new Intent(getApplicationContext(), CreateAccountActivity.class));
                break;
            default:
                break;
        }
    }
}