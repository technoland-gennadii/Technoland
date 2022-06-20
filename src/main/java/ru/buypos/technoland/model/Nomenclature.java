package ru.buypos.technoland.model;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "nomenclature")
public class Nomenclature {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "g_nomenclature")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "article", length = 45)
    private String article;

    @Column(name = "name", length = 45)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "users_id", nullable = false)
    private User users;

    @OneToMany(mappedBy = "nomenclature")
    private Set<Product> products = new LinkedHashSet<>();

    @OneToMany(mappedBy = "nomenclature")
    private Set<Cod> cod = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
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

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Set<Cod> getCod() {
        return cod;
    }

    public void setCod(Set<Cod> cod) {
        this.cod = cod;
    }

}