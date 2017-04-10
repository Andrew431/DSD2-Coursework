/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Andrew Muir
 * S1511342
 */
public class Customer {
    
    private int customerId;
    private String customerName;
    private String customerEmail;
    private String customerPassword;
    private CustomerVisit customervisit;
    
 
    public Customer(int customerId, String customerName, String customerEmail, String customerPassword, CustomerVisit customervisit)
    {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPassword = customerPassword;
        this.customervisit = customervisit;
        
    }
    
    public CustomerVisit getCustomerVisit()
    {
        return customervisit;
    }
    
    public void setCustomerVisit(CustomerVisit customervisit)
    {
        this.customervisit = customervisit;
    }
    
    public int getCustomerId()
    {
        return customerId;
    }
    
    public void setCustomerId(int customerId)
    {
        this.customerId = customerId;
    }
    
    public String getCustomerName()
    {
        return customerName;
    }
    
    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }
    
    public String getCustomerEmail()
    {
        return customerEmail;
    }
    
    public void setCustomerEmail(String customerEmail)
    {
        this.customerEmail = customerEmail;
    }
    
    public String getCustomerPassword()
    {
        return customerPassword;
    }
    
    public void setCustomerPassword(String customerPassword)
    {
        this.customerPassword = customerPassword;
    }
    
    @Override
    public String toString() {
        return  "customer id: " + getCustomerId() + ", " +
                "customer name: " + getCustomerName() + ", " +
                "customer email: " + getCustomerEmail() + ", " +
                "customer password: " + getCustomerPassword();
    }  
}
