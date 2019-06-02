package com.nytimes.booksinfo.retrofit;

import com.nytimes.booksinfo.pojos.Book;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiInterface {
    @GET
    Call<Book> getBooksInfo(@Url String url);
}
