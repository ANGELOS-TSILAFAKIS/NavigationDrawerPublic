package info.android_angel.navigationdrawer.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import info.android_angel.navigationdrawer.R;
import info.android_angel.navigationdrawer.activity_movies.Now_playing_Movie;
import info.android_angel.navigationdrawer.activity_movies.Popular_Movie;
import info.android_angel.navigationdrawer.activity_movies.SearchActivity;
import info.android_angel.navigationdrawer.activity_movies.Show_Movie_Details_ID;
import info.android_angel.navigationdrawer.activity_movies.Top_Rated_Movie;
import info.android_angel.navigationdrawer.activity_movies.Upcoming_Movie;
import info.android_angel.navigationdrawer.activity_tv.Popular_TV;
import info.android_angel.navigationdrawer.activity_tv.TV_Airing_Today_TV;
import info.android_angel.navigationdrawer.activity_tv.TV_On_The_Air_TV;
import info.android_angel.navigationdrawer.activity_tv.Top_Rated_TV;
import info.android_angel.navigationdrawer.adapter_id_search.MovieAdapterSearch;
import info.android_angel.navigationdrawer.adapter_main_activity.MoviesAdapter_main_activity;
import info.android_angel.navigationdrawer.model.Movie;
import info.android_angel.navigationdrawer.model.MoviesResponse;
import info.android_angel.navigationdrawer.package_recycler_touch_listener.RecyclerTouchListener;
import info.android_angel.navigationdrawer.rest.ApiClient;
import info.android_angel.navigationdrawer.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ANGELOS on 2016.
 */

public class MainActivity extends AppCompatActivity {

    /**  SEARCH 2017    **/
    private RecyclerView searchRecyclerView;

    //TextView java_original_title, java_release_date, java_overview;
    ImageView  java_backdrop_path;

    /** 2017 ads
    private AdView mAdView;**/

    private static final String TAG = Now_playing_Movie.class.getSimpleName();

    private NavigationView navigationView;
    private DrawerLayout drawer;
    private View navHeader;
    private ImageView imgNavHeaderBg, imgProfile;
    private TextView txtName, txtWebsite;
    private Toolbar toolbar;
    //private FloatingActionButton fab;

    // urls to load navigation header background image
    // and profile image
    /**  Εδώ η αλλάγή της μικρής εικόνας.   ΜΗΝ ΤΟ ΔΙΑΓΡΑΨΕΙΣ **/
    //private static final String urlNavHeaderBg = "http://api.androidhive.info/images/nav-menu-header-bg.jpg";
    //private static final String urlProfileImg = "https://image.tmdb.org/t/p/w500/nHXiMnWUAUba2LZ0dFkNDVdvJ1o.jpg";
    private static final String urlProfileImg ="@android:drawable/stacked_green";

    /**  Εδώ η αλλάγή της μεγάλης εικόνας **/
   // https://image.tmdb.org/t/p/w500/kqjL17yufvn9OVLyXYpvtyrFfak.jpg
   private static final String urlNavHeaderBg = "https://image.tmdb.org/t/p/w300/kqjL17yufvn9OVLyXYpvtyrFfak.jpg";

    // index to identify current nav menu item
    public static int navItemIndex = 0;

    // tags used to attach the fragments
    private static final String TAG_HOME = "home";
    private static final String TAG_PHOTOS = "photos";
    private static final String TAG_MOVIES = "movies";
    private static final String TAG_NOTIFICATIONS = "notifications";
    private static final String TAG_SETTINGS = "settings";
    public static String CURRENT_TAG = TAG_HOME;

    private static final String TAG_nav_movies_Get_Now_Playing = "nav_movies_Get_Now_Playing";

    private final static String page_2 = "2";
    private final static String page_3 = "3";


    // toolbar titles respected to selected nav menu item
    private String[] activityTitles;

    // flag to load home fragment when user presses back key
    private boolean shouldLoadHomeFragOnBackPress = true;
    private Handler mHandler;


    // Search EditText
    EditText inputSearch;

    private List<Movie> mArrayList;
    private MovieAdapterSearch movieAdapterSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mHandler = new Handler();

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);

        // Navigation view header
        navHeader = navigationView.getHeaderView(0);
        txtName = (TextView) navHeader.findViewById(R.id.name);
        txtWebsite = (TextView) navHeader.findViewById(R.id.website);
        imgNavHeaderBg = (ImageView) navHeader.findViewById(R.id.img_header_bg);
        //imgProfile = (ImageView) navHeader.findViewById(R.id.img_profile);

        // load toolbar titles from string resources
        activityTitles = getResources().getStringArray(R.array.nav_item_activity_titles);

        // load nav menu header data
        //imgNavHeaderBg                 ΓΙΑ ΤΗΝ ΕΙΚΟΝΑ
        //loadNavHeader();

        // initializing navigation menu
        setUpNavigationView();

        if (savedInstanceState == null) {
            navItemIndex = 0;
            CURRENT_TAG = TAG_HOME;
            loadHomeFragment();
        }

        /** AdView
        mAdView = (AdView) findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                // Check the LogCat to get your test device ID   C04B1BFFB0774708339BC273F8A43708
                .addTestDevice("@string/addTestDevice")
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

        final ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        /**
         * getNow_playing Για να έχουμε LinearLayoutManager.HORIZONTAL
         * activity_main_movies_recycler_view    app_bar_main.xml
         **/

        final RecyclerView recyclerView_Now_playing = (RecyclerView) findViewById(R.id.activity_main_movies_recycler_view);
        recyclerView_Now_playing.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        Call<MoviesResponse> call = apiService.getNowPlayingMovies(getResources().getString(R.string.API_KEY));
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, final Response<MoviesResponse> response) {
                if (!response.isSuccessful()) {
                    //System.out.println("Error");
                }

                if(response.isSuccessful())   {
                final List<Movie> movies = response.body().getResults();

                recyclerView_Now_playing.setAdapter(new MoviesAdapter_main_activity(movies, R.layout.activity_main_movies_get_now_playing_movie_list_item, getApplicationContext()));


                    /** 2017   Search
                    inputSearch = (EditText) findViewById(R.id.inputSearch);

                    inputSearch.addTextChangedListener(new TextWatcher() {

                        List<Movie> movies = response.body().getResults();

                        @Override
                        public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                            // When user changed the Text
                            //MainActivity.this.(new MoviesAdapter_main_activity(movies, R.layout.activity_main_movies_get_now_playing_movie_list_item, getApplicationContext())).getFilter().filter(cs);
                        }

                        @Override
                        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                                      int arg3) {
                            // TODO Auto-generated method stub

                        }

                        @Override
                        public void afterTextChanged(Editable arg0) {
                            // TODO Auto-generated method stub
                        }
                    });
                     **/

                }else{
                    int statusCode = response.code();
                    switch(statusCode){
                        case 	401:
                            //Toast.makeText(getApplicationContext(),"Invalid API key: You must be granted a valid key.", Toast.LENGTH_SHORT).show();

                        case 	404:
                            //Toast.makeText(getApplicationContext(),"The resource you requested could not be found.", Toast.LENGTH_SHORT).show();

                    }
                }

                // μάλλον το βρήκα από το stackoverflow
                recyclerView_Now_playing.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView_Now_playing, new RecyclerTouchListener.ClickListener() {


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
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                // Log error here since request failed
                //Log.e(TAG, t.toString());
            }
        });

        /** PAGE = 2  **/

        final RecyclerView recyclerView_Now_playing_2 = (RecyclerView) findViewById(R.id.activity_main_movies_recycler_view_page_2);
        recyclerView_Now_playing_2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        Call<MoviesResponse> call_2 = apiService.getNowPlayingMovies_2(getResources().getString(R.string.API_KEY), page_2);
        call_2.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call_2, final Response<MoviesResponse> response) {
                if (!response.isSuccessful()) {
                    //System.out.println("Error");
                }

                if(response.isSuccessful())   {
                    final List<Movie> movies = response.body().getResults();

                    recyclerView_Now_playing_2.setAdapter(new MoviesAdapter_main_activity(movies, R.layout.activity_main_movies_get_now_playing_movie_list_item, getApplicationContext()));


                }else{
                    int statusCode = response.code();
                    switch(statusCode){
                        case 	401:
                            //Toast.makeText(getApplicationContext(),"Invalid API key: You must be granted a valid key.", Toast.LENGTH_SHORT).show();

                        case 	404:
                            //Toast.makeText(getApplicationContext(),"The resource you requested could not be found.", Toast.LENGTH_SHORT).show();

                    }
                }

                // μάλλον το βρήκα από το stackoverflow
                recyclerView_Now_playing_2.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView_Now_playing_2, new RecyclerTouchListener.ClickListener() {

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
            public void onFailure(Call<MoviesResponse> call_2, Throwable t) {
                // Log error here since request failed
                //Log.e(TAG, t.toString());
            }
        });

        /** PAGE = 3    **/

        final RecyclerView recyclerView_Now_playing_3 = (RecyclerView) findViewById(R.id.activity_main_movies_recycler_view_page_3);
        recyclerView_Now_playing_3.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        Call<MoviesResponse> call_3 = apiService.getNowPlayingMovies_2(getResources().getString(R.string.API_KEY), page_3);
        call_3.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call_3, final Response<MoviesResponse> response) {
                if (!response.isSuccessful()) {
                    //System.out.println("Error");
                }

                if(response.isSuccessful())   {
                    final List<Movie> movies = response.body().getResults();

                    recyclerView_Now_playing_3.setAdapter(new MoviesAdapter_main_activity(movies, R.layout.activity_main_movies_get_now_playing_movie_list_item, getApplicationContext()));


                }else{
                    int statusCode = response.code();
                    switch(statusCode){
                        case 	401:
                            //Toast.makeText(getApplicationContext(),"Invalid API key: You must be granted a valid key.", Toast.LENGTH_SHORT).show();

                        case 	404:
                            //Toast.makeText(getApplicationContext(),"The resource you requested could not be found.", Toast.LENGTH_SHORT).show();

                    }
                }

                recyclerView_Now_playing_3.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView_Now_playing_3, new RecyclerTouchListener.ClickListener() {

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
            public void onFailure(Call<MoviesResponse> call_3, Throwable t) {
                // Log error here since request failed
                //Log.e(TAG, t.toString());
            }
        });

        /**  activity_main_people_recycler_view   app_bar_main.xml**/

        /**

         final RecyclerView recyclerView_People = (RecyclerView) findViewById(R.id.activity_main_people_recycler_view);
        recyclerView_People.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        Call<PeopleResponse> call_people = apiService.getPopularPeople(API_KEY);
        call_people.enqueue(new Callback<PeopleResponse>() {
             @Override
             public void onResponse(Call<PeopleResponse> call, Response<PeopleResponse> response) {

                 if (!response.isSuccessful()) {
                     //System.out.println("Error");
                 }

                 if(response.isSuccessful())   {
                 List<People> people = response.body().getResults();

                 //List<People_known_for> people_known_for = response.body().getΚnown_for();

                 recyclerView_People.setAdapter(new PeopleAdapterPopular_main_activity(people,
                         R.layout.activity_main_movies_get_popular_people_list_item, getApplicationContext()));

                 }else{
                     int statusCode = response.code();
                     switch(statusCode){
                         case 	401:
                             //Toast.makeText(getApplicationContext(),"Invalid API key: You must be granted a valid key.", Toast.LENGTH_SHORT).show();

                         case 	404:
                             //Toast.makeText(getApplicationContext(),"The resource you requested could not be found.", Toast.LENGTH_SHORT).show();

                     }
                 }

                 recyclerView_People.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView_People, new RecyclerTouchListener.ClickListener() {

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
                     //on selecting a single album
                     //TrackListActivity will be launched to show tracks inside the album
                     Intent i = new Intent(getApplicationContext(), Show_People_Details_ID.class);

                     //send album id to tracklist activity to get list of songs under that album
                     //String people_id = ((TextView) view.findViewById(R.id.people_id)).getText().toString();
                     i.putExtra("people_id", people_id);

                     startActivity(i);
                 }

                 }));

             }

            @Override
            public void onFailure(Call<PeopleResponse> call, Throwable t) {
                // Log error here since request failed
                //Log.e(TAG, t.toString());
            }
        });

         **/

/**
 //activity_main_tv_recycler_view    app_bar_main.xml   **/
/**
        final RecyclerView recyclerView_TV = (RecyclerView) findViewById(R.id.activity_main_tv_recycler_view);
        recyclerView_TV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


        Call<TVResponse> call_TV = apiService.getPopularTv(API_KEY);
        call_TV.enqueue(new Callback<TVResponse>() {
            @Override
            public void onResponse(Call<TVResponse> call_TV, Response<TVResponse> response) {

                if (!response.isSuccessful()) {
                    //System.out.println("Error");
                }

                if(response.isSuccessful())   {
                List<TV> tv = response.body().getResults();

                recyclerView_TV.setAdapter(new TVAdapter_main_activity(tv,
                        R.layout.activity_main_movies_get_airing_today_tv_list_item, getApplicationContext()));

                }else{
                    int statusCode = response.code();
                    switch(statusCode){
                        case 	401:
                            //Toast.makeText(getApplicationContext(),"Invalid API key: You must be granted a valid key.", Toast.LENGTH_SHORT).show();

                        case 	404:
                            //Toast.makeText(getApplicationContext(),"The resource you requested could not be found.", Toast.LENGTH_SHORT).show();
                    }
                }
**/

                /**
                recyclerView_TV.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView_TV, new RecyclerTouchListener.ClickListener() {

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
                        // on selecting a single album
                        // TrackListActivity will be launched to show tracks inside the album
                        Intent i = new Intent(getApplicationContext(), Popular_Movie.class);

                        // send album id to tracklist activity to get list of songs under that album
                        String tv_id = ((TextView) view.findViewById(R.id.tv_id)).getText().toString();
                        i.putExtra("tv_id", tv_id);
                        startActivity(i);
                    }

                }));

            }

            @Override
            public void onFailure(Call<TVResponse> call_TV, Throwable t) {
                //Log error here since request failed
                //Log.e(TAG, t.toString());
                //Toast.makeText(getApplicationContext(), "activity_main_tv_recycler_view", Toast.LENGTH_SHORT).show();
            }
        });
**/
        /**
        //TextView java_revenue, java_tagline, java_runtime;
        //java_original_title = (TextView) findViewById(R.id.revenue);
        //java_release_date = (TextView) findViewById(R.id.subtitle);
        //java_overview = (TextView) findViewById(R.id.runtime);

        java_backdrop_path = (ImageView) findViewById(R.id.backdrop_path_view);


        Call<MovieGetLatest> call_latest = apiService.getLatestMovies(API_KEY);
        call_latest.enqueue(new Callback<MovieGetLatest>() {
            @Override
            public void onResponse(Call<MovieGetLatest> call_latest, Response<MovieGetLatest> response) {

                if (!response.isSuccessful()) {
                    //System.out.println("Error");
                }
                if (response.isSuccessful()) {

                    try {
                        //Picasso.with(itemView.getContext()).load("https://image.tmdb.org/t/p/w500" + movies.get(position).getPosterPath()).into(holder.rating_image_View_java);
                        //Picasso.with(MainActivity).load("http://i.imgur.com/DvpvklR.png").into(imageView);
                        Picasso.with(getApplicationContext()).load("https://image.tmdb.org/t/p/w500" + response.body().getbackdrop_Path()).into(java_backdrop_path);

                        /**
                        //java_original_title.setText(response.body().getOriginalTitle());
                        //java_release_date.setText(response.body().getReleaseDate());
                        //java_overview.setText(response.body().getOverview());


                    } catch (Exception e) {
                        //Log.d("onResponse", "There is an error");
                        //e.printStackTrace();
                        //Toast.makeText(getApplicationContext(), "onResponse", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    int statusCode = response.code();
                    switch (statusCode) {
                        case 401:
                            //Toast.makeText(getApplicationContext(), "Invalid API key: You must be granted a valid key.", Toast.LENGTH_SHORT).show();

                        case 404:
                            //Toast.makeText(getApplicationContext(), "The resource you requested could not be found.", Toast.LENGTH_SHORT).show();
                    }
                }

            }

            @Override
            public void onFailure(Call<MovieGetLatest> call, Throwable t) {

            }
        });
         **/

        /**  Checking an Internet Connection in Android  **/
        checkConnection();

        /**  SEARCH 2017    **/
        //initViews();
        //loadJSON();

        /**
         * Enabling Search Filter

        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                //MainActivity.this.movieAdapterSearch.getFilter().filter(cs);

                startActivity(new Intent(MainActivity.this, SearchActivity.class));
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }
        });
* */
    }

    /**  Checking an Internet Connection in Android  **/
    protected boolean isOnline() {

        ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }

    public void checkConnection(){
        if(isOnline()){
            //Toast.makeText(MainActivity.this, "You are connected to Internet", Toast.LENGTH_SHORT).show();

        }else{
            //Toast.makeText(MainActivity.this, "You are not connected to Internet", Toast.LENGTH_SHORT).show();

            AlertDialog alertDialog = new AlertDialog.Builder(
                    MainActivity.this).create();

            // Setting Dialog Title
            alertDialog.setTitle("You are not connected to Internet.");

            // Setting Dialog Message
            alertDialog.setMessage("Please check your network settings.");

            // Setting Icon to Dialog
            alertDialog.setIcon(R.drawable.ic_report_problem_black_24dp);

            // Setting OK Button
            /**
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {
            // Write your code here to execute after dialog closed
                    Intent i_Button = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i_Button);
                     Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
                }
            });
             */

            // Showing Alert Message
            alertDialog.show();

        }

    }

    /***
     * Load navigation menu header information
     * like background image, profile image
     * name, website, notifications action view (dot)
     */
    private void loadNavHeader() {
        /**  Εδώ η αλλάγή.  **/
        // name, website
       // txtName.setText("Ravi Tamada");
        //txtWebsite.setText("www.androidhive.info");
        /**txtName.setText("Create by: Angel"); **/
        //txtWebsite.setText("www.picachu.info");


        // loading header background image
        Glide.with(this).load(urlNavHeaderBg)
                .crossFade()
               .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imgNavHeaderBg);

        // Loading profile image
        /**Glide.with(this).load(urlProfileImg)
                .crossFade()
                .thumbnail(0.5f)
                .bitmapTransform(new CircleTransform(this))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imgProfile);
        **/
    }

    /***
     * Returns respected fragment that user
     * selected from navigation menu
     */
    @SuppressLint("RestrictedApi")
    private void loadHomeFragment() {
        // selecting appropriate nav menu item
        selectNavMenu();

        // set toolbar title
        setToolbarTitle();

        // if user select the current navigation menu again, don't do anything
        // just close the navigation drawer
        if (getSupportFragmentManager().findFragmentByTag(CURRENT_TAG) != null) {
            drawer.closeDrawers();

            return;
        }

        //Closing drawer on item click
        drawer.closeDrawers();

        // refresh toolbar menu
        invalidateOptionsMenu();
    }

    private void setToolbarTitle() {
        getSupportActionBar().setTitle(activityTitles[navItemIndex]);
    }

    private void selectNavMenu() {
        navigationView.getMenu().getItem(navItemIndex).setChecked(true);
    }

    private void setUpNavigationView() {
        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {
                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.home:
                        navItemIndex = 0;
                        CURRENT_TAG = TAG_HOME;
                        break;

                    case R.id.nav_about_us:
                        // launch new intent instead of loading fragment
                        startActivity(new Intent(MainActivity.this, AboutUsActivity.class));
                        drawer.closeDrawers();
                        return true;
                    case R.id.nav_privacy_policy:
                        // launch new intent instead of loading fragment
                        startActivity(new Intent(MainActivity.this, PrivacyPolicyActivity.class));
                        drawer.closeDrawers();
                        return true;

                    /**  search for delete **/
                    case R.id.search:
                        // launch new intent instead of loading fragment
                        startActivity(new Intent(MainActivity.this, SearchActivity.class));
                        //drawer.closeDrawers();
                        return true;


                  /**  Πέντε κατηγορίες ταινιών.     movies  FROM  activity_main_drawer.xml **/

                    case R.id.nav_movies_Get_Now_Playing:
                        // launch new intent instead of loading fragment
                        startActivity(new Intent(MainActivity.this, Now_playing_Movie.class));
                        drawer.closeDrawers();
                        return true;

                    case R.id.nav_movies_Get_Popular:
                        // launch new intent instead of loading fragment
                        startActivity(new Intent(MainActivity.this, Popular_Movie.class));
                        drawer.closeDrawers();
                        return true;

                    case R.id.nav_movies_Get_Top_Rated:
                        // launch new intent instead of loading fragment
                        startActivity(new Intent(MainActivity.this, Top_Rated_Movie.class));
                        drawer.closeDrawers();
                        return true;

                    case R.id.nav_movies_Get_Upcoming:
                        // launch new intent instead of loading fragment
                        startActivity(new Intent(MainActivity.this, Upcoming_Movie.class));
                        drawer.closeDrawers();
                        return true;

                    /**  Δύο κατηγορίες προσώπων.   people  FROM  activity_main_drawer.xml

                    case R.id.nav_people_Get_Popular:
                        // launch new intent instead of loading fragment
                        startActivity(new Intent(MainActivity.this, Popular_People.class));
                        drawer.closeDrawers();
                        return true;
                     **/
                    /**  Πέντε κατηγορίες για την τηλεόραση.     tv  FROM  activity_main_drawer.xml **/

                    case R.id.nav_tv_Get_TV_Airing_Today:
                        // launch new intent instead of loading fragment
                        startActivity(new Intent(MainActivity.this, TV_Airing_Today_TV.class));
                        drawer.closeDrawers();
                        return true;

                    case R.id.nav_tv_Get_Popular:
                        // launch new intent instead of loading fragment
                        startActivity(new Intent(MainActivity.this, Popular_TV.class));
                        drawer.closeDrawers();
                        return true;

                    case R.id.nav_tv_Get_Top_Rated:
                        // launch new intent instead of loading fragment
                        startActivity(new Intent(MainActivity.this, Top_Rated_TV.class));
                        drawer.closeDrawers();
                        return true;

                    case R.id.nav_tv_Get_TV_On_The_Air:
                        // launch new intent instead of loading fragment
                        startActivity(new Intent(MainActivity.this, TV_On_The_Air_TV.class));
                        drawer.closeDrawers();
                        return true;

                    default:
                        navItemIndex = 0;
                }

                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }
                menuItem.setChecked(true);

                loadHomeFragment();

                return true;
            }
        });


        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }
        };

        /**  Εδώ η αλλάγή.  **/
        //Setting the actionbarToggle to drawer layout
        drawer.addDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessary or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawers();
            return;
        }

        // This code loads home fragment when back key is pressed
        // when user is in other fragment than home
        if (shouldLoadHomeFragOnBackPress) {
            // checking if user is on other navigation menu
            // rather than home
            if (navItemIndex != 0) {
                navItemIndex = 0;
                CURRENT_TAG = TAG_HOME;
                loadHomeFragment();
                return;
            }
        }

        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        // when fragment is notifications, load the menu created for notifications
        if (navItemIndex == 3) {
            getMenuInflater().inflate(R.menu.notifications, menu);
        }

        /**  SEARCH    **/
        //MenuInflater menuInflater = getMenuInflater();
        //menuInflater.inflate(R.menu.main, menu);


        getMenuInflater().inflate(R.menu.main, menu);

        MenuItem search = menu.findItem(R.id.search);


        SearchView searchView = (SearchView) MenuItemCompat.getActionView(search);
        search(searchView);

        return true;
    }

    /**  SEARCH     **/
    private void search(SearchView searchView) {

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                //Toast.makeText(MainActivity.this, "Search is Selected", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(MainActivity.this,SearchActivity.class);
                /** FLAG_ACTIVITΙES  **/

                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED
                        | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_TASK_ON_HOME);

                String api_key_search = query.toString();
                i.putExtra("api_key_search", api_key_search);

                //Toast.makeText(MainActivity.this, api_key_search, Toast.LENGTH_SHORT).show();

                startActivity(i);

                return true;
            }

            @Override
            public boolean onQueryTextChange(final String newText) {

                return false;
            }
        });
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
