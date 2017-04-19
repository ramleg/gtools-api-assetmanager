package com.globant.corp.gtools.api.assetmanager.service;

import com.globant.corp.gtools.api.assetmanager.bean.AssetBean;
import com.globant.corp.gtools.api.assetmanager.entity.Asset;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ram
 */
public interface AssetService {
    
    public List<AssetBean> getAll();
    public AssetBean getByid(Long id);
    public Iterable<Asset> getByType(Long idType);
    public Iterable<Asset> getByType(Long idType, Long idSubType1);
    public Iterable<Asset> getByType(Long idType, Long idSubType1, Long idSubType2);
    
    public String save(Map<String,String> map);
    public String save(List<Map<String,String>> mapList);
}
