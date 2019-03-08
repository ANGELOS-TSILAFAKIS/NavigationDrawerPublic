package info.android_angel.navigationdrawer.activity_tv;

/**
 * Created by ANGELOS
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import info.android_angel.navigationdrawer.model_tv_id_get_details.TVGetDetails;
import info.android_angel.navigationdrawer.rest.ApiClient;
import info.android_angel.navigationdrawer.R;
import info.android_angel.navigationdrawer.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Show_TV_Details_ID extends AppCompatActivity {
    TextView java_tv_id;
    TextView java_first_air_date, java_homepage, java_last_air_date;
    TextView java_name, java_number_of_episodes, java_number_of_seasons;
    TextView java_original_language, java_original_name;
    TextView java_overview, java_popularity;
    TextView java_vote_average, java_vote_count;

    // "backdrop_path": "/lyA5Bw5paTzsVFGYHx3EbZNR9mK.jpg",
    private ImageView java_backdrop_path;

    // Album id    KEY_TV_ID
    String tv_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.nav_tv_get_details_id_and_more);

        //TextView java_id;
        //java_tv_id = (TextView) findViewById(R.id.tv_id);

        // TextView java_first_air_date, java_homepage, java_last_air_date;
        java_first_air_date = (TextView) findViewById(R.id.first_air_date);
        java_homepage = (TextView) findViewById(R.id.homepage);
        java_last_air_date = (TextView) findViewById(R.id.last_air_date);

        //TextView java_name, java_number_of_episodes, java_number_of_seasons;
        java_name = (TextView) findViewById(R.id.name);
        java_number_of_episodes = (TextView) findViewById(R.id.number_of_episodes);
        java_number_of_seasons = (TextView) findViewById(R.id.number_of_seasons);

        //TextView java_original_language, java_original_name;
        java_original_language = (TextView) findViewById(R.id.original_language);
        java_original_name = (TextView) findViewById(R.id.original_name);

        //TextView java_overview, java_popularity;
        java_overview = (TextView) findViewById(R.id.overview);
        java_popularity = (TextView) findViewById(R.id.popularity);

        //TextView java_vote_average, java_vote_count;
        java_vote_average = (TextView) findViewById(R.id.vote_average);
        java_vote_count = (TextView) findViewById(R.id.vote_count);

        java_backdrop_path = (ImageView) findViewById(R.id.backdrop_path_view);

        /**  Προσοχή εδώ η αλλάγή.............  **/
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (getResources().getString(R.string.API_KEY).isEmpty()) {
            //Toast.makeText(getApplicationContext(), "Please obtain your API KEY from themoviedb.org first!", Toast.LENGTH_LONG).show();
            return;
        }

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        //intent.getStringExtra(Now_playing_ID.KEY_MOVIE_Overview);
        // Get album id
        Intent i_tv = getIntent();
        tv_id = i_tv.getStringExtra("tv_id");
        //people_id = "1245";
        //Toast.makeText(getApplicationContext(), people_id, Toast.LENGTH_SHORT).show();


        /** GET
         /person/{person_id} **/
        Call<TVGetDetails> call = apiService.getDetailstTVId(tv_id, getResources().getString(R.string.API_KEY));
        call.enqueue(new Callback<TVGetDetails>() {
            @Override
            public void onResponse(Call<TVGetDetails> call, Response<TVGetDetails> response) {

                try {
                    if (response.isSuccessful()) {

                        Picasso.with(getApplicationContext()).load("https://image.tmdb.org/t/p/w300" + response.body().getBackdropPath()).into(java_backdrop_path);

                        //TextView java_id;
                        java_tv_id.setText(response.body().getId().toString());

                        // TextView java_first_air_date, java_homepage, java_last_air_date;
                        java_first_air_date.setText(response.body().getFirstAirDate());
                        java_homepage.setText(response.body().getHomepage());
                        java_last_air_date.setText(response.body().getLastAirDate());

                        //TextView java_name, java_number_of_episodes, java_number_of_seasons;
                        java_name.setText(response.body().getName());
                        java_number_of_episodes.setText(response.body().getNumberOfEpisodes().toString());
                        java_number_of_seasons.setText(response.body().getNumberOfSeasons().toString());

                        //TextView java_original_language, java_original_name;
                        java_original_language.setText(response.body().getOriginalLanguage());
                        java_original_name.setText(response.body().getOriginalName());

                        //TextView java_overview, java_popularity;
                        java_overview.setText(response.body().getOverview());
                        java_popularity.setText(response.body().getPopularity().toString());

                        //TextView java_vote_average, java_vote_count;
                        java_vote_average.setText(response.body().getVoteAverage().toString());
                        java_vote_count.setText(response.body().getVoteCount().toString());

                    } else {
                        int statusCode = response.code();
                        switch (statusCode) {
                            //case 	401:
                                //Toast.makeText(getApplicationContext(),"Invalid API key: You must be granted a valid key.", Toast.LENGTH_SHORT).show();

                            //case 	404:
                                //Toast.makeText(getApplicationContext(),"The resource you requested could not be found.", Toast.LENGTH_SHORT).show();
                            case 401:
                                Toast.makeText(getApplicationContext(), "Authentication failed: You do not have permissions to access the service.", Toast.LENGTH_SHORT).show();

                            case 404:
                                Toast.makeText(getApplicationContext(), "The resource you requested could not be found. Invalid id: The pre-requisite id is invalid or not found.", Toast.LENGTH_SHORT).show();
                            case 503:
                                Toast.makeText(getApplicationContext(), "Service offline: This service is temporarily offline, try again later.", Toast.LENGTH_SHORT).show();

                            case 429:
                                Toast.makeText(getApplicationContext(), "Your request count (#) is over the allowed limit of (40).", Toast.LENGTH_SHORT).show();
                            case 400:
                                Toast.makeText(getApplicationContext(), "Too many append to response objects: The maximum number of remote calls is 20.", Toast.LENGTH_SHORT).show();

                        }
                    }

                } catch (Exception e) {
                    Log.d("onResponse", "There is an error");
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<TVGetDetails> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "TVGetDetails", Toast.LENGTH_SHORT).show();
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