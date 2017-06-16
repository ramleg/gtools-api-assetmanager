package com.globant.corp.gtools.api.assetmanager.serviceImpl;

import com.globant.corp.gtools.api.assetmanager.entity.AssetType;
import com.globant.corp.gtools.api.assetmanager.entity.AssetType0;
import com.globant.corp.gtools.api.assetmanager.entity.AssetType1;
import com.globant.corp.gtools.api.assetmanager.repo.AssetType0Repo;
import com.globant.corp.gtools.api.assetmanager.repo.AssetType1Repo;
import org.springframework.stereotype.Service;
import com.globant.corp.gtools.api.assetmanager.service.AssetTypeService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ramiro.acoglanis
 */
@Service
public class AssetTypeServiceImpl implements AssetTypeService{

    @Autowired AssetType0Repo type0repo;
    @Autowired AssetType1Repo type1repo;

    @Override
    public String create(int Lvl, String description, Long rel) {
        try{
            switch (Lvl){
                case 0: type0repo.save(new AssetType0(description));
                        return "ok";
                case 1: type1repo.save(new AssetType1(description, type0repo.findById(rel)));
                        return "ok";
                default:return "bad";
            }
        }catch(Exception e){
            // Log Debug lvl
            return "bad";
        }
    }

    @Override
    public String update(Long id, int lvl, String description, Long rel) {
        try{
            switch(lvl){
                case 0:
                    AssetType0 type0 = type0repo.findById(id);
                    type0.setDescription(description);
                    type0repo.save(type0);
                    return "ok";
                case 1:
                    AssetType1 type1 = type1repo.findById(id);
                    type1.setDescription(description);
                    type1.setRelType0(type0repo.findById(rel));
                    type1repo.save(type1);
                    return "ok";
                default:return "bad";
            }
        }catch(Exception e){
            // Log Debug lvl
            return "bad";
        }
        
    }

    @Override
    public String activate(int lvl, Long id) {
        return null;
    }
    @Override
    public String deactivate(int lvl, Long id) {
        return null;
    }

    @Override
    public Map<String, String> getType0(String id) {
        return buildTypeMap(type0repo.findById(Long.parseLong(id)));
    }

    @Override
    public List<Map<String, String>> getType0List(String activeFilter) {
        switch(activeFilter){
            case "enabled": return buildType0List(type0repo.findByActiveOrderByDescriptionAsc(true));
            case "dosabled": return buildType0List(type0repo.findByActiveOrderByDescriptionAsc(false));
            case "all": return buildType0List(type0repo.findAllByOrderByDescriptionAsc());
            default: return null;
        }
    }

    @Override
    public Map<String, String> getType1(String id) {
        return buildTypeMap(type1repo.findById(Long.parseLong(id)));
    }

    @Override
    public List<Map<String, String>> getType1List(Long rel, String activeFilter) {
        if(rel==null){
            switch(activeFilter){
                case "enabled": return buildType1List(type1repo.findByActiveOrderByDescriptionAsc(true));
                case "disabled": return buildType1List(type1repo.findByActiveOrderByDescriptionAsc(false));
                case "all": return buildType1List(type1repo.findAllByOrderByDescriptionAsc());
                default:return null;
            }
        }else{
            switch(activeFilter){
                case "enabled": return buildType1List(type1repo.findByRelType0AndActiveOrderByDescriptionAsc(type0repo.findById(rel), true));
                case "disabled": return buildType1List(type1repo.findByRelType0AndActiveOrderByDescriptionAsc(type0repo.findById(rel), false));
                case "all": return buildType1List(type1repo.findByRelType0OrderByDescriptionAsc(type0repo.findById(rel)));
                default:return null;
            }
        }
    }

    private List<Map<String,String>> buildType0List(Iterable<AssetType0> assetType0List){
        List<Map<String,String>> list = new ArrayList<>();
        for(AssetType assetType: assetType0List){
            list.add(buildTypeMap(assetType));
        }
        return list;
    }
    private List<Map<String,String>> buildType1List(Iterable<AssetType1> assetType1List){
        List<Map<String,String>> list = new ArrayList<>();
        for(AssetType assetType: assetType1List){
            list.add(buildTypeMap(assetType));
        }
        return list;
    }
    
    private Map<String, String> buildTypeMap(AssetType assetType){
        
        Map<String,String> map = new HashMap<>();
        
        map.put("id",assetType.getId().toString());
        map.put("description", assetType.getDescription());
        map.put("active", String.valueOf(assetType.isActive()));
        if(assetType instanceof AssetType1){
            String s = ((AssetType1) assetType).getRelType0().getId().toString();
            map.put("relType0", s);
        }            
        return map;
    }

    @Override
    public String delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
