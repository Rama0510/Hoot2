package com.app.librarymanagement.activities.Admin;

import static com.app.librarymanagement.helpers.common_helper.getAuthorBooks;
import static com.app.librarymanagement.helpers.common_helper.getBookDetails;
import static com.app.librarymanagement.helpers.common_helper.getBooksData;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.app.librarymanagement.R;
import com.app.librarymanagement.models.Book;
import com.app.librarymanagement.models.adapters.BooksAdapter;
import com.app.librarymanagement.models.adapters.FindBookAdapter;
import java.util.List;

public class AuthorDetailsActivity extends AppCompatActivity {
    BooksAdapter adapter;
    RecyclerView recyclerView;
    int strId;
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
        setUpRecyclerView();
    }

    public void setUpRecyclerView(){
        List<Book> list = getAuthorBooks(strId);
        recyclerView = findViewById(R.id.ListMyBooks);
        adapter = new BooksAdapter(list, getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
