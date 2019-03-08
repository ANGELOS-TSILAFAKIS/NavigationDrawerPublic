package info.android_angel.navigationdrawer.model_TV_get_latest;

/**
 * Created by ANGELOS on 2017.
 *
 */

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class TVGetLatest_seasons {

    @SerializedName("air_date")
    private String air_date;
    @SerializedName("episode_count")
    private Integer episode_count;
    @SerializedName("id")
    private Integer id;
    @SerializedName("poster_path")
    private String poster_path;
    @SerializedName("season_number")
    private Integer season_number;

    public TVGetLatest_seasons(String air_date, Integer episode_count, Integer id,
                               String poster_path, Integer season_number ) {
        this.air_date = air_date;
        this.episode_count = episode_count;
        this.id = id;
        this.poster_path = poster_path;
        this.season_number = season_number;

    }

    public String getΑir_date() {
        return air_date;
    }

    public void setΑir_date(String air_date) {
        this.air_date = air_date;
    }

    public Integer getΕpisode_count() {
        return episode_count;
    }

    public void setΕpisode_count(Integer episode_count) {
        this.episode_count = episode_count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public Integer getSeason_number() {
        return season_number;
    }

    public void setSeason_number(Integer season_number) {
        this.season_number = season_number;
    }

}