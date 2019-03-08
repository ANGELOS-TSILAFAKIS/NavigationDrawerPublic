package info.android_angel.navigationdrawer.adapter_id_movies.details_id_adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import info.android_angel.navigationdrawer.model_movie_id_get_details.MovieGetDetails_belongs_to_collection;
import info.android_angel.navigationdrawer.R;

//public class  CreditsAdapter extends RecyclerView.Adapter< CreditsAdapter. CreditsViewHolder> {

/**
 * Created by ANGELOS on 2017.
 *
 *   "belongs_to_collection": {
 "id": 748,
 "name": "X-Men Collection",
 "poster_path": "/1Zo4J5SAni8lyXt7NxJwJZ0f0ip.jpg",
 "backdrop_path": "/Abnosho2v3bcdvDww6T7Hfeczm1.jpg"
 },
 */

public class DetailsAdapter_belongs_to_collection extends RecyclerView.Adapter<DetailsAdapter_belongs_to_collection.DetailsViewHolder> {

    private MovieGetDetails_belongs_to_collection detailsAdapter_belongs_to_collection;
    private int rowLayout;
    private Context context;
    //String ImagePath;


    public static class DetailsViewHolder extends RecyclerView.ViewHolder {
        LinearLayout DetailsLayout;

        //"name": "X-Men Collection",
        private TextView movie_name;
        // "poster_path": "/1Zo4J5SAni8lyXt7NxJwJZ0f0ip.jpg",
        private ImageView movie_poster_path;
        //"backdrop_path": "/Abnosho2v3bcdvDww6T7Hfeczm1.jpg"
        private ImageView movie_backdrop_path;

        public DetailsViewHolder(View v) {
            super(v);
            DetailsLayout = (LinearLayout) v.findViewById(R.id.details_layout);
            movie_name = (TextView) v.findViewById(R.id.movie_name_view);
            movie_poster_path = (ImageView) itemView.findViewById(R.id.movie_poster_path_view);
            movie_backdrop_path = (ImageView) itemView.findViewById(R.id.movie_backdrop_path_view);
        }
    }

    public DetailsAdapter_belongs_to_collection(MovieGetDetails_belongs_to_collection detailsAdapter_belongs_to_collection,
                                 int rowLayout, Context context) {

        //super(rowLayout, context);

        this.detailsAdapter_belongs_to_collection = detailsAdapter_belongs_to_collection;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public DetailsAdapter_belongs_to_collection.DetailsViewHolder onCreateViewHolder(ViewGroup parent,
                                                                      int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new DetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DetailsViewHolder holder, int position) {
        holder.movie_name.setText(detailsAdapter_belongs_to_collection.getName());
        Picasso.with(holder.itemView.getContext()).load("https://image.tmdb.org/t/p/w45" + detailsAdapter_belongs_to_collection.getPosterPath()).into(holder.movie_poster_path);
        Picasso.with(holder.itemView.getContext()).load("https://image.tmdb.org/t/p/w45" + detailsAdapter_belongs_to_collection.getBackdropPath()).into(holder.movie_backdrop_path);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    //@Override
    //public int getItemCount() {
    //    return detailsAdapter_belongs_to_collection.size();
    //}

}
