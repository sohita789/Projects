package com.xworkz.commonModule.repository;

import com.xworkz.commonModule.entity.ModuleEntity;

public interface ModuleRepository {

    public boolean validateAndSave(ModuleEntity entity);

    ModuleEntity onLogin(String email, String password);

    long countName(String name);

    long countByEmail(String email);

    long countByAlterEmail(String alterEmail);

    long countByPhoneNo(long phoneNo);

    long countByAlterPhoneNo(long alterPhoneNo);

    long countByLocation(String location);

    boolean update(ModuleEntity entity);

    ModuleEntity findByEmail(String email);

    //public ModuleEntity getNameByEmailAndPassword(String email, String password);


}



