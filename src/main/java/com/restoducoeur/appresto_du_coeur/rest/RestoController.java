package com.restoducoeur.appresto_du_coeur.rest;


import com.restoducoeur.appresto_du_coeur.exceptions.ResourceNotFoundException;
import com.restoducoeur.appresto_du_coeur.models.Menu;
import com.restoducoeur.appresto_du_coeur.models.Resto;
import com.restoducoeur.appresto_du_coeur.service.MenuService;
import com.restoducoeur.appresto_du_coeur.service.RestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/resto")
public class RestoController {
    @Autowired
    private RestoService restoService;

    @Autowired
    private MenuService menuService;

    @GetMapping("/listeresto")
    public List<Resto> getListResto(){
        return restoService.getListRestaurant();
    }




    @GetMapping("/menu/{idMenu}/resto")
    public Optional<Resto> findRestoMenuById(@PathVariable ("idMenu") Long idMenu){
        menuService.findById(idMenu);
        return restoService.findRestoMenu(idMenu);

    }




    @GetMapping("/menu/{idResto}")
    public Set<Menu> findRestoById(@PathVariable("idResto") Long idResto){

        Optional<Resto> resto = restoService.findRestoId(idResto);

        if(resto.isEmpty()){
            throw new ResourceNotFoundException();
        } else {
            return resto.get().getMenus();
        }
    }


    @PostMapping("/addresto")
    public void addResto(@RequestBody Resto resto){
        restoService.addRestaurant(resto);
    }


    @PutMapping("/{id}")
    public void updateResto(@RequestBody Resto resto, @PathVariable("id") Long id){
        restoService.updateRestaurant(id, resto);
    }

    @DeleteMapping("{id}")
    public void deleteResto(@PathVariable("id") Long id){
        restoService.deleteResto(id);
    }
}
