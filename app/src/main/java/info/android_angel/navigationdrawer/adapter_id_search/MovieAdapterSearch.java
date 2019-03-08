package info.android_angel.navigationdrawer.adapter_id_search;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import info.android_angel.navigationdrawer.model.Movie;
import info.android_angel.navigationdrawer.R;

/**
 * Created by ANGELOS on 2017.
 */

public class MovieAdapterSearch extends RecyclerView.Adapter<MovieAdapterSearch.MovieViewHolder> implements Filterable {
    //private ArrayList<Movie> mFilteredList;
    //private ArrayList<Movie> movies;
    private List<Movie> movies;
    private int rowLayout;
    private Context context;

    //private ArrayList<Movie> mArrayList;
    private List<Movie> mArrayList;

    public MovieAdapterSearch(List<Movie> arrayList) {
        mArrayList = arrayList;
        movies = arrayList;
    }


    public MovieAdapterSearch(List<Movie> arrayList, int rowLayout, Context context) {
        this.mArrayList = arrayList;
        this.movies = arrayList;

        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public MovieAdapterSearch.MovieViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);

        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieAdapterSearch.MovieViewHolder holder, final int position) {

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

    @Override
    public  Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String charString = charSequence.toString();

                if (charString.isEmpty()) {

                    movies = mArrayList;
                } else {

                    ArrayList<Movie> filteredList = new ArrayList<>();

                    for (Movie movie_Version : mArrayList) {

                        if (movie_Version.getTitle().toLowerCase().contains(charString) || movie_Version.getReleaseDate().toLowerCase().contains(charString) || movie_Version.getTitle().toLowerCase().contains(charString)) {

                            filteredList.add(movie_Version);
                        }
                    }

                    movies = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = movies;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                movies = (ArrayList<Movie>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder{
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

        //api_key_search
        //private ClipData.Item api_key_search;

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

            //api_key_search
            //api_key_search = (ClipData.Item) menu.findItem(R.id.search);

            //if (posterPath == null)

            movie_poster_path = (ImageView) itemView.findViewById(R.id.movie_poster_path_view);

        }
    }

}



