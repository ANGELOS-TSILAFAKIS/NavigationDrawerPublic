package info.android_angel.navigationdrawer.activity_people;

/**
 * Created by A-PC-A on 2016.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

import info.android_angel.navigationdrawer.activity_movies.SearchActivity;
import info.android_angel.navigationdrawer.adapter.PeopleAdapterPopular;
import info.android_angel.navigationdrawer.model.People;
import info.android_angel.navigationdrawer.model.PeopleResponse;
import info.android_angel.navigationdrawer.rest.ApiClient;
import info.android_angel.navigationdrawer.rest.ApiInterface;
import info.android_angel.navigationdrawer.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Popular_People extends AppCompatActivity {

    private static final String TAG = Popular_People.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_people_get_popular);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (getResources().getString(R.string.API_KEY).isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please obtain your API KEY from themoviedb.org first!", Toast.LENGTH_LONG).show();
            return;
        }

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.people_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<PeopleResponse> call = apiService.getPopularPeople(getResources().getString(R.string.API_KEY));
        call.enqueue(new Callback<PeopleResponse>() {
            @Override
            public void onResponse(Call<PeopleResponse> call, final Response<PeopleResponse> response) {

                if (!response.isSuccessful()) {
                    System.out.println("Error");
                }

                if(response.isSuccessful())   {

                    List<People> people = response.body().getResults();

                    recyclerView.setAdapter(new PeopleAdapterPopular(people,
                                         R.layout.nav_people_get_popular_list_item, getApplicationContext()));

                }else{
                    int statusCode = response.code();
                    switch(statusCode){
                        case 	401:
                            Toast.makeText(getApplicationContext(),"Invalid API key: You must be granted a valid key.", Toast.LENGTH_SHORT).show();

                        case 	404:
                            Toast.makeText(getApplicationContext(),"The resource you requested could not be found.", Toast.LENGTH_SHORT).show();

                    }
                }

                /**
                recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {

                    @Override
                    public void onClick(View view, int position) {
                        // on selecting a single album
                        // TrackListActivity will be launched to show tracks inside the album
                        Intent i = new Intent(getApplicationContext(), Show_People_Details_ID.class);

                        String people_id = ((TextView) view.findViewById(R.id.people_id)).getText().toString();
                        i.putExtra("people_id", people_id);
                        //i.putExtra(KEY_MOVIE_ID, movies_response.get(position).getId());

                        //Toast.makeText(getApplicationContext(),people_id, Toast.LENGTH_SHORT).show();

                        startActivity(i);

                    }

                @Override
                public void onLongClick(View view, int position) {
                    // on selecting a single album
                    // TrackListActivity will be launched to show tracks inside the album
                    Intent i = new Intent(getApplicationContext(), Popular_Movie.class);

                    // send album id to tracklist activity to get list of songs under that album
                    String people_id = ((TextView) view.findViewById(R.id.people_id)).getText().toString();
                    i.putExtra("people_id", people_id);

                    startActivity(i);
                }
            }));
             **/
        }

            @Override
            public void onFailure(Call<PeopleResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });

    }

    /**  SEARCH 2017    **/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);

        MenuItem search = menu.findItem(R.id.search);

        SearchView searchView = (SearchView) MenuItemCompat.getActionView(search);
        search(searchView);

        return true;
    }

    /**  SEARCH  **/
    private void search(SearchView searchView) {

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                //Toast.makeText(Popular_Movie.this, "Search is Selected", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Popular_People.this,SearchActivity.class);
                String api_key_search = query.toString();
                i.putExtra("api_key_search", api_key_search);

                /**switch_key_activity  for SearchActivity    **/
                String switch_key_activity = "Popular_People";
                i.putExtra("switch_key_activity", switch_key_activity);

                //Toast.makeText(MainActivity.this, api_key_search, Toast.LENGTH_SHORT).show();

                //String api_key_search = ((TextView) menu.findItem(R.id.search)).getText().toString();
                //i.putExtra("api_key_search", api_key_search);
                startActivity(i);

                return true;
            }

            @Override
            public boolean onQueryTextChange(final String newText) {

                return false;
            }
        });
    }

    /**  Για το βέλος που μας πηγαίνει στο αρχικό μενού  **/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            // finish the activity
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}