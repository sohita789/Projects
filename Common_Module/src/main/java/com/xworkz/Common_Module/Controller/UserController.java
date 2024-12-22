package com.xworkz.Common_Module.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.xworkz.Common_Module.DTO.UserDTO;
import com.xworkz.Common_Module.Service.UserService;



@Controller
@RequestMapping("/")
@EnableWebMvc
public class UserController {

    @Autowired
    private UserService service;
    public UserController()
    {
        System.out.println("ModuleController Running");
    }


    @PostMapping("/SignupServlet")
    public String onSignup(UserDTO dto, Model model) {
        System.out.println("save is Running in ModuleController");
        System.out.println(dto);
        boolean result=service.validateAndSave(dto);
        model.addAttribute("name","SignupSuccess");
        return "Signup.jsp";
        }

    @PostMapping("/SigninServlet")
    public  String save(@RequestParam String email, @RequestParam String password, Model model)
    {
        String valid = service.getNameByEmailAndPassword(email,password);
        System.out.println("is it working"+valid);
        model.addAttribute("msg","SiginSuccess");
        return "Signin.jsp";
    }
    @PostMapping("/resetPassword")
    public String resetPassword(String email, String oldPassword, String newPassword, String confirmPassword) {
    if (!newPassword.equals(confirmPassword)) {
        return "ResetPassword.jsp";
    }

      boolean isValid = service.resetPassword(email, oldPassword, newPassword);
      if (isValid) {
        return "Signin.jsp";
     } else {
        return "ResetPassword.jsp";
    }
    }
}


