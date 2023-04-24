package com.restoducoeur.appresto_du_coeur.service;

import com.restoducoeur.appresto_du_coeur.models.Menu;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface MenuService {
    Set<Menu> getSetMenu(Long idResto);

    Optional<Menu> findById(Long id);

    Menu createMenu(Menu menu);


    Menu updateMenu(Menu menu, Long id);

    Optional<Menu> findMenuId(Long idResto);

    List<Menu> getListMenu();

    Optional<Menu> findByIdMenu(Long id);
}
