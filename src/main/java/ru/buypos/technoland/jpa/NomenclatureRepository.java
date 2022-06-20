package ru.buypos.technoland.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.buypos.technoland.model.Nomenclature;

public interface NomenclatureRepository extends JpaRepository<Nomenclature, Long> {
}