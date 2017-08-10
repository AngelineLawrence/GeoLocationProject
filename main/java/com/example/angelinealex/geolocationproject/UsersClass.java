package com.example.angelinealex.geolocationproject;

/**
 * Created by AngelineAlex on 8/8/17.
 */
public class UsersClass {

    private String address;
    private String phonenumber;
    private String activity;
    private String department;
    private String name;
    private String email;
    private String userId;
    private double latitude;
    private double longitude;

    /**
     * Instantiates a new Users class.
     */
    public UsersClass(){


    }//name,address,activity,phonenumber,department,email


    /**
     * Instantiates a new Users class.
     *
     * @param name        the name
     * @param address     the address
     * @param activity    the activity
     * @param phonenumber the phonenumber
     * @param department  the department
     * @param email       the email
     * @param latitude    the latitude
     * @param longitude   the longitude
     */
    public UsersClass(String name, String address, String activity, String phonenumber, String department, String email,double latitude, double longitude) {
        this.address = address;
        this.phonenumber = phonenumber;
        this.activity = activity;
        this.department = department;
        this.email=email;
        this.name=name;
        this.latitude=latitude;
        this.longitude=longitude;
        //this.userId="";
    }

    /**
     * Instantiates a new Users class.
     *
     * @param latitude  the latitude
     * @param longitude the longitude
     * @param name      the name
     */
    public UsersClass(double latitude, double longitude, String name){
        this.name=name;
        this.latitude=latitude;
        this.longitude=longitude;
    }

   /* public UsersClass(String userId){
        this.userId=userId;
    }*/

    /**
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets phonenumber.
     *
     * @return the phonenumber
     */
    public String getPhonenumber() {
        return phonenumber;
    }

    /**
     * Sets phonenumber.
     *
     * @param phonenumber the phonenumber
     */
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    /**
     * Gets activity.
     *
     * @return the activity
     */
    public String getActivity() {
        return activity;
    }

    /**
     * Sets activity.
     *
     * @param activity the activity
     */
    public void setActivity(String activity) {
        this.activity = activity;
    }

    /**
     * Gets department.
     *
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets department.
     *
     * @param department the department
     */
    public void setDepartment(String department) { this.department = department; }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() { return email; }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) { this.email = email; }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public String getUserId() { return userId; }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
    public void setUserId(String userId) { this.userId = userId; }

    /**
     * Gets latitude.
     *
     * @return the latitude
     */
    public double getLatitude() { return latitude; }

    /**
     * Sets latitude.
     *
     * @param latitude the latitude
     */
    public void setLatitude(double latitude) { this.latitude = latitude; }

    /**
     * Gets longitude.
     *
     * @return the longitude
     */
    public double getLongitude() { return longitude; }

    /**
     * Sets longitude.
     *
     * @param longitude the longitude
     */
    public void setLongitude(double longitude) { this.longitude = longitude; }


}

