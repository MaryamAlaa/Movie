package com.example.mariam.moviedb;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Domtyyyyyy on 8/13/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {
    List<Movie> movieList;
    OnItemClickListner listener;

    public interface OnItemClickListner {
        void onItemClick(Movie film);

        void onNameClicked(String name);
    }

    public MovieAdapter(List<Movie> movieList, OnItemClickListner listner) {
        this.movieList = movieList;
        this.listener = listner;
    }

    @Override
    public MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View list = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list, parent, false);
        MovieHolder holder = new MovieHolder(list);
        return holder;
    }

    @Override
    public void onBindViewHolder(MovieHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.bind(movie, listener);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class MovieHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.movieName)
        TextView moviename;
        @BindView(R.id.moviePoster)
        ImageView movieposter;

        public MovieHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(final Movie movie, final OnItemClickListner listener) {
            moviename.setText(movie.getTitle());

            Uri uri = Uri.parse(movie.getPoster_path());
            Context context = movieposter.getContext();
            Picasso.with(context).load(uri).into(movieposter);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(movie);
                }
            });
            moviename.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onNameClicked(moviename.getText().toString());
                }
            });

        }

    }

}
