package com.cloud.modal;

import java.util.Date;


public class OccupantInfo {

    private long userId;
    private String firstName;
    private String lastName;
    private String emailId;

    private double rentMinimum;
    private double rentMaximum;
    private Date leaseStartDate;
    private String state;
    private String country;
    private String gender;
    private String foodPreference;
    private String degreeLevel;

    public OccupantInfo(long userId, String firstName, String lastName, String emailId, double rentMinimum, double rentMaximum, Date leaseStartDate, String state, String country, String gender, String foodPreference, String degreeLevel) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.rentMinimum = rentMinimum;
        this.rentMaximum = rentMaximum;
        this.leaseStartDate = leaseStartDate;
        this.state = state;
        this.country = country;
        this.gender = gender;
        this.foodPreference = foodPreference;
        this.degreeLevel = degreeLevel;
    }

    public OccupantInfo() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getLeaseStartDate() {
        return leaseStartDate;
    }

    public void setLeaseStartDate(Date leaseStartDate) {
        this.leaseStartDate = leaseStartDate;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public double getRentMinimum() {
        return rentMinimum;
    }

    public void setRentMinimum(double rentMinimum) {
        this.rentMinimum = rentMinimum;
    }

    public double getRentMaximum() {
        return rentMaximum;
    }

    public void setRentMaximum(double rentMaximum) {
        this.rentMaximum = rentMaximum;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFoodPreference() {
        return foodPreference;
    }

    public void setFoodPreference(String foodPreference) {
        this.foodPreference = foodPreference;
    }

    public String getDegreeLevel() {
        return degreeLevel;
    }

    public void setDegreeLevel(String degreeLevel) {
        this.degreeLevel = degreeLevel;
    }
}
