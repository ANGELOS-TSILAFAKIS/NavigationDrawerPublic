package info.android_angel.navigationdrawer.adapter;

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
import info.android_angel.navigationdrawer.model.TV;

public class TVAdapter extends RecyclerView.Adapter<TVAdapter.TVViewHolder> {

    private List<TV> tvs;
    private int rowLayout;
    private Context context;

    public static class TVViewHolder extends RecyclerView.ViewHolder {
        LinearLayout tvLayout;
        //title
        private TextView tv_title;
        //release_date
        private TextView tv_release_date;
        //overview
        private TextView tv_overview;
        //vote_average
        private TextView  tv_vote_average;
        // private ImageView poster_path;
        private ImageView tv_poster_path;

        private TextView tv_id;

        public TVViewHolder(View v) {
            super(v);
            tvLayout = (LinearLayout) v.findViewById(R.id.tvs_layout);
            tv_title = (TextView) v.findViewById(R.id.tv_title_view);
            tv_release_date = (TextView) v.findViewById(R.id.tv_release_date_view);
            tv_overview = (TextView) v.findViewById(R.id.tv_overview_view);
            tv_vote_average = (TextView) v.findViewById(R.id.tv_vote_average_view);

            //if (posterPath == null)

            tv_poster_path = (ImageView) itemView.findViewById(R.id.tv_poster_path_view);

            //album_id
            tv_id = (TextView) v.findViewById(R.id.tv_id);

        }
    }

    public TVAdapter(List<TV> tvs, int rowLayout, Context context) {

        //super(rowLayout, context);

        this.tvs = tvs;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public TVAdapter.TVViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new TVViewHolder(view);
    }


    @Override
    public void onBindViewHolder(TVViewHolder holder, final int position) {
        holder.tv_title.setText(tvs.get(position).getname());
        //Προηγούμενο παράδειγμα
        //holder.data.setText(tvs.get(position).getReleaseDate());
        holder.tv_release_date.setText(tvs.get(position).getfirst_air_date());
        holder.tv_overview.setText(tvs.get(position).getOverview());
        holder.tv_vote_average.setText(tvs.get(position).getVoteAverage().toString());

        //album_id
        holder.tv_id.setText(tvs.get(position).getId().toString());

        //https://square.github.io/picasso/
        Picasso.with(holder.itemView.getContext()).load("https://image.tmdb.org/t/p/w300" + tvs.get(position).getPosterPath()).into(holder.tv_poster_path);

    }

    @Override
    public int getItemCount() {
        return tvs.size();
    }
}