package info.android_angel.navigationdrawer.adapter_id_movies.details_id_adapter;

/**
 *  Created by ANGELOS on 2017.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

import info.android_angel.navigationdrawer.model_movie_id_get_details.MovieGetDetails_production_countries;
import info.android_angel.navigationdrawer.R;

public class DetailsAdapter_production_countries extends RecyclerView.Adapter<DetailsAdapter_production_countries.DetailsViewHolder> {

    private List<MovieGetDetails_production_countries> details_production_countries;
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

    public DetailsAdapter_production_countries(List<MovieGetDetails_production_countries> details_production_countries, int rowLayout, Context context) {

        //super(rowLayout, context);

        this.details_production_countries = details_production_countries;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public DetailsAdapter_production_countries.DetailsViewHolder onCreateViewHolder(ViewGroup parent,
                                                                                    int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new DetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DetailsAdapter_production_countries.DetailsViewHolder holder, int position) {
        holder.movie_name.setText(details_production_countries.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return details_production_countries.size();
    }
}



