package info.android_angel.navigationdrawer.adapter_id_movies.details_id_adapter;

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
import info.android_angel.navigationdrawer.model_movie_id_get_details.MovieGetDetails_genres;

public class DetailsAdapter_genres extends RecyclerView.Adapter<DetailsAdapter_genres.DetailsViewHolder> {

    private List<MovieGetDetails_genres> detailsAdapter_genres;
    private int rowLayout;
    private Context context;
    //String ImagePath;

    public static class DetailsViewHolder extends RecyclerView.ViewHolder {
        LinearLayout DetailsLayout;

        private TextView movie_name;

        public DetailsViewHolder(View v) {
            super(v);
            DetailsLayout = (LinearLayout) v.findViewById(R.id.details_layout);
            movie_name = (TextView) v.findViewById(R.id.movie_name_view);

        }
    }

    public DetailsAdapter_genres(List<MovieGetDetails_genres> detailsAdapter_genres,
                                 int rowLayout, Context context) {

        //super(rowLayout, context);

        this.detailsAdapter_genres = detailsAdapter_genres;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public DetailsAdapter_genres.DetailsViewHolder onCreateViewHolder(ViewGroup parent,
                                                                                    int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new DetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DetailsAdapter_genres.DetailsViewHolder holder, int position) {
        holder.movie_name.setText(detailsAdapter_genres.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return detailsAdapter_genres.size();
    }

}


