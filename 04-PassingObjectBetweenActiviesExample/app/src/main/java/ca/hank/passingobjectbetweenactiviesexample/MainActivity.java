package ca.hank.passingobjectbetweenactiviesexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btDetail;
    TextView tvMovieName;
    Movie movie = new Movie("Titanic", "James Cameron", 1997, 7.8, new String[]{"Leonardo DiCaprio", "Kate Winslet", "Billy Zane"});

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        tvMovieName = findViewById(R.id.tvMovieName);
        tvMovieName.setText("movie name: " + movie.movieName);
        btDetail = findViewById(R.id.btDetail);
        btDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetailActivity();
            }
        });
    }

    public static final String EXTRA_MOVIE = "movie";

    public void openDetailActivity() {

        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra(EXTRA_MOVIE, movie);
        startActivity(intent);
    }
}
