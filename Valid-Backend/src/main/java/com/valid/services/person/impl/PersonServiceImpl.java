package com.valid.services.person.impl;

import com.valid.core.exceptions.base.ServiceException;
import com.valid.domain.dto.PersonDTO;
import com.valid.domain.entity.Person;
import com.valid.repositories.person.facade.PersonRepositoryFacade;
import com.valid.services.person.PersonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class PersonServiceImpl implements PersonService {

    private final PersonRepositoryFacade personRepositoryFacade;

    public PersonServiceImpl(PersonRepositoryFacade personRepositoryFacade) {
        this.personRepositoryFacade = personRepositoryFacade;
    }

    @Override
    public List<PersonDTO> findAll() throws ServiceException {
        List<Person> personList = personRepositoryFacade.findAll();
        return personList.stream().map(this::mapperUserEntity).collect(Collectors.toList());
    }


    @Override
    public Person findPersonEntityById(Integer id) throws ServiceException {
        return personRepositoryFacade.findPersonEntityById(id);
    }

    @Override
    public Person save(PersonDTO person) throws ServiceException {
        return personRepositoryFacade.save(mapperEntityUser(person));
    }

    @Override
    public Person updateStatus(Integer id, Boolean procesado) throws ServiceException {
        return personRepositoryFacade.update(id,procesado);
    }

    @Override
    public Person update(PersonDTO person) throws ServiceException {
        return personRepositoryFacade.updatePerson(mapperEntityUser(person));
    }

    private PersonDTO mapperUserEntity(Person entity) {
        return PersonDTO.builder().id(entity.getId()).nombre(entity.getNombre()).apellido(entity.getApellido()).procesado(entity.getProcesado()).build();
    }

    private Person mapperEntityUser(PersonDTO personDTO){
        return Person.builder().id(personDTO.getId()).nombre(personDTO.getNombre()).apellido(personDTO.getApellido()).procesado(personDTO.getProcesado()).build();
    }

}
