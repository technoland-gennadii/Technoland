package ru.buypos.technoland.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.buypos.technoland.model.Cod;

public interface CodRepository extends JpaRepository<Cod, Long> {
}