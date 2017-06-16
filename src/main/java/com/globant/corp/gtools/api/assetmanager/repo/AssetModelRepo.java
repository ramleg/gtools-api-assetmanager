package com.globant.corp.gtools.api.assetmanager.repo;

import com.globant.corp.gtools.api.assetmanager.entity.AssetModel;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Ram
 */
public interface AssetModelRepo extends CrudRepository<AssetModel, Long>{
    public AssetModel findById(Long id);
    public Iterable<AssetModel> findByActive(boolean active);
    public Iterable<AssetModel> findByAssetType0(Long idType0);
    public Iterable<AssetModel> findByAssetType0AndAssetType1(Long idType0, Long idType1);
}
