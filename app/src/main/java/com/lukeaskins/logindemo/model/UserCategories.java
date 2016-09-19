package com.lukeaskins.logindemo.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class UserCategories {

    @SerializedName("id")
    @Expose
    private List<Object> id = new ArrayList<Object>();
    @SerializedName("type")
    @Expose
    private String type;

    /**
     *
     * @return
     * The id
     */
    public List<Object> getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(List<Object> id) {
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