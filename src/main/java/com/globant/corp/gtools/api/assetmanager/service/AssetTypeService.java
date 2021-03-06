package com.globant.corp.gtools.api.assetmanager.service;

import com.globant.corp.gtools.api.assetmanager.entity.AssetType0;
import com.globant.corp.gtools.api.assetmanager.entity.AssetType1;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ramiro.acoglanis
 */
public interface AssetTypeService {
    public Map<String,String> getType0(String id);
    public List<Map<String, String>> getType0List(String activeFilter);
    public Map<String,String> getType1(String id);
    public List<Map<String, String>> getType1List(Long rel, String activeFilter);
    
    public String create(int lvl, String description, Long rel);
    public String update(Long id, int lvl, String description, Long rel);
    public String activate(int lvl, Long id);
    public String deactivate(int lvl, Long id);
    public String delete(Long id);
}
