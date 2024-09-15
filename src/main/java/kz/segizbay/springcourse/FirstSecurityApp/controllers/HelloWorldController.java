package kz.segizbay.springcourse.FirstSecurityApp.controllers;

import kz.segizbay.springcourse.FirstSecurityApp.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import kz.segizbay.springcourse.FirstSecurityApp.security.PersonDetails;

@Controller
public class HelloWorldController {
    private final AdminService adminService;

    @Autowired
    public HelloWorldController(AdminService adminService) {
        this.adminService = adminService;
    }

    @RequestMapping("/hello")
    public String helloWorld(){
        return "hello";
    }

    @RequestMapping("/showUserInfo")
    public String showUserInfo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        System.out.println(personDetails.getPerson());
        return "hello";
    }

    @RequestMapping("/admin")
    public String adminPage(){
        adminService.doAdminStuff();
        return "admin";
    }
}
