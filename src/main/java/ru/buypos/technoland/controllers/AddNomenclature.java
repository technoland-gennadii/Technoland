package ru.buypos.technoland.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.buypos.technoland.jpa.NomenclatureRepository;
import ru.buypos.technoland.jpa.UserRepository;
import ru.buypos.technoland.model.Nomenclature;
import ru.buypos.technoland.model.User;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AddNomenclature {

    @Autowired
    NomenclatureRepository nomenclatureRepository;

    @Autowired
    UserRepository userRepository;


    @GetMapping(path = "/addNomenclature/{id}")
    public void addNomenclature (@PathVariable Long id, @RequestBody List<Nomenclature> nomenclature) {

        User user = userRepository.findById(id).orElseThrow();
        List<Nomenclature> nomenclatures = new ArrayList<>();
        nomenclature.forEach(nomenclature1 -> {
            Nomenclature nomenclature2 = new Nomenclature();
            nomenclature2.setArticle(nomenclature1.getArticle());
            nomenclature2.setName(nomenclature1.getName());
            nomenclature2.setUsers(user);
            nomenclatures.add(nomenclature2);
        });
        nomenclatureRepository.saveAll(nomenclatures);
    }



}
