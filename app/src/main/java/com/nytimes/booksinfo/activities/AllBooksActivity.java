package com.nytimes.booksinfo.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.nytimes.booksinfo.R;
import com.nytimes.booksinfo.adapters.BooksAdapter;
import com.nytimes.booksinfo.database.DatabaseHelper;
import com.nytimes.booksinfo.pojos.Book;
import com.nytimes.booksinfo.retrofit.ApiClient;
import com.nytimes.booksinfo.retrofit.ApiInterface;
import com.nytimes.booksinfo.utils.Constants;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllBooksActivity extends BaseActivity {
    private BooksAdapter adapter;

    @BindView(R.id.books_recycler_view)
    RecyclerView recyclerView;
    private String currentFormattedDate;
    private DatabaseHelper database;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.books_list_info);
        ButterKnife.bind(this);
        Date currentDate = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        currentFormattedDate = df.format(currentDate);
        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.books_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //initializing the productlist
        database = new DatabaseHelper(this);
        if(database.getAllData() != null && database.getAllData().size() > 0 ){
            adapter = new BooksAdapter(AllBooksActivity.this, database.getAllData());
            //setting adapter to recyclerview
            recyclerView.setAdapter(adapter);
        }else{
            makeApiCall();
        }

    }

    private void makeApiCall() {
        showProgressDialog();
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        try {
            Call<Book> call = apiService.getBooksInfo(currentFormattedDate +"/"+ Constants.LIST + ".json?offset=0&api-key="+ Constants.API_KEY);
            call.enqueue(new Callback<Book>() {
                @Override
                public void onResponse(Call<Book> call, Response<Book> response) {
                    if (response.body() != null) {
                       if (response.body().getStatus().equalsIgnoreCase("OK")) {

                           if(response.body().getResults() != null  && response.body().getResults().getBooks() != null){
                               adapter = new BooksAdapter(AllBooksActivity.this, response.body().getResults().getBooks());
                               //setting adapter to recyclerview
                               recyclerView.setAdapter(adapter);
                               for(int i  = 0 ; i < response.body().getResults().getBooks().size() ; i++){
                                   database.insertData(response.body().getResults().getBooks().get(i));
                               }
                           }else{
                               Toast.makeText(AllBooksActivity.this, "No results found", Toast.LENGTH_SHORT).show();
                           }


                       }else{
                           if(response.body().getStatus() != null){
                               Toast.makeText(AllBooksActivity.this, "" + response.body().getStatus(), Toast.LENGTH_SHORT).show();
                           }

                       }

                    } else {
                       Toast.makeText(AllBooksActivity.this, getResources().getString(R.string.no_response), Toast.LENGTH_SHORT).show();
                    }
                    dismissProgressDialog();
                }

                @Override
                public void onFailure(Call<Book> call, Throwable t) {
                    // Log error here since request failed
                    Log.e("Exception", t.toString());
                    dismissProgressDialog();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
