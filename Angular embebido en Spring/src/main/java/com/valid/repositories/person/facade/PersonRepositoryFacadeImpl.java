package com.valid.repositories.person.facade;

import com.valid.core.exceptions.base.ServiceException;
import com.valid.core.exceptions.enums.LogRefServices;
import com.valid.core.exceptions.persistence.DataNotFoundPersistenceException;
import com.valid.core.exceptions.service.DataNotFoundServiceException;
import com.valid.domain.entity.Person;
import com.valid.repositories.person.PersonRepository;
import org.springframework.stereotype.Component;

import javax.persistence.PersistenceException;
import java.util.List;
import java.util.Optional;

@Component
public class PersonRepositoryFacadeImpl implements PersonRepositoryFacade {

    private final PersonRepository personRepository;

    public PersonRepositoryFacadeImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    public List<Person> findAll() throws ServiceException {
        try {
            return Optional.of(personRepository.findAll())
                    .orElseThrow(() -> new DataNotFoundServiceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "No se encontraron registros."));
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "Error en la busqeuda de persona", pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error General", e);
        }
    }

    @Override
    public Person findPersonEntityById(Integer id) throws ServiceException {
        try {
            return Optional.of(personRepository.findPersonEntityById(id))
                    .orElseThrow(() -> new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "No se encontro persona por el Id"));
        } catch (IllegalArgumentException | PersistenceException p) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "Error en la busqueda por Id", p);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error General", e);
        }
    }

    @Override
    public Person save(Person person) throws ServiceException {
        try {
            return personRepository.save(person);
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "Error en la busqueda del usuario.", pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general.", e);
        }
    }

    @Override
    public Person update(Integer id, Boolean procesado) throws ServiceException {
        try {
            return personRepository.save(mapperPersonUpdateStatus(id, procesado));
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "Error en la busqueda del usuario.", pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general.", e);
        }
    }

    @Override
    public Person updatePerson(Person person) throws ServiceException {
        try {
            return personRepository.save(mapperPersonUpdate(person));
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "Error en la busqueda del usuario.", pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general.", e);
        }
    }

    private Person mapperPersonUpdateStatus(Integer id, Boolean procesado) throws ServiceException {
        Person userActual = findPersonEntityById(id);
        userActual.setProcesado(procesado);
        return userActual;
    }
    private Person mapperPersonUpdate(Person person) throws ServiceException {
        Person userActual = findPersonEntityById(person.getId());
        userActual.setNombre(person.getNombre());
        userActual.setApellido(person.getApellido());
        userActual.setProcesado(person.getProcesado());
        return userActual;
    }
}
