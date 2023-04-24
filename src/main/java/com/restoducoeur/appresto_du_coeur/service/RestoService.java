package com.restoducoeur.appresto_du_coeur.service;

import com.restoducoeur.appresto_du_coeur.models.Resto;

import java.util.List;
import java.util.Optional;

public interface RestoService {

    List<Resto> getListRestaurant();

    Optional<Resto> findRestoId(Long idResto);

    void addRestaurant(Resto resto);

    void updateRestaurant(Long id, Resto resto);




    Optional<Resto> findRestoMenu(Long idMenu);



    void deleteResto(Long id);
}
