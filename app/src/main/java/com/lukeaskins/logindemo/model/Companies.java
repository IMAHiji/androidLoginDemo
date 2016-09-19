package com.lukeaskins.logindemo.model;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Companies {

    @SerializedName("id")
    @Expose
    private List<Integer> id = new ArrayList<Integer>();
    @SerializedName("type")
    @Expose
    private String type;

    /**
     *
     * @return
     * The id
     */
    public List<Integer> getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(List<Integer> id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    public void setType(String type) {
        this.type = type;
    }

}
