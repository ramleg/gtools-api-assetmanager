package com.globant.corp.gtools.api.assetmanager.serviceImpl;

import com.globant.corp.gtools.api.assetmanager.entity.AssetType;
import com.globant.corp.gtools.api.assetmanager.entity.AssetType0;
import com.globant.corp.gtools.api.assetmanager.entity.AssetType1;
import com.globant.corp.gtools.api.assetmanager.entity.AssetType2;
import com.globant.corp.gtools.api.assetmanager.repo.AssetType0Repo;
import com.globant.corp.gtools.api.assetmanager.repo.AssetType1Repo;
import com.globant.corp.gtools.api.assetmanager.repo.AssetType2Repo;
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
    @Autowired AssetType2Repo type2repo;

    @Override
    public String create(int Lvl, String description, Long rel) {
        try{
            switch (Lvl){
                case 0: type0repo.save(new AssetType0(description));
                        return "ok";
                case 1: type1repo.save(new AssetType1(description, type0repo.findById(rel)));
                        return "ok";
                case 2: type2repo.save(new AssetType2(description, type1repo.findById(rel)));
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
                case 2:
                    AssetType2 type2 = type2repo.findById(id);
                    type2.setDescription(description);
                    type2.setRelType1(type1repo.findById(rel));
                    type2repo.save(type2);
                    return "ok";
                default:return "bad";
            }
        }catch(Exception e){
            // Log Debug lvl
            return "bad";
        }
        
        
        
    }

    @Override
    public String setActive(int lvl, Long id, boolean active) {
        try{
            switch(lvl){
                case 0:
                    AssetType0 assetType0 = type0repo.findById(id);
                    assetType0.setActive(active);
                    type0repo.save(assetType0);
                    Iterable<AssetType1> type1Iterable = type1repo.findByRelType0OrderByDescriptionAsc(assetType0);
                    List<AssetType1> type1List = new ArrayList<>();
                    for(AssetType1 assetType1: type1Iterable){
                        assetType1.setActive(active);
                        type1List.add(assetType1);
                    }
                    type1repo.save(type1List);
                    return "ok";
                case 1:
                    AssetType1 assetType1 = type1repo.findById(id);
                    assetType1.setActive(active);
                    type1repo.save(assetType1);
                    Iterable<AssetType2> type2Iterable = type2repo.findByRelType1OrderByDescriptionAsc(assetType1);
                    List<AssetType2> type2List = new ArrayList<>();
                    for(AssetType2 assetType2: type2Iterable){
                        assetType2.setRelType1(null);
                        type2List.add(assetType2);
                    }
                    type2repo.save(type2List);
                    return "ok";
                case 2:
                    AssetType2 assetType2 = type2repo.findById(id);
                    assetType2.setActive(active);
                    type2repo.save(assetType2);
                    return "ok";
                default:return "bad";
            }
        }catch(Exception e){
            //Log Debug lvl
            return "bad";
        }
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

    @Override
    public Map<String, String> getType2(String id) {
        return buildTypeMap(type2repo.findById(Long.parseLong(id)));
    }

    @Override
    public List<Map<String, String>> getType2List(Long rel, String activeFilter) {
        if(rel==null){
            switch(activeFilter){
                case "enabled": return buildType2List(type2repo.findByActiveOrderByDescriptionAsc(true));
                case "disabled": return buildType2List(type2repo.findByActiveOrderByDescriptionAsc(false));
                case "all": return buildType2List(type2repo.findAllByOrderByDescriptionAsc());
                default:return null;
            }
        }else{
            switch(activeFilter){
                case "enabled": return buildType2List(type2repo.findByRelType1AndActiveOrderByDescriptionAsc(type1repo.findById(rel), true));
                case "disabled": return buildType2List(type2repo.findByRelType1AndActiveOrderByDescriptionAsc(type1repo.findById(rel), false));
                case "all": return buildType2List(type2repo.findByRelType1OrderByDescriptionAsc(type1repo.findById(rel)));
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
    private List<Map<String,String>> buildType2List(Iterable<AssetType2> assetType2List){
        List<Map<String,String>> list = new ArrayList<>();
        for(AssetType assetType: assetType2List){
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
        if(assetType instanceof AssetType2){
            String s = ((AssetType2) assetType).getRelType1().getId().toString();
            map.put("relType1", s);
        }
            
        return map;
    }

    @Override
    public String delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
