package kz.segizbay.springcourse.FirstSecurityApp.controllers;

import jakarta.validation.Valid;
import kz.segizbay.springcourse.FirstSecurityApp.models.Person;
import kz.segizbay.springcourse.FirstSecurityApp.services.RegistrationService;
import kz.segizbay.springcourse.FirstSecurityApp.util.PersonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthContoller {
    private final PersonValidator personValidator;
    private final RegistrationService registrationService;

    @Autowired
    public AuthContoller(PersonValidator personValidator, RegistrationService registrationService) {
        this.personValidator = personValidator;
        this.registrationService = registrationService;
    }


    @RequestMapping("/login")
    public String loginPage(){
        return "auth/login";
    }

    @RequestMapping("/register")
    public String registerPage(@ModelAttribute Person person){
        return "auth/register";
    }

    @PostMapping("/register")
    public String perfomRegister(@ModelAttribute @Valid Person person, BindingResult bindingResult){
        personValidator.validate(person, bindingResult);

        if (bindingResult.hasErrors()){
            return "/auth/register";
        }

        registrationService.save(person);
        return "redirect:/auth/login";
    }
}
