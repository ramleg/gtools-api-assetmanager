package com.globant.corp.gtools.api.assetmanager;

import com.globant.corp.gtools.api.assetmanager.entity.AssetType0;
import com.globant.corp.gtools.api.assetmanager.entity.AssetType1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.globant.corp.gtools.api.assetmanager.repo.AssetModelRepo;
import com.globant.corp.gtools.api.assetmanager.repo.AssetType0Repo;
import com.globant.corp.gtools.api.assetmanager.repo.AssetType1Repo;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GtoolsApiAssetmanagerApplicationTests {

    @Autowired
    AssetModelRepo repo;
    @Autowired
    AssetType0Repo repo0;
    @Autowired
    AssetType1Repo repo1;
    
	@Test
	public void contextLoads(){
	}

}
