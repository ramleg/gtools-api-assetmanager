package com.globant.corp.gtools.api.assetmanager.repo;

import com.globant.corp.gtools.api.assetmanager.entity.Asset;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Ram
 */
public interface AssetRepo extends CrudRepository<Asset, Long>{
    public Asset findById(Long id);
    public Iterable<Asset> findByType(Long idType);
    public Iterable<Asset> findByTypeAndSubType1(Long idType, Long idSubType1);
    public Iterable<Asset> findByTypeAndSubType1AndSubType2(Long idType, Long idSubType1, Long idSubType2);
}
