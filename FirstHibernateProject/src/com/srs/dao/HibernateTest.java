package com.srs.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import com.srs.dto.UserDetails;

public class HibernateTest {
	
	public static void main(String[] args){
		UserDetails user = new UserDetails();
		user.setUserId(2);
		user.setUserName("user 1");
		
		Configuration configuration = new Configuration();
        
		configuration.configure("hibernate.cfg.xml");
        
		ServiceRegistryBuilder serviceRegistryBuilder = 
        		new ServiceRegistryBuilder().applySettings(configuration.getProperties());
        
        SessionFactory sessionFactory = configuration
                        .buildSessionFactory(serviceRegistryBuilder.buildServiceRegistry());
        Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		
	}

}
