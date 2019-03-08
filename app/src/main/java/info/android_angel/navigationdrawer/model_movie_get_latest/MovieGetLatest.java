package info.android_angel.navigationdrawer.model_movie_get_latest;

/**
 * Created by ANGELOS on 2017.
 */
import com.google.gson.annotations.SerializedName;

import java.util.List;

import info.android_angel.navigationdrawer.model.Movie;

public class MovieGetLatest {
    @SerializedName("adult")
    private boolean adult;
    @SerializedName("backdrop_path")
    private String backdrop_path;

    //belongs_to_collection.....................ΠΡΟΣΟΧΗ...
    @SerializedName("belongs_to_collection")
    private String belongs_to_collection;
    @SerializedName("budget")
    private Integer budget;
    //array[object]
    @SerializedName("genres")
    private List<MovieGetLatest_genres> genres;
    @SerializedName("homepage")
    private String homepage;
    @SerializedName("id")
    private Integer id;
    @SerializedName("imdb_id")
    private String imdb_id;
    @SerializedName("original_language")
    private String originalLanguage;
    @SerializedName("original_title")
    private String originalTitle;
    @SerializedName("overview")
    private String overview;
    @SerializedName("popularity")
    private Double popularity;
    @SerializedName("poster_path")
    private String poster_path;
    //array[object]
    @SerializedName("production_companies")
    private List<MovieGetLatest_production_companies> production_companies;
    //array[object]
    @SerializedName("production_countries")
    private List<MovieGetLatest_production_countries> production_countries;
    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("revenue")
    private Integer revenue;
    @SerializedName("runtime")
    private Integer runtime;
    //array[object]
    @SerializedName("spoken_languages")
    private List<MovieGetLatest_spoken_languages> spoken_languages;
    @SerializedName("status")
    private String status;
    @SerializedName("tagline")
    private String tagline;

    @SerializedName("title")
    private String title;
    @SerializedName("video")
    private Boolean video;
    @SerializedName("vote_average")
    private Double voteAverage;
    @SerializedName("vote_count")
    private Integer voteCount;

    public MovieGetLatest(boolean adult, String backdrop_Path, String belongs_to_collection,
                          Integer budget, List<MovieGetLatest_genres> genres, String homepage, Integer id,
                          String imdb_id, String originalLanguage, String originalTitle,
                          String overview, Double popularity, String posterPath,
                          List<MovieGetLatest_production_companies> production_companies,  List<MovieGetLatest_production_countries> production_countries,
                          String releaseDate, Integer revenue, Integer runtime,
                          List<MovieGetLatest_spoken_languages> spoken_languages, String status, String tagline,
                          String title, Boolean video, Double voteAverage, Integer voteCount

    ) {
        this.adult = adult;
        this.backdrop_path = backdrop_Path;
        this.belongs_to_collection = belongs_to_collection;
        this.budget = budget;
        this.genres = genres;
        this.homepage = homepage;
        this.id = id;

        this.imdb_id = imdb_id;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.overview = overview;
        this.popularity = popularity;
        this.poster_path = posterPath;

        this.production_companies = production_companies;
        this.production_countries = production_countries;
        this.releaseDate = releaseDate;
        this.revenue = revenue;
        this.runtime = runtime;


        this.spoken_languages = spoken_languages;
        this.status = status;
        this.tagline = tagline;
        this.title = title;
        this.video = video;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;

    }

    public Boolean getΑdult() {
        return adult;
    }

    public void setΑdult(Boolean adult) {
        this.adult = adult;
    }

    public String getbackdrop_Path() {
        return backdrop_path;
    }

    public void setbackdrop_Path(String backdrop_Path) {
        this.backdrop_path = backdrop_path;
    }

    public String getbelongs_to_collection() {
        return belongs_to_collection;
    }

    public void setbelongs_to_collection(String belongs_to_collection) {
        this.belongs_to_collection = belongs_to_collection;
    }

    public Integer getbudget() {
        return budget;
    }

    public void setbudget(Integer budget) {
        this.budget = budget;
    }

    public List<MovieGetLatest_genres> getgenres() {
        return genres;
    }

    public void setgenres(List<Movie> results) {
        this.genres = genres;
    }

    public String gethomepage() {
        return homepage;
    }

    public void sethomepage(String homepage) {
        this.homepage = homepage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getimdb_id() {
        return imdb_id;
    }

    public void setimdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public void setOriginalLanguage(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public String getPosterPath() {
        return poster_path;
    }

    public void setPosterPath(String poster_path) {
        this.poster_path = poster_path;
    }

    public List<MovieGetLatest_production_companies> getproduction_companies() {
        return production_companies;
    }

    public void setproduction_companies(List<MovieGetLatest_production_companies> production_companies) {
        this.production_companies = production_companies;
    }

    public List<MovieGetLatest_production_countries> getproduction_countries() {
        return production_countries;
    }

    public void setproduction_countries(List<MovieGetLatest_production_countries> production_countries) {
        this.production_countries = production_countries;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getrevenue() {
        return revenue;
    }

    public void setrevenue(Integer revenue) {
        this.revenue = revenue;
    }

    public Integer getruntime() {
        return runtime;
    }

    public void setruntime(Integer runtime) {
        this.runtime = runtime;
    }

    public List<MovieGetLatest_spoken_languages> getspoken_languages() {
        return spoken_languages;
    }

    public void setspoken_languages(List<MovieGetLatest_spoken_languages> spoken_languages) {
        this.spoken_languages = spoken_languages;
    }

    public String getstatus() {
        return status;
    }

    public void setstatus(String status) {
        this.status = status;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

}
