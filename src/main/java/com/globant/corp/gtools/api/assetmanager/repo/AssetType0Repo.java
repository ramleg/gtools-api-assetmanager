package com.globant.corp.gtools.api.assetmanager.repo;

import com.globant.corp.gtools.api.assetmanager.entity.AssetType0;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author ramiro.acoglanis
 */
public interface AssetType0Repo extends CrudRepository<AssetType0, Long>{
    
    public AssetType0 findById(Long id);
    public AssetType0 findByIdAndActive(Long id, boolean active);
    public Iterable<AssetType0> findAllByOrderByDescriptionAsc();
    public Iterable<AssetType0> findByActiveOrderByDescriptionAsc(boolean  active);
    
}
