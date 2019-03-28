package com.redhat.depositretention.drools;

import com.google.gson.Gson;
import com.myspace.deposit_retention.Customer_Profile;
import com.myspace.deposit_retention.EventModel;
import com.myspace.deposit_retention.OFFER;

import org.kie.api.runtime.ClassObjectFilter;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;


public class DroolsRulesApplier {
    private static KieSession KIE_SESSION;

    private static final Logger LOGGER = LoggerFactory.getLogger(DroolsRulesApplier.class);

    public DroolsRulesApplier(String sessionName) {
        KIE_SESSION = DroolsSessionFactory.createDroolsSession(sessionName);
        System.out.println("test");
    }

    /**
     * Applies the loaded Drools rules to a given String.
     *
     * @param
     * @return the String after the rule has been applied
     */


    public String processTransaction(String info) {

        EventModel eventModel = new Gson().fromJson(info,EventModel.class);
        Customer_Profile customer = new Customer_Profile();
        customer.setThirdPartyTransfer(true);
        customer.setInFlow(false);
        customer.setOutFlow(false);

        KIE_SESSION.insert(customer);
        KIE_SESSION.insert(eventModel);
        KIE_SESSION.fireAllRules();

        Collection<?> offers = KIE_SESSION.getObjects(new ClassObjectFilter(OFFER.class));
        String offerId = "";
       for(Object offerObj:offers) {
           OFFER offer = (OFFER) offerObj;
           offerId = offer.getOFFER_NAME();
       }
       return offerId;



    }


}
