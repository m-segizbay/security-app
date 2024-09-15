package kz.segizbay.springcourse.FirstSecurityApp.services;

import kz.segizbay.springcourse.FirstSecurityApp.models.Person;
import kz.segizbay.springcourse.FirstSecurityApp.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class PeopleService {
    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public Optional<Person> findByUsername(String username){
        return peopleRepository.findByUsername(username);
    }
}
