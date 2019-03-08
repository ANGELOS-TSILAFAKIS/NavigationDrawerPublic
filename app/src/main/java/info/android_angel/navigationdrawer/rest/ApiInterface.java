package info.android_angel.navigationdrawer.rest;

/**
 * Created by ANGELOS on 2017.
 */

import info.android_angel.navigationdrawer.model.MoviesResponse;
import info.android_angel.navigationdrawer.model.MultiResponse;
import info.android_angel.navigationdrawer.model.PeopleResponse;
import info.android_angel.navigationdrawer.model.TVResponse;
import info.android_angel.navigationdrawer.model_TV_get_latest.TVGetLatest;
import info.android_angel.navigationdrawer.model_movie_get_latest.MovieGetLatest;
import info.android_angel.navigationdrawer.model_movie_id_get_credits.MovieGetCredits;
import info.android_angel.navigationdrawer.model_movie_id_get_details.MovieGetDetails;
import info.android_angel.navigationdrawer.model_movie_id_get_images.MovieGetImages;
import info.android_angel.navigationdrawer.model_movie_id_get_recommendations.MovieGetRecommendations;
import info.android_angel.navigationdrawer.model_movie_id_get_reviews.MovieGetReviews;
import info.android_angel.navigationdrawer.model_movie_id_get_similar.MovieGetSimilarMovies;
import info.android_angel.navigationdrawer.model_people_id_get_details.PeopleGetDetails;
import info.android_angel.navigationdrawer.model_tv_id_get_details.TVGetDetails;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    /**  Έξι κατηγορίες ταινιών.  {movie_id}   movies  **/

    @GET("movie/{movie_id}")
    Call<MovieGetDetails> getDetailstMoviesId(@Path("movie_id") String id, @Query("api_key") String apiKey);

    @GET("movie/{movie_id}/credits")
    Call<MovieGetCredits> getCreditsMoviesId(@Path("movie_id") String id, @Query("api_key") String apiKey);

    @GET("movie/{movie_id}/images")
    Call<MovieGetImages> getLatestImagesId(@Path("movie_id") String id, @Query("api_key") String apiKey);

    @GET("movie/{movie_id}/recommendations")
    Call<MovieGetRecommendations> getRecommendationsMoviesId(@Path("movie_id") String id, @Query("api_key") String apiKey);

    @GET("movie/{movie_id}/similar")
    Call<MovieGetSimilarMovies> getSimilarMoviesId(@Path("movie_id") String id, @Query("api_key") String apiKey);

    @GET("movie/{movie_id}/reviews")
    Call<MovieGetReviews> getReviewsMoviesId(@Path("movie_id") String id, @Query("api_key") String apiKey);

    /**  Πέντε κατηγορίες ταινιών.     movies  **/
    /** @GET("movie/latest")
    Call<MovieGetLatest> getLatestMovies(@Query("api_key") String apiKey);**/
    @GET("movie/latest")
    Call<MovieGetLatest> getLatestMovies(@Query("api_key") String apiKey);


    @GET("movie/now_playing")
    Call<MoviesResponse> getNowPlayingMovies(@Query("api_key") String apiKey);

    //@Query("page") String pagekey
    @GET("movie/now_playing")
    Call<MoviesResponse> getNowPlayingMovies_2(@Query("api_key") String apiKey, @Query("page") String pagekey);

    @GET("movie/popular")
    Call<MoviesResponse> getPopularMovies(@Query("api_key") String apiKey);

    //@Query("page") String pagekey
    @GET("movie/now_playing")
    Call<MoviesResponse> getPopularMovies_2(@Query("api_key") String apiKey, @Query("page") String pagekey);

    @GET("movie/top_rated")
    Call<MoviesResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    //@Query("page") String pagekey
    @GET("movie/now_playing")
    Call<MoviesResponse> getTopRatedMovies_2(@Query("api_key") String apiKey, @Query("page") String pagekey);

    @GET("movie/upcoming")
    Call<MoviesResponse> getUpcomingMovies(@Query("api_key") String apiKey);

    //@Query("page") String pagekey
    @GET("movie/now_playing")
    Call<MoviesResponse> getUpcomingMovies_2(@Query("api_key") String apiKey, @Query("page") String pagekey);

    /**  SEARCH   movie  **/

    @GET("search/movie")
    Call<MoviesResponse> getSearchForMovies(@Query("api_key") String apiKey, @Query("query") String apiKeySearch);

    @GET("search/person")
    Call<PeopleResponse> getSearchForPeople(@Query("api_key") String apiKey, @Query("query") String apiKeySearch);

    @GET("search/tv")
    Call<TVResponse> getSearchForTV(@Query("api_key") String apiKey, @Query("query") String apiKeySearch);

    @GET("search/multi")
    Call<MultiResponse> getSearchForMulti(@Query("api_key") String apiKey, @Query("query") String apiKeySearch);

    //Call<People> call_People = apiService.getPopularPeople(API_KEY);
    /**  Δύο κατηγορίες προσώπων.   people  **/
    @GET("/person/{person_id}")
    Call<PeopleGetDetails> getDetailstPeopleId(@Path("person_id") String id, @Query("api_key") String apiKey);

    //@GET("person/latest")
    //Call<PeopleGetLatest> getLatestPeople(@Query("api_key") String apiKey);

    @GET("person/popular")
    Call<PeopleResponse> getPopularPeople(@Query("api_key") String apiKey);

    /**  Πέντε κατηγορίες για την τηλεόραση.    tv  **/

    @GET("/tv/{tv_id}")
    Call<TVGetDetails> getDetailstTVId(@Path("tv_id") String id, @Query("api_key") String apiKey);

    @GET("tv/latest")
    Call<TVGetLatest> getLatestTv(@Query("api_key") String apiKey);

    @GET("tv/airing_today")
    Call<TVResponse> getAiringTodayTv(@Query("api_key") String apiKey);

    //@Query("page") String pagekey
    @GET("tv/airing_today")
    Call<TVResponse> getAiringTodayTv_2(@Query("api_key") String apiKey, @Query("page") String pagekey);

    @GET("tv/on_the_air")
    Call<TVResponse> getOnTheAirTv(@Query("api_key") String apiKey);

    //@Query("page") String pagekey
    @GET("tv/on_the_air")
    Call<TVResponse> getOnTheAirTv_2(@Query("api_key") String apiKey, @Query("page") String pagekey);

    @GET("tv/popular")
    Call<TVResponse> getPopularTv(@Query("api_key") String apiKey);

    //@Query("page") String pagekey
    @GET("tv/popular")
    Call<TVResponse> getPopularTv_2(@Query("api_key") String apiKey, @Query("page") String pagekey);

    @GET("tv/top_rated")
    Call<TVResponse> getTopRatedTv(@Query("api_key") String apiKey);

    //@Query("page") String pagekey
    @GET("tv/top_rated")
    Call<TVResponse> getTopRatedTv_2(@Query("api_key") String apiKey, @Query("page") String pagekey);

/**
 * Εάν θέλεις και άλλα....
 * **/

}

