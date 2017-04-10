
package daos;


import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.query.Predicate;



import java.util.List;
import java.io.File;
import java.io.IOException;
import model.Customer;
import model.CustomerVisit;
import model.Product;

/**
 *
 * @author Andrew Muir
 * S1511342
 */
public class DB4oCustomerDAO {
    private final File file;
    private ObjectContainer db; 
    
    public DB4oCustomerDAO() throws IOException
    {
        file = new File("./customersdb");
        if (file.exists()) {
            file.delete();
            file.createNewFile();
        }
        open();
    }
    
    private void open()
    {
        EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
        config.common().objectClass(model.Customer.class).objectField("customervisit").cascadeOnDelete(true);
        config.common().objectClass(model.Customer.class).objectField("customervisit").cascadeOnUpdate(true);
        db = Db4oEmbedded.openFile(config, file.getAbsolutePath());
    }
    
    
    public void close() 
    {
        db.close();
    } 
    
    public void storeCustomer(Customer c)
    {
        db.store(c);
        db.commit();
    }
    
    public void storeProduct(Product p)
    {
        db.store(p);
        db.commit();
    }
    
    public void storeCustomerVisit(CustomerVisit v)
    {
        db.store(v);
        db.commit();
    }
    
    public void deleteCustomer(Customer c)
    {
        db.delete(c);
        db.commit();
    }
    
    
    public List<Customer> getAllCustomers()
    {
        Customer proto = new Customer(0, null, null, null, null);

        List<Customer> customers = db.queryByExample(proto); 
 
        return customers;
    }
    
    public List<Product> getAllProducts()
    {
        Product proto = new Product(0, null, null, 0, 0.0);

        List<Product> products = db.queryByExample(proto); 
 
        return products;
    }
    
    public List<CustomerVisit> getAllCustomerVisits()
    {
        CustomerVisit proto = new CustomerVisit(0, 0, null);
      
        List<CustomerVisit> customervisits = db.queryByExample(proto); 
 
        return customervisits;
    }
    
    public CustomerVisit getCustomerVisitById(int id)
    {
        CustomerVisit proto = new CustomerVisit(id, 0, null);
        CustomerVisit v = (CustomerVisit) db.queryByExample(proto).next();
        return v;
              
    }
    
    public Customer getCustomerById(int id)
    {
        Customer proto = new Customer(id, null, null, null, null);
        Customer c = (Customer) db.queryByExample(proto).next();
        return c;
    }
    
    public Product getProductById(int id)
    {
        Product proto = new Product(id, null, null, 0, 0.0);
        Product p = (Product) db.queryByExample(proto).next();
        return p;
    }
    
    
    
    
}
