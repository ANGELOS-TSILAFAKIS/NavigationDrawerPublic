package info.android_angel.navigationdrawer.rest;

/**
 * Created by ANGELOS on 2017.
 */

import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;

import retrofit2.converter.gson.GsonConverterFactory;



public class ApiClient {

    public static final String BASE_URL = "https://api.themoviedb.org/3/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}

