package com.lukeaskins.logindemo.model;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Links {

    @SerializedName("companies")
    @Expose
    private Companies companies;
    @SerializedName("user_categories")
    @Expose
    private UserCategories userCategories;

    /**
     *
     * @return
     * The companies
     */
    public Companies getCompanies() {
        return companies;
    }

    /**
     *
     * @param companies
     * The companies
     */
    public void setCompanies(Companies companies) {
        this.companies = companies;
    }

    /**
     *
     * @return
     * The userCategories
     */
    public UserCategories getUserCategories() {
        return userCategories;
    }

    /**
     *
     * @param userCategories
     * The user_categories
     */
    public void setUserCategories(UserCategories userCategories) {
        this.userCategories = userCategories;
    }

}

