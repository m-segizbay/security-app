package kz.segizbay.springcourse.FirstSecurityApp.util;

import kz.segizbay.springcourse.FirstSecurityApp.models.Person;
import kz.segizbay.springcourse.FirstSecurityApp.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class PersonValidator implements Validator {
    private final PeopleService peopleService;

    @Autowired
    public PersonValidator(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person newPerson = (Person) target;

        Optional<Person> person = peopleService.findByUsername(newPerson.getUsername());

        if (person.isPresent()){
            errors.rejectValue("username", "", "Такой логин уже есть!");
        }
    }
}
