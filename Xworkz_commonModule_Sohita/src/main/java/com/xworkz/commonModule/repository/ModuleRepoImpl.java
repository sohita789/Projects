package com.xworkz.commonModule.repository;


import com.xworkz.commonModule.entity.ModuleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

    @Repository
    public class ModuleRepoImpl implements ModuleRepository {

        @Autowired
        EntityManagerFactory emf;

        @Override
        public boolean validateAndSave(ModuleEntity entity) {
            System.out.println("validateAndSave in ModuleRepoImpl");
            System.out.println("repoImpl"+entity);

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
    public ModuleEntity onLogin(String email, String password) {
        EntityManager entityManager = emf.createEntityManager();
        try {
          //  String queryStr = "SELECT p FROM ModuleEntity p WHERE p.email = :email";
            Query query = entityManager.createNamedQuery("getModuleEntitylistByEmail");
            query.setParameter("email", email);
            ModuleEntity result = (ModuleEntity) query.getSingleResult();
           return result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }


     @Override
     public long countName(String name) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            String queryStr = "SELECT COUNT(p) FROM ModuleEntity p WHERE p.name = :name";
            Query query = entityManager.createQuery(queryStr);
            query.setParameter("name", name);

            long count = (long) query.getSingleResult();
            System.out.println("  count for name: " + count);

            return count;

        } catch (Exception e) {
            System.out.println("Error fetching count for name: " + name);
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    return 0;
}


    @Override
    public long countByEmail(String email) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            String queryStr = "SELECT COUNT(p) FROM ModuleEntity p WHERE p.email = :email";
            Query query = entityManager.createQuery(queryStr);
            query.setParameter("email", email);

            long count = (long) query.getSingleResult();
            System.out.println("  count for Email: " + count);

            return count;

        } catch (Exception e) {
            System.out.println("Error getting  count for email: " + email);
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return 0;
    }

    @Override
    public long countByAlterEmail(String alterEmail) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            String Queystr = "SELECT COUNT(p) FROM ModuleEntity p WHERE p.alterEmail = :alterEmail";
            Query query = entityManager.createQuery(Queystr);
            query.setParameter("alterEmail", alterEmail);
            long count = (long) query.getSingleResult();

            System.out.println("Count for Alternate email " + count);
            return count;
        } catch (Exception e) {
            System.out.println("Error getting  count for AlternateEmail : " + alterEmail);
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return 0;
    }
    @Override
    public long countByPhoneNo(long phoneNo) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            String queryStr = "SELECT COUNT(p) FROM ModuleEntity p WHERE p.phoneNo = :phoneNo";
            Query query = entityManager.createQuery(queryStr);
            query.setParameter("phoneNo", phoneNo);

            long count = (long) query.getSingleResult();
            System.out.println("  count for phoneNumber: " + count);

            return count;

        } catch (Exception e) {
            System.out.println("Error getting  count for phoneNo: " + phoneNo);
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return 0;
    }


@Override
public long countByAlterPhoneNo(long alterPhoneNo) {
    EntityManager entityManager = emf.createEntityManager();
    try {
        String QueryStr = "SELECT COUNT(p) FROM ModuleEntity p WHERE p.alterPhoneNo = :alterPhoneNo";
        Query query = entityManager.createQuery(QueryStr);
        query.setParameter("alterPhoneNo", alterPhoneNo);

        long count = (long) query.getSingleResult();
        System.out.println("count for Alternate Phone" + count);
        return count;

    } catch (Exception e) {
        System.out.println("Error getting  count for AlterPhoneNo : " + alterPhoneNo);
        e.printStackTrace();
    } finally {
        entityManager.close();
    }
    return 0;
}

    @Override
    public long countByLocation(String location) {
        return 0;
    }


    @Override
    public boolean update(ModuleEntity entity) {

        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        System.out.println(entity);
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
        System.out.println("");
        try {
            String queryStr = "SELECT p FROM ModuleEntity p WHERE p.email = :email";
            Query query = entityManager.createQuery(queryStr);
            query.setParameter("email", email);

            List<ModuleEntity> result = query.getResultList();
            if (!result.isEmpty()) {
                System.out.println("findByEmail "+result.get(0));
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

