package com.xworkz.commonModule.Controller;

import com.xworkz.commonModule.DTO.ModuleDTO;
import com.xworkz.commonModule.entity.ModuleEntity;
import com.xworkz.commonModule.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

    @Controller
    @RequestMapping("/")
    public class ModuleController {

        @Autowired
        ModuleService modelService;

        public ModuleController() {

            System.out.println("created the  NoArgs moduleController..");
        }

        @PostMapping("/signup")
        public String onSignup(Model model, @Valid ModuleDTO modelDTO, BindingResult bindingResult) {
            System.out.println("sign up DTO"+modelDTO);
            System.out.println(modelDTO);

            if(bindingResult.hasErrors()){
                model.addAttribute("error",bindingResult.getAllErrors());
                System.out.println("Controller "+bindingResult);
                return "Signup";
            }
            boolean result=modelService.validateAndSave(modelDTO);
            if(result){
             modelService.saveEmail(modelDTO.getEmail());
             model.addAttribute("success","successfully signedup as "+modelDTO.getName());
             return "Success";
         }
             else{
             return "Signup";
         }
        }

        @PostMapping("/signin")
        public  String onLogin(@RequestParam  String email,@RequestParam String password, Model model)
        {
            ModuleEntity entity = modelService.login(email,password);
            System.out.println(entity);
            if(entity == null){
                return "Signin";
            }
            if(entity.getResetstatus() == -1){
                return "ResetPassword";
            }
            if(entity.getResetstatus()> 3){
                return "Signin";
            }
            if(entity.getResetstatus() == 0){
                return "Success";
            }
            return "Signin";

        }
        @PostMapping("/resetPassword")
        public String resetPassword(@RequestParam String email, @RequestParam String oldPassword, @RequestParam String newPassword, @RequestParam String confirmPassword) {
            if (!newPassword.equals(confirmPassword)) {
                return "ResetPassword";
            }
            System.out.println("email:"+email+"old password"+oldPassword+"new password"+newPassword+"confirm password"+confirmPassword);

            boolean isValid = modelService.resetPassword(email, oldPassword, newPassword);
            if (isValid) {
             return "Signin";
         }
            else {
            return "ResetPassword";
          }
        }
    }

