package com.lukeaskins.logindemo.model;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class UserLoginResponse {

    @SerializedName("users")
    @Expose
    private Users users;

    /**
     *
     * @return
     * The users
     */
    public Users getUsers() {
        return users;
    }

    /**
     *
     * @param users
     * The users
     */
    public void setUsers(Users users) {
        this.users = users;
    }

}