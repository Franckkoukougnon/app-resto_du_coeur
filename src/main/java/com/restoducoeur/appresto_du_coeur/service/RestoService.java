package com.restoducoeur.appresto_du_coeur.service;

import com.restoducoeur.appresto_du_coeur.models.Resto;

import java.util.List;
import java.util.Optional;

public interface RestoService {

    List<Resto> getListRestaurant();

    Optional<Resto> findRestoId(Long id);

    void addRestaurant(Resto resto);

    void updateRestaurant(Long id, Resto resto);


    void findById(Long idResto);


    Optional<Resto> findRestoMenu(Long idMenu);
}
