package com.cloud.entity;

import javax.persistence.*;

@Entity
@Table(name="food_preferences")
public class FoodPreference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
