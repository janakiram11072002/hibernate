package hibernate.learning.hibernate.learning;

import hibernate.learning.MapFile.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
	
	public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        EmployeDetails emp = new EmployeDetails();
        //emp.setId(5678);
        emp.setName("miachel");;
        emp.setSalary(95000);
        
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();
        try
        {
        	s.saveOrUpdate(emp);
        	s.getTransaction().commit();
        	
        }
        catch(Exception e)
        {
        	System.out.println(e.getMessage());
        }
        s.close();

        emp = null;
        s = sf.openSession();
        s.beginTransaction();
        try
        {
            emp = (EmployeDetails)s.get(EmployeDetails.class,1234);
            System.out.println("id : " +emp.getId() +" emp name : "+emp.getName());
        }
        catch(Exception e)
        {
        	System.out.println(e.getMessage());
        }
        
    }
}
