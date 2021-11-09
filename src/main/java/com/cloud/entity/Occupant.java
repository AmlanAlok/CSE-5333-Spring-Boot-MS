package com.cloud.entity;

import javax.persistence.*;
import java.sql.Date;

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
    private Long gendersId;

    @Column
    private Long foodPreferencesId;

    @Column
    private Long degreeLevelId;

    @Column
    private Long usersId;

    @Column
    private Date createdAt;

    @Column
    private Date updatedAt;

    public Occupant(Double rentMinimum, Double rentMaximum, Date leaseStartDate, String state, String country, Long gendersId, Long foodPreferencesId, Long degreeLevelId) {
        this.rentMinimum = rentMinimum;
        this.rentMaximum = rentMaximum;
        this.leaseStartDate = leaseStartDate;
        this.state = state;
        this.country = country;
        this.gendersId = gendersId;
        this.foodPreferencesId = foodPreferencesId;
        this.degreeLevelId = degreeLevelId;
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

    public void setGenderId(Long gendersId) {
        this.gendersId = gendersId;
    }

    public void setFoodPreferenceId(Long foodPreferencesId) {
        this.foodPreferencesId = foodPreferencesId;
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
                ", genderId=" + gendersId +
                ", foodPreferenceId=" + foodPreferencesId +
                ", degreeLevelId=" + degreeLevelId +
                ", usersId=" + usersId +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
