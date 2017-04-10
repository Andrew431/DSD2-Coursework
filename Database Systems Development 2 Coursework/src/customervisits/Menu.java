
package customervisits;

import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

import daos.DB4oCustomerDAO;
import java.util.GregorianCalendar;
import java.util.Iterator;
import model.Customer;
import model.CustomerVisit;
import model.Product;
import model.GoldCustomer;

/**
 *
 * @author Andrew Muir
 * S1511342
 */
public class Menu {
    
    public static void main(String[] args) throws IOException {        
        Scanner userInput = new Scanner (System.in);
        char choice;
        DB4oCustomerDAO customerdao = new DB4oCustomerDAO();      
        
        do
        {
            System.out.print("1. Register a new customer ");
            System.out.print("2. List all customers ");
            System.out.print("3. List all products ");
            System.out.print("4. List all customer visits ");
            System.out.print("5. Retrieve specified customer visit details ");            
            System.out.print("6. Delete customer ");
            System.out.print("7. Update customer visit ");
            System.out.print("8. Show all customer visit and product details for customer ");
            System.out.print("9. List products viewed on customer visits");
            System.out.println("Q. Quit");
            System.out.print("Enter choice ");
            choice = userInput.next().charAt(0);
            switch(choice)
            {
                case '1': 
                    System.out.println("Register a new customer");
                    registerCustomer(customerdao);
                    break;
                case '2': 
                    System.out.println("List all customers");
                    listAllCustomers(customerdao.getAllCustomers());
                    break;
                case '3': 
                    System.out.println("List all products");
                    listAllProducts(customerdao.getAllProducts());           
                    break;                    
                case '4': 
                    System.out.println("List all customer visits");
                    listAllCustomerVisits(customerdao.getAllCustomerVisits());
                    break;                    
                case '5': 
                    System.out.println("Retrieve specified customer visit details");
                    System.out.println(customerdao.getCustomerVisitById(1));
                    break;
                case '6': 
                    System.out.println("Delete customer");
                    deleteCustomer(customerdao);
                    break;                    
                case '7': 
                    System.out.println("Update customer visit");
                    updateCustomerVisit(customerdao);
                    break;
                case '8':
                    System.out.println("Customer visit and product details");
                    System.out.println(customerdao.getCustomerVisitById(3));
                    break;
                case '9':
                    System.out.println("Products viewed on customer visits");
                    //System.out.println(customerdao.getViewedProducts());
                    break;
                case 'Q':
                case 'q':
                    System.out.println("Quitting");
                    userInput.close();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 'Q' && choice != 'q');
    }
    
  
    
    public static void registerCustomer(DB4oCustomerDAO customerdao) throws IOException
    {
        System.out.println("Register customer");
        
        //Create customer visits
        
        CustomerVisit v1 = new CustomerVisit(1, 1, new GregorianCalendar(2017,04,10));
        customerdao.storeCustomerVisit(v1);
        
        CustomerVisit v2 = new CustomerVisit(2, 2, new GregorianCalendar(2017,04,10));
        customerdao.storeCustomerVisit(v2);
        
        CustomerVisit v3 = new CustomerVisit(3, 3, new GregorianCalendar(2017,04,10));
        customerdao.storeCustomerVisit(v3);
        
        CustomerVisit v4 = new CustomerVisit(4, 4, new GregorianCalendar(2017,04,10));       
        customerdao.storeCustomerVisit(v4);
        
        CustomerVisit v5 = new CustomerVisit(5, 5, new GregorianCalendar(2017,04,10));
        customerdao.storeCustomerVisit(v5);
        
        CustomerVisit v6 = new CustomerVisit(6, 6, new GregorianCalendar(2017,04,10));   
        customerdao.storeCustomerVisit(v6);
        
        //Create products
        
        Product p1 = new Product(1, "Shampoo", "Product for use in hair", 1, 5.20);
        customerdao.storeProduct(p1);
        
        Product p2 = new Product(2, "Sandwich", "Cheese and ham sandwich", 1, 0.80);
        customerdao.storeProduct(p2);
        
        Product p3 = new Product(3, "Deoderant", "Spray on body, two for price of one", 2, 1.50);
        customerdao.storeProduct(p3);
        
        Product p4 = new Product(4, "Pepsi", "Bottle of pepsi", 1, 1.00);
        customerdao.storeProduct(p4);
        
        Product p5 = new Product(5, "Crisps", "Cheese and onion", 1, 0.50);
        customerdao.storeProduct(p5);
        
        //Add products to visit
        
        v1.addProductToVisit(p1);
        v2.addProductToVisit(p2);
        v3.addProductToVisit(p3);
        v4.addProductToVisit(p4);
        v6.addProductToVisit(p1);
        
         
        
        //Create customers
        
        Customer c1 = new Customer(1, "Andrew", "andrew@andrew.com", "password", v1);
        customerdao.storeCustomer(c1);  
        
        Customer c2 = new Customer(2, "John", "john@john.com", "password", v2);
        customerdao.storeCustomer(c2);        
        
        Customer c3 = new Customer(3, "Jane", "jane@jane.com", "password", v3);
        customerdao.storeCustomer(c3);       
        
        Customer c4 = new Customer(4, "Stephen", "stephen@stephen.com", "password", v4);
        customerdao.storeCustomer(c4);   
        
        Customer c5 = new Customer(5, "Stephanie", "stephanie@stephanie.com", "password", v5);
        customerdao.storeCustomer(c5);
        
        Customer c6 = new GoldCustomer(6, "Jacob", "jacob@jacob.com", "password", v6, 0.20);
        customerdao.storeCustomer(c6);
       
    }
    
    public static void updateCustomerVisit(DB4oCustomerDAO customerdao) throws IOException
    {
        CustomerVisit v = customerdao.getCustomerVisitById(5);
        Product p = customerdao.getProductById(1);
        v.addProductToVisit(p);
        
    }
    
    public static void deleteCustomer(DB4oCustomerDAO customerdao) throws IOException
    {
        Customer c = customerdao.getCustomerById(1);
        customerdao.deleteCustomer(c);
    }
    
    
    
    public static void listAllCustomers(List<Customer> customers)
    {
        System.out.println("List all customers");
        
        System.out.println(customers.size() + " customer(s) found:");
        for (Iterator<Customer> iter = customers.iterator(); iter.hasNext();) {
            Customer c = (Customer) iter.next(); 
            System.out.println(c);
        }
    }
    
    public static void listAllProducts(List<Product> products)
    {
        System.out.println("List all products");
        
        System.out.println(products.size() + " product(s) found:");
        for (Iterator<Product> iter = products.iterator(); iter.hasNext();) {
            Product p = (Product) iter.next();
            System.out.println(p);
        }
    }
    
    public static void listAllCustomerVisits(List<CustomerVisit> customervisits)
    {
        System.out.println("List all customer visits");
        
        System.out.println(customervisits.size() + " customer visit(s) found:");
        for (Iterator<CustomerVisit> iter = customervisits.iterator(); iter.hasNext();) {
            CustomerVisit v = (CustomerVisit) iter.next();
            System.out.println(v);
        }
    }
    
  
    
}
