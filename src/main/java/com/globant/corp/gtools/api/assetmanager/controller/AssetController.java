package com.globant.corp.gtools.api.assetmanager.controller;

import com.globant.corp.gtools.api.assetmanager.entity.Asset;
import com.globant.corp.gtools.api.assetmanager.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public Iterable<Asset> getall(){
        return assetService.getAll();
    }

    @GetMapping("/id/{id}")
    public Asset getById(@PathVariable("id") String id){
        return assetService.getByid(Long.parseLong(id));
    }
    
    @GetMapping("/type/{type}")
    public Iterable<Asset> getByType(@PathVariable("type") String type){
        return assetService.getByType(Long.parseLong(type));
    }
    
}
