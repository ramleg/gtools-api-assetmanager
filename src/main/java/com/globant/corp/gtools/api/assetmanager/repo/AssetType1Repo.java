package com.globant.corp.gtools.api.assetmanager.repo;

import com.globant.corp.gtools.api.assetmanager.entity.AssetType0;
import com.globant.corp.gtools.api.assetmanager.entity.AssetType1;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author ramiro.acoglanis
 */
public interface AssetType1Repo extends CrudRepository<AssetType1, Long>{
    public AssetType1 findById(Long id);
    public Iterable<AssetType1> findByActive(boolean active);
    public Iterable<AssetType1> findByRelType0(AssetType0 rel);
    public Iterable<AssetType1> findByRelType0AndActive(AssetType0 rel, boolean active);
}
