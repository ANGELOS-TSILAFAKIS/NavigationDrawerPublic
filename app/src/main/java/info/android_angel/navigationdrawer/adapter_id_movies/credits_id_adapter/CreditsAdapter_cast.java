package info.android_angel.navigationdrawer.adapter_id_movies.credits_id_adapter;

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

import info.android_angel.navigationdrawer.model_movie_id_get_credits.MovieGetCredits_cast;
import info.android_angel.navigationdrawer.R;

/**
 * Created by ANGELOS on 2017.
 *   "id": 278,
 "cast": [
 {
 "cast_id": 3,
 "character": "Andy Dufresne",
 "credit_id": "52fe4231c3a36847f800b131",
 "id": 504,
 "name": "Tim Robbins",
 "order": 0,
 "profile_path": "/7pirFsBQe93TSfzu404Hgcj1YWj.jpg"
 *
 */

public class  CreditsAdapter_cast extends RecyclerView.Adapter< CreditsAdapter_cast. CreditsViewHolder> {

    private List<MovieGetCredits_cast> credits;
    private int rowLayout;
    private Context context;
    //String ImagePath;

    public static class CreditsViewHolder extends RecyclerView.ViewHolder {
        LinearLayout CreditsLayout;
        //"character": "Andy Dufresne"  FOR MOVIE
        private TextView movie_character;
        //"name": "Tim Robbins",    FOR MOVIE
        private TextView movie_name;
        // private ImageView posterPath;
        //"profile_path": "/7pirFsBQe93TSfzu404Hgcj1YWj.jpg"
        private ImageView movie_profile_path;

        public CreditsViewHolder(View v) {
            super(v);
            CreditsLayout = (LinearLayout) v.findViewById(R.id.credits_layout);
            movie_character = (TextView) v.findViewById(R.id.movie_character_view);
            movie_name = (TextView) v.findViewById(R.id.movie_name_view);

            //if (movie_profile_path == null)

                movie_profile_path = (ImageView) itemView.findViewById(R.id.movie_profile_path_view);

        }
    }

    public CreditsAdapter_cast(List<MovieGetCredits_cast> credits, int rowLayout, Context context) {

        //super(rowLayout, context);

        this.credits = credits;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public CreditsAdapter_cast.CreditsViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new CreditsViewHolder(view);
    }


    @Override
    public void onBindViewHolder(CreditsViewHolder holder, final int position) {
        holder.movie_character.setText(credits.get(position).getCharacter());

        holder.movie_name.setText(credits.get(position).getName());

        Picasso.with(holder.itemView.getContext()).load("https://image.tmdb.org/t/p/w185" + credits.get(position).getProfilePath()).into(holder.movie_profile_path);

    }

    @Override
    public int getItemCount() {
        return credits.size();
    }
}




