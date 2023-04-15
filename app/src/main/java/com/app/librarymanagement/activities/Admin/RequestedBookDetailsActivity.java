package com.app.librarymanagement.activities.Admin;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.app.librarymanagement.R;
import com.app.librarymanagement.models.Book;
import com.app.librarymanagement.models.BookRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class RequestedBookDetailsActivity extends AppCompatActivity {
    TextView tvUserName,book_title,tvReqDate,tvCount;
    Button btnRequestAccept,btnRequestReject;
    private DatabaseReference databaseReference;
    List<BookRequest> list = new ArrayList<>();
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
            String strId= intent.getStringExtra("req_id");
            if(!strId.isEmpty()) {
                getRequestedBookData(strId);
            }
            else {
                Toast.makeText(this, "invalid!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),RequestedBooksActivity.class));
            }
        }
    }
    boolean flag = false;
    private void getRequestedBookData(String strId){
        databaseReference = FirebaseDatabase.getInstance().getReference("book_requests");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    try {
                        String id = ds.child("id").getValue(String.class);
                        if (strId.equals(id)) {
                            flag = true;
                            String bookId = ds.child("book_id").getValue(String.class);
                            String requestedDate = ds.child("requestedDate").getValue(String.class);
                            String status = ds.child("status").getValue(String.class);
                            String userName = ds.child("userName").getValue(String.class);
                            String user_id = ds.child("user_id").getValue(String.class);
                            String bookName = ds.child("bookName").getValue(String.class);
                            BookRequest bookRequest = new BookRequest(id, bookId, user_id, bookName, userName, requestedDate, status);
                            displayData(bookRequest);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if(!flag){
                    Toast.makeText(RequestedBookDetailsActivity.this, "invalid details!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), RequestedBooksActivity.class));
                }
            }  @Override
            public void onCancelled(DatabaseError databaseError) {}
        });

        btnRequestAccept.setOnClickListener(view->{
            Toast.makeText(this, "Accepted!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(),RequestedBooksActivity.class));
        });
        btnRequestReject.setOnClickListener(view->{
            Toast.makeText(this, "Rejected!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(),RequestedBooksActivity.class));
        });
    }

    private void displayData(BookRequest book){
        tvUserName.setText(book.getUserName());
        book_title.setText(book.getBookName());
        tvReqDate.setText(book.getRequestedDate());
    }

}
