package com.example.samad.customrecyclerview;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    ImageView mImageView;
    TextView mTextView;
    //@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mTextView=(TextView) findViewById(R.id.textView1);
        mImageView=(ImageView)findViewById(R.id.imageView1 );
        Bundle mBundle = getIntent().getExtras();
        if (mBundle!= null){
            String s=mBundle.getString("Browser Name");
            mTextView.setText(s);
            Bitmap bmp = (Bitmap) mBundle.getParcelable("Browser Image");
            mImageView.setImageBitmap(bmp );

            }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

