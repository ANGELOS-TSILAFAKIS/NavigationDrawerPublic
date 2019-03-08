package info.android_angel.navigationdrawer.activity_movies;

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
import android.view.View;
import android.widget.TextView;

import java.util.List;

import info.android_angel.navigationdrawer.R;
import info.android_angel.navigationdrawer.adapter_id_search.MovieAdapterSearch;
import info.android_angel.navigationdrawer.adapter_id_search.TVAdapterSearch;
import info.android_angel.navigationdrawer.model.Movie;
import info.android_angel.navigationdrawer.model.MoviesResponse;
import info.android_angel.navigationdrawer.model.TV;
import info.android_angel.navigationdrawer.model.TVResponse;
import info.android_angel.navigationdrawer.package_recycler_touch_listener.RecyclerTouchListener;
import info.android_angel.navigationdrawer.rest.ApiClient;
import info.android_angel.navigationdrawer.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ANGELOS on 2017.
 */

public class SearchActivity extends AppCompatActivity {

    // switch_key_activity
    String switch_key_activity;

    /** ads
    private AdView mAdView;**/

    /**  SEARCH    **/
    //private RecyclerView searchRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_movies_tv_people_search);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);


        /**  AdView
        mAdView = (AdView) findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                // Check the LogCat to get your test device ID
                .addTestDevice("C04B1BFFB0774708339BC273F8A43708")
                .build();

        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
            }

            @Override
            public void onAdClosed() {
                //Toast.makeText(getApplicationContext(), "Ad is closed!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                //Toast.makeText(getApplicationContext(), "Ad failed to load! error code: " + errorCode, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdLeftApplication() {
                //Toast.makeText(getApplicationContext(), "Ad left application!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
            }
        });

        mAdView.loadAd(adRequest);**/
        /**END    AdView  **/

        //String api_key_search = "Jack";

        Intent i = getIntent();
        String api_key_search = i.getStringExtra("api_key_search");

        /**   MOVIES  **/
        final RecyclerView recyclerView_Search_Movie = (RecyclerView) findViewById(R.id.movies_recycler_view);
        recyclerView_Search_Movie.setLayoutManager(new LinearLayoutManager(this));

        Call<MoviesResponse> call_search_movie = apiService.getSearchForMovies(getResources().getString(R.string.API_KEY), api_key_search);
        call_search_movie.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, final Response<MoviesResponse> response) {
                if (!response.isSuccessful()) {
                    //System.out.println("Error");
                }

                if(response.isSuccessful())   {

                    List<Movie> movies = response.body().getResults();
                    recyclerView_Search_Movie.setAdapter(new MovieAdapterSearch(movies, R.layout.nav_movies_get_now_playing_list_item, getApplicationContext()));

                }else{
                    int statusCode = response.code();
                    switch(statusCode){
                        case 	401:
                            //Toast.makeText(getApplicationContext(),"Invalid API key: You must be granted a valid key.", Toast.LENGTH_SHORT).show();
                        case 	404:
                            //Toast.makeText(getApplicationContext(),"The resource you requested could not be found.", Toast.LENGTH_SHORT).show();
                    }
                }

                recyclerView_Search_Movie.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView_Search_Movie, new RecyclerTouchListener.ClickListener() {

                @Override
                public void onClick(View view, int position) {
                    // on selecting a single album
                    // TrackListActivity will be launched to show tracks inside the album
                    Intent i = new Intent(getApplicationContext(), Show_Movie_Details_ID.class);

                    List<Movie> movies_response = response.body().getResults();

                    //Getting the requested book from the list
                    Movie movie_show = movies_response.get(position);

                    String movie_id = ((TextView) view.findViewById(R.id.movie_id)).getText().toString();
                    i.putExtra("movie_id", movie_id);

                    // Toast.makeText(getApplicationContext(),movie_id, Toast.LENGTH_SHORT).show();

                    startActivity(i);

                }

                @Override
                public void onLongClick(View view, int position) {
                    // on selecting a single album
                    // TrackListActivity will be launched to show tracks inside the album
                    Intent i = new Intent(getApplicationContext(), Popular_Movie.class);

                    // send album id to tracklist activity to get list of songs under that album
                    String album_id = ((TextView) view.findViewById(R.id.album_id)).getText().toString();
                    i.putExtra("album_id", album_id);

                    startActivity(i);
                }
            }));

            }

            @Override
            public void onFailure(Call<MoviesResponse> call_search_movie, Throwable t) {
                // Log error here since request failed
                //Log.e(TAG, t.toString());
            }
        });

        /**   People
        final RecyclerView recyclerView_Search_People = (RecyclerView) findViewById(R.id.people_recycler_view);
        recyclerView_Search_People.setLayoutManager(new LinearLayoutManager(this));

        Call<PeopleResponse> call_search_people = apiService.getSearchForPeople(API_KEY, api_key_search);
        call_search_people.enqueue(new Callback<PeopleResponse>() {
            @Override
            public void onResponse(Call<PeopleResponse> call_search_people, Response<PeopleResponse> response) {

                //JSONResponse jsonResponse = response.body();
                //ArrayList = new ArrayList<>(Arrays.asList(jsonResponse.getAndroid()));
                //mAdapter = new DataAdapter(mArrayList);
                //mRecyclerView.setAdapter(mAdapter);


                List<People> people = response.body().getResults();
                //recyclerView_Search.setAdapter(new MovieAdapterSearch((ArrayList<Movie>) movies, R.layout.activity_main_movies_get_now_playing_movie_list_item, getApplicationContext()));
                recyclerView_Search_People.setAdapter(new PeopleAdapterSearch(people, R.layout.nav_people_get_popular_list_item, getApplicationContext()));

            }

            @Override
            public void onFailure(Call<PeopleResponse> call_search_people, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });

         **/

        /**   TV  **/
        final RecyclerView recyclerView_Search_TV = (RecyclerView) findViewById(R.id.tv_recycler_view);
        recyclerView_Search_TV.setLayoutManager(new LinearLayoutManager(this));

        Call<TVResponse> call_search_TV = apiService.getSearchForTV(getResources().getString(R.string.API_KEY), api_key_search);
        call_search_TV.enqueue(new Callback<TVResponse>() {
            @Override
            public void onResponse(Call<TVResponse> call_search_TV, Response<TVResponse> response) {

                //JSONResponse jsonResponse = response.body();
                //ArrayList = new ArrayList<>(Arrays.asList(jsonResponse.getAndroid()));
                //mAdapter = new DataAdapter(mArrayList);
                //mRecyclerView.setAdapter(mAdapter);


                List<TV> tvs = response.body().getResults();
                //recyclerView_Search.setAdapter(new MovieAdapterSearch((ArrayList<Movie>) movies, R.layout.activity_main_movies_get_now_playing_movie_list_item, getApplicationContext()));
                recyclerView_Search_TV.setAdapter(new TVAdapterSearch(tvs, R.layout.nav_tv_get_airing_today_list_item, getApplicationContext()));

            }

            @Override
            public void onFailure(Call<TVResponse> call_search_TV, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);

        MenuItem search = menu.findItem(R.id.search);

        SearchView searchView = (SearchView) MenuItemCompat.getActionView(search);
        search(searchView);

        return true;
    }

    /**  SEARCH    **/
    private void search(SearchView searchView) {

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                //Toast.makeText(SearchActivity.this, "Search is Selected", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(SearchActivity.this,SearchActivity.class);
                // clear all the activities
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                        | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED
                        | Intent.FLAG_ACTIVITY_CLEAR_TOP);

                String api_key_search = query.toString();
                i.putExtra("api_key_search", api_key_search);

                switch_key_activity = i.getStringExtra("switch_key_activity");

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

    /**  Για το βέλος που μας πηγαίνει στο αρχικό μενού  **/

    public boolean onOptionsItemSelected_2(MenuItem item) {
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


    /** 2017 ads
    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }
     **/
}
