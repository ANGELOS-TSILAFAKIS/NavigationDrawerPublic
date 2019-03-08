package info.android_angel.navigationdrawer.adapter_id_movies.reviews_id_adapter;

/**
 * Created by ANGELOS on 2017.
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import info.android_angel.navigationdrawer.R;

import info.android_angel.navigationdrawer.model_movie_id_get_reviews.MovieGetReviews_results;

/**
 *
 * ReviewsAdapter  =  MoviesAdapter
 *
 * MOVIE = Reviews
 *
 *   "results": [
 {
 "id": "5723a329c3a3682e720005db",
 "author": "elshaarawy",
 "content": "very good movie 9.5/10 محمد الشعراوى",
 "url": "https://www.themoviedb.org/review/5723a329c3a3682e720005db"
 },
 {
 "id": "578193f29251417c28001764",
 "author": "John Chard",
 "content": "Some birds aren't meant to be caged.\r\n\r\nThe Shawshank Redemption is written and
 */


public class ReviewsAdapter extends RecyclerView.Adapter<ReviewsAdapter.ReviewsViewHolder> {

    private List<MovieGetReviews_results> reviews;
    private int rowLayout;
    private Context context;
    //String ImagePath;

    public static class ReviewsViewHolder extends RecyclerView.ViewHolder {
        LinearLayout reviewsLayout;
        //"author": "elshaarawy"
        private TextView movie_author;
        // "content": "very good movie 9.5/10 محمد الشعراوى",
        private TextView movie_content;

        public ReviewsViewHolder(View v) {
            super(v);
            reviewsLayout = (LinearLayout) v.findViewById(R.id.reviews_layout);
            movie_author = (TextView) v.findViewById(R.id.movie_author_name_view);
            movie_content = (TextView) v.findViewById(R.id.movie_content_view);
            //  movie_release_date = (TextView) v.findViewById(R.id.movie_release_date_view);

            //if (posterPath == null)

            //movie_profile_path = (ImageView) itemView.findViewById(R.id.movie_profile_path_view);
        }
    }

    public ReviewsAdapter(List<MovieGetReviews_results> reviews, int rowLayout, Context context) {

        //super(rowLayout, context);

        this.reviews = reviews;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public ReviewsAdapter.ReviewsViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new ReviewsViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ReviewsViewHolder holder, final int position) {
        holder.movie_author.setText(reviews.get(position).getAuthor());
        holder.movie_content.setText(reviews.get(position).getContent().toString());
        //  holder.movie_release_date.setText(reviews.get(position).getReleaseDate());

        //Picasso.with(holder.itemView.getContext()).load("https://image.tmdb.org/t/p/w500" + reviews.get(position).getPosterPath()).into(holder.movie_profile_path);

    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }
}



