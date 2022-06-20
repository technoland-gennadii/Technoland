package ru.buypos.technoland.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.buypos.technoland.model.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}