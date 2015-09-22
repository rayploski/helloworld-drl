package org.jboss.quickstarts.brms.helloworlddrl;



import java.math.BigDecimal;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

public class HelloWorldExample {


    
    
	public static void main(String[] args) {
        
		// Generate the various KIE Services
		KieServices kieServices = KieServices.Factory.get();

		// Create a KIE container based on business rules found within the classpath.
		KieContainer kContainer = kieServices.getKieClasspathContainer();
	    
		// Create a stateless session
		StatelessKieSession kSession = kContainer.newStatelessKieSession();


		// Let's create some objects to evaluate including customers and sales.
	    Customer vipCustomer = new Customer("Mr. Good Customer", CustomerType.VIP);
	    Customer regularCustomer = new Customer("Mr. Typical Customer", CustomerType.REGULAR);
	    Customer badCustomer = new Customer("Mr. Bad Customer", CustomerType.BAD);
	  	    
	    // A sale for a VIP customer
	    Sale vipSale = new Sale(vipCustomer, new BigDecimal(1000));

	    // A sale for a regular customer
	    Sale regularSale = new Sale(regularCustomer, new BigDecimal(1000));
	    
	    // A sale for a Bad customer
	    Sale badSale = new Sale(badCustomer, new BigDecimal(50));


        // Send the VIP sale into the knowledge session for evaluation:	    
        System.out.println("** Testing VIP customer **");        
        kSession.execute(vipSale);
        
        // Sale is approved.  50% Discount.
        System.out.println(vipSale);
        
        // Send the Regular sale into the knowledge session for evaluation:
        System.out.println("** Testing regular customer **");
        kSession.execute(regularSale);

        // Sale approved.  No Discount.
        System.out.println(regularSale);

        // Sent the Bad customer's sale into the knowledge session for evaluation:
        System.out.println("** Testing bad customer **");        
        kSession.execute(badSale);

        // Sale denied
        System.out.println(badSale);
        
        
	}
	

}
