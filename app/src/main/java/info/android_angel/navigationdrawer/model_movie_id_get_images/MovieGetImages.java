package info.android_angel.navigationdrawer.model_movie_id_get_images;

/**
 * Created by ANGELOS on 2017.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieGetImages {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("backdrops")
    @Expose
    private List<MovieGetImages_backdrops> backdrops = null;
    @SerializedName("posters")
    @Expose
    private List<MovieGetImages_posters> posters = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<MovieGetImages_backdrops> getBackdrops() {
        return backdrops;
    }

    public void setBackdrops(List<MovieGetImages_backdrops> backdrops) {
        this.backdrops = backdrops;
    }

    public List<MovieGetImages_posters> getPosters() {
        return posters;
    }

    public void setPosters(List<MovieGetImages_posters> posters) {
        this.posters = posters;
    }


}
