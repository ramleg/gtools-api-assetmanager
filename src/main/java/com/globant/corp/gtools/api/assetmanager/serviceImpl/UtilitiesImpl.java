package com.globant.corp.gtools.api.assetmanager.serviceImpl;

import com.globant.corp.gtools.api.assetmanager.service.Utilities;
import org.springframework.stereotype.Service;

/**
 *
 * @author ramiro.acoglanis
 */
@Service
public class UtilitiesImpl implements Utilities{

    @Override
    public boolean stringToBool(String s) throws IllegalArgumentException{
        switch(s){
            case "1": return true;
            case "true": return true;
            case "0": return false;
            case "false": return false;
            default: throw new IllegalArgumentException(s + " is not boolean");
        }
    }
    
}
