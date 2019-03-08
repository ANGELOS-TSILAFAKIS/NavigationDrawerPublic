package info.android_angel.navigationdrawer.model_movie_id_get_credits;

/**
 * Created by ANGELOS on 2017.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieGetCredits {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("cast")
    @Expose
    private List<MovieGetCredits_cast> cast = null;
    @SerializedName("crew")
    @Expose
    private List<MovieGetCredits_crew> crew = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<MovieGetCredits_cast> getCast() {
        return cast;
    }

    public void setCast(List<MovieGetCredits_cast> cast) {
        this.cast = cast;
    }

    public List<MovieGetCredits_crew> getCrew() {
        return crew;
    }

    public void setCrew(List<MovieGetCredits_crew> crew) {
        this.crew = crew;
    }
}
