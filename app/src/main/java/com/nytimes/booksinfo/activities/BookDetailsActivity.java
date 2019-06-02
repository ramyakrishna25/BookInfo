package com.nytimes.booksinfo.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nytimes.booksinfo.R;
import com.nytimes.booksinfo.adapters.BooksAdapter;
import com.nytimes.booksinfo.pojos.Book;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookDetailsActivity extends BaseActivity {
    private BooksAdapter adapter;

    @BindView(R.id.contributor)
    TextView contributor;
    @BindView(R.id.description)
    TextView description;
    @BindView(R.id.buy_here_link)
    TextView buy_here_link;
    @BindView(R.id.imageView)
    ImageView imageView;
    private Book.Books bookDetails;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_details_lyt);
        ButterKnife.bind(this);
        bookDetails = getIntent().getParcelableExtra("BookDetails");
        contributor.setText(bookDetails.getContributor());
        description.setText(bookDetails.getDescription());
        Glide.with(this).load(bookDetails.getBookImage())
                .placeholder(R.mipmap.ic_launcher)
                .into(imageView);
        buy_here_link.setText(Html.fromHtml("<a href=" + bookDetails.getAmazonProductUrl()+ ">" +
                "Amazon" + "</a> "));
        buy_here_link.setMovementMethod(LinkMovementMethod.getInstance());



    }


}
