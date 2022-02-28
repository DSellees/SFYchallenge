package com.example.sfychallenge;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.sfychallenge.models.Photo;
import com.squareup.picasso.Picasso;

public class PhotoDetails extends AppCompatActivity {

    public static final String PHOTO ="PHOTO";

    private ImageView ivPhotoDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_details);

        Intent intent = getIntent();
        Photo selectPhoto = (Photo) intent.getSerializableExtra(PHOTO);

        initValues(selectPhoto);

    }

    private void initValues(Photo p){

        ivPhotoDetails = (ImageView) findViewById(R.id.iv_photoDetails);

        Picasso.get()
                .load(p.getUrls().getRegular())
                .fit()
                .centerCrop()
                .into(ivPhotoDetails);

    }
}
