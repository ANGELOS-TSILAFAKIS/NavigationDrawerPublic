package info.android_angel.navigationdrawer.model_TV_get_latest;

/**
 * Created by ANGELOS on 2017.
 */

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class TVGetLatest {
    @SerializedName("backdrop_path")
    private String backdrop_path;
    //array[object]
    @SerializedName("created_by")
    private List<TVGetLatest_created_by>
            created_by;
    //array[integer]
    @SerializedName("episode_run_time")
    private List<Integer> episode_run_time = new ArrayList<Integer>();
    @SerializedName("first_air_date")
    private String first_air_date;
    //array[object]
    @SerializedName("genres")
    private List<TVGetLatest_genres> genres;
    @SerializedName("homepage")
    private String homepage;
    @SerializedName("id")
    private Integer id;
    @SerializedName("in_production")
    private Boolean in_production;
    //array[String]
    @SerializedName("languages")
    private List<String> languages = new ArrayList<String>();
    @SerializedName("last_air_date")
    private String last_air_date;
    @SerializedName("name")
    private String name;
    //array[object]
    @SerializedName("networks")
    private List<TVGetLatest_networks> networks;
    @SerializedName("number_of_episodes")
    private Integer number_of_episodes;
    @SerializedName("number_of_seasons")
    private Integer number_of_seasons;
    //array[String]
    @SerializedName("origin_country")
    private List<String> origin_country = new ArrayList<String>();
    @SerializedName("original_language")
    private String originalLanguage;
    @SerializedName("original_name")
    private String original_name;
    @SerializedName("overview")
    private String overview;
    @SerializedName("popularity")
    private Double popularity;
    @SerializedName("poster_path")
    private String poster_path;
    //array[object]
    @SerializedName("production_companies")
    private List<TVGetLatest_production_companies> production_companies;
    //array[object]
    @SerializedName("seasons")
    private List<TVGetLatest_seasons> seasons;
    @SerializedName("status")
    private String status;
    @SerializedName("type")
    private String type;
    @SerializedName("vote_average")
    private Double vote_average;
    @SerializedName("vote_count")
    private Integer vote_count;

/**
    public TVGetLatest(boolean adult, String backdrop_Path, String belongs_to_collection,
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
**/


    public String getbackdrop_Path() {
        return backdrop_path;
    }

    public void setbackdrop_Path(String backdrop_Path) {
        this.backdrop_path = backdrop_path;
    }

    public List<TVGetLatest_created_by> getCreated_by() {
        return created_by;
    }

    public void setCreated_by(List<TVGetLatest_created_by> created_by) {
        this.created_by = created_by;
    }

    public List<Integer> getEpisode_run_time() {
        return episode_run_time;
    }

    public void setEpisode_run_time(List<Integer> episode_run_time) {
        this.episode_run_time = episode_run_time;
    }

    public String getFirst_air_date() {
        return first_air_date;
    }

    public void setFirst_air_dateh(String first_air_date) {
        this.first_air_date = first_air_date;
    }

    public List<TVGetLatest_genres> getGenres() {
        return genres;
    }

    public void setGenres(List<TVGetLatest_genres> genres) {
        this.genres = genres;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getIn_production() {
        return in_production;
    }

    public void setIn_production(Boolean in_production) {
        this.in_production = in_production;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public String getLast_air_date() {
        return last_air_date;
    }

    public void setLast_air_date(String last_air_date) {
        this.last_air_date = last_air_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TVGetLatest_networks> getNetworks() {
        return networks;
    }

    public void setNetworks(List<TVGetLatest_networks> networks) {
        this.networks = networks;
    }

    public Integer getNumber_of_episodes() {
        return number_of_episodes;
    }

    public void setNumber_of_episodes(Integer number_of_episodes) {
        this.number_of_episodes = number_of_episodes;
    }

    public Integer getNumber_of_seasons() {
        return number_of_seasons;
    }

    public void setNumber_of_seasons(Integer number_of_episodes) {
        this.number_of_seasons = number_of_seasons;
    }

    public List<String> getOrigin_country() {
        return origin_country;
    }

    public void setOrigin_country(List<String> origin_country) {
        this.origin_country = origin_country;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
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

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public List<TVGetLatest_production_companies> getProduction_companies() {
        return production_companies;
    }

    public void setProduction_companies(List<TVGetLatest_production_companies> production_companies) {
        this.production_companies = production_companies;
    }

    public List<TVGetLatest_seasons> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<TVGetLatest_seasons> seasons) {
        this.seasons = seasons;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getVote_average() {
        return vote_average;
    }

    public void setVote_average(Double vote_average) {
        this.vote_average = vote_average;
    }

    public Integer getVote_count() {
        return vote_count;
    }

    public void setVote_count(Integer vote_count) {
        this.vote_count = vote_count;
    }

}