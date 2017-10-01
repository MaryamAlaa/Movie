package com.example.mariam.moviedb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));


        Call<MovieModel> connection = ApiClient.getMovieModel(getString(R.string.query), getString(R.string.api_key));

        connection.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, retrofit2.Response<MovieModel> response) {
                List<Movie> list = response.body().getResults();
                movieAdapter = new MovieAdapter(list, new MovieAdapter.OnItemClickListner() {
                    @Override
                    public void onItemClick(Movie film) {
                        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);

                        intent.putExtra(getString(R.string.story), film.overview);
                        intent.putExtra(getString(R.string.rate), film.vote_average);
                        intent.putExtra(getString(R.string.image), film.getPoster_path());
                        startActivity(intent);
                    }

                    @Override
                    public void onNameClicked(String name) {
                        Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
                    }
                });
                recyclerView.setAdapter(movieAdapter);
            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }


    public class MovieModel {
        private List<Movie> results;

        public List<Movie> getResults() {
            return results;
        }

        public void setResults(List<Movie> results) {
            this.results = results;
        }
    }
}
