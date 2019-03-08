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

import info.android_angel.navigationdrawer.model_movie_id_get_details.MovieGetDetails_spoken_languages;
import info.android_angel.navigationdrawer.R;

public class DetailsAdapter_spoken_languages extends RecyclerView.Adapter<DetailsAdapter_spoken_languages.DetailsViewHolder> {

    private List<MovieGetDetails_spoken_languages> detailsAdapter_spoken_languages;
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

    public DetailsAdapter_spoken_languages(List<MovieGetDetails_spoken_languages> detailsAdapter_spoken_languages,
                                           int rowLayout, Context context) {

        //super(rowLayout, context);

        this.detailsAdapter_spoken_languages = detailsAdapter_spoken_languages;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public DetailsAdapter_spoken_languages.DetailsViewHolder onCreateViewHolder(ViewGroup parent,
                                                                                    int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new DetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DetailsAdapter_spoken_languages.DetailsViewHolder holder, int position) {
        holder.movie_name.setText(detailsAdapter_spoken_languages.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return detailsAdapter_spoken_languages.size();
    }

}






