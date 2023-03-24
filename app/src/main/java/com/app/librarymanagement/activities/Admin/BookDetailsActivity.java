package com.app.librarymanagement.activities.Admin;

import static com.app.librarymanagement.helpers.common_helper.getBookDetails;
import static com.app.librarymanagement.helpers.common_helper.getBooksData;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.librarymanagement.R;
import com.app.librarymanagement.models.Book;
import com.app.librarymanagement.models.adapters.BooksAdapter;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.List;
import java.util.UUID;

public class BookDetailsActivity extends AppCompatActivity {
    Button btnBookUpdate;
    TextView tvDelete,tvBookName,tvPublishedOn,tvShortDesc,tvLongDesc,tvCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        findViewById(R.id.btnBack).setOnClickListener(view->{
            this.finish();
        });
        tvBookName = findViewById(R.id.tvBookName);
        tvPublishedOn = findViewById(R.id.tvPublishedOn);
        btnBookUpdate = findViewById(R.id.btnBookUpdate);
        tvShortDesc = findViewById(R.id.tvShortDesc);
        tvLongDesc = findViewById(R.id.tvLongDesc);
        tvCount = findViewById(R.id.tvCount);
        tvDelete = findViewById(R.id.tvDelete);

        Intent intent = getIntent();
        if (null != intent) {
            //Null Checking
            int strId= intent.getIntExtra("book_id",0);
            if(strId != 0) {
                Book book = getBookDetails(strId);
                displayData(book);
            }
            else {
                Toast.makeText(this, "invalid!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),BooksActivity.class));
            }
        }
        btnBookUpdate.setOnClickListener(view->{
            updateBook();
        });
        tvDelete.setOnClickListener(view->{
            Toast.makeText(this, "Deleted!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(),BooksActivity.class));
        });
    }
    private void displayData(Book book){
        tvBookName.setText(book.getName());
        tvPublishedOn.setText(book.getPublished());
        tvShortDesc.setText(book.getShortDescription());
        tvLongDesc.setText(book.getLongDescription());
        tvCount.setText("Available: "+book.getCount());
    }

    public void updateBook() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.activity_edit_book);
        bottomSheetDialog.show();
        EditText bookName = bottomSheetDialog.findViewById(R.id.bookName);
        EditText etShortDesc = bottomSheetDialog.findViewById(R.id.etShortDesc);
        EditText etLongDesc = bottomSheetDialog.findViewById(R.id.etLongDesc);
        EditText etQuantity = bottomSheetDialog.findViewById(R.id.etQuantity);
        Button btnUpdateCust = bottomSheetDialog.findViewById(R.id.btnUpdateCust);

        bookName.setText(tvBookName.getText());
        etShortDesc.setText(tvShortDesc.getText());
        etLongDesc.setText(tvLongDesc.getText());
        etQuantity.setText(tvCount.getText());

        btnUpdateCust.setOnClickListener(view -> {
            String stBookName = bookName.getText().toString();
            String stShortDesc = etShortDesc.getText().toString();
            String sLongDesc = etLongDesc.getText().toString();
            String stQuantity = etQuantity.getText().toString();

            if (!stBookName.isEmpty() && !stShortDesc.isEmpty()
                    && !sLongDesc.isEmpty() && !stQuantity.isEmpty()) {
                Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show();
                bottomSheetDialog.dismiss();
            } else {
                Toast.makeText(this, "invalid details!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
