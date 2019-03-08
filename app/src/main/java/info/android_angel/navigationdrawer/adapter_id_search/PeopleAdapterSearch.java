package info.android_angel.navigationdrawer.adapter_id_search;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import info.android_angel.navigationdrawer.model.People;
import info.android_angel.navigationdrawer.R;

/**
 * Created by ANGELOS on 2017.
 */

public class PeopleAdapterSearch extends RecyclerView.Adapter<PeopleAdapterSearch.PeopleViewHolder> implements Filterable {

    //private ArrayList<Movie> mFilteredList;
    //private ArrayList<Movie> movies;
    private List<People> people;
    private int rowLayout;
    private Context context;

    //private ArrayList<Movie> mArrayList;
    private List<People> mArrayList;

    public PeopleAdapterSearch(List<People> arrayList) {
        mArrayList = arrayList;
        people = arrayList;
    }

    public PeopleAdapterSearch(List<People> arrayList, int rowLayout, Context context) {
        this.mArrayList = arrayList;
        this.people = arrayList;

        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public PeopleAdapterSearch.PeopleViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);

        return new PeopleAdapterSearch.PeopleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PeopleAdapterSearch.PeopleViewHolder holder, final int position) {

        holder.people_name.setText(people.get(position).getΝame());
        //holder.data.setText(people_known_for.get(position).getOverview());
        //holder.movieDescription.setText(people.get(position).getΝame());
        holder.people_popularity.setText(people.get(position).getPopularity().toString());

        //album_id
        holder.people_id.setText(people.get(position).getId().toString());

        /**   https://developers.themoviedb.org/3/configuration/get-api-configuration   **/
        Picasso.with(holder.itemView.getContext()).load("https://image.tmdb.org/t/p/w500" + people.get(position).getProfile_path()).into(holder.people_profile_path);

    }

    @Override
    public int getItemCount() {
        return people.size();
    }

    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String charString = charSequence.toString();

                if (charString.isEmpty()) {

                    people = mArrayList;
                } else {

                    ArrayList<People> filteredList = new ArrayList<>();

                    for (People people_Version : mArrayList) {

                        if (people_Version.getΝame().toLowerCase().contains(charString) || people_Version.getΝame().toLowerCase().contains(charString) || people_Version.getΝame().toLowerCase().contains(charString)) {

                            filteredList.add(people_Version);
                        }
                    }

                    people = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = people;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                people = (ArrayList<People>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class PeopleViewHolder extends RecyclerView.ViewHolder{
        LinearLayout peopleLayout;
        //"name": "Monica Bellucci",
        private TextView people_name;

        // "popularity": 48.609344
        private TextView people_popularity;

        //"profile_path": "/z3sLuRKP7hQVrvSTsqdLjGSldwG.jpg",
        private ImageView people_profile_path;

        private TextView people_id;

        /**  2017  **/
        private final Context context;

        //api_key_search
        //private ClipData.Item api_key_search;

        public PeopleViewHolder(View v) {

            super(v);

            /**  2017  **/
            context = v.getContext();

            peopleLayout = (LinearLayout) v.findViewById(R.id.people_layout);
            people_name = (TextView) v.findViewById(R.id.people_name_view);
            people_popularity = (TextView) v.findViewById(R.id.people_popularity_view);

            //if (posterPath == null)

            people_profile_path = (ImageView) itemView.findViewById(R.id.people_profile_path_view);

            //album_id
            people_id = (TextView) v.findViewById(R.id.people_id);

        }
    }

}
