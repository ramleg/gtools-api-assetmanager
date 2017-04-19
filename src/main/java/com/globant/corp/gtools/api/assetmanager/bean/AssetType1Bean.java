package com.globant.corp.gtools.api.assetmanager.bean;

/**
 *
 * @author ramiro.acoglanis
 */
public class AssetType1Bean {
    Long id;
    String desc;

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
}
