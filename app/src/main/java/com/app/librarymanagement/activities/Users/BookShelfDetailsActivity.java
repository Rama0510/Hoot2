package com.app.librarymanagement.activities.Users;

import static com.app.librarymanagement.helpers.common_helper.getMyShelfDetails;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.app.librarymanagement.R;
import com.app.librarymanagement.models.Book;
import com.app.librarymanagement.models.MyShelfBook;

public class BookShelfDetailsActivity extends AppCompatActivity {
    Button btnBookUpdate, btnSendRequest;
    TextView tvDelete, tvBookName,tvPublishedOn,tvShortDesc,tvLongDesc,tvCount,tvAuthor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_shelf_details);
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
            int strId= intent.getIntExtra("shelf_id",0);
            if(strId != 0) {
                MyShelfBook book = getMyShelfDetails(strId);
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

    private void displayData(MyShelfBook book){
        Book book1= new Book();
        tvBookName.setText(book.getBookName());
        tvPublishedOn.setText(book.getRequestedDate());
        tvShortDesc.setText(book1.getShortDescription());
        tvLongDesc.setText(book1.getLongDescription());
        tvCount.setText("Available: "+book1.getCount());
    }
}
