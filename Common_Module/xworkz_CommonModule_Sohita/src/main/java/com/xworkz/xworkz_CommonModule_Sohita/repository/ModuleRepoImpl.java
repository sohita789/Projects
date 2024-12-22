package com.xworkz.xworkz_CommonModule_Sohita.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.xworkz_CommonModule_Sohita.entity.ModuleEntity;
@Repository
public class ModuleRepoImpl implements ModuleRepository{
	
@Autowired
EntityManagerFactory emf;

	@Override
	public boolean validateAndSave(ModuleEntity entity) {
		
		System.out.println("repoImpl"+entity);
	       // EntityManagerFactory emf=Persistence.createEntityManagerFactory("xyz");
	        
	        EntityManager em= emf.createEntityManager();
	        EntityTransaction et=em.getTransaction();
	        
	        try {
	            et.begin();
	            em.persist(entity);
	            et.commit();
	        }catch (Exception e){
	            if(et.isActive()){
	                et.rollback();
	            }
	        }finally {
	            em.close();
	        }
	        return true;
	}
	
	@Override
    public String getNameByEmailAndPassword(String email, String password) {
        EntityManager entityManager=emf.createEntityManager();
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
        EntityManager em=emf.createEntityManager();
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
        EntityManager em = emf.createEntityManager();
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
    public Long countByAltEmail(String alterEmail) {
        EntityManager em = emf.createEntityManager();
        Long count = 0L;
        try {
            count = (Long) em.createNamedQuery("countByAlterEmail")
                    .setParameter("SetAlterEmail", alterEmail)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(); // Log the error
        } finally {
            em.close();
        }
        return count;
    }


   
	@Override
    public Long countByPhoneNo(String phoneNo) {
        EntityManager em = emf.createEntityManager();
        Long count = 0L;
        try {
            count = (Long) em.createNamedQuery("countByPhoneNo")
                    .setParameter("SetPhoneNo", phoneNo)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(); // Log the error
        } finally {
            em.close();
        }
        return count;
    }

    
	@Override
    public Long countByAlterPhoneNo(String alterPhoneNo) {
        EntityManager em = emf.createEntityManager();
        Long count = 0L;
        try {
            count = (Long) em.createNamedQuery("countByAlterPhoneNo")
                    .setParameter("SetAlterPhoneNo", alterPhoneNo)
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
        EntityManager em = emf.createEntityManager();
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
	public Long countByAlterEmail(String alterEmail) {
		EntityManager em = emf.createEntityManager();
		Long count =0L;
		try {
			count = (Long)em.createNamedQuery("countByAlterEmail")
					.setParameter("SetAlterEmail",alterEmail)
					.getSingleResult();
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return null;
	}
	
	 @Override
	    public boolean update(ModuleEntity entity) {
	        EntityManager entityManager = emf.createEntityManager();
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
	    public ModuleEntity findByEmail(String email) {
	        EntityManager entityManager = emf.createEntityManager();
	        try {
	            String queryStr = "SELECT p FROM ModuleEntity p WHERE p.email = :email";
	            Query query = entityManager.createQuery(queryStr);
	            query.setParameter("email", email);

	            List<ModuleEntity> result = query.getResultList();
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
	
	
	
	


