package ru.buypos.technoland.model;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "trade_facility")
public class TradeFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "g_trade_facility")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", length = 45)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "users_id", nullable = false)
    private User users;

    @OneToMany(mappedBy = "tradeFacility")
    private Set<Document> documents = new LinkedHashSet<>();

    @OneToMany(mappedBy = "tradeFacility")
    private Set<Cod> cod = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public Set<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
    }

    public Set<Cod> getCod() {
        return cod;
    }

    public void setCod(Set<Cod> cod) {
        this.cod = cod;
    }

}