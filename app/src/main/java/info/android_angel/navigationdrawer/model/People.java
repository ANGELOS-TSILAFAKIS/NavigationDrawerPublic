package info.android_angel.navigationdrawer.model;

/**
 * Created by ANGELOS on 2017.
 */

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class People{
    @SerializedName("profile_path")
    private String profile_path;
    @SerializedName("adult")
    private boolean adult;

    @SerializedName("id")
    private Integer id;

    //array[object]    OR  OR  OR
    @SerializedName("known_for")
    private List<People_known_for> known_for;

    @SerializedName("name")
    private String name;
    @SerializedName("popularity")
    private Double popularity;

    public People(String profile_path, boolean adult,  Integer id,
                 List<People_known_for> known_for,  String name, Double popularity
                 ) {
        this.profile_path = profile_path;
        this.adult = adult;
        this.id = id;

        this.known_for = known_for;
        this.name = name;
        this.popularity = popularity;
    }

    public String getProfile_path() {
        return profile_path;
    }

    public void setProfile_path(String profile_path) {
        this.profile_path = profile_path;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<People_known_for> getΚnown_for(){
        return known_for;
    }

    public void setΚnown_for(List<People_known_for> known_for) {
        this.known_for = known_for;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public String getΝame() {
        return name;
    }

    public void setΝame(String name) {
        this.name = name;
    }

}

