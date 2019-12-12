package com.drools_test;


import java.util.ArrayList;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class Test {
	public static void main(String[] args) {
		KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("ksession-rules");
        
        for(Stu stu : getStus()) {
        	kSession.insert(stu);
        }
        
        kSession.fireAllRules();
        kSession.dispose();
    }

    public static List<Stu> getStus() {
        List<Stu> stus = new ArrayList<Stu>();
        stus.add(new Stu("张三", 16, "male"));
        stus.add(new Stu("huhu", 18, "male"));
        stus.add(new Stu("王五", 32, "male"));
        stus.add(new Stu("张红", 23, "female"));
        stus.add(new Stu("李四", 35, "male"));
        stus.add(new Stu("张小雅", 31, "female"));
        return stus;
    }
}
