package com.lukeaskins.logindemo.model;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Example {

    @SerializedName("users")
    @Expose
    private UserLoginResponse users;

    /**
     *
     * @return
     * The users
     */
    public UserLoginResponse getUsers() {
        return users;
    }

    /**
     *
     * @param users
     * The users
     */
    public void setUsers(UserLoginResponse users) {
        this.users = users;
    }

}