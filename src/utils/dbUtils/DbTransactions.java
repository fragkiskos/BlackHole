package utils.dbUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import utils.HibernateUtil;

public class DbTransactions {
	
	

	public static boolean storeObject(Object o){
		try{
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		    session.beginTransaction();
		    session.save(o);
		    session.getTransaction().commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	public static boolean updateObject(Object o){
		try{
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		    session.beginTransaction();
		    session.update(o);
		    session.getTransaction().commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	public static Object getObjectById(String className ,long id){
		try{
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
		    Object resultO = session.get(className, id);
		    session.getTransaction().commit();
			return resultO;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public static List<Object> getObjectsByStringProperty(String tableName,String key,String value){
		try{
			
			
			String query = "Select * from "+tableName+" where "+key+"='"+value+"'";
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Query sqlQuery = session.createSQLQuery(query);
			List<Object> results = sqlQuery.list();
			return results;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static List<Object> getObjectsByProperty(String className,String key,long value){
		try{
			
			
			String query = " from "+className+" where "+key+"=?";
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Query sqlQuery = session.createQuery(query);
			sqlQuery.setLong(0, value);
			List<Object> results = sqlQuery.list();
			return results;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static List<Object> getObjectsByProperty(String className,String key,double value){
		try{
			
			
			String query = "from "+className+" where "+key+"=?";
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Query sqlQuery = session.createQuery(query);
			sqlQuery.setDouble(0, value);
			System.out.println(sqlQuery);
			List<Object> results = sqlQuery.list();
			return results;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static List<Object> getObjectsByProperty(String className,String key,Date value){
		try{
			
			
			String query = " from "+className+" where "+key+">?";
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Query sqlQuery = session.createQuery(query);
			sqlQuery.setTimestamp(0, value);
			List<Object> results = sqlQuery.list();
			return results;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static List<Object> getObjectsByProperty(String className,String key,String value){
		try{
			
			
			String query = " from "+className+" where "+key+"=?";
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Query sqlQuery = session.createQuery(query);
			sqlQuery.setString(0, value);
			List<Object> results = sqlQuery.list();
			return results;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static List<Object> getObjectsByProperty(String className,String key,int value){
		try{
			
			
			String query = " from "+className+" where "+key+"=?";
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Query sqlQuery = session.createQuery(query);
			sqlQuery.setInteger(0, value);
			List<Object> results = sqlQuery.list();
			return results;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
	public static List<Object> getObjectsByProperties(Map<Object,Object> properties){
		return null;
	}
	public static boolean deleteObjectById(long id){
		return false;
	}
	
	public static boolean deleteObjectsByProperty(Object key,Object value){
		return false;
	}
	
	public static List<Object> deleteObjectsByProperties(Map<Object,Object> properties){
		return null;
	}
}
