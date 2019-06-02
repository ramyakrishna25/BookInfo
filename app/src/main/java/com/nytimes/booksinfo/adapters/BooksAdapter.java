package com.nytimes.booksinfo.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nytimes.booksinfo.R;
import com.nytimes.booksinfo.activities.BookDetailsActivity;
import com.nytimes.booksinfo.pojos.Book;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.MyViewHolder> {

    private Context context;
    private List<Book.Books> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imageView)
        ImageView imageViewIcon;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.author_name)
        TextView authorName;
        @BindView(R.id.publisher_name)
        TextView publisherName;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    public BooksAdapter(Context context, List<Book.Books> data) {
        this.dataSet = data;
        this.context = context;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_list_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {
        holder.title.setText(dataSet.get(listPosition).getTitle());
        holder.authorName.setText("Author : " + dataSet.get(listPosition).getAuthor());
        holder.publisherName.setText("Publisher : " + dataSet.get(listPosition).getPublisher());
        holder.itemView.setTag(dataSet.get(listPosition));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(context, BookDetailsActivity.class);
                myIntent.putExtra("BookDetails", dataSet.get(listPosition));
                context.startActivity(myIntent);
            }
        });
        Glide.with(context).load(dataSet.get(listPosition).getBookImage())
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.imageViewIcon);
    }
    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
