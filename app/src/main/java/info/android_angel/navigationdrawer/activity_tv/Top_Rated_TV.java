package info.android_angel.navigationdrawer.activity_tv;

/**
 *  Created by ANGELOS on 2017.
 *
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
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdView;

import java.util.List;

import info.android_angel.navigationdrawer.R;
import info.android_angel.navigationdrawer.activity_movies.SearchActivity;
import info.android_angel.navigationdrawer.activity_movies.Show_Movie_Details_ID;
import info.android_angel.navigationdrawer.adapter.TVAdapter;
import info.android_angel.navigationdrawer.model.TV;
import info.android_angel.navigationdrawer.model.TVResponse;
import info.android_angel.navigationdrawer.package_recycler_touch_listener.RecyclerTouchListener;
import info.android_angel.navigationdrawer.rest.ApiClient;
import info.android_angel.navigationdrawer.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class Top_Rated_TV extends AppCompatActivity {

    private final static String page_2 = "2";
    private final static String page_3 = "3";

    /** 2017 ads**/
    private AdView mAdView;

    private static final String TAG = Top_Rated_TV.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_tv_get_airing_today);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (getResources().getString(R.string.API_KEY).isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please obtain your API KEY from themoviedb.org first!", Toast.LENGTH_LONG).show();
            return;
        }

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.tvs_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        /** 2017   AdView
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
                Toast.makeText(getApplicationContext(), "Ad is closed!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                Toast.makeText(getApplicationContext(), "Ad failed to load! error code: " + errorCode, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdLeftApplication() {
                Toast.makeText(getApplicationContext(), "Ad left application!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
            }
        });

        mAdView.loadAd(adRequest);**/
        /**END 2017   AdView  **/

        /**  Προσοχή εδώ η αλλάγή.............  **/
        Call<TVResponse> call = apiService.getTopRatedTv(getResources().getString(R.string.API_KEY));
        call.enqueue(new Callback<TVResponse>() {
            @Override
            public void onResponse(Call<TVResponse> call, Response<TVResponse> response) {
                if (!response.isSuccessful()) {
                    System.out.println("Error");
                }

                if(response.isSuccessful())   {
                List<TV> tvs = response.body().getResults();

                recyclerView.setAdapter(new TVAdapter(tvs, R.layout.nav_tv_get_airing_today_list_item, getApplicationContext()));
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
                        Intent i = new Intent(getApplicationContext(), Show_TV_Details_ID.class);

                        String tv_id = ((TextView) view.findViewById(R.id.tv_id)).getText().toString();
                        i.putExtra("tv_id", tv_id);
                        //i.putExtra(KEY_MOVIE_ID, movies_response.get(position).getId());

                        //Toast.makeText(getApplicationContext(),tv_id, Toast.LENGTH_SHORT).show();

                        startActivity(i);

                    }

                    @Override
                    public void onLongClick(View view, int position) {

                    }
                }));
 **/
            }

            @Override
            public void onFailure(Call<TVResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });


        /** PAGE = 2 **/

        final RecyclerView recyclerView_2 = (RecyclerView) findViewById(R.id.tvs_recycler_view_page_2);
        recyclerView_2.setLayoutManager(new LinearLayoutManager(this));

        Call<TVResponse> call_2 = apiService.getTopRatedTv_2(getResources().getString(R.string.API_KEY), page_2);
        call_2.enqueue(new Callback<TVResponse>() {
            @Override
            public void onResponse(Call<TVResponse> call_2, final Response<TVResponse> response) {
                if (!response.isSuccessful()) {
                    //System.out.println("Error");
                }

                if(response.isSuccessful())   {
                    final List<TV> tvs = response.body().getResults();

                    recyclerView_2.setAdapter(new TVAdapter(tvs, R.layout.nav_tv_get_airing_today_list_item, getApplicationContext()));


                }else{
                    int statusCode = response.code();
                    switch(statusCode){
                        case 	401:
                            //Toast.makeText(getApplicationContext(),"Invalid API key: You must be granted a valid key.", Toast.LENGTH_SHORT).show();

                        case 	404:
                            //Toast.makeText(getApplicationContext(),"The resource you requested could not be found.", Toast.LENGTH_SHORT).show();

                    }
                }

                recyclerView_2.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView_2, new RecyclerTouchListener.ClickListener() {


                    @Override
                    public void onClick(View view, int position) {
                        // on selecting a single album
                        // TrackListActivity will be launched to show tracks inside the album
                        Intent i = new Intent(getApplicationContext(), Show_Movie_Details_ID.class);

                        String movie_id = ((TextView) view.findViewById(R.id.movie_id)).getText().toString();
                        i.putExtra("movie_id", movie_id);
                        //i.putExtra(KEY_MOVIE_ID, movies_response.get(position).getId());

                        //Toast.makeText(getApplicationContext(),movie_id, Toast.LENGTH_SHORT).show();

                        startActivity(i);
                    }

                    @Override
                    public void onLongClick(View view, int position) {
                        // on selecting a single album
                        // TrackListActivity will be launched to show tracks inside the album
                        //Intent i = new Intent(getApplicationContext(), Show_Movie_Details_ID.class);

                        // send album id to tracklist activity to get list of songs under that album
                        //String movie_id = ((TextView) view.findViewById(R.id.movie_id)).getText().toString();
                        //i.putExtra("movie_id", movie_id);

                        //startActivity(i);
                    }

                }));

            }

            @Override
            public void onFailure(Call<TVResponse> call_2, Throwable t) {
                // Log error here since request failed
                //Log.e(TAG, t.toString());
            }
        });

        /** PAGE = 3 **/

        final RecyclerView recyclerView_3 = (RecyclerView) findViewById(R.id.tvs_recycler_view_page_3);
        recyclerView_3.setLayoutManager(new LinearLayoutManager(this));

        Call<TVResponse> call_3 = apiService.getTopRatedTv_2(getResources().getString(R.string.API_KEY), page_3);
        call_3.enqueue(new Callback<TVResponse>() {
            @Override
            public void onResponse(Call<TVResponse> call_3, final Response<TVResponse> response) {
                if (!response.isSuccessful()) {
                    //System.out.println("Error");
                }

                if(response.isSuccessful())   {
                    final List<TV> tvs = response.body().getResults();

                    recyclerView_3.setAdapter(new TVAdapter(tvs, R.layout.nav_tv_get_airing_today_list_item, getApplicationContext()));


                }else{
                    int statusCode = response.code();
                    switch(statusCode){
                        case 	401:
                            //Toast.makeText(getApplicationContext(),"Invalid API key: You must be granted a valid key.", Toast.LENGTH_SHORT).show();

                        case 	404:
                            //Toast.makeText(getApplicationContext(),"The resource you requested could not be found.", Toast.LENGTH_SHORT).show();

                    }
                }

                recyclerView_3.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView_3, new RecyclerTouchListener.ClickListener() {


                    @Override
                    public void onClick(View view, int position) {
                        // on selecting a single album
                        // TrackListActivity will be launched to show tracks inside the album
                        Intent i = new Intent(getApplicationContext(), Show_Movie_Details_ID.class);

                        String movie_id = ((TextView) view.findViewById(R.id.movie_id)).getText().toString();
                        i.putExtra("movie_id", movie_id);
                        //i.putExtra(KEY_MOVIE_ID, movies_response.get(position).getId());

                        //Toast.makeText(getApplicationContext(),movie_id, Toast.LENGTH_SHORT).show();

                        startActivity(i);
                    }


                    @Override
                    public void onLongClick(View view, int position) {
                        // on selecting a single album
                        // TrackListActivity will be launched to show tracks inside the album
                        //Intent i = new Intent(getApplicationContext(), Show_Movie_Details_ID.class);

                        // send album id to tracklist activity to get list of songs under that album
                        //String movie_id = ((TextView) view.findViewById(R.id.movie_id)).getText().toString();
                        //i.putExtra("movie_id", movie_id);

                        //startActivity(i);
                    }

                }));

            }

            @Override
            public void onFailure(Call<TVResponse> call_3, Throwable t) {
                // Log error here since request failed
                //Log.e(TAG, t.toString());
            }
        });

    }


    /**  SEARCH   **/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);

        MenuItem search = menu.findItem(R.id.search);

        SearchView searchView = (SearchView) MenuItemCompat.getActionView(search);
        search(searchView);

        return true;
    }

    /**  SEARCH   **/
    private void search(SearchView searchView) {

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                //Toast.makeText(Popular_Movie.this, "Search is Selected", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Top_Rated_TV.this,SearchActivity.class);
                String api_key_search = query.toString();
                i.putExtra("api_key_search", api_key_search);

                /**switch_key_activity  for SearchActivity    **/
                String switch_key_activity = "Top_Rated_TV";
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