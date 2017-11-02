/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author su393507
 */
public class HibernateUtil 
{
    public static SessionFactory sessionFactory;
       public static SessionFactory getSessionFactory()
    {
        try
        {
Configuration config = new Configuration( );
	 sessionFactory =config.configure("hibernate.cfg.xml").buildSessionFactory( );
        
    }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return sessionFactory;
    }
}     
    

