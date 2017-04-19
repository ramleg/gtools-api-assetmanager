package com.globant.corp.gtools.api.assetmanager.repo;

import com.globant.corp.gtools.api.assetmanager.entity.Asset;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Ram
 */
public interface AssetRepo extends CrudRepository<Asset, Long>{
    public Asset findById(Long id);
    public Iterable<Asset> findByAssetType0(Long idType0);
    public Iterable<Asset> findByAssetType0AndAssetType1(Long idType0, Long idType1);
    public Iterable<Asset> findByAssetType0AndAssetType1AndAssetType2(Long idType0, Long idType1, Long idType2);
}
