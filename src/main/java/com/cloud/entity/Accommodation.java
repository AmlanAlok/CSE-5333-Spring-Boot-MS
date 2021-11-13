package com.cloud.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name="accommodations")
public class Accommodation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private int bedroomCount;

    @Column
    private int bathroomCount;

    @Column
    private int vacancyCount;

    @Column
    private double rentPerOccupant;

    @Column
    private Date leaseStartDate;

    @Column
    private Date leaseEndDate;

    @Column
    private Date moveInDate;

    @Column
    private double distanceFromCampus;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private Long usersId;

    @Column
    private Long furnishingStatusId;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    public Accommodation(int bedroomCount, int bathroomCount, int vacancyCount, double rentPerOccupant, Date leaseStartDate, Date leaseEndDate, Date moveInDate, double distanceFromCampus, String name, String address, Long furnishingStatusId, Timestamp createdAt) {
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
        this.furnishingStatusId = furnishingStatusId;
        this.createdAt = createdAt;
    }

    public void setBedroomCount(int bedroomCount) {
        this.bedroomCount = bedroomCount;
    }

    public void setBathroomCount(int bathroomCount) {
        this.bathroomCount = bathroomCount;
    }

    public void setVacancyCount(int vacancyCount) {
        this.vacancyCount = vacancyCount;
    }

    public void setRentPerOccupant(double rentPerOccupant) {
        this.rentPerOccupant = rentPerOccupant;
    }

    public void setLeaseStartDate(Date leaseStartDate) {
        this.leaseStartDate = leaseStartDate;
    }

    public void setLeaseEndDate(Date leaseEndDate) {
        this.leaseEndDate = leaseEndDate;
    }

    public void setMoveInDate(Date moveInDate) {
        this.moveInDate = moveInDate;
    }

    public void setDistanceFromCampus(double distanceFromCampus) {
        this.distanceFromCampus = distanceFromCampus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUsersId(Long usersId) {
        this.usersId = usersId;
    }

    public void setFurnishingStatusId(Long furnishingStatusId) {
        this.furnishingStatusId = furnishingStatusId;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Accommodation{" +
                "id=" + id +
                ", bedroomCount=" + bedroomCount +
                ", bathroomCount=" + bathroomCount +
                ", vacancyCount=" + vacancyCount +
                ", rentPerOccupant=" + rentPerOccupant +
                ", leaseStartDate=" + leaseStartDate +
                ", leaseEndDate=" + leaseEndDate +
                ", moveInDate=" + moveInDate +
                ", distanceFromCampus=" + distanceFromCampus +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", usersId=" + usersId +
                ", furnishingStatusId=" + furnishingStatusId +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
