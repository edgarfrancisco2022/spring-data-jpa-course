package com.edgarfrancisco.springdatajpacourse.repository;

import com.edgarfrancisco.springdatajpacourse.entity.PracticeClassPerson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PracticeClassPracticePersonRepositoryTest {
    @Autowired
    private PracticePersonRepository practicePersonRepository;

    @Test
    void saveMethod() {
        PracticeClassPerson practiceClassPerson1 = new PracticeClassPerson();
        practiceClassPerson1.setFirstName("Edgar");
        practiceClassPerson1.setLastName("Perez");
        practiceClassPerson1.setEmail("edgar@gmail.com");
        practicePersonRepository.save(practiceClassPerson1);
    }

    @Test
    void updateUsingSaveMethod() {
        PracticeClassPerson practiceClassPerson = practicePersonRepository.findById(1L).get();
        practiceClassPerson.setEmail("edgarfrancisco@gmail.com");
        practicePersonRepository.save(practiceClassPerson);
    }

    @Test
    void saveAllMethod() {
        // Create more persons
        PracticeClassPerson practiceClassPerson2 = new PracticeClassPerson();
        practiceClassPerson2.setFirstName("Johann");
        practiceClassPerson2.setLastName("Bach");
        practiceClassPerson2.setEmail("bach@gmail.com");

        PracticeClassPerson practiceClassPerson3 = new PracticeClassPerson();
        practiceClassPerson3.setFirstName("Sergei");
        practiceClassPerson3.setLastName("Rachmaninoff");
        practiceClassPerson3.setEmail("sergei@gmail.com");

        practicePersonRepository.saveAll(List.of(practiceClassPerson2, practiceClassPerson3));
    }

    @Test
    void findByIdMethod() {
        PracticeClassPerson practiceClassPerson = practicePersonRepository.findById(3L).get();
        System.out.println(practiceClassPerson.getFirstName());
    }

    @Test
    void findAllMethod() {
        List<PracticeClassPerson> practiceClassPeople = practicePersonRepository.findAll();
        practiceClassPeople.forEach(x -> System.out.println(x.getFirstName()));
    }

    @Test
    void deleteByIdMethod() {
        practicePersonRepository.deleteById(1L);
    }

    @Test
    void deleteMethod() {
        PracticeClassPerson practiceClassPerson = practicePersonRepository.findById(2L).get();
        practicePersonRepository.delete(practiceClassPerson);
    }

    @Test
    void deleteAll() {
        // To delete all entities
        // personRepository.deleteAll();
        // To delete a list of entities
        PracticeClassPerson practiceClassPerson1 = practicePersonRepository.findById(3L).get();
        PracticeClassPerson practiceClassPerson2 = practicePersonRepository.findById(4L).get();
        practicePersonRepository.deleteAll(List.of(practiceClassPerson1, practiceClassPerson2));
    }

    @Test
    void countMethod() {
        long count = practicePersonRepository.count();
        System.out.println(count);
    }

    @Test
    void existsByIdMethod() {
        boolean result = practicePersonRepository.existsById(5L);
        System.out.println(result);
    }
}
