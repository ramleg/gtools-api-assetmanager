package com.globant.corp.gtools.api.assetmanager.repo;

import com.globant.corp.gtools.api.assetmanager.entity.AssetType1;
import com.globant.corp.gtools.api.assetmanager.entity.AssetType2;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author ramiro.acoglanis
 */
public interface AssetType2Repo extends CrudRepository<AssetType2, Long>{
    public AssetType2 findById(Long id);
    public Iterable<AssetType2> findByActive(boolean active);
    public Iterable<AssetType2> findByRelType1(AssetType1 rel);
    public Iterable<AssetType2> findByRelType1AndActive(AssetType1 rel, boolean active);
    
}
