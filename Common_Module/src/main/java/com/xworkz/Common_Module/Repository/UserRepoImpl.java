package com.xworkz.Common_Module.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.Common_Module.entity.UserEntity;

@Repository
public class UserRepoImpl implements UserRepository {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
    public boolean save(UserEntity entity) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(entity);
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {


        }
        return true;
    }
   
	@Override
    public String getNameByEmailAndPassword(String email, String password) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction=entityManager.getTransaction();
        String name=null;
        try{
            entityTransaction.begin();
            Query query=entityManager.createNamedQuery("getNameByEmailAndPassword");
            query.setParameter("byemail",email).setParameter("bypassword",password);
            name=(String)query.getSingleResult();
            entityTransaction.commit();
        } catch (Exception e) {
            if(entityTransaction.isActive()){
                entityTransaction.rollback();
            }
        }
        finally {

        }
        return name;
    }
    
	@Override
    public Long countName(String name) {
        EntityManager em=entityManagerFactory.createEntityManager();
        EntityTransaction et=em.getTransaction();
        Long count= (Long)em.createNamedQuery("countName").setParameter("SetName",name).getSingleResult();
        try{
            et.begin();
            et.commit();
        }
        catch(Exception e)
        {
            if(et.isActive())
            {
                et.rollback();
            }
        }
        finally {
            em.close();
            //` emf.close();
        }
        return count;
    }

 
	@Override
    public Long countByEmail(String email) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Long count = 0L;
        try {
            count = (Long) em.createNamedQuery("countByEmail")
                    .setParameter("SetEmail", email)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(); // Log the error
        } finally {
            em.close();
        }
        return count;
    }

   
	@Override
    public Long countByAltEmail(String altEmail) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Long count = 0L;
        try {
            count = (Long) em.createNamedQuery("countByAltEmail")
                    .setParameter("SetAltEmail", altEmail)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(); // Log the error
        } finally {
            em.close();
        }
        return count;
    }


   
	@Override
    public Long countByPhone(String phone) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Long count = 0L;
        try {
            count = (Long) em.createNamedQuery("countByPhone")
                    .setParameter("SetPhone", phone)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(); // Log the error
        } finally {
            em.close();
        }
        return count;
    }

    
	@Override
    public Long countByAltPhone(String altPhone) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Long count = 0L;
        try {
            count = (Long) em.createNamedQuery("countByAltPhone")
                    .setParameter("SetAltPhone", altPhone)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(); // Log the error
        } finally {
            em.close();
        }
        return count;
    }

   
	@Override
    public Long countByLocation(String location) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Long count = 0L;
        try {
            count = (Long) em.createNamedQuery("countByLocation")
                    .setParameter("SetLocation", location)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(); // Log the error
        } finally {
            em.close();
        }
        return count;
    }
	 @Override
	    public boolean update(UserEntity entity) {
	        EntityManager entityManager = entityManagerFactory.createEntityManager();
	        EntityTransaction transaction = entityManager.getTransaction();

	        try {
	            transaction.begin();
	            entityManager.merge(entity);
	            transaction.commit();
	            return true;
	        } catch (Exception e) {
	            if (transaction.isActive()) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	            return false;
	        } finally {
	            entityManager.close();
	        }
	    }

	    @Override
	    public UserEntity findByEmail(String email) {
	        EntityManager entityManager = entityManagerFactory.createEntityManager();
	        try {
	            String queryStr = "SELECT p FROM ModuleEntity p WHERE p.email = :email";
	            Query query = entityManager.createQuery(queryStr);
	            query.setParameter("email", email);

	            List<UserEntity> result = query.getResultList();
	            if (!result.isEmpty()) {
	                return result.get(0);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            entityManager.close();
	        }
	        return null;
	    }
}