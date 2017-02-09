package com.globant.corp.gtools.api.assetmanager.controller;

import com.globant.corp.gtools.api.assetmanager.entity.Asset;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ramiro.acoglanis
 */
@RestController
public class MainController {
    
    @GetMapping("/asset")
    @CrossOrigin(origins="*", maxAge=3600)
    public Asset getAsset(){
        return new Asset("Notebook", "Dell - Latitude e7470");
    }
    
}
