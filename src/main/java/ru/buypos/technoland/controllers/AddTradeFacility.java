package ru.buypos.technoland.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.buypos.technoland.jpa.TradeFacilityRepository;
import ru.buypos.technoland.jpa.UserRepository;
import ru.buypos.technoland.model.TradeFacility;
import ru.buypos.technoland.model.User;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AddTradeFacility {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TradeFacilityRepository tradeFacilityRepository;


    @GetMapping(path = "/addTradeFacility/{id}")
    public void addTradeFacility (@PathVariable Long id, @RequestBody List<TradeFacility> tradeFacilities) {

        User user = userRepository.findById(id).orElseThrow();
        List<TradeFacility> tradeFacilities1 = new ArrayList<>();
        tradeFacilities.forEach(nomenclature1 -> {
            TradeFacility tradeFacility = new TradeFacility();
            tradeFacility.setName(nomenclature1.getName());
            tradeFacility.setUsers(user);
            tradeFacilities1.add(tradeFacility);
        });
        tradeFacilityRepository.saveAll(tradeFacilities1);
    }
}
