package info.android_angel.navigationdrawer.adapter_id_movies;

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
import info.android_angel.navigationdrawer.model_movie_id_get_recommendations.MovieGetRecommendations_results;

/**
 *RecommendationsAdapter
 * AdapterSimilar  =  MoviesAdapter
 *
 * MOVIE = Similar = Recommendations
 *
 */

public class RecommendationsAdapter extends RecyclerView.Adapter<RecommendationsAdapter.RecommendationsViewHolder> {

    private List<MovieGetRecommendations_results> recommendations;
    private int rowLayout;
    private Context context;
    //String ImagePath;

    public static class RecommendationsViewHolder extends RecyclerView.ViewHolder {
        LinearLayout recommendationsLayout;
        //"title": "Kong: Skull Island",
        private TextView movie_title;
        //"vote_average": 6.1,
        private TextView movie_vote_average;
        //"release_date": "2017-03-08",
        private TextView movie_release_date;

        // private ImageView posterPath;
        //"poster_path": "/aoUyphk4nwffrwlZRaOa0eijgpr.jpg",
        private ImageView movie_profile_path;

        public RecommendationsViewHolder(View v) {
            super(v);
            recommendationsLayout = (LinearLayout) v.findViewById(R.id.recommendations_layout);
            movie_title = (TextView) v.findViewById(R.id.movie_title_view);
            movie_vote_average = (TextView) v.findViewById(R.id.movie_vote_average_view);
            movie_release_date = (TextView) v.findViewById(R.id.movie_release_date_view);

            //if (posterPath == null)

            movie_profile_path = (ImageView) itemView.findViewById(R.id.movie_profile_path_view);
        }
    }

    public RecommendationsAdapter(List<MovieGetRecommendations_results> recommendations, int rowLayout, Context context) {

        //super(rowLayout, context);

        this.recommendations = recommendations;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public RecommendationsAdapter.RecommendationsViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new RecommendationsViewHolder(view);
    }


    @Override
    public void onBindViewHolder(RecommendationsViewHolder holder, final int position) {
        holder.movie_title.setText(recommendations.get(position).getTitle());
        holder.movie_vote_average.setText(recommendations.get(position).getVoteAverage().toString());
        holder.movie_release_date.setText(recommendations.get(position).getReleaseDate());

        Picasso.with(holder.itemView.getContext()).load("https://image.tmdb.org/t/p/w300" + recommendations.get(position).getPosterPath()).into(holder.movie_profile_path);

    }

    @Override
    public int getItemCount() {
        return recommendations.size();
    }
}



