package info.android_angel.navigationdrawer.adapter_main_activity;

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

import info.android_angel.navigationdrawer.model.TV;
import info.android_angel.navigationdrawer.R;

public class TVAdapter_main_activity extends RecyclerView.Adapter<TVAdapter_main_activity.TVViewHolder> {

    private List<TV> tvs;
    private int rowLayout;
    private Context context;

    public static class TVViewHolder extends RecyclerView.ViewHolder {
        LinearLayout tvLayout;
        private TextView tv_title;

        private TextView tv_id;

        // private ImageView poster_path;
        private ImageView tv_poster_path;

        public TVViewHolder(View v) {
            super(v);
            tvLayout = (LinearLayout) v.findViewById(R.id.tvs_layout);
            tv_title = (TextView) v.findViewById(R.id.tv_title_view);

            tv_id = (TextView) v.findViewById(R.id.tv_id);
            //if (posterPath == null)

            tv_poster_path = (ImageView) itemView.findViewById(R.id.tv_poster_path_view);
        }
    }

    public TVAdapter_main_activity(List<TV> tvs, int rowLayout, Context context) {

        //super(rowLayout, context);

        this.tvs = tvs;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public TVAdapter_main_activity.TVViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new TVViewHolder(view);
    }


    @Override
    public void onBindViewHolder(TVViewHolder holder, final int position) {
        holder.tv_title.setText(tvs.get(position).getname());

        //album_id
        holder.tv_id.setText(tvs.get(position).getId().toString());

        Picasso.with(holder.itemView.getContext()).load("https://image.tmdb.org/t/p/w300" + tvs.get(position).getPosterPath()).into(holder.tv_poster_path);

    }

    @Override
    public int getItemCount() {
        return tvs.size();
    }
}