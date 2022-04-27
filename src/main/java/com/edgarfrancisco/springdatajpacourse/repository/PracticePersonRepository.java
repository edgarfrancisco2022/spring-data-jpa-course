package com.edgarfrancisco.springdatajpacourse.repository;

import com.edgarfrancisco.springdatajpacourse.entity.PracticeClassPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PracticePersonRepository extends JpaRepository<PracticeClassPerson, Long> {
}
