package com.app.librarymanagement.activities.Users;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.app.librarymanagement.R;
import com.app.librarymanagement.models.Book;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class BookDetailsActivity extends AppCompatActivity {
    Button btnBookUpdate,btnSendRequest;
    TextView tvDelete,tvBookName,tvPublishedOn,tvShortDesc,tvLongDesc,tvCount,tvAuthor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_request);
        findViewById(R.id.btnBack).setOnClickListener(view->{
            this.finish();
        });
        tvBookName = findViewById(R.id.tvBookName);
        tvAuthor = findViewById(R.id.tvAuthor);
        tvPublishedOn = findViewById(R.id.tvPublishedOn);
        tvShortDesc = findViewById(R.id.tvShortDesc);
        tvLongDesc = findViewById(R.id.tvLongDesc);
        tvCount = findViewById(R.id.tvCount);
        btnSendRequest = findViewById(R.id.btnSendRequest);

        Intent intent = getIntent();

        if (null != intent) {
            //Null Checking
            int strId= intent.getIntExtra("book_id",0);
            if(strId != 0) {
                Book book = new Book();
                displayData(book);
            }
            else {
                Toast.makeText(this, "invalid!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), FindBooksActivity.class));
            }
        }
        btnSendRequest.setOnClickListener(view->{
            Toast.makeText(this, "Request Sent!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(),FindBooksActivity.class));
        });
    }

    private void displayData(Book book){
        tvBookName.setText(book.getName());
//        tvPublishedOn.setText(book.getPublished());
        tvShortDesc.setText(book.getShortDescription());
        tvLongDesc.setText(book.getLongDescription());
        tvCount.setText("Available: "+book.getCount());
    }
}
