package com.restoducoeur.appresto_du_coeur.rest;

import com.restoducoeur.appresto_du_coeur.models.Menu;
import com.restoducoeur.appresto_du_coeur.models.Resto;
import com.restoducoeur.appresto_du_coeur.service.MenuService;
import com.restoducoeur.appresto_du_coeur.service.RestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @Autowired
    private RestoService restoService;

    @GetMapping("/listemenu")
    public List<Menu> getListMenu(){
        return menuService.getListMenu();
    }

    @GetMapping("/menu/{id}")
    public Optional<Menu> findById(@PathVariable("id") Long id){
        return  menuService.findById(id);
    }

    @GetMapping("/resto/{idResto}/menu")
    public Optional<Menu> findMenuById(@PathVariable("idResto") Long idResto){
        restoService.findRestoId(idResto);
        return  menuService.findMenuId(idResto);
    }

/*    @GetMapping("/resto/{idResto}/menu")
    public Resto findMenuById(@PathVariable("idResto") Long idResto){
        restoService.findRestoId(idResto);
        return  menuService.findMenuId(idResto).get().getResto();
    }*/

    @PostMapping
    public Menu createMenu(@RequestBody Menu menu){
        return menuService.createMenu(menu);
    }

    @PutMapping ("/{id}")
    public Menu updateMenu(@PathVariable Long id, @RequestBody Menu menu){
        return menuService.updateMenu(menu,id);
    }

}
