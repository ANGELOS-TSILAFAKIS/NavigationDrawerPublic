package info.android_angel.navigationdrawer.model_TV_get_latest;

/**
 * Created by ANGELOS on 2017.
 **/

import com.google.gson.annotations.SerializedName;

        import java.util.ArrayList;
        import java.util.List;

public class TVGetLatest_genres {

    @SerializedName("id")
    private Integer id;

    @SerializedName("name")
    private String name;

    public TVGetLatest_genres( Integer id,
                                 String name ) {
        this.id = id;
        this.name = name;
    }

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