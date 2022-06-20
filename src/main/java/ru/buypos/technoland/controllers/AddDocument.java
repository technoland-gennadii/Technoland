package ru.buypos.technoland.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.buypos.technoland.jpa.DocumentRepository;
import ru.buypos.technoland.jpa.TradeFacilityRepository;
import ru.buypos.technoland.jpa.UserRepository;
import ru.buypos.technoland.model.Document;
import ru.buypos.technoland.model.TradeFacility;
import ru.buypos.technoland.model.User;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AddDocument {

    @Autowired
    UserRepository userRepository;


    @Autowired
    TradeFacilityRepository tradeFacilityRepository;


    @Autowired
    DocumentRepository documentRepository;


    @GetMapping(path = "/addDocument/{userId}/{tradeFacilityId}")
    public void addDocument (@PathVariable Long userId, @PathVariable Long tradeFacilityId, @RequestBody List<Document> documents) {

        User user = userRepository.findById(userId).orElseThrow();
        TradeFacility tradeFacility1 = tradeFacilityRepository.findById(tradeFacilityId).orElseThrow();

        List<Document> documents1 = new ArrayList<>();

        documents.forEach(document -> {

            Document document1 = new Document();

            document1.setDate(document.getDate());
            document1.setNumber(document.getNumber());

            document1.setUsers(user);
            document1.setTradeFacility(tradeFacility1);
            documents1.add(document1);

        });
        documentRepository.saveAll(documents1);
    }
}
