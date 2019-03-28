package com.redhat.depositretention.drools;

import org.kie.api.KieServices;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DroolsSessionFactory {

    protected static KieSession createDroolsSession(String sessionName) {
        KieServices kieServices = KieServices.Factory.get();
        ReleaseId releaseId = kieServices.newReleaseId("com.myspace","Deposit_Retention","1.0.0");
        KieContainer kieContainer = kieServices.newKieContainer(releaseId);
        KieSession kieSession =  kieContainer.newKieSession();
        return kieSession;
    }
}
