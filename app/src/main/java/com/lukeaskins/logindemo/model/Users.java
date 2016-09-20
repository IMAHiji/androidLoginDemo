package com.lukeaskins.logindemo.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Users {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;
    @SerializedName("user_type")
    @Expose
    private String userType;
    @SerializedName("user_attributes")
    @Expose
    private UserAttributes userAttributes;
    @SerializedName("is_admin")
    @Expose
    private Boolean isAdmin;
    @SerializedName("preferred_contact_method")
    @Expose
    private Object preferredContactMethod;
    @SerializedName("zipcode")
    @Expose
    private String zipcode;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("has_stripe_token")
    @Expose
    private Boolean hasStripeToken;
    @SerializedName("last_four")
    @Expose
    private String lastFour;
    @SerializedName("links")
    @Expose
    private Links links;
    @SerializedName("company_ids")
    @Expose
    private List<Integer> companyIds = new ArrayList<Integer>();
    @SerializedName("job_category_ids")
    @Expose
    private List<Object> jobCategoryIds = new ArrayList<Object>();

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     * The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     * The firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName
     * The first_name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return
     * The lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     * The last_name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return
     * The phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     *
     * @param phoneNumber
     * The phone_number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     *
     * @return
     * The userType
     */
    public String getUserType() {
        return userType;
    }

    /**
     *
     * @param userType
     * The user_type
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     *
     * @return
     * The userAttributes
     */
    public UserAttributes getUserAttributes() {
        return userAttributes;
    }

    /**
     *
     * @param userAttributes
     * The user_attributes
     */
    public void setUserAttributes(UserAttributes userAttributes) {
        this.userAttributes = userAttributes;
    }

    /**
     *
     * @return
     * The isAdmin
     */
    public Boolean getIsAdmin() {
        return isAdmin;
    }

    /**
     *
     * @param isAdmin
     * The is_admin
     */
    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    /**
     *
     * @return
     * The preferredContactMethod
     */
    public Object getPreferredContactMethod() {
        return preferredContactMethod;
    }

    /**
     *
     * @param preferredContactMethod
     * The preferred_contact_method
     */
    public void setPreferredContactMethod(Object preferredContactMethod) {
        this.preferredContactMethod = preferredContactMethod;
    }

    /**
     *
     * @return
     * The zipcode
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     *
     * @param zipcode
     * The zipcode
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
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

    /**
     *
     * @return
     * The hasStripeToken
     */
    public Boolean getHasStripeToken() {
        return hasStripeToken;
    }

    /**
     *
     * @param hasStripeToken
     * The has_stripe_token
     */
    public void setHasStripeToken(Boolean hasStripeToken) {
        this.hasStripeToken = hasStripeToken;
    }

    /**
     *
     * @return
     * The lastFour
     */
    public String getLastFour() {
        return lastFour;
    }

    /**
     *
     * @param lastFour
     * The last_four
     */
    public void setLastFour(String lastFour) {
        this.lastFour = lastFour;
    }

    /**
     *
     * @return
     * The links
     */
    public Links getLinks() {
        return links;
    }

    /**
     *
     * @param links
     * The links
     */
    public void setLinks(Links links) {
        this.links = links;
    }

    /**
     *
     * @return
     * The companyIds
     */
    public List<Integer> getCompanyIds() {
        return companyIds;
    }

    /**
     *
     * @param companyIds
     * The company_ids
     */
    public void setCompanyIds(List<Integer> companyIds) {
        this.companyIds = companyIds;
    }

    /**
     *
     * @return
     * The jobCategoryIds
     */
    public List<Object> getJobCategoryIds() {
        return jobCategoryIds;
    }

    /**
     *
     * @param jobCategoryIds
     * The job_category_ids
     */
    public void setJobCategoryIds(List<Object> jobCategoryIds) {
        this.jobCategoryIds = jobCategoryIds;
    }
}