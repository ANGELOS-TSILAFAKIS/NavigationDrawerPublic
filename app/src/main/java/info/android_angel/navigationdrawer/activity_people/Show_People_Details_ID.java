package info.android_angel.navigationdrawer.activity_people;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import info.android_angel.navigationdrawer.model_people_id_get_details.PeopleGetDetails;
import info.android_angel.navigationdrawer.rest.ApiClient;
import info.android_angel.navigationdrawer.rest.ApiInterface;
import info.android_angel.navigationdrawer.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//ads
/**
 *  Created by ANGELOS on 2016.
 */

public class Show_People_Details_ID extends AppCompatActivity {
    TextView java_people_id;
    TextView java_biography, java_birthday, java_deathday;
    TextView java_gender, java_homepage, java_name;
    TextView java_place_of_birth, java_popularity;

    // private ImageView profile_path;
    private ImageView java_profile_path;

    // Album id    KEY_MOVIE_ID
    String people_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.nav_people_get_details_id_and_more);

        //TextView java_id;
        java_people_id = (TextView) findViewById(R.id.people_id);

        //TextView java_biography, java_birthday, java_deathday;
        java_biography = (TextView) findViewById(R.id.biography);
        java_birthday = (TextView) findViewById(R.id.birthday);
        java_deathday = (TextView) findViewById(R.id.deathday);

        //TextView java_gender, java_homepage, java_name;
        java_gender = (TextView) findViewById(R.id.gender);
        java_homepage = (TextView) findViewById(R.id.homepage);
        java_name = (TextView) findViewById(R.id.name);

        //TextView java_place_of_birth, java_popularity;
        java_place_of_birth = (TextView) findViewById(R.id.place_of_birth);
        java_popularity = (TextView) findViewById(R.id.popularity);

        java_profile_path = (ImageView) findViewById(R.id.profile_path_view);

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
        Intent i_people = getIntent();
        people_id = i_people.getStringExtra("people_id");
        //people_id = "1245";
        //Toast.makeText(getApplicationContext(), people_id, Toast.LENGTH_SHORT).show();


        /** GET
         /person/{person_id} **/
        Call<PeopleGetDetails> call = apiService.getDetailstPeopleId(people_id, getResources().getString(R.string.API_KEY));
        call.enqueue(new Callback<PeopleGetDetails>() {
            @Override
            public void onResponse(Call<PeopleGetDetails> call, Response<PeopleGetDetails> response) {

                try {
                    if (response.isSuccessful()) {

                        Picasso.with(getApplicationContext()).load("https://image.tmdb.org/t/p/w300" + response.body().getProfilePath()).into(java_profile_path);

                        //TextView java_id;
                        java_people_id.setText(response.body().getId().toString());

                        //TextView java_biography, java_birthday, java_deathday;
                        java_biography.setText(response.body().getBiography());
                        java_birthday.setText(response.body().getBirthday());
                        java_deathday.setText(response.body().getDeathday());

                        //TextView java_gender, java_homepage, java_name;
                        java_gender.setText(response.body().getGender().toString());
                        java_homepage.setText(response.body().getHomepage());
                        java_name.setText(response.body().getName());

                        //TextView java_place_of_birth, java_popularity;
                        java_place_of_birth.setText(response.body().getPlaceOfBirth());
                        java_popularity.setText(response.body().getPopularity().toString());

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
            public void onFailure(Call<PeopleGetDetails> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "PeopleGetDetails", Toast.LENGTH_SHORT).show();
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
