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

import info.android_angel.navigationdrawer.R;
import info.android_angel.navigationdrawer.model.People;
import info.android_angel.navigationdrawer.model.People_known_for;

public class PeopleAdapterPopular_main_activity extends RecyclerView.Adapter<PeopleAdapterPopular_main_activity.PeopleViewHolder> {

    private List<People> people;
    private int rowLayout;
    private Context context;
    //String ImagePath;

    //People_known_for
    private List<People_known_for> people_known_for;

    public static class PeopleViewHolder extends RecyclerView.ViewHolder {
        LinearLayout peopleLayout;
        //"name": "Monica Bellucci",
        private TextView people_name;

        // profile_path": "/z3sLuRKP7hQVrvSTsqdLjGSldwG.jpg
        private ImageView people_profile_path;

        private TextView people_id;

        public PeopleViewHolder(View v) {
            super(v);
            peopleLayout = (LinearLayout) v.findViewById(R.id.people_layout);
            people_name = (TextView) v.findViewById(R.id.people_name_view);

            //if (posterPath == null)

            people_profile_path = (ImageView) itemView.findViewById(R.id.people_profile_path_view);

            //album_id
            people_id = (TextView) v.findViewById(R.id.people_id);

        }
    }
    //List<People_known_for> people_known_for,
    public PeopleAdapterPopular_main_activity(List<People> people,
                                int rowLayout,
                                Context context) {

        //super(rowLayout, context);
        //this.people_known_for = people_known_for;
        this.people = people;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public PeopleAdapterPopular_main_activity.PeopleViewHolder onCreateViewHolder(ViewGroup parent,
                                                                    int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new PeopleViewHolder(view);
    }


    @Override
    public void onBindViewHolder(PeopleViewHolder holder, final int position) {
        holder.people_name.setText(people.get(position).getΝame());

        //album_id
        holder.people_id.setText(people.get(position).getId().toString());

        /** Picasso.with(holder.itemView.getContext()).load("https://image.tmdb.org/t/p/w500" + people.get(position).getPosterPath()).into(holder.people_profile_path);
         **/
        Picasso.with(holder.itemView.getContext()).load("https://image.tmdb.org/t/p/w300" + people.get(position).getProfile_path()).into(holder.people_profile_path);

    }

    @Override
    public int getItemCount() {
        return people.size();
    }
}