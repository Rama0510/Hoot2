package com.app.librarymanagement.models.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.app.librarymanagement.R;
import com.app.librarymanagement.activities.Admin.AuthorDetailsActivity;
import com.app.librarymanagement.activities.Admin.BookDetailsActivity;
import com.app.librarymanagement.activities.Admin.RequestedBookDetailsActivity;
import com.app.librarymanagement.activities.Admin.RequestedBooksActivity;
import com.app.librarymanagement.models.BookRequest;

import java.util.Collections;
import java.util.List;

public class BooksRequestsAdapter extends RecyclerView.Adapter<BooksRequestsAdapter.BookRequest> {
    List<com.app.librarymanagement.models.BookRequest> list = Collections.emptyList();
    Context mContext;
    public BooksRequestsAdapter(List<com.app.librarymanagement.models.BookRequest> list, Context context){
        this.list = list;
        this.mContext = context;
    }

    @NonNull
    @Override
    public BookRequest onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_request, parent, false);
        return new BooksRequestsAdapter.BookRequest(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BookRequest holder, int position) {
       com.app.librarymanagement.models.BookRequest request = list.get(position);
        holder.requested_book_name.setText(request.getBookName());
        holder.request_user_name.setText(request.getUserName());
        holder.text_request_date.setText(request.getRequestedDate());
        holder.requestedBookItem.setOnClickListener(view->{
            Intent intent = new Intent(view.getContext(), RequestedBookDetailsActivity.class);
            Bundle extras = new Bundle();
            extras.putInt("req_id",request.getId());
            intent.putExtras(extras);
            view.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    static class BookRequest extends RecyclerView.ViewHolder{
        // Here we hold the MyDoctorItems
        TextView requested_book_name,request_user_name,text_request_date;
        CardView requestedBookItem;
        public BookRequest(@NonNull View itemView) {
            super(itemView);
            text_request_date = itemView.findViewById(R.id.text_request_date);
            request_user_name = itemView.findViewById(R.id.request_user_name);
            requested_book_name = itemView.findViewById(R.id.requested_book_name);
            requestedBookItem = itemView.findViewById(R.id.requestedBookItem);
        }
    }
}
