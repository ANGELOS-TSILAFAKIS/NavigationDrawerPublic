package info.android_angel.navigationdrawer.adapter;

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

import info.android_angel.navigationdrawer.R;
import info.android_angel.navigationdrawer.model.Movie;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private List<Movie> movies;
    private int rowLayout;
    private Context context;
    //String ImagePath;

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        //title
        private TextView movie_title;
        //release_date
        private TextView movie_release_date;
        //overview
        private TextView movie_overview;
        //vote_average
        private TextView movie_vote_average;

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
            movie_release_date = (TextView) v.findViewById(R.id.movie_release_date_view);
            movie_overview = (TextView) v.findViewById(R.id.movie_overview_view);
            movie_vote_average = (TextView) v.findViewById(R.id.movie_vote_average_view);

            //album_id
            movie_id = (TextView) v.findViewById(R.id.movie_id);

            //if (movie_poster_path == null)

            movie_poster_path = (ImageView) itemView.findViewById(R.id.movie_poster_path_view);

        }
    }

    public MoviesAdapter(List<Movie> movies, int rowLayout, Context context) {

        //super(rowLayout, context);

        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        //inflate(R.layout.example_item  ...);
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        holder.movie_title.setText(movies.get(position).getTitle());
        holder.movie_release_date.setText(movies.get(position).getReleaseDate());
        holder.movie_overview.setText(movies.get(position).getOverview());
        holder.movie_vote_average.setText(movies.get(position).getVoteAverage().toString());
        //holder.posterPath.setText(movies.get(position).getPosterPath());
        //rating_image_View_java.setImageBitmap(BitmapFactory
        //       .decodeFile(holder.posterPath.setText(movies.get(position).getPosterPath())
        //       );


        //album_id
        holder.movie_id.setText(movies.get(position).getId().toString());

        //PICASSO
        Picasso.with(holder.itemView.getContext()).load("https://image.tmdb.org/t/p/w300" + movies.get(position).getPosterPath()).into(holder.movie_poster_path);

        //Picasso.with(MainActivity)
        //     .load("https://image.tmdb.org/t/p/w500" + movies.get(position).getPosterPath())
        //      .placeholder(R.drawable.star)
        //      .error(android.R.drawable.stat_notify_error)
        //     .into(holder.rating_image_View_java);


    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
