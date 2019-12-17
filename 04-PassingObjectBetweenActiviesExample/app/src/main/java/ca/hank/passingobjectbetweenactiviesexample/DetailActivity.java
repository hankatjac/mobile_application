package ca.hank.passingobjectbetweenactiviesexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.TextView;

import java.util.Arrays;

public class DetailActivity extends AppCompatActivity {
    TextView tvDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        init();
    }

    public void init() {
        Movie movie = (Movie) getIntent().getSerializableExtra(MainActivity.EXTRA_MOVIE);
        tvDetail = findViewById(R.id.tvDetail);
        tvDetail.setText("Movie Name: " + movie.movieName + "\n" + "Directed By: " + movie.directedBy
                + "\n" + "Starring " + Arrays.toString(movie.starring) + "\n" + "Movie Year: " + movie.year
                + "\n" + "Rating: " + movie.rating + "\n");
    }
}