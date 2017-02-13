/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@Entity(name="SubType2")
@Table(name="sub_type_2")
public class SubType2 {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String desc;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_sub_type_1")
    private SubType1 relSubType1;

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

    public SubType1 getRelSubType1() {
        return relSubType1;
    }

    public void setRelSubType1(SubType1 relSubType1) {
        this.relSubType1 = relSubType1;
    }

    
    
}
