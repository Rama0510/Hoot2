package com.app.librarymanagement.activities.Users;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.app.librarymanagement.R;
import com.app.librarymanagement.models.Book;
import com.app.librarymanagement.models.adapters.FindBookAdapter;

import java.util.ArrayList;
import java.util.List;

public class FindBooksActivity extends AppCompatActivity {
    FindBookAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_books);
        setUpRecyclerView();
        findViewById(R.id.btnBack).setOnClickListener(view->{
            startActivity(new Intent(getApplicationContext(),DashboardUserActivity.class));
        });
    }

    public void setUpRecyclerView(){
        List<Book> list = new ArrayList<>();
        recyclerView = findViewById(R.id.ListMyBooks);
        adapter = new FindBookAdapter(list, getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
