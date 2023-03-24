package com.app.librarymanagement.activities.Users;

import static com.app.librarymanagement.helpers.common_helper.getAuthorBooks;
import static com.app.librarymanagement.helpers.common_helper.getAuthorsDetails;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.librarymanagement.R;
import com.app.librarymanagement.models.Author;
import com.app.librarymanagement.models.Book;
import com.app.librarymanagement.models.adapters.BooksAdapter;
import com.app.librarymanagement.models.adapters.FindBookAdapter;

import java.util.List;

public class AuthorDetailsActivity extends AppCompatActivity {
    FindBookAdapter adapter;
    RecyclerView recyclerView;
    int strId;
    TextView tvAuthName,tvAuthorAge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author_details);
        findViewById(R.id.btnBack).setOnClickListener(view->{
            this.finish();
        });
        Intent intent = getIntent();
        if (null != intent) {
            //Null Checking
            strId= intent.getIntExtra("author_id",0);
        }
        tvAuthName= findViewById(R.id.tvAuthName);
        tvAuthorAge= findViewById(R.id.tvAuthorAge);
        setUpRecyclerView();
    }

    public void setUpRecyclerView(){
        List<Book> list = getAuthorBooks(strId);
        Author auth_details = getAuthorsDetails(strId);
        recyclerView = findViewById(R.id.ListMyBooks);
        adapter = new FindBookAdapter(list, getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        tvAuthName.setText(auth_details.getName());
        tvAuthorAge.setText("Age: "+auth_details.getAge());
    }

}
