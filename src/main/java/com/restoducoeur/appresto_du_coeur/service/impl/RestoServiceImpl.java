package com.restoducoeur.appresto_du_coeur.service.impl;

import com.restoducoeur.appresto_du_coeur.dao.MenuRepository;
import com.restoducoeur.appresto_du_coeur.dao.RestoRepository;
import com.restoducoeur.appresto_du_coeur.models.Resto;
import com.restoducoeur.appresto_du_coeur.service.RestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestoServiceImpl implements RestoService {

    @Autowired
   private RestoRepository restoRepository;


    @Autowired
    private MenuRepository menuRepository;

    @Override
    public List<Resto> getListRestaurant() {
        List<Resto> listResto = new ArrayList<>();
        restoRepository.findAll().forEach(listResto::add);
        return listResto;
    }

    @Override
    public Optional<Resto> findRestoId(Long id) {
        return restoRepository.findById(id);
    }

    @Override
    public void addRestaurant(Resto resto) {
        restoRepository.save(resto);
    }

    @Override
    public void updateRestaurant(Long id, Resto resto) {
        resto.setId(id);
        restoRepository.save(resto);
    }

    @Override
    public void findById(Long idResto) {
        restoRepository.existsById(idResto);

    }

    @Override
    public Optional<Resto> findRestoMenu(Long idMenu) {
        return restoRepository.findById(idMenu);
    }


}
