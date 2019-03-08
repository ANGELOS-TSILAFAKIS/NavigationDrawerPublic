package info.android_angel.navigationdrawer.model_movie_id_get_details;

/**
 * Created by ANGELOS on 2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieGetDetails_genres {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
