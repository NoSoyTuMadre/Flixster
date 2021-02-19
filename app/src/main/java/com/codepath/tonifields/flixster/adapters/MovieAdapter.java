package com.codepath.tonifields.flixster.adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codepath.tonifields.flixster.R;
import com.codepath.tonifields.flixster.models.Movie;
import com.codepath.tonifields.flixster.modules.GlideApp;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    Context context;
    List<Movie> movies;

    public MovieAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("MovieAdapter", "onCreateViewHolder");
        View movieView = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(movieView);
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("MovieAdapter", "onBindViewHolder " + position);
        // Get the movie at the passed in position
        Movie movie = movies.get(position);
        // Bind the movie data into the ViewHolder
        holder.bind(movie);
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() { return movies.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvOverview;
        ImageView ivPoster;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setBackgroundColor(Color.BLACK);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvOverview = itemView.findViewById(R.id.tvOverview);
            ivPoster = itemView.findViewById(R.id.ivPoster);
        }

        public void bind(Movie movie) {
            tvTitle.setText(movie.getTitle());
            tvTitle.setTextColor(Color.BLUE);
            tvOverview.setText(movie.getOverview());
            tvOverview.setTextColor(Color.WHITE);
            String imageUrl;

            // if phone is in landscape
            if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                // then imageUrl = backdrop image
                imageUrl = movie.getBackdropPath();
            } else {
                // else imageUrl = poster image
                imageUrl = movie.getPosterPath();
            }

//            MultiTransformation<Bitmap> multi = new MultiTransformation<Bitmap>(new RoundedCornersTransformation(25, 0, RoundedCornersTransformation.CornerType.TOP));
//            Bitmap image = null;
//            try {
//                image = BitmapFactory.decodeStream(new URL(imageUrl).openConnection().getInputStream());
//                Log.i("Image: ", image.toString());
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//            BitmapScaler.scaleToFitWidth(image, screenWidth);

            GlideApp.with(context)
                    .load(imageUrl)
                    .placeholder(R.drawable.ic_loader_dark)
                    .override(1000, 800)
                    .dontAnimate()
                    .into(ivPoster);
        }
    }
}
