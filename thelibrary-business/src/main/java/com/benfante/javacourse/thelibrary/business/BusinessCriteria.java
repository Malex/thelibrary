package com.benfante.javacourse.thelibrary.business;

import java.util.List;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.benfante.javacourse.thelibrary.business.entity.Result;
import com.benfante.javacourse.thelibrary.business.entity.RulesBIN;
import com.benfante.javacourse.thelibrary.business.entity.RulesBOU;

public class BusinessCriteria {
	
	private static final Logger log = LoggerFactory.getLogger(BusinessCriteria.class);
	 
	private static BusinessCriteria instance = null;
	
	private BusinessCriteria() {
	}
	
	private KieBase getKBase() {
		KieServices kserv = KieServices.Factory.get();
//		KieFileSystem kieFileSystem = kserv.newKieFileSystem();
//		Collection<String> resources = ResourceList.getResources(Pattern.compile(".drl"));
//		for(String item : resources) {
//			File f = new File(item);
//			Resource res = kserv.getResources().newFileSystemResource(f).setResourceType(ResourceType.DRL);
//			kieFileSystem.write(res);
//		}
//		KieBuilder kbuilder = kserv.newKieBuilder(kieFileSystem);
//		kserv.
		KieBase kbase = kserv.getKieClasspathContainer().getKieBase();
		return kbase;
	}

	protected RulesBOU fireRulesProcessor(final RulesBIN bin) {
		final Result result = new Result();
		final KieBase kbase = getKBase();
		final KieSession ksession = kbase.newKieSession();
		final List<Object> resultList = bin.getFacts();
		for(Object item : resultList) {
			ksession.insert(item);
		}
		ksession.insert(result);
		ksession.fireAllRules();
		ksession.dispose();
		final RulesBOU out = new RulesBOU();
		out.setResult(result);
		out.setProcessedFacts(resultList);
		return out;
	}
	
	public RulesBOU fireRules(final RulesBIN rules) {
		if(rules==null) {
			final String error = "Rules BIN is null";
			log.error(error);
			throw new IllegalArgumentException(error);
		}
		if(rules.getFacts()==null) {
			final String error = "Fact list is null";
			log.error(error);
			throw new IllegalArgumentException(error);
		}
		if(rules.getFacts().size()==0) {
			log.warn("Empty list of facts was passed to rule processing");
		}
		final RulesBOU out = fireRulesProcessor(rules);
		return out;
	}
	
//	public void fireRules(Object... facts) {
//		fireRulesArray(facts);
//	}

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
