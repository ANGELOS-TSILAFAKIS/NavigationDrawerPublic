package info.android_angel.navigationdrawer.model_people_id_get_movie_credits;

/**
 * Created by ANGELOS on 2017.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PeopleGetMovieCredits {

    @SerializedName("cast")
    @Expose
    private List<PeopleGetMovieCredits_cast> cast = null;
    @SerializedName("crew")
    @Expose
    private List<PeopleGetMovieCredits_crew> crew = null;
    @SerializedName("id")
    @Expose
    private Integer id;

    public List<PeopleGetMovieCredits_cast> getCast() {
        return cast;
    }

    public void setCast(List<PeopleGetMovieCredits_cast> cast) {
        this.cast = cast;
    }

    public List<PeopleGetMovieCredits_crew> getCrew() {
        return crew;
    }

    public void setCrew(List<PeopleGetMovieCredits_crew> crew) {
        this.crew = crew;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}