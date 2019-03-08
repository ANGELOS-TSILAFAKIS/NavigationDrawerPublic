package info.android_angel.navigationdrawer.adapter_id_movies;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import java.util.List;

import info.android_angel.navigationdrawer.model_movie_id_get_similar.MovieGetSimilarMovies_results;
import info.android_angel.navigationdrawer.R;

/**
 * Created by ANGELOS on 2017.
 *
 * AdapterSimilar  =  MoviesAdapter
 *
 * MOVIE = Similar
 */

public class SimilarAdapter extends RecyclerView.Adapter<SimilarAdapter.SimilarViewHolder> {

    private List<MovieGetSimilarMovies_results> similar;
    private int rowLayout;
    private Context context;
    //String ImagePath;

    private String SEETHIS;

    public static class SimilarViewHolder extends RecyclerView.ViewHolder {
        LinearLayout similarLayout;

        // private ImageView profile_path;
        private ImageView movie_profile_path;

        public SimilarViewHolder(View v) {
            super(v);
            similarLayout = (LinearLayout) v.findViewById(R.id.similar_layout);
           // movie_title = (TextView) v.findViewById(R.id.movie_title_view);
          //  movie_vote_average = (TextView) v.findViewById(R.id.movie_vote_average_view);
          //  movie_release_date = (TextView) v.findViewById(R.id.movie_release_date_view);

            //if (posterPath == null)

            movie_profile_path = (ImageView) itemView.findViewById(R.id.movie_profile_path_view);
        }
    }

    public SimilarAdapter(List<MovieGetSimilarMovies_results> similar, int rowLayout, Context context) {

        //super(rowLayout, context);

        this.similar = similar;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public SimilarAdapter.SimilarViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new SimilarViewHolder(view);
    }


    @Override
    public void onBindViewHolder(SimilarViewHolder holder, final int position) {
        Picasso.with(holder.itemView.getContext()).load("https://image.tmdb.org/t/p/w300" + similar.get(position).getPosterPath()).into(holder.movie_profile_path);

    }

    @Override
    public int getItemCount() {
        return similar.size();
    }
}
