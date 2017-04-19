package com.globant.corp.gtools.api.assetmanager;

import com.globant.corp.gtools.api.assetmanager.repo.AssetRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GtoolsApiAssetmanagerApplicationTests {

    @Autowired
    AssetRepo repo;
    
	@Test
	public void contextLoads() {
            
            repo.findAll();
            
	}

}
