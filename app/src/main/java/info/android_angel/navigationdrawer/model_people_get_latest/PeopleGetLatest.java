package info.android_angel.navigationdrawer.model_people_get_latest;

/**
 *Βρήκα και για τους ηθοποιούς και για retrofit
 */

/**
 * Created by ANGELOS on 2017.
 */

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class PeopleGetLatest {
    @SerializedName("adult")
    private boolean adult;
    //array[object]
    @SerializedName("also_known_as")
    private List<PeopleGetLatest_also_known_as> also_known_as;
    @SerializedName("biography")
    private String biography;
    @SerializedName("birthday")
    private String birthday;
    @SerializedName("deathday")
    private String deathday;
    @SerializedName("gender")
    private Integer gender;
    @SerializedName("homepage")
    private String homepage;
    @SerializedName("id")
    private Integer id;
    @SerializedName("imdb_id")
    private String imdb_id;
    @SerializedName("name")
    private String name;
    @SerializedName("place_of_birth")
    private String place_of_birth;
    @SerializedName("popularity")
    private Double popularity;
    @SerializedName("profile_path")
    private String profile_path;
/**   λάθος  https://developers.themoviedb.org/3/people
    public PeopleGetLatest(boolean adult, String backdrop_Path, String belongs_to_collection,
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

    public Boolean getΑdult() {
        return adult;
    }

    public void setΑdult(Boolean adult) {
        this.adult = adult;
    }

    public List<PeopleGetLatest_also_known_as> getΑlso_known_as() {
        return also_known_as;
    }

    public void setΑlso_known_as(List<PeopleGetLatest_also_known_as> also_known_as) {
        this.also_known_as = also_known_as;
    }

    public String getbiography() {
        return biography;
    }

    public void setbiography(String biography) {
        this.biography = biography;
    }

    public String getΒirthday() {
        return birthday;
    }

    public void setΒirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getdeathday() {
        return deathday;
    }

    public void setdeathday(String deathday) {
        this.deathday = deathday;
    }

    public Integer getgender() {
        return gender;
    }

    public void setgender(Integer gender) {
        this.gender = gender;
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

    public String getΙmdb_id() {
        return imdb_id;
    }

    public void setΙmdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public String getΝame() {
        return name;
    }

    public void setΝame(String name) {
        this.name = name;
    }

    public String getPlace_of_birth() {
        return place_of_birth;
    }

    public void setPlace_of_birth(String place_of_birth) {
        this.place_of_birth = place_of_birth;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public String getProfile_path() {
        return profile_path;
    }

    public void setProfile_path(String profile_path) {
        this.profile_path = profile_path;
    }

}
