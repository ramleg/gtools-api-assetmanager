/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.corp.gtools.api.assetmanager.entity;

import javax.persistence.Column;
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
 * @author ramiro.acoglanis
 */
@Entity(name="AssetModel")
@Table(name="asset_model")
public class AssetModel {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String description;
    private boolean stackable = false;
    private boolean active = true;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_asset_type0")
    private AssetType0 assetType0;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_asset_type1")
    private AssetType1 assetType1;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_asset_type2")
    private AssetType2 assetType2;

    
    
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

    public boolean isStackable() {
        return stackable;
    }

    public void setStackable(boolean stackable) {
        this.stackable = stackable;
    }

    public AssetType0 getAssetType0() {
        return assetType0;
    }

    public void setAssetType0(AssetType0 assetType0) {
        this.assetType0 = assetType0;
    }

    public AssetType1 getAssetType1() {
        return assetType1;
    }

    public void setAssetType1(AssetType1 assetType1) {
        this.assetType1 = assetType1;
    }

    public AssetType2 getAssetType2() {
        return assetType2;
    }

    public void setAssetType2(AssetType2 assetType2) {
        this.assetType2 = assetType2;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    
}
