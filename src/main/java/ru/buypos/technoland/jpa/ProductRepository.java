package ru.buypos.technoland.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.buypos.technoland.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}