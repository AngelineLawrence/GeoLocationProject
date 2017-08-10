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

    public UsersClass(){


    }//name,address,activity,phonenumber,department,email

    public UsersClass(String name, String address, String activity, String phonenumber, String department, String email) {
        this.address = address;
        this.phonenumber = phonenumber;
        this.activity = activity;
        this.department = department;
        this.email=email;
        this.name=name;
        //this.userId="";
    }

   /* public UsersClass(String userId){
        this.userId=userId;
    }*/

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) { this.department = department; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getUserId() { return userId; }

    public void setUserId(String userId) { this.userId = userId; }


}

