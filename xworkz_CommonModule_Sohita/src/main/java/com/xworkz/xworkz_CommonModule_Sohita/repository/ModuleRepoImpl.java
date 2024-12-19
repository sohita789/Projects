package com.xworkz.xworkz_CommonModule_Sohita.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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

	//	
	}
	


