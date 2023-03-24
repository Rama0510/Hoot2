package com.app.librarymanagement.activities.Users;

import static com.app.librarymanagement.helpers.common_helper.getMyShelfBooks;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.librarymanagement.R;
import com.app.librarymanagement.models.Book;
import com.app.librarymanagement.models.MyShelfBook;
import com.app.librarymanagement.models.adapters.BooksAdapter;
import com.app.librarymanagement.models.adapters.BooksShelfAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyShelvesActivity extends AppCompatActivity {
    BooksShelfAdapter adapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_shelves);
        setUpRecyclerView();
        findViewById(R.id.btnBack).setOnClickListener(view->{
            this.finish();
        });
    }
    public void setUpRecyclerView(){
        List<MyShelfBook> list = getMyShelfBooks();
        recyclerView = findViewById(R.id.ListMyBooks);
        adapter = new BooksShelfAdapter(list, getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
