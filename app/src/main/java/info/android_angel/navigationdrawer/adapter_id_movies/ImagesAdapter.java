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

import info.android_angel.navigationdrawer.model_movie_id_get_images.MovieGetImages_backdrops;
import info.android_angel.navigationdrawer.R;

/**
 *   "id": 278,
 "backdrops": [
 {
 "aspect_ratio": 1.77777777777778,
 "file_path": "/xBKGJQsAIeweesB79KC89FpBrVr.jpg",
 "height": 1080,
 "iso_639_1": null,
 "vote_average": 5.69707401032702,
 "vote_count": 20,
 "width": 1920
 },
 */

public class  ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ImagesViewHolder> {

    private List<MovieGetImages_backdrops> images;
    private int rowLayout;
    private Context context;
    //String ImagePath;

    public static class ImagesViewHolder extends RecyclerView.ViewHolder {
        LinearLayout ImagesLayout;
        //"vote_average": 5.69707401032702,  FOR MOVIE
        private TextView movie_vote_average;
        //vote_count": 20,    FOR MOVIE
        private TextView movie_vote_count;
        // private ImageView posterPath;
        //"file_path": "/xBKGJQsAIeweesB79KC89FpBrVr.jpg",
        private ImageView movie_file_path;

        public ImagesViewHolder(View v) {
            super(v);
            ImagesLayout = (LinearLayout) v.findViewById(R.id.images_layout);
            movie_vote_average = (TextView) v.findViewById(R.id.movie_vote_average_view);
            movie_vote_count = (TextView) v.findViewById(R.id.movie_vote_count_view);

            //if (posterPath == null)

            movie_file_path = (ImageView) itemView.findViewById(R.id.movie_file_path_view);
        }
    }

    public ImagesAdapter(List<MovieGetImages_backdrops> images, int rowLayout, Context context) {

        //super(rowLayout, context);

        this.images = images;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public ImagesAdapter.ImagesViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new ImagesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ImagesViewHolder holder, final int position) {
        holder.movie_vote_average.setText(images.get(position).getVoteAverage().toString());

        holder.movie_vote_count.setText(images.get(position).getVoteCount().toString());

        Picasso.with(holder.itemView.getContext()).load("https://image.tmdb.org/t/p/w300" + images.get(position).getFilePath()).into(holder.movie_file_path);

    }

    @Override
    public int getItemCount() {
        return images.size();
    }
}


