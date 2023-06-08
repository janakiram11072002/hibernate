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
        emp.setId(123);
        emp.setName("Harish");;
        emp.setSalary(800000);
        
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();
        try
        {
        	s.saveOrUpdate(emp);
        	s.getTransaction().commit();
        	
        }catch(Exception e)
        {
        	System.out.println(e.getMessage());
        }
    }
}
