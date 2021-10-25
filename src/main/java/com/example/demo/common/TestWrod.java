package com.example.demo.common;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @author Administrator
 * @version 1.0
 * @description: TODO
 * @date 2021/10/23 17:53
 */
public class TestWrod {
    public static void main(String[] args) {
//        KieServices kss = KieServices.Factory.get();
        KieServices ks = KieServices.get();
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession kss =kc.newKieSession("session");
        int count = kss.fireAllRules();
        System.out.println("总执行了"+count+"条规则");
        kss.dispose();
    }
}
