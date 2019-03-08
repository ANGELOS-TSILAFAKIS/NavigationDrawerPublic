package info.android_angel.navigationdrawer.adapter_id_movies.credits_id_adapter;
/**
 * Created by ANGELOS on 2017.
 *
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
import info.android_angel.navigationdrawer.model_movie_id_get_credits.MovieGetCredits_crew;
/**
 *   "id": 278,
 "crew": [
 {
 "credit_id": "52fe4231c3a36847f800b127",
 "department": "Directing",
 "id": 4027,
 "job": "Director",
 "name": "Frank Darabont",
 "profile_path": "/9KVvZtDyy8DXacw2TTsjC9VLxQi.jpg"
 },
 *
 */
public class CreditsAdapter_crew extends RecyclerView.Adapter< CreditsAdapter_crew. CreditsViewHolder> {

    private List<MovieGetCredits_crew> credits;
    private int rowLayout;
    private Context context;
    //String ImagePath;

    public static class CreditsViewHolder extends RecyclerView.ViewHolder {
        LinearLayout CreditsLayout;
        // "department": "Directing",  FOR MOVIE
        private TextView movie_department;
        // "job": "Director",    FOR MOVIE
        private TextView movie_job;

        //  "name": "Frank Darabont",    FOR MOVIE
        private TextView movie_name;

        // private ImageView posterPath;
        // "profile_path": "/9KVvZtDyy8DXacw2TTsjC9VLxQi.jpg"
        private ImageView movie_profile_path;

        public CreditsViewHolder(View v) {
            super(v);
            CreditsLayout = (LinearLayout) v.findViewById(R.id.credits_layout);
            movie_department = (TextView) v.findViewById(R.id.movie_department_view);
            movie_job = (TextView) v.findViewById(R.id.movie_job_view);
            movie_name = (TextView) v.findViewById(R.id.movie_name_view);

            //if (posterPath == null)

            movie_profile_path = (ImageView) itemView.findViewById(R.id.movie_profile_path_view);
        }
    }

    public CreditsAdapter_crew(List<MovieGetCredits_crew> credits, int rowLayout, Context context) {

        //super(rowLayout, context);

        this.credits = credits;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public CreditsAdapter_crew.CreditsViewHolder onCreateViewHolder(ViewGroup parent,
                                                                    int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new CreditsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CreditsViewHolder holder, final int position) {
        holder.movie_department.setText(credits.get(position).getDepartment());

        holder.movie_job.setText(credits.get(position).getJob());

        holder.movie_name.setText(credits.get(position).getName());

        Picasso.with(holder.itemView.getContext()).load("https://image.tmdb.org/t/p/w185" + credits.get(position).getProfilePath()).into(holder.movie_profile_path);

    }

    @Override
    public int getItemCount() {
        return credits.size();
    }
}


