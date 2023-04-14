package com.app.librarymanagement.activities.Users;

import static com.app.librarymanagement.helpers.common_helper.getUserDetails;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.app.librarymanagement.R;
import com.app.librarymanagement.helpers.BaseActivity;
import com.app.librarymanagement.models.User;

public class UserProfile extends BaseActivity {
    TextView tvName,tvJob,tvEmail,tvMobile,tvAddress,tvAge,tvGender;
    Button btnHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        findViewById(R.id.btnBack).setOnClickListener(view->{
            startActivity(new Intent(this, DashboardUserActivity.class));
        });
        tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);
        tvMobile = findViewById(R.id.tvMobile);
        tvAddress = findViewById(R.id.tvAddress);
        tvAge = findViewById(R.id.tvAge);
        tvGender = findViewById(R.id.tvGender);
        btnHome = findViewById(R.id.btnHome);

        Intent intent = getIntent();
        if (null != intent) {
            //Null Checking
            // String strId= intent.getStringExtra("lab_id");
            String strId= "1";
            if(!strId.isEmpty()){
                User user= getUserDetails(strId);
                if(!user.getId().equals(""))
                    showDetails(user);
                else{
                    Toast.makeText(this, "invalid!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), DashboardUserActivity.class));
                }
            }
            else {
                Toast.makeText(this, "invalid!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), DashboardUserActivity.class));
            }
        }
        btnHome.setOnClickListener(view->{
            startActivity(new Intent(this, DashboardUserActivity.class));
        });
    }

    private void showDetails(User user){
        tvName.setText(user.getName());
        tvAddress.setText(user.getAddress());
        tvEmail.setText(user.getEmail());
        tvMobile.setText(user.getTel());
        tvAge.setText("Age: "+user.getAge());
        tvGender.setText("Gender: "+user.getGender());
    }
}
