package kz.segizbay.springcourse.FirstSecurityApp.services;

import kz.segizbay.springcourse.FirstSecurityApp.models.Person;
import kz.segizbay.springcourse.FirstSecurityApp.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegistrationService {
    private final PeopleRepository peopleRepository;

    @Autowired
    public RegistrationService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public void save(Person person){
        peopleRepository.save(person);
    }
}
