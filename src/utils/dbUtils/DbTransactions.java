package utils.dbUtils;

import java.util.Date;
import java.util.Iterator;
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
			session.getTransaction().commit();
			return results;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	

	
	public static List<Object> getObjectsByProperty(String className,String key,Object value){
		try{
			
			String propertyClassName = value.getClass().getCanonicalName();
			String query = " from "+className+" where "+key+"=?";
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Query sqlQuery = session.createQuery(query);
			if(propertyClassName.equals("java.lang.Long")){
				Long castedValue = (Long)value;
				sqlQuery.setLong(0, castedValue);
			}
			if(propertyClassName.equals("java.lang.Double")){
				Double castedValue = (Double)value;
				sqlQuery.setDouble(0, castedValue);
			}
			if(propertyClassName.equals("java.lang.Boolean")){
				Boolean castedValue = (Boolean)value;
				sqlQuery.setBoolean(0, castedValue);
			}
			if(propertyClassName.equals("java.util.Date")){
				Date castedValue = (Date)value;
				sqlQuery.setTimestamp(0, castedValue);
			}
			if(propertyClassName.equals("java.lang.Integer")){
				Integer castedValue = (Integer)value;
				sqlQuery.setInteger(0, castedValue);
			}
			if(propertyClassName.equals("java.lang.String")){
				String castedValue = (String)value;
				sqlQuery.setString(0, castedValue);
			}
			List<Object> results = sqlQuery.list();
			session.getTransaction().commit();
			return results;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static List<Object> getObjectsByPropertyOrderBy(String className,String key,Object value,String orderColumn){
		try{
			
			String propertyClassName = value.getClass().getCanonicalName();
			String query = " from "+className+" where "+key+"=? order by "+orderColumn ;
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Query sqlQuery = session.createQuery(query);
			if(propertyClassName.equals("java.lang.Long")){
				Long castedValue = (Long)value;
				sqlQuery.setLong(0, castedValue);
			}
			if(propertyClassName.equals("java.lang.Double")){
				Double castedValue = (Double)value;
				sqlQuery.setDouble(0, castedValue);
			}
			if(propertyClassName.equals("java.lang.Boolean")){
				Boolean castedValue = (Boolean)value;
				sqlQuery.setBoolean(0, castedValue);
			}
			if(propertyClassName.equals("java.util.Date")){
				Date castedValue = (Date)value;
				sqlQuery.setTimestamp(0, castedValue);
			}
			if(propertyClassName.equals("java.lang.Integer")){
				Integer castedValue = (Integer)value;
				sqlQuery.setInteger(0, castedValue);
			}
			if(propertyClassName.equals("java.lang.String")){
				String castedValue = (String)value;
				sqlQuery.setString(0, castedValue);
			}
			List<Object> results = sqlQuery.list();
			session.getTransaction().commit();
			return results;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
	public static List<Object> getObjectsByProperties(String className,Map<Object,Object> properties){
		try{
			String query = " from "+className+" where ";
			Iterator iterator = properties.entrySet().iterator();
			int i=1;
			while (iterator.hasNext()) {
				if(i<properties.size()){
					Map.Entry mapEntry = (Map.Entry) iterator.next();
					query = query + mapEntry.getKey()+"=? AND ";
				}else{
					Map.Entry mapEntry = (Map.Entry) iterator.next();
					query = query + mapEntry.getKey()+"=?";
				}
				
				i++;
			}
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			Query sqlQuery = session.createQuery(query);
			System.out.println(sqlQuery);
			Iterator iterator2 = properties.entrySet().iterator();
			i=0;
			while (iterator2.hasNext()) {
				Map.Entry mapEntry = (Map.Entry) iterator2.next();
				if(mapEntry.getValue().getClass().getName().equals("java.lang.Long") ){
					sqlQuery.setLong(i,(Long) mapEntry.getValue());
				}
				if(mapEntry.getValue().getClass().getName().equals("java.lang.String") ){
					sqlQuery.setString(i,(String) mapEntry.getValue());
				}
				if(mapEntry.getValue().getClass().getName().equals("java.lang.Double") ){
					sqlQuery.setDouble(i,(Double) mapEntry.getValue());
				}
				if(mapEntry.getValue().getClass().getName().equals("java.lang.Boolean") ){
					sqlQuery.setBoolean(i,(Boolean) mapEntry.getValue());
				}
				if(mapEntry.getValue().getClass().getName().equals("java.lang.Integer") ){
					sqlQuery.setInteger(i,(Integer) mapEntry.getValue());
				}
				if(mapEntry.getValue().getClass().getName().equals("java.util.Date") ){
					sqlQuery.setTimestamp(i,(Date) mapEntry.getValue());
				}
				
				i++;
			}
			
			List<Object> results = sqlQuery.list();
			session.getTransaction().commit();
			return results;
		}catch(Exception e){
			e.printStackTrace();
			return null;
	}
	}
	public static boolean deleteObjectById(String className, long id){
		try{
			Object o = getObjectById(className, id);
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			session.delete(o);
			session.getTransaction().commit();
			return true;
		}catch(Exception ex){
			return false;
		}
		
	}
	
	public static boolean deleteObjectsByProperty(String className, String key,long value){
		try{
			List<Object> os = getObjectsByProperty(className, key, value);
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			for(int i=0;i<os.size();i++){
				session.delete(os.get(i));
			}
			session.getTransaction().commit();
			return true;
		}catch(Exception ex){
			return false;
		}
		
	}
	
	public static boolean deleteObjectsByProperty(String className, String key,Date value){
		try{
			List<Object> os = getObjectsByProperty(className, key, value);
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			for(int i=0;i<os.size();i++){
				session.delete(os.get(i));
			}
			session.getTransaction().commit();
			return true;
		}catch(Exception ex){
			return false;
		}
		
	}
	
	public static boolean deleteObjectsByProperty(String className, String key,String value){
		try{
			List<Object> os = getObjectsByProperty(className, key, value);
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			for(int i=0;i<os.size();i++){
				session.delete(os.get(i));
			}
			session.getTransaction().commit();
			return true;
		}catch(Exception ex){
			return false;
		}
		
	}
	
	public static boolean deleteObjectsByProperty(String className, String key,int value){
		try{
			List<Object> os = getObjectsByProperty(className, key, value);
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			for(int i=0;i<os.size();i++){
				session.delete(os.get(i));
			}
			session.getTransaction().commit();
			return true;
		}catch(Exception ex){
			return false;
		}
		
	}
	
	public static boolean deleteObjectsByProperty(String className, String key,double value){
		try{
			List<Object> os = getObjectsByProperty(className, key, value);
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			for(int i=0;i<os.size();i++){
				session.delete(os.get(i));
			}
			session.getTransaction().commit();
			return true;
		}catch(Exception ex){
			return false;
		}
		
	}
	
	public static boolean deleteObjectsByProperty(String className, String key,boolean value){
		try{
			List<Object> os = getObjectsByProperty(className, key, value);
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			for(int i=0;i<os.size();i++){
				session.delete(os.get(i));
			}
			session.getTransaction().commit();
			return true;
		}catch(Exception ex){
			return false;
		}
		
	}
	public static boolean deleteObjectsByProperties(String className,Map<Object,Object> properties){
		try{
			List<Object> os = getObjectsByProperties(className, properties);
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			for(int i=0;i<os.size();i++){
				session.delete(os.get(i));
			}
			session.getTransaction().commit();
			return true;
		}catch(Exception ex){
			return false;
		}
		
	}
}
