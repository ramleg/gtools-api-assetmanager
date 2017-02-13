package com.globant.corp.gtools.api.assetmanager.serviceImpl;

import com.globant.corp.gtools.api.assetmanager.entity.Asset;
import com.globant.corp.gtools.api.assetmanager.repo.AssetRepo;
import com.globant.corp.gtools.api.assetmanager.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ram
 */
@Service
public class AssetServiceImpl implements AssetService{

    @Autowired
    AssetRepo repo;
    
    @Override
    public Iterable<Asset> getAll() {
        return repo.findAll();
    }

    @Override
    public Asset getByid(Long id) {
        return repo.findById(id);
    }

    @Override
    public Iterable<Asset> getByType(Long idType) {
        return repo.findByType(idType);
    }

    @Override
    public Iterable<Asset> getByType(Long idType, Long idSubType1) {
        return repo.findByTypeAndSubType1(idType, idSubType1);
    }

    @Override
    public Iterable<Asset> getByType(Long idType, Long idSubType1, Long idSubType2) {
        return repo.findByTypeAndSubType1AndSubType2(idType, idSubType1, idSubType2);
    }
    
}
