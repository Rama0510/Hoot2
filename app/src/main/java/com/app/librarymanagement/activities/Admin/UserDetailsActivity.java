package com.app.librarymanagement.activities.Admin;

import static com.app.librarymanagement.helpers.common_helper.getUserDetails;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.app.librarymanagement.R;
import com.app.librarymanagement.models.User;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class UserDetailsActivity extends AppCompatActivity {
    Button btnUserDetails;
    String strId;
    TextView tvUserName,tvAge,tvEmail,tvMobile,tvAddress,tvDelete,tvGender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        findViewById(R.id.btnBack).setOnClickListener(view->{
            this.finish();
        });

        tvUserName= findViewById(R.id.tvUserName);
        tvEmail= findViewById(R.id.tvEmail);
        tvAge= findViewById(R.id.tvAge);
        tvMobile= findViewById(R.id.tvMobile);
        tvAddress= findViewById(R.id.tvAddress);
        tvDelete= findViewById(R.id.tvDelete);
        tvGender= findViewById(R.id.tvGender);
        btnUserDetails= findViewById(R.id.btnUserDetails);
        Intent intent = getIntent();
        if (null != intent) {
            //Null Checking
            strId= intent.getStringExtra("user_id");
            User user = getUserDetails(strId);
            if(!user.getId().isEmpty()){
                tvUserName.setText(user.getName());
                tvEmail.setText(user.getEmail());
                tvMobile.setText(user.getTel());
                tvAddress.setText(user.getAddress());
                tvAge.setText("Age: "+user.getAge());
                tvGender.setText("Gender: "+user.getGender());
                tvDelete.setOnClickListener(view->{
                    Toast.makeText(this, "Deleted!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), MyUsersActivity.class));
                });
                btnUserDetails.setOnClickListener(view->{
                    updateUser();
                });
            }else{
                Toast.makeText(this, "invalid!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), UserDetailsActivity.class));
            }
        }
    }

    public void updateUser() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.activity_edit_user);
        bottomSheetDialog.show();
        EditText etName = bottomSheetDialog.findViewById(R.id.etName);
        EditText etEmail = bottomSheetDialog.findViewById(R.id.etEmail);
        EditText etPhone = bottomSheetDialog.findViewById(R.id.etPhone);
        EditText etAge = bottomSheetDialog.findViewById(R.id.etAge);
        EditText etGender = bottomSheetDialog.findViewById(R.id.etGender);
        EditText etAddress = bottomSheetDialog.findViewById(R.id.etAddress);
        Button btnUpdate = bottomSheetDialog.findViewById(R.id.btnUpdate);

        etName.setText(tvUserName.getText());
        etEmail.setText(tvEmail.getText());
        etPhone.setText(tvMobile.getText());
        etAge.setText(tvAge.getText());
        etGender.setText(tvGender.getText());
        etAddress.setText(tvAddress.getText());

        btnUpdate.setOnClickListener(view -> {
            String stName = etName.getText().toString();
            String stEmail = etEmail.getText().toString();
            String stPhone = etPhone.getText().toString();
            String stAge = etAge.getText().toString();
            String stGender = etGender.getText().toString();
            String stAddress = etAddress.getText().toString();

            if (!stName.isEmpty() && !stEmail.isEmpty()
                    && !stPhone.isEmpty() && !stAge.isEmpty()
                    && !stGender.isEmpty() && !stAddress.isEmpty()) {
                Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show();
                bottomSheetDialog.dismiss();
            } else {
                Toast.makeText(this, "invalid details!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
