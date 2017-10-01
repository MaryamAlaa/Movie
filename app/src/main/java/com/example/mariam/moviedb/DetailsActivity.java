package com.example.mariam.moviedb;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Domtyyyyyy on 8/13/2017.
 */

public class DetailsActivity extends AppCompatActivity {
    @BindView(R.id.photo)
    ImageView imageView;
    @BindView(R.id.movieRate)
    TextView rateView;
    @BindView(R.id.movieStory)
    TextView storyView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        Bundle bundle = getIntent().getExtras();
        String rate = bundle.getString(getString(R.string.rate));
        String story = bundle.getString(getString(R.string.story));
        String photo = bundle.getString(getString(R.string.image));
        Uri uri = Uri.parse(photo);
        Context context = imageView.getContext();
        Picasso.with(context).load(uri).into(imageView);
        rateView.setText(rate);
        storyView.setText(story);
    }
}
