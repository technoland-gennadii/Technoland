package ru.buypos.technoland.model;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "g_users")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", nullable = false, length = 45)
    private String username;

    @Column(name = "`key`", nullable = false, length = 45)
    private String key;

    @OneToMany(mappedBy = "users")
    private Set<Nomenclature> nomenclatures = new LinkedHashSet<>();

    @OneToMany(mappedBy = "users")
    private Set<TradeFacility> tradeFacilities = new LinkedHashSet<>();

    @OneToMany(mappedBy = "users")
    private Set<Document> documents = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Set<Nomenclature> getNomenclatures() {
        return nomenclatures;
    }

    public void setNomenclatures(Set<Nomenclature> nomenclatures) {
        this.nomenclatures = nomenclatures;
    }

    public Set<TradeFacility> getTradeFacilities() {
        return tradeFacilities;
    }

    public void setTradeFacilities(Set<TradeFacility> tradeFacilities) {
        this.tradeFacilities = tradeFacilities;
    }

    public Set<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
    }

}