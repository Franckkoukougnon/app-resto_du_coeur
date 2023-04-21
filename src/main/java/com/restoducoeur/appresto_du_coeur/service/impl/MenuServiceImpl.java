package com.restoducoeur.appresto_du_coeur.service.impl;

import com.restoducoeur.appresto_du_coeur.dao.MenuRepository;
import com.restoducoeur.appresto_du_coeur.dao.RestoRepository;
import com.restoducoeur.appresto_du_coeur.models.Menu;
import com.restoducoeur.appresto_du_coeur.service.MenuService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private RestoRepository restoRepository;
    @Override
    public Set<Menu> getSetMenu(Long idResto) {
//        return restoRepository.findById(idResto).get().getMenus();
        return null;
    }

    @Override
    public Optional<Menu> findById(Long id) {
        return menuRepository.findById(id);
    }

    @Override
    public Menu createMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public Menu updateMenu(Menu menu, Long id) {
       return menuRepository.findById(id).map(menu1 -> {
            BeanUtils.copyProperties(menu,menu1);
            return menuRepository.save(menu1);
        }).orElseThrow(() -> new EntityNotFoundException("Le menu n'existe pas !"));

    }

    @Override
    public Optional<Menu> findMenuId(Long idResto) {
        return menuRepository.findById(idResto);
    }


}
