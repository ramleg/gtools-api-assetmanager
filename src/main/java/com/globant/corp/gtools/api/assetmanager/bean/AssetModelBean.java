package com.globant.corp.gtools.api.assetmanager.bean;

import com.globant.corp.gtools.api.assetmanager.entity.AssetType1;
import com.globant.corp.gtools.api.assetmanager.entity.AssetType2;
import com.globant.corp.gtools.api.assetmanager.entity.AssetType0;

/**
 *
 * @author ramiro.acoglanis
 */
public class AssetModelBean {
    
    Long id;
    String description;
    AssetType0Bean assetType0;
    AssetType1Bean assetType1;
    AssetType2Bean assetType2;
    boolean stackable;

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

    public AssetType0Bean getAssetType0() {
        return assetType0;
    }

    public void setType(AssetType0 type) {
        this.assetType0 = new AssetType0Bean(type.getId(), type.getDescription());
    }

    public AssetType1Bean getAssetType1() {
        return assetType1;
    }

    public void setType1(AssetType1 type1) {
        this.assetType1 = new AssetType1Bean(type1.getId(), type1.getDescription());
    }

    public AssetType2Bean getAssetType2() {
        return assetType2;
    }

    public void setType2(AssetType2 type2) {
        this.assetType2 = new AssetType2Bean(type2.getId(), type2.getDescription());
    }

    public boolean isStackable() {
        return stackable;
    }

    public void setStackable(boolean stackable) {
        this.stackable = stackable;
    }
    
    
}
