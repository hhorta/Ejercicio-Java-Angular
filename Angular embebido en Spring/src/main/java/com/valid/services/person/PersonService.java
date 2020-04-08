package com.valid.services.person;

import com.valid.core.exceptions.base.ServiceException;
import com.valid.domain.dto.PersonDTO;
import com.valid.domain.entity.Person;

import java.util.List;

public interface PersonService {
    List<PersonDTO> findAll() throws ServiceException;
    Person findPersonEntityById(Integer id) throws ServiceException;
    Person save(PersonDTO person) throws ServiceException;
    Person updateStatus(Integer id, Boolean procesado) throws ServiceException;
    Person update(PersonDTO person) throws  ServiceException;
}
