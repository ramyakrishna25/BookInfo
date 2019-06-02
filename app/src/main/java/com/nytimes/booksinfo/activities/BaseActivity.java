package com.nytimes.booksinfo.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.nytimes.booksinfo.R;

public class BaseActivity extends AppCompatActivity {
    private boolean isProgressVisible;
    private ProgressDialog progressDialog;
    public Toolbar toolbar;
    public FrameLayout frameLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_lyt);
        try {
            toolbar = (Toolbar) findViewById(R.id.toolbar);
            frameLayout = (FrameLayout) findViewById(R.id.frame);
            setSupportActionBar(toolbar);
            ActionBar ab = getSupportActionBar();
            ab.setDisplayHomeAsUpEnabled(true);
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

    public void showProgressDialog() {
        try {

            progressDialog = new ProgressDialog(BaseActivity.this);
            progressDialog.setMax(100);
            progressDialog.setMessage("Loading....");
            progressDialog.setCancelable(false);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dismissProgressDialog() {
        try {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
