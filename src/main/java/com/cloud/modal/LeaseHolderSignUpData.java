package com.cloud.modal;

import java.sql.Date;

public class LeaseHolderSignUpData {

    private String firstName = "";
    private String lastName = "";
    private String emailId = "";
    private String password = "";
    private String phoneNumber = "";
    private long rolesId;

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
    private Long furnishingStatusId;

    private String updatedAt = "";

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getRolesId() {
        return rolesId;
    }

    public void setRolesId(long rolesId) {
        this.rolesId = rolesId;
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

    public Long getFurnishingStatusId() {
        return furnishingStatusId;
    }

    public void setFurnishingStatusId(Long furnishingStatusId) {
        this.furnishingStatusId = furnishingStatusId;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
