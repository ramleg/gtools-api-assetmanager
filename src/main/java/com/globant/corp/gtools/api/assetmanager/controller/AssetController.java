package com.globant.corp.gtools.api.assetmanager.controller;

import com.globant.corp.gtools.api.assetmanager.bean.AssetBean;
import com.globant.corp.gtools.api.assetmanager.entity.Asset;
import com.globant.corp.gtools.api.assetmanager.service.AssetService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ram
 */
@RestController
@RequestMapping("/asset")
public class AssetController {
    
    @Autowired
    AssetService assetService;
    
    @GetMapping("/getall")
    public Iterable<AssetBean> getall(){
        return assetService.getAll();
    }

    @GetMapping("/id/{id}")
    public AssetBean getById(@PathVariable("id") String id){
        return assetService.getByid(Long.parseLong(id));
    }
    
    @GetMapping("/type/{type}")
    public Iterable<Asset> getByType(@PathVariable("type") String type){
        return assetService.getByType(Long.parseLong(type));
    }
    

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public @ResponseBody String putAsset(@RequestBody Map<String,String> asset){
        return assetService.save(asset);
    }
    
}
