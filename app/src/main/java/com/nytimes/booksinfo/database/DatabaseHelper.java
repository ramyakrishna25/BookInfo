package com.nytimes.booksinfo.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.nytimes.booksinfo.pojos.Book;
import com.nytimes.booksinfo.pojos.BookDb;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "books.db";
    public static final String TABLE_NAME = "books_table";
    public static final String PUBLISHER = "publisher";
    public static final String DESCRIPTION = "description";
    public static final String TITLE = "title";
    public static final String AUTHOR = "author";
    public static final String CONTRIBUTOR = "contributor";
    public static final String BOOK_IMAGE = "book_image";
    public static final String AMAZON_PRODUCT_URL = "amazon_product_url";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

       String CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + "("
                        + PUBLISHER + " TEXT,"
                        + DESCRIPTION + " TEXT,"
                        + TITLE + " TEXT,"
                        + AUTHOR + " TEXT,"
                        + CONTRIBUTOR + " TEXT,"
                        + BOOK_IMAGE + " TEXT,"
                        + AMAZON_PRODUCT_URL + " TEXT"
                        + ")";

        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(Book.Books books) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PUBLISHER,books.getPublisher());
        contentValues.put(DESCRIPTION,books.getDescription());
        contentValues.put(TITLE,books.getTitle());
        contentValues.put(AUTHOR,books.getAuthor());
        contentValues.put(CONTRIBUTOR,books.getContributor());
        contentValues.put(BOOK_IMAGE,books.getBookImage());
        contentValues.put(AMAZON_PRODUCT_URL,books.getAmazonProductUrl());
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public List<Book.Books> getAllData() {
        List<Book.Books> books = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Book.Books bookDb = new Book.Books();
                bookDb.setPublisher(cursor.getString(cursor.getColumnIndex(PUBLISHER)));
                bookDb.setDescription(cursor.getString(cursor.getColumnIndex(DESCRIPTION)));
                bookDb.setTitle(cursor.getString(cursor.getColumnIndex(TITLE)));
                bookDb.setAuthor(cursor.getString(cursor.getColumnIndex(AUTHOR)));
                bookDb.setContributor(cursor.getString(cursor.getColumnIndex(CONTRIBUTOR)));
                bookDb.setBookImage(cursor.getString(cursor.getColumnIndex(BOOK_IMAGE)));
                bookDb.setAmazonProductUrl(cursor.getString(cursor.getColumnIndex(AMAZON_PRODUCT_URL)));
                books.add(bookDb);
            } while (cursor.moveToNext());

            // close db connection
            db.close();
        }

        return books;
    }

    public boolean updateData(String id,String name,String surname,String marks) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PUBLISHER,id);
        contentValues.put(DESCRIPTION,name);
        contentValues.put(TITLE,surname);
        contentValues.put(AUTHOR,marks);
        contentValues.put(CONTRIBUTOR,surname);
        contentValues.put(BOOK_IMAGE,marks);
        contentValues.put(AMAZON_PRODUCT_URL,marks);
        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { id });
        return true;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
    }
}
