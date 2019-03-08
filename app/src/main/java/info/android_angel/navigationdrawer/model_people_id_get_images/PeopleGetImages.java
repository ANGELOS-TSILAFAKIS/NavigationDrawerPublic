package info.android_angel.navigationdrawer.model_people_id_get_images;

/**
 * Created by ANGELOS on 2017.
 */
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PeopleGetImages {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("profiles")
    @Expose
    private List<PeopleGetImages_profiles> profiles = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<PeopleGetImages_profiles> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<PeopleGetImages_profiles> profiles) {
        this.profiles = profiles;
    }

}