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

import info.android_angel.navigationdrawer.model_movie_id_get_details.MovieGetDetails_production_companies;
import info.android_angel.navigationdrawer.R;

public class DetailsAdapter_production_companies extends RecyclerView.Adapter<DetailsAdapter_production_companies.DetailsViewHolder> {

    private List<MovieGetDetails_production_companies> details_production_companies;
    private int rowLayout;
    private Context context;
    //String ImagePath;

    public static class DetailsViewHolder extends RecyclerView.ViewHolder {
        LinearLayout DetailsLayout;
        //"name": "Tim Robbins",    FOR MOVIE
        private TextView movie_name;

        public DetailsViewHolder(View v) {
            super(v);
            DetailsLayout = (LinearLayout) v.findViewById(R.id.details_layout);
            movie_name = (TextView) v.findViewById(R.id.movie_name_view);

        }
    }

    public DetailsAdapter_production_companies(List<MovieGetDetails_production_companies> details_production_companies, int rowLayout, Context context) {

        //super(rowLayout, context);

        this.details_production_companies = details_production_companies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public DetailsAdapter_production_companies.DetailsViewHolder onCreateViewHolder(ViewGroup parent,
                                                                                    int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new DetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DetailsAdapter_production_companies.DetailsViewHolder holder, int position) {
        holder.movie_name.setText(details_production_companies.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return details_production_companies.size();
    }


}








