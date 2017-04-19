package com.globant.corp.gtools.api.assetmanager.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Ram
 */
@Entity(name="AssetType1")
@Table(name="asset_type1")
public class AssetType1 {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String description;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_asset_type0")
    private AssetType0 relType0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AssetType0 getRelType0() {
        return relType0;
    }

    public void setRelType0(AssetType0 relType0) {
        this.relType0 = relType0;
    }

    
    
}
