package com.globant.corp.gtools.api.assetmanager.service;

import com.globant.corp.gtools.api.assetmanager.bean.AssetModelBean;
import com.globant.corp.gtools.api.assetmanager.entity.AssetModel;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ram
 */
public interface AssetModelService {
    
    public List<Map<String,String>> getList(String filter);
    public Map<String,String> getByid(Long id);
    public Iterable<AssetModel> getByType(Long idType);
    public Iterable<AssetModel> getByType(Long idType, Long idSubType1);
    public Iterable<AssetModel> getByType(Long idType, Long idSubType1, Long idSubType2);
    
    public String create(Map<String,String> assetMap);
    public String update(Map<String,String> assetMap);
        
    public String setActive(Long id, boolean activation);
    
    public String delete(Long id);
}
