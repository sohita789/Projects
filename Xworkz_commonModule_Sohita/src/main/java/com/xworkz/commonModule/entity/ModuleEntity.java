package com.xworkz.commonModule.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Digits;

@Data
@Entity
@RequiredArgsConstructor
@Table(name="module_table")

@NamedQuery(name = "getModuleEntitylistByEmail", query = "SELECT p FROM ModuleEntity p WHERE p.email = :email")
@NamedQuery(name = "getModuleEntitycountName", query = "SELECT COUNT(p) FROM ModuleEntity p WHERE p.name = :name")
@NamedQuery(name = "getModuleEntitycountByEmail", query = "SELECT COUNT(p) FROM ModuleEntity p WHERE p.email = :email")
@NamedQuery(name = "getModuleEntitycountbyPhoneNo", query = "SELECT COUNT(p) FROM ModuleEntity p WHERE p.phoneNo = :phoneNo")
@NamedQuery(name = "getModuleEntitycountbyalterEmail", query = "SELECT COUNT(p) FROM ModuleEntity p WHERE p.alterEmail = :alterEmail")
@NamedQuery(name = "getModuleEntitycountbyalterPhoneNo", query = "SELECT COUNT(p) FROM ModuleEntity p WHERE p.alterPhoneNo = :alterPhoneNo")
@NamedQuery(name = "getModuleEntitylistbyemailforResetpassword", query = "SELECT p FROM ModuleEntity p WHERE p.email = :email")
public class ModuleEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String name;

        private String email;

        @Digits(integer = 10, fraction = 0,message = "number should contain 10 digits")
        private long phoneNo;

        private String alterEmail;
        @Digits(integer = 10, fraction = 0,message = "number should contain 10 digits")

        private long alterPhoneNo;

        private String location;

        private String password;

        private int Resetstatus;

}
