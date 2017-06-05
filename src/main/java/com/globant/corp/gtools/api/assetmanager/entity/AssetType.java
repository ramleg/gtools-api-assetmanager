package com.globant.corp.gtools.api.assetmanager.entity;

/**
 *
 * @author ramiro.acoglanis
 */
public abstract class AssetType {

    private Long id;
    private String description;
    private boolean active = true;

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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    
}
