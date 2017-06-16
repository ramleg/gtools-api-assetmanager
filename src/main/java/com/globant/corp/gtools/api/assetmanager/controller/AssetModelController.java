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
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author Ram
 */

@RestController
@RequestMapping("/assetmodel")
@CrossOrigin(origins = "*")
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
    @RequestMapping(value = "/activation", method = RequestMethod.PUT)
    public @ResponseBody String disableAsset(@RequestBody Map<String,String> assetModelData){
        return assetModelService.setActive(Long.parseLong(assetModelData.get("id")), false);
    }
    // enable an assetmodel
    @RequestMapping(value = "/deactivation", method = RequestMethod.PUT)
    public @ResponseBody String enableAsset(@RequestBody Map<String,String> assetModelData){
        return assetModelService.setActive(Long.parseLong(assetModelData.get("id")), true);
    }
    
    
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
    
    @RequestMapping(value = "/type0", method = RequestMethod.POST)
    public @ResponseBody String createType0(@RequestBody Map<String,String> type0){
        return assetTypeService.create(0, type0.get("description"), null);
    }
    
    @RequestMapping(value = "/type0", method = RequestMethod.PUT)
    public @ResponseBody String updateType0(@RequestBody Map<String,String> type0){
        return assetTypeService.update(Long.parseLong(type0.get("id")),0,type0.get("description"),null);
    }
    
    @RequestMapping(value = "/type0/activation", method = RequestMethod.POST)
    public @ResponseBody String activateType0(@RequestBody Map<String,String> type0){
        return null;
    }
    
    @RequestMapping(value = "/type0/deactivation", method = RequestMethod.POST)
    public @ResponseBody String deactivateType0(@RequestBody Map<String,String> type0){
        return null;
    }
    
    
    //***************************************************************************************************************
    
    
    // filter can accept 'id' to get a particular one
    @GetMapping("/type1/{id}")
    public @ResponseBody Map<String,String> getAssetType1(@PathVariable("id") String id){
        return assetTypeService.getType1(id);
    }
    // the 'filter' accepts the words 'enabled' / 'disabled' / 'all'
    // the 'rel' is the 'id' relType0
    @GetMapping("/type1/list/{rel}/{filter}")
    public @ResponseBody List<Map<String,String>> getAssetType1list(@PathVariable("filter") String filter,@PathVariable("rel") String rel){
        Long r = rel.equals("0")?null:Long.parseLong(rel);
        return assetTypeService.getType1List(r,filter);
    }
    
    @RequestMapping(value = "/type1", method = RequestMethod.POST)
    public @ResponseBody String createType1(@RequestBody Map<String,String> type1){
        return assetTypeService.create(1, type1.get("description"), Long.parseLong(type1.get("relType0")));
    }
    
    @RequestMapping(value = "/type1", method = RequestMethod.PUT)
    public @ResponseBody String updateType1(@RequestBody Map<String,String> type1){
        return assetTypeService.update(Long.parseLong(type1.get("id")),1,type1.get("description"),Long.parseLong(type1.get("relType0")));
    }
    
    @RequestMapping(value = "/type1/activation", method = RequestMethod.PUT)
    public @ResponseBody String activateType1(@RequestBody Map<String,String> type0){
        return null;
    }
    
    @RequestMapping(value = "/type1/deactivation", method = RequestMethod.PUT)
    public @ResponseBody String deactivateType1(@RequestBody Map<String,String> type0){
        return null;
    }
    
    //***************************************************************************************************************
    
    
    // filter can accept 'id' to get a particular one
    @GetMapping("/type2/{id}")
    public @ResponseBody Map<String,String> getAssetType2(@PathVariable("id") String id){
        return assetTypeService.getType2(id);
    }
    // the 'filter' accepts the words 'enabled' / 'disabled' / 'all'
    // the 'rel' is the 'id' relType1
    @GetMapping("/type2/list/{rel}/{filter}")
    public @ResponseBody List<Map<String,String>> getAssetType2list(@PathVariable("filter") String filter,@PathVariable("rel") String rel){
        Long r = rel.equals("0")?null:Long.parseLong(rel);
        return assetTypeService.getType2List(r,filter);
    }
    @RequestMapping(value = "/type2", method = RequestMethod.POST)
    public @ResponseBody String createType2(@RequestBody Map<String,String> type2){
        return assetTypeService.create(2, type2.get("description"), Long.parseLong(type2.get("relType0")));
    }
    @RequestMapping(value = "/type2", method = RequestMethod.PUT)
    public @ResponseBody String updateType2(@RequestBody Map<String,String> type2){
        return assetTypeService.update(Long.parseLong(type2.get("id")),2,type2.get("description"),Long.parseLong(type2.get("relType1")));
    }
    
    @RequestMapping(value = "/type2/activation", method = RequestMethod.PUT)
    public @ResponseBody String activateType2(@RequestBody Map<String,String> type0){
        return null;
    }
    
    @RequestMapping(value = "/type2/deactivation", method = RequestMethod.PUT)
    public @ResponseBody String deactivateType2(@RequestBody Map<String,String> type0){
        return null;
    }
    
}
