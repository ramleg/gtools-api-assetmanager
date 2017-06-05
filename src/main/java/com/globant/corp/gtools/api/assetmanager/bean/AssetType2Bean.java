package com.globant.corp.gtools.api.assetmanager.bean;

/**
 *
 * @author ramiro.acoglanis
 */
public class AssetType2Bean {
    Long id;
    String desc;
    String type1rel;

    public AssetType2Bean(Long id, String desc) {
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

    public String getType1rel() {
        return type1rel;
    }

    public void setType1rel(String type1rel) {
        this.type1rel = type1rel;
    }
    
    
}
