package com.cloud.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name="occupants")
public class Occupant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private Double rentMinimum;

    @Column
    private Double rentMaximum;

    @Column
    private Date leaseStartDate;

    @Column
    private String state;

    @Column
    private String country;

    @Column
    private Long genderId;

    @Column
    private Long foodPreferenceId;

    @Column
    private Long degreeLevelId;

    @Column
    private Long usersId;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    public Occupant(Double rentMinimum, Double rentMaximum, Date leaseStartDate, String state, String country, Long genderId, Long foodPreferenceId, Long degreeLevelId, Timestamp createdAt) {
        this.rentMinimum = rentMinimum;
        this.rentMaximum = rentMaximum;
        this.leaseStartDate = leaseStartDate;
        this.state = state;
        this.country = country;
        this.genderId = genderId;
        this.foodPreferenceId = foodPreferenceId;
        this.degreeLevelId = degreeLevelId;
        this.createdAt = createdAt;
    }

    public void setRentMinimum(Double rentMinimum) {
        this.rentMinimum = rentMinimum;
    }

    public void setRentMaximum(Double rentMaximum) {
        this.rentMaximum = rentMaximum;
    }

    public void setLeaseStartDate(Date leaseStartDate) {
        this.leaseStartDate = leaseStartDate;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setGenderId(Long genderId) {
        this.genderId = genderId;
    }

    public void setFoodPreferenceId(Long foodPreferenceId) {
        this.foodPreferenceId = foodPreferenceId;
    }

    public void setDegreeLevelId(Long degreeLevelId) {
        this.degreeLevelId = degreeLevelId;
    }

    public void setUsersId(Long usersId) {
        this.usersId = usersId;
    }

    @Override
    public String toString() {
        return "Occupant{" +
                "id=" + id +
                ", rentMinimum=" + rentMinimum +
                ", rentMaximum=" + rentMaximum +
                ", leaseStartDate=" + leaseStartDate +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", genderId=" + genderId +
                ", foodPreferenceId=" + foodPreferenceId +
                ", degreeLevelId=" + degreeLevelId +
                ", usersId=" + usersId +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
