package com.xworkz.commonModule.Controller;

import com.xworkz.commonModule.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping("/")
    public class ModuleRestController {

        @Autowired
        private ModuleService modelService;

        @GetMapping(value = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
        public String onName(@PathVariable String name, Model model) {
            System.out.println("name=" + name);
            long count = modelService.countName(name);
            if (count > 0) {
                model.addAttribute("disp", "exists");
                return "exist";
            } else {
                System.out.println("name doesnt exists");

                return " ";
            }
        }

        @GetMapping(value = "/email/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
        public String onEmail(@PathVariable String email) {
            System.out.println("email=" + email);
            long count = modelService.countByEmail(email);
            if (count > 0) {
                return "exist";
            } else {
                System.out.println("email doesnt exists:" + email);

                return " ";
            }
        }

        @GetMapping(value = "/alterEmail/{alterEmail}", produces = MediaType.APPLICATION_JSON_VALUE)
        public String onAlterEmail(@PathVariable String alterEmail) {
             System.out.println("alterEmail=" + alterEmail);
            long count = modelService.countByAlterEmail(alterEmail);
            if (count > 0) {
                return "exist";
            } else {
                System.out.println("doesnt exists");

                return " ";
            }
        }

        @GetMapping(value = "/phoneNo/{phoneNo}", produces = MediaType.APPLICATION_JSON_VALUE)
        public String onPhoneNo(@PathVariable long phoneNo) {
            System.out.println("phoneNo=" + phoneNo);
            long count = modelService.countByPhoneNo(phoneNo);
            if (count > 0) {
                return "exist";
            } else {
                System.out.println("doesnt exists");

                return " ";
            }
        }

        @GetMapping(value = "/alterPhoneNo/{alterPhoneNo}", produces = MediaType.APPLICATION_JSON_VALUE)
        public String onAlterPhoneNo(@PathVariable long alterPhoneNo) {
             System.out.println("alterPhoneNo=" + alterPhoneNo);
            long count = modelService.countByAlterPhoneNo(alterPhoneNo);
            if (count > 0) {
                System.out.println("does not exist");
                return "exist";
            } else {
                System.out.println("exists");
                return " ";
            }
        }
    }
      //  @GetMapping(value = "/location/{location}", produces = MediaType.APPLICATION_JSON_VALUE)
        //public String onLocation(@PathVariable String location) {
          //  System.out.println("location=" + location);
            //long count = modelService.countByLocation(location);
            //if (count > 0) {
             //   return  "exist";
            //} else {
             //   System.out.println("doesnt exists");

         //   return " ";
       // }


