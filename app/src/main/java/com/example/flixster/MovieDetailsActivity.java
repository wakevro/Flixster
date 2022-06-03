package com.example.flixster;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.flixster.models.Movie;

import org.parceler.Parcels;

public class MovieDetailsActivity extends AppCompatActivity {

    Movie movie;

    TextView tvDetailsTitle;
    TextView tvDetailsOverview;
    RatingBar rbDetailsVoteAverage;
    ImageView ivDetailsPoster;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        tvDetailsTitle = findViewById(R.id.tvDetailsTitle);
        tvDetailsOverview = findViewById(R.id.tvDetailsOverview);
        rbDetailsVoteAverage = findViewById(R.id.rbDetailsVoteAverage);
        ivDetailsPoster = findViewById(R.id.ivDetailsPoster);

        movie = (Movie) Parcels.unwrap(getIntent().getParcelableExtra(Movie.class.getSimpleName()));
        Log.d("MovieDetailsActivity", String.format("Showing details for '$s'", movie.getTitle()));

        tvDetailsTitle.setText(movie.getTitle());
        tvDetailsOverview.setText(movie.getOverview());

//        Log.e("Movie Id", movie.getMovieId());

        float voteAverage = movie.getVoteAverage().floatValue();
        rbDetailsVoteAverage.setRating(voteAverage / 2.0f);

        String imageUrl;
        imageUrl = movie.getPosterPath();
        Log.d("Url path: ",imageUrl);

        int radius = 50;
        Glide.with(this)
                .load(imageUrl)
                .placeholder(R.drawable.flicks_movie_placeholder)
                .transform(new RoundedCorners(radius))
                .into(ivDetailsPoster);


    }


}