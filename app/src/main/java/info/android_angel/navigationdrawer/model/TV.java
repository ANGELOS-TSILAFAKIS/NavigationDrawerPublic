package info.android_angel.navigationdrawer.model;

/**
 * Created by ANGELOS on 2017.
 */

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class TV {
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("popularity")
    private Double popularity;
    @SerializedName("id")
    private Integer id;
    @SerializedName("backdrop_path")
    private String backdrop_path;
    @SerializedName("vote_average")
    private Double voteAverage;
    @SerializedName("overview")
    private String overview;
    @SerializedName("first_air_date")
    private String first_air_date;
    @SerializedName("origin_country")
    private List<String> origin_country = new ArrayList<String>();
    @SerializedName("genre_ids")
    private List<Integer> genreIds = new ArrayList<Integer>();
    @SerializedName("original_language")
    private String original_language;
    @SerializedName("vote_count")
    private Integer voteCount;
    @SerializedName("name")
    private String name;
    @SerializedName("original_name")
    private String original_name;

    public TV(String posterPath, Double popularity, Integer id,
                 String backdrop_path, Double voteAverage, String overview,

                 String first_air_date, List<String> origin_country, List<Integer> genreIds,
                 String original_language, Integer voteCount,String name,
                 String original_name) {
        this.posterPath = posterPath;
        this.popularity = popularity;
        this.id = id;

        this.backdrop_path = backdrop_path;
        this.voteAverage = voteAverage;
        this.overview = overview;

        this.first_air_date = first_air_date;
        this.origin_country = origin_country;
        this.genreIds = genreIds;

        this.original_language = original_language;
        this.voteCount = voteCount;
        this.name = name;

        this.original_name = original_name;

    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public Double getpopularity() {
        return popularity;
    }

    public void setpopularity(Double popularity) {
        this.popularity = popularity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getbackdropPath() {
        return backdrop_path;
    }

    public void setbackdropPath(String backdropPath) {
        this.backdrop_path = backdropPath;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double vote_average) {
        this.voteAverage = vote_average;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getfirst_air_date() {
        return first_air_date;
    }

    public void setfirst_air_date(String first_air_date) {
        this.first_air_date = first_air_date;
    }

    public List<String> getorigin_country() {
        return origin_country;
    }

    public void setorigin_country(List<String> origin_country) {
        this.origin_country = origin_country;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    public String getoriginal_language() {
        return original_language;
    }

    public void setoriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public Integer getvoteCount() {
        return voteCount;
    }

    public void setvoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getoriginal_name() {
        return original_name;
    }

    public void setoriginal_name(String original_name) {
        this.original_name = original_name;
    }

}

