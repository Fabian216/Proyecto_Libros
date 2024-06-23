package org.example.simple.models;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity(name = "Cliente")
@data
@NoArgsConstructor

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "email")
    private String email;

    @Column(name = "telefono")
    private String telefono;
}
