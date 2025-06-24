package org.gerdoc.pixup.hibernate;

// Session permite interactuar con la base de datos
import org.hibernate.Session;

// SessionFactory es una fabrica de sesiones, se usa para crear sesiones
import org.hibernate.SessionFactory;

// MetadataSources permite construir metadatos de la base de datos
import org.hibernate.boot.MetadataSources;

// StandardServiceRegistry es un registro de servicios estandarizado, se usa para configurar Hibernate
import org.hibernate.boot.registry.StandardServiceRegistry;

// StandardServiceRegistryBuilder permite construir un StandardServiceRegistry, es decir un registro de servicios para Hibernate
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public final class HibernateUtil {

	private static SessionFactory sessionFactory;
	private static StandardServiceRegistry registry;
	
	public static boolean loadRegistry( ) {
		try {
			System.out.println( "HibernateUtil.init()");
			registry = new StandardServiceRegistryBuilder()
					.configure("hibernate.cfg.xml") // se carga la configuracion hibernate
					.build();
			System.out.println( "HibernateUtil.registry");
			return registry != null;
		}
		catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy( registry );
		}
		return false;
	}

	public static boolean loadSessionFactory( ) {
		try {
			if( registry == null ) {
				if( !loadRegistry() ) {
					return false;
				}
			}
			System.out.println( "HibernateUtil.init.sessionFactory");
			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
			System.out.println( "HibernateUtil.sessionFactory");
			return sessionFactory != null;
		}
		catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy( registry );
		}
		return false;
	}
	
	public static StandardServiceRegistry getRegistry( ) {
		if( registry == null ) {
			if( !loadRegistry( ) ) {
				return null;
			}
		}
		return registry;
	}
	
	public static SessionFactory getSessionFactory( ) {
		if( sessionFactory == null ) {
			if( !loadSessionFactory() ) {
				return null;
			}
		}
		return sessionFactory;
	}
	
	public static Session getSession( ) {
		if( sessionFactory == null ) {
			if( !loadSessionFactory() ) {
				return null;
			}
		}
		return sessionFactory.openSession( );
	}
}
