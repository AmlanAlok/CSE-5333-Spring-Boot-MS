package com.cloud.modal;

import java.util.Date;

public class LeaseHolderInfo {

    private long userId;
    private String firstName;
    private String lastName;
    private String emailId;

    private int bedroomCount;
    private int bathroomCount;
    private int vacancyCount;
    private double rentPerOccupant;
    private Date leaseStartDate;
    private Date leaseEndDate;
    private Date moveInDate;
    private double distanceFromCampus;
    private String name;
    private String address;
    private String furnishingStatus;

    public LeaseHolderInfo(long userId, String firstName, String lastName, String emailId, int bedroomCount, int bathroomCount, int vacancyCount, double rentPerOccupant, Date leaseStartDate, Date leaseEndDate, Date moveInDate, double distanceFromCampus, String name, String address, String furnishingStatus) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.bedroomCount = bedroomCount;
        this.bathroomCount = bathroomCount;
        this.vacancyCount = vacancyCount;
        this.rentPerOccupant = rentPerOccupant;
        this.leaseStartDate = leaseStartDate;
        this.leaseEndDate = leaseEndDate;
        this.moveInDate = moveInDate;
        this.distanceFromCampus = distanceFromCampus;
        this.name = name;
        this.address = address;
        this.furnishingStatus = furnishingStatus;
    }

    public LeaseHolderInfo() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public int getBedroomCount() {
        return bedroomCount;
    }

    public void setBedroomCount(int bedroomCount) {
        this.bedroomCount = bedroomCount;
    }

    public int getBathroomCount() {
        return bathroomCount;
    }

    public void setBathroomCount(int bathroomCount) {
        this.bathroomCount = bathroomCount;
    }

    public int getVacancyCount() {
        return vacancyCount;
    }

    public void setVacancyCount(int vacancyCount) {
        this.vacancyCount = vacancyCount;
    }

    public double getRentPerOccupant() {
        return rentPerOccupant;
    }

    public void setRentPerOccupant(double rentPerOccupant) {
        this.rentPerOccupant = rentPerOccupant;
    }

    public Date getLeaseStartDate() {
        return leaseStartDate;
    }

    public void setLeaseStartDate(Date leaseStartDate) {
        this.leaseStartDate = leaseStartDate;
    }

    public Date getLeaseEndDate() {
        return leaseEndDate;
    }

    public void setLeaseEndDate(Date leaseEndDate) {
        this.leaseEndDate = leaseEndDate;
    }

    public Date getMoveInDate() {
        return moveInDate;
    }

    public void setMoveInDate(Date moveInDate) {
        this.moveInDate = moveInDate;
    }

    public double getDistanceFromCampus() {
        return distanceFromCampus;
    }

    public void setDistanceFromCampus(double distanceFromCampus) {
        this.distanceFromCampus = distanceFromCampus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFurnishingStatus() {
        return furnishingStatus;
    }

    public void setFurnishingStatus(String furnishingStatus) {
        this.furnishingStatus = furnishingStatus;
    }
}
