package com.valid.repositories.person.facade;

import com.valid.core.exceptions.base.ServiceException;
import com.valid.domain.entity.Person;

import java.util.List;


public interface PersonRepositoryFacade {

    List<Person> findAll() throws ServiceException;
    Person findPersonEntityById(Integer id) throws ServiceException;
    Person save(Person person) throws ServiceException;
    Person update(Integer id, Boolean procesado) throws ServiceException;
    Person updatePerson(Person person) throws ServiceException;
}
