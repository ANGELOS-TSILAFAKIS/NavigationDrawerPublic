package info.android_angel.navigationdrawer.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;

import info.android_angel.navigationdrawer.R;
import info.android_angel.navigationdrawer.rest.ApiClient;
import info.android_angel.navigationdrawer.rest.ApiInterface;

/**
 * Created by ANGELOS on 8/12/2016.
 */

public class AboutUsActivity extends AppCompatActivity {


    // TV GET LATEST IMAGE
    ImageView  java_backdrop_path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);


        /**   LATEST TV

        java_backdrop_path = (ImageView) findViewById(R.id.backdrop_path_view);

        Call<TVGetLatest> call_latest = apiService.getLatestTv(API_KEY);
        call_latest.enqueue(new Callback<TVGetLatest>() {
            @Override
            public void onResponse(Call<TVGetLatest> call_latest, Response<TVGetLatest> response) {

                if (!response.isSuccessful()) {
                    //System.out.println("Error");
                }
                if (response.isSuccessful()) {

                    try {
                        Picasso.with(getApplicationContext()).load("https://image.tmdb.org/t/p/w500" + response.body().getbackdrop_Path()).into(java_backdrop_path);

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
            public void onFailure(Call<TVGetLatest> call, Throwable t) {

            }
        });

         **/

    }

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
