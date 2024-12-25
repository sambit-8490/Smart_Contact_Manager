package com.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

    @RequestMapping("/home")
    public String homePage(Model model){
        model.addAttribute("isLogin", true);
        System.out.println("Home page loading");
        return "home";
    }

    //about route

    @RequestMapping("/about")
    public String aboutPage(Model model){
        model.addAttribute("isLogin", true);
        System.out.println("About page loading");
        return "about";
    }
    
    //services

    @RequestMapping("/services")
    public String servicesPage(){
        System.out.println("Services page loading");
        return "services";
    }

    //contact page

    @GetMapping("/contact")
    public String contact(){
        System.out.println("Contact page loading");
        return "contact";
    }

    @GetMapping("/login")
    public String login() {
        return new String("login");
    }

    @GetMapping("/register")
    public String register(Model model) {
        UserForm userForm = new UserForm();
        //default data can be added if you want
        // userForm.setName("Prajwal");
        model.addAttribute("userForm", userForm);


        return "register";
    }
    
    //processing
    @RequestMapping(value="/do-register", method= RequestMethod.POST)
    public String processRegister(@ModelAttribute UserForm userForm, HttpSession session) {
        System.out.println("Processing registration");
        //we have fetch the form data 
        //UserForm
        System.out.println(userForm);

        //validate form data 


        //save to database


        //userservice
        //UserForm --> User
        // User user = User.builder()
        // .name(userForm.getName())
        // .email(userForm.getEmail())
        // .password(userForm.getPassword())
        // .about(userForm.getAbout())
        // .phoneNumber(userForm.getPhoneNumber())
        // .profilePic("")
        // .build();


        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic("");

        User saveUser = userService.saveUser(user);

        System.out.println("User saved :");
        // message = "Registrstion successful"

        //add the message 
        Message message = Message.builder().content("Registration Successful").type(MessageType.green).build();

        session.setAttribute("message",message);

        //redirect to login page 
        return "redirect:/register";
    }
    

}