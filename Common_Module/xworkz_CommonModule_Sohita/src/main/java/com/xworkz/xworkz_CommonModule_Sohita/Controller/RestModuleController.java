package com.xworkz.xworkz_CommonModule_Sohita.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xworkz.xworkz_CommonModule_Sohita.service.ModuleService;


@RestController
@RequestMapping("/")
public class RestModuleController {
    @Autowired
    private ModuleService service;

    @GetMapping(value = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String onName(@PathVariable String name) {
        System.out.println("name=" + name);
        Long count = this.service.countName(name);
        if (count == 0) {
            System.out.println("does not exist");
        } else {
            System.out.println("exists");
        }
        return null;
    }

    @GetMapping(value = "/email/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String onEmail(@PathVariable String email) {
        System.out.println("email=" + email);
        Long count = this.service.countByEmail(email);
        if (count == 0) {
            System.out.println("does not exist");
        } else {
            System.out.println("exists");
        }
        return null;
    }

    @GetMapping(value = "/alterEmail/{alterEmail}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String onAltEmail(@PathVariable String alterEmail) {
        System.out.println("alterEmail=" + alterEmail);
        Long count = this.service.countByAlterEmail(alterEmail);
        if (count == 0) {
            System.out.println("does not exist");
        } else {
            System.out.println("exists");
        }
        return null;
    }

    @GetMapping(value = "/phoneNo/{phoneNo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String onPhone(@PathVariable String phoneNo) {
        System.out.println("phoneNo=" + phoneNo);
        Long count = this.service.countByPhoneNo(phoneNo);
        if (count == 0) {
            System.out.println("does not exist");
        } else {
            System.out.println("exists");
        }
        return null;
    }

    @GetMapping(value = "/alterPhoneNo/{alterPhoneNo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String onAltPhone(@PathVariable String alterPhoneNo) {
        System.out.println("alterPhoneNo=" + alterPhoneNo);
        Long count = this.service.countByAlterPhoneNo(alterPhoneNo);
        if (count == 0) {
            System.out.println("does not exist");
        } else {
            System.out.println("exists");
        }
        return null;
    }

    @GetMapping(value = "/location/{location}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String onLocation(@PathVariable String location) {
        System.out.println("location=" + location);
        Long count = this.service.countByLocation(location);
        if (count == 0) {
            System.out.println("does not exist");
        } else {
            System.out.println("exists");
        }
        return null;
    }
}