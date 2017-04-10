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
public class Product {
    
    private int productCode;
    private String productName;
    private String productDescription;
    private int productQuantity;
    private double productUnitPrice;
    
    
    
    public Product(int productCode, String productName, String productDescription, int productQuantity, double productUnitPrice)
    {
        this.productCode = productCode;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productQuantity = productQuantity;
        this.productUnitPrice = productUnitPrice;
    }

    
    public int getProductCode()
    {
        return productCode;
    }
    
    public void setProductCode(int productCode)
    {
        this.productCode = productCode;
    }
    
    public String getProductName()
    {
        return productName;
    }
    
    public void setProductName(String productName)
    {
        this.productName = productName;
    }
    
    public String getProductDescription()
    {
        return productDescription;
    }
    
    public void setProductDescription(String productDescription)
    {
        this.productDescription = productDescription;
    }
    
    public int getProductQuantity()
    {
        return productQuantity;
    }
    
    public void setProductQuantity(int productQuantity)
    {
        this.productQuantity = productQuantity;
    }
    
    public double getProductUnitPrice()
    {
        return productUnitPrice;
    }
    
    public void setProductUnitPrice(double productUnitPrice)
    {
        this.productUnitPrice = productUnitPrice;
    }
   

    
    @Override
    public String toString(){
        return  "product code: " + getProductCode() + ", " +
                "product name: " + getProductName() + ", " +
                "product description: " + getProductDescription() + ", " +
                "product quantity: " + getProductQuantity() + ", " +
                "product unit price: " + getProductUnitPrice();

    }
}
