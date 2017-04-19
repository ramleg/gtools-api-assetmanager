package com.globant.corp.gtools.api.assetmanager.serviceImpl;

import com.globant.corp.gtools.api.assetmanager.bean.AssetBean;
import com.globant.corp.gtools.api.assetmanager.bean.AssetType0Bean;
import com.globant.corp.gtools.api.assetmanager.entity.Asset;
import com.globant.corp.gtools.api.assetmanager.repo.AssetRepo;
import com.globant.corp.gtools.api.assetmanager.service.AssetService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.globant.corp.gtools.api.assetmanager.repo.AssetType0Repo;
import com.globant.corp.gtools.api.assetmanager.repo.AssetType1Repo;
import com.globant.corp.gtools.api.assetmanager.repo.AssetType2Repo;

/**
 *
 * @author Ram
 */
@Service
public class AssetServiceImpl implements AssetService{

    @Autowired
    AssetRepo assetRepo;
    
    @Autowired
    AssetType0Repo assetType0Repo;
    @Autowired
    AssetType1Repo assetType1Repo;
    @Autowired
    AssetType2Repo assetType2Repo;
    
    @Override
    public List<AssetBean> getAll(){
        List<AssetBean> assetList = new ArrayList<>();
        for(Asset asset : assetRepo.findAll()){
            assetList.add(createAssetBean(asset));
        }
        return assetList;
    }

    @Override
    public AssetBean getByid(Long id) {
        return createAssetBean(assetRepo.findById(id));
    }

    @Override
    public Iterable<Asset> getByType(Long idType0) {
        return assetRepo.findByAssetType0(idType0);
    }

    @Override
    public Iterable<Asset> getByType(Long idType0, Long idType1) {
        return assetRepo.findByAssetType0AndAssetType1(idType0, idType1);
    }

    @Override
    public Iterable<Asset> getByType(Long idType0, Long idType1, Long idType2) {
        return assetRepo.findByAssetType0AndAssetType1AndAssetType2(idType0, idType1, idType2);
    }
    
    
    private AssetBean createAssetBean(Asset asset){
        AssetBean bean = new AssetBean();
        bean.setId(asset.getId());
        bean.setDescription(asset.getDescription());
        bean.setType(asset.getAssetType0());
        bean.setType1(asset.getAssetType1());
        bean.setType2(asset.getAssetType2());
        bean.setStackable(asset.isStackable());
        return bean;
    }

    @Override
    public String save(Map<String,String> map) {        
        try{
            assetRepo.save(buildAsset(map));
            return "ok";
        }catch(Exception e){
            return "bad";
        }
        
           
        
    }

    @Override
    public String save(List<Map<String,String>> mapList) {
        List<Asset> assetList = new ArrayList<>();
        try{
            for(Map<String,String> map : mapList){
            assetList.add(buildAsset(map));
            }
            assetRepo.save(assetList);
            return "ok";
        }catch(Exception e){
            return "bad";
        }
        
    }
    
    private Asset buildAsset(Map<String,String> map){
        Asset asset = new Asset();
        //asset.setId(Long.parseLong(map.get("id")));
        asset.setDescription(map.get("description"));
        asset.setAssetType0(assetType0Repo.findById(Long.parseLong(map.get("assetType0"))));
        asset.setAssetType1(assetType1Repo.findById(Long.parseLong(map.get("assetType1"))));
        asset.setAssetType2(assetType2Repo.findById(Long.parseLong(map.get("assetType2"))));
        asset.setStackable((map.get("stackable").equals("true")?true:false));
        return asset;
    }
}
