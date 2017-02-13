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
@Entity(name="SubType1")
@Table(name="sub_type_1")
public class SubType1 {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String desc;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_type")
    private Type relType;

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

    public Type getRelType() {
        return relType;
    }

    public void setRelType(Type relType) {
        this.relType = relType;
    }

    
    
}
