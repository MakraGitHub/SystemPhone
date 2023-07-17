package com.makara.SystemPhone.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "models")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "brandId")
    private Brand brand;
}