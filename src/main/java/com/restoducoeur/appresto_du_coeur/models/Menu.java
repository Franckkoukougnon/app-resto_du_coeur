package com.restoducoeur.appresto_du_coeur.models;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String entree;
    private String plat;
    private String dessert;
    private double price;

    @ManyToOne(cascade ={CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "resto_id")
    private  Resto resto;
}
