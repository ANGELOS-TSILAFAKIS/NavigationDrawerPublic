package info.android_angel.navigationdrawer.model_tv_id_get_images;

/**
 * Created by ANGELOS on 2017.
 */
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TVGetImages {

    @SerializedName("backdrops")
    @Expose
    private List<TVGetImages_backdrop> backdrops = null;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("posters")
    @Expose
    private List<TVGetImages_poster> posters = null;

    public List<TVGetImages_backdrop> getBackdrops() {
        return backdrops;
    }

    public void setBackdrops(List<TVGetImages_backdrop> backdrops) {
        this.backdrops = backdrops;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<TVGetImages_poster> getPosters() {
        return posters;
    }

    public void setPosters(List<TVGetImages_poster> posters) {
        this.posters = posters;
    }

}
