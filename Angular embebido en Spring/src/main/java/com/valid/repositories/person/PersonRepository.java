package com.valid.repositories.person;

import com.valid.domain.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {

    @Query("SELECT p FROM Person p where p.id=:ID")
    Person findPersonEntityById(@Param("ID") Integer id);
}
