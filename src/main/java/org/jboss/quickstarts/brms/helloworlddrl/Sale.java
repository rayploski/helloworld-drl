/*
 * JBoss, Home of Professional Open Source
 * Copyright 2014, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.quickstarts.brms.helloworlddrl;

import java.io.Serializable;
import java.math.BigDecimal;

public class Sale implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Customer customer;

    private BigDecimal value = new BigDecimal(0);

    private double discount = 0;

    private boolean approved = false;

    public Sale(Customer customer, BigDecimal value) {
        this.customer = customer;
        this.value = value;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public Customer getCustomer() {
        return customer;
    }

    public BigDecimal getValue() {
        return value;
    }
    
    public String toString(){
    	StringBuilder sb = new StringBuilder();
    	return sb.append("Sale to:")
    	  .append(customer.getName())
    	  .append(", Approved:")
    	  .append(approved)
    	  .append(", Discount:")
    	  .append(discount)
    	  .toString();
    }

}
