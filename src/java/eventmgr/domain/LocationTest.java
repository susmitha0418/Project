/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eventmgr.domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;
import static java.lang.System.out;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Transaction;

/**
 *
 * @author su393507
 */
public class LocationTest 
{
    private SessionFactory sessionFactory;
    private static SessionFactory factory =HibernateUtil.getSessionFactory();

    public static void saveLocations()
    {
        Session session = factory.openSession( );
		Location loc1 = new Location();
		loc1.setName("Kasetsart University");
		loc1.setAddress("Pahonyotin Rd, Bangkok");
		Location loc2 = new Location();
		loc2.setName("Mahidol University");
		loc2.setAddress("Salaya, Nakorn Pathom");

		out.println("Saving locations...");
		out.println( loc1 );
		out.println( loc2 );
		
		Transaction tx = session.beginTransaction();
		session.save( loc1 );
		session.save( loc2 );
		tx.commit();
		session.close();	
		out.println("Locations saved");

    }
    public static void testRetrieve( ) 
    {
        out.println("Retrieving locations...");
		Session session = factory.openSession();
		Query query = session.createQuery("from Location");
		Transaction tx = session.beginTransaction();
		List list = query.list( );		
		for( Object loc : list ) out.println( loc );
		tx.commit();
		session.close();
		out.println("Done retrieving");

    }
    public static void testUpdate(String name,String addr)
    {    
       out.println("Updating "+name +"...");
		Session session = factory.openSession( );
                //Query query1 = session.createQuery("from Location l where l.address like '%Bangkok%'");

		Transaction tx = session.beginTransaction();
		 Query query = session.createQuery("from Location where name=:name");
		query.setParameter("name", name );
		List list = query.list( );   
if ( list.size() == 0 ) 
{
    out.print("No location named "+name);
}
		else {
			// change first location that matches
			Location loc = (Location) list.get(0);
			loc.setAddress(addr);
			out.println( loc );
		}
		tx.commit();
		session.close( );

    }
    public static void main(String args[])
    {
                //saveLocations();
		//testRetrieve();
		//testUpdate("Kasetsart University", "Kampaengsaen");
	//testRetrieve();

    }
}
    

