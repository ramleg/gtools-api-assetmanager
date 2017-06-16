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
    public AssetType2 findByIdAndActive(Long id, boolean active);
    public Iterable<AssetType2> findAllByOrderByDescriptionAsc();
    public Iterable<AssetType2> findByActiveOrderByDescriptionAsc(boolean active);
    public Iterable<AssetType2> findByRelType1OrderByDescriptionAsc(AssetType1 rel);
    public Iterable<AssetType2> findByRelType1AndActiveOrderByDescriptionAsc(AssetType1 rel,boolean active);
}
