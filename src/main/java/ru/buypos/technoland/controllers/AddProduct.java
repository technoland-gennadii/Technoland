package ru.buypos.technoland.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.buypos.technoland.jpa.DocumentRepository;
import ru.buypos.technoland.jpa.NomenclatureRepository;
import ru.buypos.technoland.jpa.ProductRepository;
import ru.buypos.technoland.model.Document;
import ru.buypos.technoland.model.Nomenclature;
import ru.buypos.technoland.model.Product;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AddProduct {

    @Autowired
    DocumentRepository documentRepository;



    @Autowired
    NomenclatureRepository nomenclatureRepository;


    @Autowired
    ProductRepository productRepository;



    @GetMapping(path = "/addProduct/{documentsId}/{nomenclatureId}")
    public void addProduct (@PathVariable Long documentsId, @PathVariable Long nomenclatureId, @RequestBody List<Product> products) {

        Document document = documentRepository.findById(documentsId).orElseThrow();
        Nomenclature nomenclature1 = nomenclatureRepository.findById(nomenclatureId).orElseThrow();



        List<Product> products1 = new ArrayList<>();

        products.forEach(product -> {

            Product product1 = new Product();

            product1.setNomenclaturecod(product.getNomenclaturecod());
            product1.setQuantity(product.getQuantity());

            product1.setDocument(document);
            product1.setNomenclature(nomenclature1);

            products1.add(product1);

        });
        productRepository.saveAll(products1);
    }


}
