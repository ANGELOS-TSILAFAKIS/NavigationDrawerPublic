package info.android_angel.navigationdrawer.adapter_main_activity;

/**
 * Created by ANGELOS on 2017.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import info.android_angel.navigationdrawer.model.Movie;
import info.android_angel.navigationdrawer.R;

public class MoviesAdapter_main_activity extends RecyclerView.Adapter<MoviesAdapter_main_activity.MovieViewHolder> {

    private List<Movie> movies;
    private int rowLayout;
    private Context context;

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        private TextView movie_title;

        private TextView movie_id;

        // private ImageView poster_path;
        private ImageView movie_poster_path;

        /**  2017  **/
        private final Context context;

        public MovieViewHolder(View v) {
            super(v);

            /**  2017  **/
            context = v.getContext();

            moviesLayout = (LinearLayout) v.findViewById(R.id.movies_layout);
            movie_title = (TextView) v.findViewById(R.id.movie_title_view);

            //album_id
            movie_id = (TextView) v.findViewById(R.id.movie_id);

            //if (posterPath == null)

            movie_poster_path = (ImageView) itemView.findViewById(R.id.movie_poster_path_view);
        }
    }

    public MoviesAdapter_main_activity(List<Movie> movies, int rowLayout, Context context) {

        //super(rowLayout, context);

        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public MoviesAdapter_main_activity.MovieViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        holder.movie_title.setText(movies.get(position).getTitle());

        //album_id
        holder.movie_id.setText(movies.get(position).getId().toString());

        Picasso.with(holder.itemView.getContext()).load("https://image.tmdb.org/t/p/w300" + movies.get(position).getPosterPath()).into(holder.movie_poster_path);

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}


