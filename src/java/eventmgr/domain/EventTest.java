/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eventmgr.domain;

import static java.lang.System.out;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author su393507
 */
public class EventTest 
{
    private static SessionFactory Factory=HibernateUtil.getSessionFactory();
    public static void saveEvents( )
    {
		Event event = new Event( );
		event.setName("Java Days");
		event.setStartdate( new java.util.Date(108,Calendar.JULY,1) );
                Session session=Factory.openSession();
                Transaction tx=session.beginTransaction();
    Query query=session.createQuery("from Location where name=:name");
    query.setParameter("name", "Kasetsart University");
    List list=query.list();
    event.setLocation((Location)list.get(0) );
    out.println("Saving events:"+event+ "Location:"+event.getLocation());
    session.save(event);
    tx.commit();
    session.close();
    out.println("event saved successfully");
}
     public static void testRetrieve( ) 
    {
        out.println("Retrieving Events...");
		Session session = Factory.openSession();
		Query query = session.createQuery("from Event");
		Transaction tx = session.beginTransaction();
		List list = query.list( );		
		for( Object even : list ) out.println( even );
		tx.commit();
		session.close();
		out.println("Event retrieving");

    }
     public static void testUpdate(String name,Location locnew)
     {
         Session session=Factory.openSession();
         Transaction t=session.beginTransaction();
         Query q=session.createQuery("from Event where name=:eve");
         q.setParameter("eve",name );
         List l=q.list();
         if(l.size()==0)
         {
             out.println("Event Not Found");
         }
         else
         {
             Event eve=(Event)l.get(0);
             eve.setLocation(locnew);
         }
         t.commit();
         session.close();
         out.println("Event updated successfully");
       }
     public static void addSpeakers(String eventname,Set <Speaker> speaker)
     {
     Session session=Factory.openSession();
     Transaction tx=session.beginTransaction();
     Query q=session.createQuery("from Event where name=:ename");
     q.setParameter("ename", eventname);
     List l=q.list();
     if(l.size()==0)
     {
         out.println("Not Found");
     }
     else
     {
         Event eve=(Event) l.get(0);
         for(Speaker s1:speaker)
         eve.addSpeaker(s1);
     }
     tx.commit();
     session.close();
     out.println("Speakers added successfully");
     }
     public static void testRetrieve1( )
     {
	System.out.println("Retrieving events...");
	
	Session session = Factory.openSession();
	Transaction tx = session.beginTransaction();
	Query query = session.createQuery( "from Event" );
	List<Event>list = (List<Event>)query.list( );
	tx.commit();
        session.close();
        for(Event e : list ) {
		out.printf("%s on %tD\n", e.toString(), e.getStartdate() );
		out.printf("  Location: %s\n", e.getLocation() );
		out.print( "  Speakers:");
		for(Speaker s : e.getSpeakers() ) out.print(" "+s.getName() );
		out.println();
	}

        
     }
    public static void main(String args[])
    {
       // LocationTest.saveLocations();
        //saveEvents();
        //testRetrieve();
        /*Session session=Factory.openSession();
        Transaction tx=session.beginTransaction();
        Query query=session.createQuery("from Location where name=:name" );
        query.setParameter("name","Mahidol University");
        List list=query.list();
        tx.commit();
        session.close();
        if(list.size()==0)
        {
            out.println("Location not found");
        }
        else
        {
            testUpdate("Java Days",(Location)list.get(0));
        }*/
      /* Speaker s1=new Speaker("susmitha","9578843759");
        Speaker s2=new Speaker("Srilakshmipriya","9095849031");
        Speaker s3=new Speaker("Priya","9080689561");
         Set<Speaker> s=new HashSet<Speaker>();
         s.add(s1);
         s.add(s2);
         s.add(s3);
         addSpeakers("Java Days",s);*/
       //testRetrieve1();
    }
}
