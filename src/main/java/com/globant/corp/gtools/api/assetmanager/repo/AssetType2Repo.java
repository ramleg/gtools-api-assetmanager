package com.globant.corp.gtools.api.assetmanager.repo;

import com.globant.corp.gtools.api.assetmanager.entity.AssetType2;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author ramiro.acoglanis
 */
public interface AssetType2Repo extends CrudRepository<AssetType2, Long>{
    public AssetType2 findById(Long id);
    
}
