package com.app.librarymanagement.activities.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.app.librarymanagement.R;
import com.app.librarymanagement.activities.LoginActivity;

public class DashboardAdminActivity extends AppCompatActivity {
    Button SignOutBtn,btnUsers,btnBooks,btnRequests,btnDues,btnAuthors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);
        btnBooks = findViewById(R.id.btnBook);
        btnAuthors = findViewById(R.id.btnAuthors);
        btnRequests = findViewById(R.id.btnRequests);
        btnUsers = findViewById(R.id.btnUsers);
        btnDues = findViewById(R.id.btnDue);
        btnUsers.setOnClickListener(view -> {

        });
        btnBooks.setOnClickListener(view -> {
             startActivity( new Intent(this, BooksActivity.class));
        });
        btnAuthors.setOnClickListener(view -> {
             startActivity(new Intent(this, AuthorsActivity.class));
        });
        btnRequests.setOnClickListener(v -> {
        });
        btnDues.setOnClickListener(v -> {
        });
        SignOutBtn=findViewById(R.id.signOutBtn);
        SignOutBtn.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });
    }
}
