package com.app.librarymanagement.activities.Admin;

import static com.app.librarymanagement.helpers.common_helper.getBookDetails;
import static com.app.librarymanagement.helpers.common_helper.getRequestedBookData;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.app.librarymanagement.R;
import com.app.librarymanagement.models.Book;
import com.app.librarymanagement.models.BookRequest;

public class RequestedBookDetailsActivity extends AppCompatActivity {
    TextView tvUserName,book_title,tvReqDate,tvCount;
    Button btnRequestAccept,btnRequestReject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_request_view);
        findViewById(R.id.btnBack).setOnClickListener(view->{
            this.finish();
        });
        tvUserName=findViewById(R.id.tvUserName);
        book_title=findViewById(R.id.book_title);
        tvReqDate=findViewById(R.id.tvReqDate);
        tvCount=findViewById(R.id.tvCount);
        btnRequestAccept=findViewById(R.id.btnRequestAccept);
        btnRequestReject=findViewById(R.id.btnRequestReject);

        Intent intent = getIntent();
        if (null != intent) {
            //Null Checking
            int strId= intent.getIntExtra("req_id",0);
            if(strId != 0) {
                BookRequest request = getRequestedBookData(strId);
                Book book = getBookDetails(request.getBook_id());
                displayData(request,book.getCount());
                btnRequestAccept.setOnClickListener(view->{
                    Toast.makeText(this, "Accepted!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),RequestedBooksActivity.class));
                });
                btnRequestReject.setOnClickListener(view->{
                    Toast.makeText(this, "Rejected!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),RequestedBooksActivity.class));
                });
            }
            else {
                Toast.makeText(this, "invalid!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),RequestedBooksActivity.class));
            }
        }
    }
    private void displayData(BookRequest book,int count){
        tvUserName.setText(book.getUserName());
        book_title.setText(book.getBookName());
        tvReqDate.setText(book.getRequestedDate());
        tvCount.setText("available: "+count);
    }
}
