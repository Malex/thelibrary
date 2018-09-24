package com.benfante.javacourse.thelibrary.business;

import org.kie.api.runtime.KieContainer;

import com.benfante.javacourse.thelibrary.business.utils.ResourceList;

import java.io.File;
import java.net.URL;
import java.util.Collection;
import java.util.regex.Pattern;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.io.Resource;
import org.kie.api.io.ResourceType;

public class BusinessCriteria {
	 
	private static BusinessCriteria instance = null;
	
	private BusinessCriteria() {
	}
	
	private KieContainer getKBase() {
		KieServices kserv = KieServices.Factory.get();
		KieFileSystem kieFileSystem = kserv.newKieFileSystem();
		Collection<String> resources = ResourceList.getResources(Pattern.compile(".drl"));
		for(String item : resources) {
			File f = new File(item);
			Resource res = kserv.getResources().newFileSystemResource(f).setResourceType(ResourceType.DRL);
			kieFileSystem.write(res);
		}
		KieBuilder kbuilder = kserv.newKieBuilder(kieFileSystem);
		kbuilder.buildAll();
		return null;
	}


	public BusinessCriteria getInstance() {
		if(instance==null) {
			getSyncroInstance();
		}
		return instance;
	}
	
	private synchronized void getSyncroInstance() {
		if(instance==null) {
			instance = new BusinessCriteria();
		}
	}
}
