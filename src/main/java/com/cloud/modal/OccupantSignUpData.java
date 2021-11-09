package com.cloud.modal;

public class OccupantSignUpData {

    private String firstName = "";
    private String lastName = "";
    private String emailId = "";
    private String password = "";
    private String phoneNumber = "";
    private long rolesId;

    private double rentMinimum;
    private double rentMaximum;
    private String leaseStartDate = "";
    private String state = "";
    private String country = "";
    private long genderId;
    private long foodPreferenceId;
    private long degreeLevelId;

    private String updatedAt = "";

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public long getRolesId() {
        return rolesId;
    }

    public double getRentMinimum() {
        return rentMinimum;
    }

    public double getRentMaximum() {
        return rentMaximum;
    }

    public String getLeaseStartDate() {
        return leaseStartDate;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public long getGenderId() {
        return genderId;
    }

    public long getFoodPreferenceId() {
        return foodPreferenceId;
    }

    public long getDegreeLevelId() {
        return degreeLevelId;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setRolesId(long rolesId) {
        this.rolesId = rolesId;
    }

    public void setRentMinimum(double rentMinimum) {
        this.rentMinimum = rentMinimum;
    }

    public void setRentMaximum(double rentMaximum) {
        this.rentMaximum = rentMaximum;
    }

    public void setLeaseStartDate(String leaseStartDate) {
        this.leaseStartDate = leaseStartDate;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setGenderId(long genderId) {
        this.genderId = genderId;
    }

    public void setFoodPreferenceId(long foodPreferenceId) {
        this.foodPreferenceId = foodPreferenceId;
    }

    public void setDegreeLevelId(long degreeLevelId) {
        this.degreeLevelId = degreeLevelId;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "OccupantSignUpData{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", rolesId=" + rolesId +
                ", rentMinimum=" + rentMinimum +
                ", rentMaximum=" + rentMaximum +
                ", leaseStartDate='" + leaseStartDate + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", genderId=" + genderId +
                ", foodPreferenceId=" + foodPreferenceId +
                ", degreeLevelId=" + degreeLevelId +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
