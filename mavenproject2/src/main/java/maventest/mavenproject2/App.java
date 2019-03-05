package maventest.mavenproject2;  
  
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;  
  
public class App {  
  
    public static void main( String[] args )  
    {  
         StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
            Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
          
        SessionFactory factory = meta.getSessionFactoryBuilder().build();  
        Session session = factory.openSession();  
        Transaction t = session.beginTransaction();  
       // String hql="update Employee set salary=:salary"+"where id=:Employee_id";
       // Query q=session.createQuery(hql);
       // q.setParameter("salary",1000);
       // q.setParameter("Employee_id", 1);
        //int result=q.executeUpdate();
       // System.out.println(result);
        
        
       // List result=q.list();
       // System.out.println(result);
          // Employee e1=new Employee();
           //e1.setid(1);
           //e1.setname("ahmad");
           //e1.setage(25);
           //e1.setsalary(500);
           ///Department d1=new Department();
           //d1.setId(1);
           //d1.setDepName("engineer");
           //d1.setDepNumber(3);
           //e1.setdepartment(d1);
           //System.out.println(e1.getdepartment().getDepName());
           //session.save(e1); 
           //session.save(d1); 
     //   Employee e2= new Employee();
      //  e2.setid(2);
       /// e2.setname("saleh");
        //e2.setage(30);
        //e2.setsalary(650);
        //Department d2=new Department();
        //d2.setId(2);
       // d2.setDepName("software");
       // d2.setDepNumber(2);
       // e2.setdepartment(d2);
       // session.save(e2);
        //session.save(d2);
        // query of salary
      //  Criteria c=session.createCriteria(Employee.class);  
       // c.addOrder(Order.asc("salary"));  
       // List<Employee> list=c.list(); 
       // for(Employee emp: list)
       // 	System.out.println(emp.getsalary());
        // query to count 
        //String SQL_QUERY = "SELECT department.depName, COUNT(department.depName) FROM Department department GROUP BY department.depName";
        //Query query = session.createQuery(SQL_QUERY);
          
        //for(Iterator it=query.iterate();it.hasNext();)
        //{
        // Object[] row = (Object[]) it.next();
        // System.out.print("department Name: " + row[0]);
        // System.out.println(" | Number of employee: " + row[1]);
       // }
        List result = session.createCriteria(Department.class)       
                .add(Restrictions.ge("depName", 0))      
                .setProjection(Projections.projectionList()
                        .add(Projections.groupProperty("depName"))
                        .add(Projections.count("depName"))           
                ).list();
        	
           
  
    t.commit();  
       System.out.println("successfully saved");    
        factory.close();  
        session.close();     
    }  
}  