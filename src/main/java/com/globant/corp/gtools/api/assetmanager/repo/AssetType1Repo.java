package com.globant.corp.gtools.api.assetmanager.repo;

import com.globant.corp.gtools.api.assetmanager.entity.AssetType0;
import com.globant.corp.gtools.api.assetmanager.entity.AssetType1;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author ramiro.acoglanis
 */
public interface AssetType1Repo extends CrudRepository<AssetType1, Long>{
    public AssetType1 findById(Long id);
    public AssetType1 findByIdAndActive(Long id, boolean active);
    public Iterable<AssetType1> findAllByOrderByDescriptionAsc();
    public Iterable<AssetType1> findByActiveOrderByDescriptionAsc(boolean active);
    public Iterable<AssetType1> findByRelType0OrderByDescriptionAsc(AssetType0 rel);
    public Iterable<AssetType1> findByRelType0AndActiveOrderByDescriptionAsc(AssetType0 rel, boolean active);
}
