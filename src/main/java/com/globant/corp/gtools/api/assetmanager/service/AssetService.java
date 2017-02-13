package com.globant.corp.gtools.api.assetmanager.service;

import com.globant.corp.gtools.api.assetmanager.entity.Asset;

/**
 *
 * @author Ram
 */
public interface AssetService {
    
    public Iterable<Asset> getAll();
    public Asset getByid(Long id);
    public Iterable<Asset> getByType(Long idType);
    public Iterable<Asset> getByType(Long idType, Long idSubType1);
    public Iterable<Asset> getByType(Long idType, Long idSubType1, Long idSubType2);
}
