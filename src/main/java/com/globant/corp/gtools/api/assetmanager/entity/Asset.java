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
@Entity(name="Asset")
@Table(name="asset")
public class Asset {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String desc;
    @Column(name="owner_group")
    private Integer OwnerGroup;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_type")
    private Type type;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_sub_type_1")
    private SubType1 subType1;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_sub_type_2")
    private SubType2 subType2;

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

    public Integer getOwnerGroup() {
        return OwnerGroup;
    }

    public void setOwnerGroup(Integer OwnerGroup) {
        this.OwnerGroup = OwnerGroup;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public SubType1 getSubType1() {
        return subType1;
    }

    public void setSubType1(SubType1 subType1) {
        this.subType1 = subType1;
    }

    public SubType2 getSubType2() {
        return subType2;
    }

    public void setSubType2(SubType2 subType2) {
        this.subType2 = subType2;
    }

    
}
