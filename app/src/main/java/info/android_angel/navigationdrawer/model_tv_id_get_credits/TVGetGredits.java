package info.android_angel.navigationdrawer.model_tv_id_get_credits;

/**
 * Created by ANGELOS on 2017.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TVGetGredits {

    @SerializedName("cast")
    @Expose
    private List<TVGetGredits_cast> cast = null;
    @SerializedName("crew")
    @Expose
    private List<TVGetGredits_crew> crew = null;
    @SerializedName("id")
    @Expose
    private Integer id;

    public List<TVGetGredits_cast> getCast() {
        return cast;
    }

    public void setCast(List<TVGetGredits_cast> cast) {
        this.cast = cast;
    }

    public List<TVGetGredits_crew> getCrew() {
        return crew;
    }

    public void setCrew(List<TVGetGredits_crew> crew) {
        this.crew = crew;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
