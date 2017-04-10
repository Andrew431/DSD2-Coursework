package model;

import java.util.Set;
import java.util.HashSet;
import java.util.Calendar;
import java.text.SimpleDateFormat;

/**
 *
 * @author Andrew Muir
 * S1511342
 */
public class CustomerVisit {
    
    private int customervisitId;
    private int customerId;
    private Set<Product> products;
    private Calendar createdvisit;
    
    public CustomerVisit(int customervisitId, int customerId, Calendar createdvisit)
    {
     
        this.customervisitId = customervisitId;
        this.customerId = customerId;
        this.products = new HashSet<Product>();
        this.createdvisit = createdvisit;
        
    }
    
    public int getCustomerVisitId()
    {
        return customervisitId;
    }
    
    public void setCustomerVisitId(int customervisitId)
    {
        this.customervisitId = customervisitId;
    }
    
    public int getCustomerId()
    {
        return customerId;
    }
    
    public void setCustomerId(int customerId)
    {
        this.customerId = customerId;
    }
    
    public Set<Product> getProducts()
    {
        return products;
    }
    
    public void setProducts(Set<Product> products)
    {
        this.products = products;
    }
    
    public void addProductToVisit(Product product)
    {
        products.add(product);
    }
    
    public Calendar getCreatedVisit()
    {
        return createdvisit;
    }
    
    public void setCreatedVisit(Calendar createdvisit)
    {
        this.createdvisit = createdvisit;
    }
    
    public String getDate()
    {
       SimpleDateFormat formatter = new SimpleDateFormat("yyyy MMM" ); 
       String date = formatter.format(createdvisit.getTime());
       return date;
    }
    
    @Override
    public String toString() {
        return  "customervisit id: " + getCustomerVisitId() + ", " +
                "customer id: " + getCustomerId() + ", " +
                "Products: " + getProducts() + ", " +
                "Date: " + getDate();
    }   
}
