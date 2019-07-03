package com.management.racermanagement.racer;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of="id")
public class Racer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int speed;

    public Racer(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public Racer(){}

}
