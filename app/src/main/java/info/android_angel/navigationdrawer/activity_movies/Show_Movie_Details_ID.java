package info.android_angel.navigationdrawer.activity_movies;

/**
 * Created by ANGELOS  on 2017.
 */

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import info.android_angel.navigationdrawer.R;
import info.android_angel.navigationdrawer.adapter_id_movies.credits_id_adapter.CreditsAdapter_cast;
import info.android_angel.navigationdrawer.adapter_id_movies.details_id_adapter.DetailsAdapter_genres;
import info.android_angel.navigationdrawer.adapter_id_movies.details_id_adapter.DetailsAdapter_production_companies;
import info.android_angel.navigationdrawer.adapter_id_movies.details_id_adapter.DetailsAdapter_production_countries;
import info.android_angel.navigationdrawer.adapter_id_movies.details_id_adapter.DetailsAdapter_spoken_languages;
import info.android_angel.navigationdrawer.adapter_id_movies.reviews_id_adapter.ReviewsAdapter;
import info.android_angel.navigationdrawer.model_movie_id_get_credits.MovieGetCredits;
import info.android_angel.navigationdrawer.model_movie_id_get_credits.MovieGetCredits_cast;
import info.android_angel.navigationdrawer.model_movie_id_get_details.MovieGetDetails;
import info.android_angel.navigationdrawer.model_movie_id_get_details.MovieGetDetails_genres;
import info.android_angel.navigationdrawer.model_movie_id_get_details.MovieGetDetails_production_companies;
import info.android_angel.navigationdrawer.model_movie_id_get_details.MovieGetDetails_production_countries;
import info.android_angel.navigationdrawer.model_movie_id_get_details.MovieGetDetails_spoken_languages;
import info.android_angel.navigationdrawer.model_movie_id_get_reviews.MovieGetReviews;
import info.android_angel.navigationdrawer.model_movie_id_get_reviews.MovieGetReviews_results;
import info.android_angel.navigationdrawer.rest.ApiClient;
import info.android_angel.navigationdrawer.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Show_Movie_Details_ID extends AppCompatActivity {

    TextView java_original_title, java_release_date, java_overview, java_vote_average;
    TextView java_budge, java_homepage, java_popularity;
    TextView java_revenue, java_tagline, java_runtime;

    TextView java_imdb_id,java_tmdb_id;
    Button button;

    // private ImageView backdrop_path;
    private ImageView java_backdrop_path;

    private static final String TAG = Show_Movie_Details_ID.class.getSimpleName();

    // Album id    KEY_MOVIE_ID
    String movie_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_movies_get_details_id_and_more);

        //TextView java_original_title, java_release_date, java_overview, java_vote_average;
        java_original_title = (TextView) findViewById(R.id.original_title);
        java_release_date = (TextView) findViewById(R.id.release_date);
        java_overview = (TextView) findViewById(R.id.overview);
        java_vote_average = (TextView) findViewById(R.id.vote_average);

        //TextView java_budge, java_homepage, java_popularity;
        java_budge = (TextView) findViewById(R.id.budget);
        java_homepage = (TextView) findViewById(R.id.homepage);
        java_popularity = (TextView) findViewById(R.id.popularity);

        //TextView java_revenue, java_tagline, java_runtime;
        java_revenue = (TextView) findViewById(R.id.revenue);
        //java_tagline = (TextView) findViewById(R.id.subtitle);
        //java_runtime = (TextView) findViewById(R.id.runtime);

        java_backdrop_path = (ImageView) findViewById(R.id.backdrop_path_view);

        /**  Προσοχή εδώ η αλλάγή.............  **/
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (getResources().getString(R.string.API_KEY).isEmpty()) {
            //Toast.makeText(getApplicationContext(), "Please obtain your API KEY from themoviedb.org first!", Toast.LENGTH_LONG).show();
            return;
        }

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        /** GET
         /movie/latest
         Call<MovieGetLatest> call = apiService.getLatestMovies(API_KEY);
         call.enqueue(new Callback<MovieGetLatest>() {
         **/

        //intent.getStringExtra(Now_playing_ID.KEY_MOVIE_Overview);
        // Get album id
        Intent i = getIntent();
        movie_id = i.getStringExtra("movie_id");
        //key_movie_id = "278";
        //Toast.makeText(getApplicationContext(), movie_id, Toast.LENGTH_SHORT).show();

        //production_companies
        final RecyclerView recyclerView_production_companies = (RecyclerView) findViewById(R.id.production_companies_recycler_view);
        recyclerView_production_companies.setLayoutManager(new LinearLayoutManager(this));

        //production_countries
        final RecyclerView recyclerView_production_countries = (RecyclerView) findViewById(R.id.production_countries_recycler_view);
        recyclerView_production_countries.setLayoutManager(new LinearLayoutManager(this));

        //genres   είδη.
        final RecyclerView recyclerView_genres = (RecyclerView) findViewById(R.id.genres_recycler_view);
        recyclerView_genres.setLayoutManager(new LinearLayoutManager(this));

        //spoken_languages
        final RecyclerView recyclerView_spoken_languages = (RecyclerView) findViewById(R.id.spoken_languages_recycler_view);
        recyclerView_spoken_languages.setLayoutManager(new LinearLayoutManager(this));

        //belongs_to_collection
        //final RecyclerView recyclerView_belongs_to_collection = (RecyclerView) findViewById(R.id.belongs_to_collection_recycler_view);
        //recyclerView_belongs_to_collection.setLayoutManager(new LinearLayoutManager(this));

        /** GET
         /movie/{movie_id}  ok ok ok
         java_tagline
         java_runtime**/
        Call<MovieGetDetails> call = apiService.getDetailstMoviesId(movie_id, getResources().getString(R.string.API_KEY));
        call.enqueue(new Callback<MovieGetDetails>() {
            @Override
            public void onResponse(Call<MovieGetDetails> call, Response<MovieGetDetails> response) {

                try {
                    if(response.isSuccessful())   {

                    Picasso.with(getApplicationContext()).load("https://image.tmdb.org/t/p/w1280" + response.body().getBackdropPath()).into(java_backdrop_path);

                    java_original_title.setText(response.body().getOriginalTitle());
                    java_release_date.setText(response.body().getReleaseDate());
                    java_overview.setText(response.body().getOverview());
                    java_vote_average.setText(response.body().getVoteAverage().toString());

                    java_budge.setText(response.body().getBudget().toString());
                    java_homepage.setText(response.body().getHomepage());
                    java_popularity.setText(response.body().getPopularity().toString());


                    /**  recyclerView_production_companies  **/
                    List<MovieGetDetails_production_companies> movies_Details_production_companies = response.body().getProductionCompanies();

                    recyclerView_production_companies.setAdapter(new DetailsAdapter_production_companies(movies_Details_production_companies, R.layout.movies_horizontal_id_details, getApplicationContext()));

                    /**  recyclerView_production_countries  **/
                    List<MovieGetDetails_production_countries> movies_Details_production_countries = response.body().getProductionCountries();

                    recyclerView_production_countries.setAdapter(new DetailsAdapter_production_countries(movies_Details_production_countries, R.layout.movies_horizontal_id_details, getApplicationContext()));

                    /**  recyclerView_genres  **/
                    List<MovieGetDetails_genres> movies_Details_genres = response.body().getGenres();

                    recyclerView_genres.setAdapter(new DetailsAdapter_genres(movies_Details_genres, R.layout.movies_horizontal_id_details, getApplicationContext()));

                    /**  recyclerView_spoken_languages  **/
                    List<MovieGetDetails_spoken_languages> movies_Details_spoken_languages = response.body().getSpokenLanguages();

                    recyclerView_spoken_languages.setAdapter(new DetailsAdapter_spoken_languages(movies_Details_spoken_languages, R.layout.movies_horizontal_id_details, getApplicationContext()));


                    java_revenue.setText(response.body().getRevenue().toString());
                    //java_tagline.setText(response.body().getTagline());
                    //java_runtime.setText(response.body().getRuntime().toString());

                    }else{
                        int statusCode = response.code();
                        switch(statusCode){
                            case 	401:
                                //Toast.makeText(getApplicationContext(),"Invalid API key: You must be granted a valid key.", Toast.LENGTH_SHORT).show();

                            case 	404:
                                //Toast.makeText(getApplicationContext(),"The resource you requested could not be found.", Toast.LENGTH_SHORT).show();

                        }
                    }

                } catch (Exception e) {
                   // Log.d("onResponse", "There is an error");
                    //e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<MovieGetDetails> call, Throwable t) {
                //Toast.makeText(getApplicationContext(), "MovieGetDetails", Toast.LENGTH_SHORT).show();
            }

        });


         //getMovieSimilar Για να έχουμε LinearLayoutManager.HORIZONTAL
        /**
         final RecyclerView recyclerView_Similar = (RecyclerView) findViewById(R.id.similar_recycler_view);
        recyclerView_Similar.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        Call<MovieGetSimilarMovies> call_Similar = apiService.getSimilarMoviesId(movie_id, API_KEY);
        call_Similar.enqueue(new Callback<MovieGetSimilarMovies>() {
            @Override
            public void onResponse(Call<MovieGetSimilarMovies> call_Similar, Response<MovieGetSimilarMovies> response) {

                if (!response.isSuccessful()) {
                    //System.out.println("Error");
                    Toast.makeText(getApplicationContext(),"MovieGetSimilarMovies", Toast.LENGTH_SHORT).show();

                }

                if(response.isSuccessful())   {

                List<MovieGetSimilarMovies_results> movies_similar = response.body().getResults();

                 recyclerView_Similar.setAdapter(new SimilarAdapter(movies_similar, R.layout.movies_horizontal_id_similar, getApplicationContext()));

                }else{
                    int statusCode = response.code();
                    switch(statusCode){
                        case 	401:
                            //Toast.makeText(getApplicationContext(),"Invalid API key: You must be granted a valid key.", Toast.LENGTH_SHORT).show();

                        case 	404:
                            //Toast.makeText(getApplicationContext(),"The resource you requested could not be found.", Toast.LENGTH_SHORT).show();

                    }
                }

            }
            @Override
            public void onFailure(Call<MovieGetSimilarMovies> call_Similar, Throwable t) {
                //Toast.makeText(getApplicationContext(), "MovieGetSimilarMovies   onFailure", Toast.LENGTH_SHORT).show();
            }

        });

         * **/

        /**getMovieCredits Για να έχουμε LinearLayoutManager.HORIZONTAL
        **/
         final RecyclerView recyclerView_Credits_cast = (RecyclerView) findViewById(R.id.credits_cast_recycler_view);
        recyclerView_Credits_cast.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

         Call<MovieGetCredits> call_Credits_cast = apiService.getCreditsMoviesId(movie_id, getResources().getString(R.string.API_KEY));
        call_Credits_cast.enqueue(new Callback<MovieGetCredits>() {
            @Override
            public void onResponse(Call<MovieGetCredits> call_Credits_cast, Response<MovieGetCredits> response) {

                if (!response.isSuccessful()) {
                    //System.out.println("Error");
                }

                if (response.isSuccessful()) {

                    List<MovieGetCredits_cast> movies_cast = response.body().getCast();

                    recyclerView_Credits_cast.setAdapter(new CreditsAdapter_cast(movies_cast, R.layout.movies_horizontal_id_credits_cast, getApplicationContext()));

                } else {
                    int statusCode = response.code();
                    switch (statusCode) {
                        case 401:
                            //Toast.makeText(getApplicationContext(), "Invalid API key: You must be granted a valid key.", Toast.LENGTH_SHORT).show();
                        case 404:
                            //Toast.makeText(getApplicationContext(), "The resource you requested could not be found.", Toast.LENGTH_SHORT).show();
                    }
                }

                /**   2017 11.04
                recyclerView_Credits_cast.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView_Credits_cast, new RecyclerTouchListener.ClickListener() {

                    @Override
                    public void onClick(View view, int position) {
                        // on selecting a single album
                        // TrackListActivity will be launched to show tracks inside the album
                        Intent i_people = new Intent(getApplicationContext(), Show_People_Details_ID.class);

                        String people_id = ((TextView) view.findViewById(R.id.people_id)).getText().toString();
                        i_people.putExtra("people_id", people_id);
                        //i.putExtra(KEY_MOVIE_ID, movies_response.get(position).getId());

                        //Toast.makeText(getApplicationContext(),people_id, Toast.LENGTH_SHORT).show();

                        startActivity(i_people);

                    }

                    @Override
                    public void onLongClick(View view, int position) {
                        //on selecting a single album
                        //TrackListActivity will be launched to show tracks inside the album
                        //Intent i = new Intent(getApplicationContext(), Popular_Movie.class);

                        // send album id to tracklist activity to get list of songs under that album
                        //String movie_id = ((TextView) view.findViewById(R.id.movie_id)).getText().toString();
                        //i.putExtra("movie_id", movie_id);

                        //startActivity(i);
                    }
                }));
                 **/

            }

            @Override
            public void onFailure(Call<MovieGetCredits> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });

        //RecommendationsAdapter
        /**getMovieRecommendations Για να έχουμε LinearLayoutManager.HORIZONTAL

        final RecyclerView recyclerView_Recommendations = (RecyclerView) findViewById(R.id.recommendations_recycler_view);
        recyclerView_Recommendations.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        Call<MovieGetRecommendations> call_recommendations = apiService.getRecommendationsMoviesId(movie_id, API_KEY);
        call_recommendations.enqueue(new Callback<MovieGetRecommendations>() {
            @Override
            public void onResponse(Call<MovieGetRecommendations> call_Credits, Response<MovieGetRecommendations> response) {

                if (!response.isSuccessful()) {
                    System.out.println("Error");
                }

                if(response.isSuccessful())   {


                List<MovieGetRecommendations_results> movies_recommendations = response.body().getResults();

                recyclerView_Recommendations.setAdapter(new RecommendationsAdapter(movies_recommendations, R.layout.movies_horizontal_id_recommendations, getApplicationContext()));

                }else{
                    int statusCode = response.code();
                    switch(statusCode){
                        case 	401:
                            Toast.makeText(getApplicationContext(),"Invalid API key: You must be granted a valid key.", Toast.LENGTH_SHORT).show();

                        case 	404:
                            Toast.makeText(getApplicationContext(),"The resource you requested could not be found.", Toast.LENGTH_SHORT).show();

                    }
                }

            }
            @Override
            public void onFailure(Call<MovieGetRecommendations> call_Credits, Throwable t) {
                //Toast.makeText(getApplicationContext(), "MovieGetRecommendations", Toast.LENGTH_SHORT).show();
            }

        });
         **/

        //ImagesAdapter
        /**getMovieImages Για να έχουμε LinearLayoutManager.HORIZONTAL

        final RecyclerView recyclerView_Images = (RecyclerView) findViewById(R.id.images_recycler_view);
        recyclerView_Images.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        Call<MovieGetImages> call_Images = apiService.getLatestImagesId(movie_id, API_KEY);
        call_Images.enqueue(new Callback<MovieGetImages>() {
            @Override
            public void onResponse(Call<MovieGetImages> call_Images, Response<MovieGetImages> response) {

                if (!response.isSuccessful()) {
                    System.out.println("Error");
                }

                if(response.isSuccessful())   {

                List<MovieGetImages_backdrops> movies_images = response.body().getBackdrops();

                recyclerView_Images.setAdapter(new ImagesAdapter(movies_images, R.layout.movies_horizontal_id_images, getApplicationContext()));


                  //https://www.themoviedb.org/documentation/api/status-codes
                }else{
                    int statusCode = response.code();
                    switch(statusCode){
                        case 	401:
                            Toast.makeText(getApplicationContext(),"Invalid API key: You must be granted a valid key.", Toast.LENGTH_SHORT).show();

                        case 	404:
                            Toast.makeText(getApplicationContext(),"The resource you requested could not be found.", Toast.LENGTH_SHORT).show();
                    }
                }

            }
            @Override
            public void onFailure(Call<MovieGetImages> call_Credits, Throwable t) {
                //Toast.makeText(getApplicationContext(), "MovieGetImages", Toast.LENGTH_SHORT).show();
            }

        });
         **/


        //ReviewsAdapter    OK OK OK
        /**getMovieReviews Για να έχουμε LinearLayoutManager.HORIZONTAL
         **/
        final RecyclerView recyclerView_Reviews = (RecyclerView) findViewById(R.id.reviews_recycler_view);
        recyclerView_Reviews.setLayoutManager(new LinearLayoutManager(this));

        Call<MovieGetReviews> call_Reviews = apiService.getReviewsMoviesId(movie_id, getResources().getString(R.string.API_KEY));
        call_Reviews.enqueue(new Callback<MovieGetReviews>() {
            @Override
            public void onResponse(Call<MovieGetReviews> call_Reviews, Response<MovieGetReviews> response) {

                if (!response.isSuccessful()) {
                    //System.out.println("Error");
                }

                if(response.isSuccessful())   {

                    List<MovieGetReviews_results> movies_reviews = response.body().getResults();

                    recyclerView_Reviews.setAdapter(new ReviewsAdapter(movies_reviews, R.layout.movies_horizontal_id_reviews, getApplicationContext()));

                }else{
                    int statusCode = response.code();
                        switch(statusCode){
                            //case 	401:
                                //Toast.makeText(getApplicationContext(),"Invalid API key: You must be granted a valid key.", Toast.LENGTH_SHORT).show();

                            //case 	404:
                                //Toast.makeText(getApplicationContext(),"The resource you requested could not be found.", Toast.LENGTH_SHORT).show();
                            case 401:
                                //Toast.makeText(getApplicationContext(), "Authentication failed: You do not have permissions to access the service.", Toast.LENGTH_SHORT).show();

                            case 404:
                                //Toast.makeText(getApplicationContext(), "The resource you requested could not be found. Invalid id: The pre-requisite id is invalid or not found.", Toast.LENGTH_SHORT).show();
                            case 503:
                                //Toast.makeText(getApplicationContext(), "Service offline: This service is temporarily offline, try again later.", Toast.LENGTH_SHORT).show();

                            case 429:
                                //Toast.makeText(getApplicationContext(), "Your request count (#) is over the allowed limit of (40).", Toast.LENGTH_SHORT).show();
                            case 400:
                                //Toast.makeText(getApplicationContext(), "Too many append to response objects: The maximum number of remote calls is 20.", Toast.LENGTH_SHORT).show();

                        }
                }


            }
            @Override
            public void onFailure(Call<MovieGetReviews> call_Credits, Throwable t) {
                //Toast.makeText(getApplicationContext(), "MovieGetReviews", Toast.LENGTH_SHORT).show();
            }

        });



        //Credits_crew     OK OK OK
        /**getCredits_crew Για να έχουμε LinearLayoutManager.HORIZONTAL
         */
        /**
        final RecyclerView recyclerView_Credits_crew = (RecyclerView) findViewById(R.id.credits_crew_recycler_view);
        recyclerView_Credits_crew.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        Call<MovieGetCredits> call_Credits_crew = apiService.getCreditsMoviesId(movie_id, API_KEY);
        call_Credits_crew.enqueue(new Callback<MovieGetCredits>() {
            @Override
            public void onResponse(Call<MovieGetCredits> call_Similar_crew, Response<MovieGetCredits> response) {

                if (!response.isSuccessful()) {
                    System.out.println("Error");
                }

                if(response.isSuccessful())   {

                List<MovieGetCredits_crew> movies_credits_crew = response.body().getCrew();

                    recyclerView_Credits_crew.setAdapter(new CreditsAdapter_crew(movies_credits_crew, R.layout.movies_horizontal_id_credits_crew, getApplicationContext()));

                }else{
                    int statusCode = response.code();
                    switch(statusCode){
                        case 	401:
                            Toast.makeText(getApplicationContext(),"Invalid API key: You must be granted a valid key.", Toast.LENGTH_SHORT).show();

                        case 	404:
                            Toast.makeText(getApplicationContext(),"The resource you requested could not be found.", Toast.LENGTH_SHORT).show();

                    }
                }

            }
            @Override
            public void onFailure(Call<MovieGetCredits> call_Credits_crew, Throwable t) {
               // Toast.makeText(getApplicationContext(), "MovieGetSimilarMovies", Toast.LENGTH_SHORT).show();
            }

        });
        **/


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


