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
 * @author ramiro.acoglanis
 */
@Entity(name="StockedAsset")
@Table(name="global_stock")
public class StockedAsset {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String comment;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_asset")
    private AssetModel assetInfo;
    
    
    
}
