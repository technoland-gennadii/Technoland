package ru.buypos.technoland.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.buypos.technoland.jpa.CodRepository;
import ru.buypos.technoland.jpa.NomenclatureRepository;
import ru.buypos.technoland.jpa.TradeFacilityRepository;
import ru.buypos.technoland.model.Cod;
import ru.buypos.technoland.model.Nomenclature;
import ru.buypos.technoland.model.TradeFacility;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AddCod {

    @Autowired
    CodRepository codRepository;

    @Autowired
    TradeFacilityRepository tradeFacilityRepository;

    @Autowired
    NomenclatureRepository nomenclatureRepository;

    @GetMapping(path = "/addCod/{nomenclature}/{tradeFacility}")
    public void addCod (@PathVariable Long nomenclature, @PathVariable Long tradeFacility, @RequestBody List<Cod> cod) {

        Nomenclature nomenclature1 = nomenclatureRepository.findById(nomenclature).orElseThrow();
        TradeFacility tradeFacility1 = tradeFacilityRepository.findById(tradeFacility).orElseThrow();
        List<Cod> cod1 = new ArrayList<>();
        cod.forEach(cod2 -> {
            Cod cod3 = new Cod();
            cod3.setVal(cod2.getVal());
            cod3.setNomenclature(nomenclature1);
            cod3.setTradeFacility(tradeFacility1);
            cod1.add(cod3);
        });
        codRepository.saveAll(cod1);
    }
}
