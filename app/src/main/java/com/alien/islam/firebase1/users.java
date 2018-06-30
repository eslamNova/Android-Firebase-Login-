package com.alien.islam.firebase1;

/**
 * Created by islam on 6/30/2018.
 */

public class users {
    String id;
    String fName;
    String lName;
    String email;
    String phone;
    String gender;
    Boolean donner;

    public users()
    {}


    public users(String id, String fName, String lName, String email, String phone, String gender, Boolean donner){
        this.id = id;

        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.donner = donner;
    }
    public String getId() {
        return id;
    }
    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getGender() {
        return gender;
    }

    public Boolean getDonner() {
        return donner;
    }
}
