package com.example.mscontactsapi.repository.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "contacts")
public class ContactDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
}
