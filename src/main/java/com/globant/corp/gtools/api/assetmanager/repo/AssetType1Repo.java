package com.globant.corp.gtools.api.assetmanager.repo;

import com.globant.corp.gtools.api.assetmanager.entity.AssetType1;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author ramiro.acoglanis
 */
public interface AssetType1Repo extends CrudRepository<AssetType1, Long>{
    public AssetType1 findById(Long id);
}
