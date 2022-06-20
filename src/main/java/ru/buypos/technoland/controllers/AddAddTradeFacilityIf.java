package ru.buypos.technoland.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.buypos.technoland.jpa.TradeFacilityRepository;
import ru.buypos.technoland.jpa.UserRepository;
import ru.buypos.technoland.model.Nomenclature;
import ru.buypos.technoland.model.TradeFacility;
import ru.buypos.technoland.model.User;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AddAddTradeFacilityIf {

    @Autowired
    TradeFacilityRepository tradeFacilityRepository;

    @Autowired
    UserRepository userRepository;

//    @Autowired
//    TradeFacilityRepo tradeFacilityRepo;


    @GetMapping(path = "/addTradeFacilityIf/{toName}/{userId}")
    public void addTradeFacilityIf (@PathVariable String toName, @PathVariable String userId, @RequestBody List<TradeFacility> tradeFacilities) {


        System.out.println(tradeFacilityRepository.existsByName(toName));

        if (tradeFacilityRepository.existsByName(toName)) {
            System.out.println("Есть");
        } else {

            System.out.println("Нет");

            User user = userRepository.findUserByKey(userId).orElseThrow();

            List<TradeFacility> tradeFacilities1 = new ArrayList<>();
            tradeFacilities.forEach(nomenclature1 -> {
                TradeFacility tradeFacility = new TradeFacility();
                tradeFacility.setName(nomenclature1.getName());
                tradeFacility.setUsers(user);
                tradeFacilities1.add(tradeFacility);
            });
            tradeFacilityRepository.saveAll(tradeFacilities1);


        }




//        if (tradeFacility.getName().isEmpty()) {
//
//            System.out.println("ПУСТОТА");
//
//        } else {
//            System.out.println("Не пусто");
//        }


//        System.out.println(tradeFacilityRepository.findByName(toName));



//        if (tradeFacilityRepository.findAll(toName)) {
//
//            User user = userRepository.findById(id).orElseThrow();
//
//            TradeFacility tradeFacility = new TradeFacility();
//            tradeFacility.setName(id);
//
//
////            List<Nomenclature> tradeFacilities1 = new ArrayList<>();
////            nomenclatures.forEach(nomenclature -> {
////                Nomenclature tradeFacility = new Nomenclature();
////                tradeFacility.setName(nomenclature1.getName());
////                tradeFacility.setUsers(user);
////                tradeFacilities1.add(tradeFacility);
//
//
//            });
//            tradeFacilityRepository.saveAll(tradeFacilities1);

        }



//        System.out.println(tradeFacilityRepository.findById(id).isEmpty());





//    }

}
