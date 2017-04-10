
package model;



/**
 *
 * @author Andrew Muir
 * S1511342
 */
public class GoldCustomer extends Customer {
    
    private double discount;
    
    
    
    public GoldCustomer(int customerId, String customerName, String customerEmail, String customerPassword, CustomerVisit customervisit, double discount){
        
        super(customerId, customerName, customerEmail, customerPassword, customervisit);
        this.discount = discount;
        
    }
    
    public double getDiscount()
    {
        return discount;
    }
    
    public void setDiscount(double discount)
    {
        this.discount = discount;
    }
    
    
    @Override
    public String toString(){
        return super.toString() + ", " +
                "Discount: " + getDiscount();
    }
    
}
