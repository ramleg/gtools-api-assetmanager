package com.globant.corp.gtools.api.assetmanager.serviceImpl;

import com.globant.corp.gtools.api.assetmanager.entity.AssetModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.globant.corp.gtools.api.assetmanager.repo.AssetType0Repo;
import com.globant.corp.gtools.api.assetmanager.repo.AssetType1Repo;
import com.globant.corp.gtools.api.assetmanager.repo.AssetModelRepo;
import com.globant.corp.gtools.api.assetmanager.service.AssetModelService;
import java.util.HashMap;

/**
 *
 * @author Ram
 */
@Service
public class AssetModelServiceImpl implements AssetModelService{

    @Autowired AssetModelRepo assetModelRepo;
    @Autowired AssetType0Repo assetType0Repo;
    @Autowired AssetType1Repo assetType1Repo;
    
    @Override
    public List<Map<String,String>> getList(String filter){
        
        switch(filter){
            case "enabled": return builResponseList(assetModelRepo.findByActive(true));
            case "disabled": return builResponseList(assetModelRepo.findByActive(false));
            case "all": return builResponseList(assetModelRepo.findAll());
            default:return null;
        }
    }
    
    @Override
    public Map<String,String> getByid(Long id) {
        return buildAssetModelMap(assetModelRepo.findById(id));
    }
    @Override
    public Iterable<AssetModel> getByType(Long idType0) {
        return assetModelRepo.findByAssetType0(idType0);
    }
    @Override
    public Iterable<AssetModel> getByType(Long idType0, Long idType1) {
        return assetModelRepo.findByAssetType0AndAssetType1(idType0, idType1);
    }
    

    @Override
    public String create(Map<String,String> assetMap) {
        try{
            assetModelRepo.save(buildNewAssetModel(assetMap));
            return "ok";
        }catch(Exception e){
            return "bad";
            //Log Debug lvl
        }
    }
    
    @Override
    public String update(Map<String,String> assetMap) {        
        try{
            assetModelRepo.save(buildUpdateAssetModel(assetMap));
            return "ok";
        }catch(Exception e){
            return "bad";
            //Log Debug lvl
        }
    }
    
    @Override
    public String setActive(Long id, boolean activation) {
        try{
            AssetModel asset = assetModelRepo.findById(id);
            asset.setActive(activation);
            assetModelRepo.save(asset);
            return "ok";
        }catch(Exception e){
            return "DB write error OR Wrong Asset ID";
        }
    }
    

    @Override
    public String delete(Long id) {
        try{
            assetModelRepo.delete(id);
            return "ok";
        }catch(Exception e){
            return "bad";
            //Log Debug lvl
        }
        
    }
    
    
    private AssetModel buildNewAssetModel(Map<String,String> map){
        try{
            AssetModel asset = new AssetModel();
            asset.setAssetType0(assetType0Repo.findById(Long.parseLong(map.get("assetType0"))));
            asset.setAssetType1(assetType1Repo.findById(Long.parseLong(map.get("assetType1"))));
            asset.setDetail(map.get("detail"));
            asset.setStackable((map.get("stackable").equals("true") ? true : false));
            return asset;
        }catch(Exception e){
            //Log Debug lvl
            return null;
        }
        
    }
    
    private AssetModel buildUpdateAssetModel(Map<String,String> map){
        try{
            AssetModel asset = assetModelRepo.findById(Long.parseLong(map.get("id")));
            asset.setDetail(map.get("description").equals("") ? null : map.get("description"));
            asset.setAssetType0(assetType0Repo.findById(Long.parseLong(map.get("assetType0"))));
            asset.setAssetType1(assetType1Repo.findById(Long.parseLong(map.get("assetType1"))));
            asset.setDetail(map.get("detail"));
            return asset;
        }catch(Exception e){
            //Log Debug lvl
            return null;
        }
        
    }
    
    private Map<String,String> buildAssetModelMap(AssetModel asset){
        Map<String,String> assetModelMap = new HashMap<>();
        assetModelMap.put("id", asset.getId().toString());
        assetModelMap.put("detail", asset.getDetail());
        assetModelMap.put("assetType0", asset.getAssetType0().getDescription());
        assetModelMap.put("assetType1", asset.getAssetType1().getDescription());
        return assetModelMap;
    }

    private List<Map<String,String>> builResponseList(Iterable<AssetModel> resultset){
        
        List<Map<String,String>> returnList = new ArrayList<>();
        Map<String,String> miniMap;
        
        for(AssetModel model: resultset){
            Map<String,String> map = new HashMap<>();            
            returnList.add(buildAssetModelMap(model));
        }
        
        return returnList;
    }

    
}
