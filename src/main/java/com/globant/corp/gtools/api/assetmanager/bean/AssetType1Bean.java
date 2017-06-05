package com.globant.corp.gtools.api.assetmanager.bean;

/**
 *
 * @author ramiro.acoglanis
 */
public class AssetType1Bean {
    Long id;
    String desc;
    String type0rel;
    
    public AssetType1Bean(Long id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getType0rel() {
        return type0rel;
    }

    public void setType0rel(String type0rel) {
        this.type0rel = type0rel;
    }
    
}
