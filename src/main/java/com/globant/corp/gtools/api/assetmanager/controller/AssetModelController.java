package com.globant.corp.gtools.api.assetmanager.controller;

import com.globant.corp.gtools.api.assetmanager.bean.AssetModelBean;
import com.globant.corp.gtools.api.assetmanager.entity.AssetModel;
import com.globant.corp.gtools.api.assetmanager.entity.AssetType0;
import com.globant.corp.gtools.api.assetmanager.entity.AssetType1;
import com.globant.corp.gtools.api.assetmanager.entity.AssetType2;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.globant.corp.gtools.api.assetmanager.service.AssetModelService;
import com.globant.corp.gtools.api.assetmanager.service.AssetTypeService;
import com.globant.corp.gtools.api.assetmanager.service.Utilities;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Ram
 */

@RestController
@RequestMapping("/assetmodel")
public class AssetModelController {
    
    @Autowired Utilities util;
    @Autowired AssetModelService assetModelService;
    @Autowired AssetTypeService assetTypeService;
    
    @GetMapping("/{id}")
    public Map<String,String> getAssetModel(@PathVariable("id") String id){
        return assetModelService.getByid(Long.parseLong(id));
    }
    
    // The filter acepts 'enabled' 'disabled' and 'all'
    @GetMapping("/list/{filter}")
    public List<Map<String,String>> listAssetModel(@PathVariable("filter") String filter){
        return assetModelService.getList(filter);
    }

    // adds new assetmodel
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody String createAsset(@RequestBody Map<String,String> assetMap){
        return assetModelService.create(assetMap);
    }    
    //update an assetmodel
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public @ResponseBody String saveAsset(@RequestBody Map<String,String> assetMap){
        return assetModelService.update(assetMap);
    }
    // delete an assetmodel
    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public @ResponseBody String deleteAsset(@RequestBody Map<String,String> assetModelData){
        return assetModelService.delete(Long.parseLong(assetModelData.get("id")));
    }
    
    // disable an assetmodel
    @RequestMapping(value = "/activation", method = RequestMethod.DELETE)
    public @ResponseBody String disableAsset(@RequestBody Map<String,String> assetModelData){
        return assetModelService.setActive(Long.parseLong(assetModelData.get("id")), false);
    }
    // enable an assetmodel
    @RequestMapping(value = "/activation", method = RequestMethod.PUT)
    public @ResponseBody String enableAsset(@RequestBody Map<String,String> assetModelData){
        return assetModelService.setActive(Long.parseLong(assetModelData.get("id")), true);
    }
    
    //***************************************************************************************************************
    //***************************************************************************************************************
    //***************************************************************************************************************
    
    
    // filter can accept 'id' to get a particular one
    @GetMapping("/type0/{id}")
    public @ResponseBody Map<String,String> getAssetType0(@PathVariable("id") String id){
        return assetTypeService.getType0(id);
    }
    // the filter accepts the words 'enabled' / 'disabled' / 'all'
    @GetMapping("/type0/list/{filter}")
    public @ResponseBody List<Map<String,String>> getAssetType0list(@PathVariable("filter") String filter){
        return assetTypeService.getType0List(filter);
    }
    // filter can accept 'id' to get a particular one
    @GetMapping("/type1/{id}")
    public @ResponseBody Map<String,String> getAssetType1(@PathVariable("id") String id){
        return assetTypeService.getType1(id);
    }
    // the 'filter' accepts the words 'enabled' / 'disabled' / 'all'
    // the 'rel' is the 'id' relType0
    @GetMapping("/type1/list/{rel}/{filter}")
    public @ResponseBody List<Map<String,String>> getAssetType1list(@PathVariable("filter") String filter,@PathVariable("rel") String rel){
        return assetTypeService.getType1List(Long.parseLong(rel),filter);
    }
    // filter can accept 'id' to get a particular one
    @GetMapping("/type2/{id}")
    public @ResponseBody Map<String,String> getAssetType2(@PathVariable("id") String id){
        return assetTypeService.getType2(id);
    }
    // the 'filter' accepts the words 'enabled' / 'disabled' / 'all'
    // the 'rel' is the 'id' relType0
    @GetMapping("/type2/list/{rel}/{filter}")
    public @ResponseBody List<Map<String,String>> getAssetType2list(@PathVariable("filter") String filter,@PathVariable("rel") String rel){
        return assetTypeService.getType2List(Long.parseLong(rel),filter);
    }
}
