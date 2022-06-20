package ru.buypos.technoland.model;

import javax.persistence.*;

@Entity
@Table(name = "cod")
public class Cod {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "g_cod")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "val", length = 45)
    private String val;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "nomenclature_id", nullable = false)
    private Nomenclature nomenclature;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "trade_facility_id", nullable = false)
    private TradeFacility tradeFacility;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public Nomenclature getNomenclature() {
        return nomenclature;
    }

    public void setNomenclature(Nomenclature nomenclature) {
        this.nomenclature = nomenclature;
    }

    public TradeFacility getTradeFacility() {
        return tradeFacility;
    }

    public void setTradeFacility(TradeFacility tradeFacility) {
        this.tradeFacility = tradeFacility;
    }

}