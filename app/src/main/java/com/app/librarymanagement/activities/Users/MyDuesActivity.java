package com.app.librarymanagement.activities.Users;

import static com.app.librarymanagement.helpers.common_helper.getOverdueBooksData;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.librarymanagement.R;
import com.app.librarymanagement.models.Book;
import com.app.librarymanagement.models.BookRequest;
import com.app.librarymanagement.models.adapters.BooksAdapter;
import com.app.librarymanagement.models.adapters.OverDueBooksAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyDuesActivity extends AppCompatActivity {
    OverDueBooksAdapter adapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dues);
        setUpRecyclerView();
        findViewById(R.id.btnBack).setOnClickListener(view->{
            this.finish();
        });
    }
    public void setUpRecyclerView(){
        List<BookRequest> list = getOverdueBooksData();
        recyclerView = findViewById(R.id.ListMyBooks);
        adapter = new OverDueBooksAdapter(list, getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
