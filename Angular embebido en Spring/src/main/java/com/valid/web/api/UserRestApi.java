package com.valid.web.api;

import com.valid.core.exceptions.base.ServiceException;
import com.valid.domain.dto.PersonDTO;
import com.valid.domain.entity.Person;
import com.valid.services.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/valid")
public class UserRestApi {


    private final PersonService service;

    @Autowired
    public UserRestApi(PersonService personService) {
        this.service = personService;
    }

    @GetMapping("/persona")
    public List<PersonDTO> getAllPersons() throws ServiceException {
        return service.findAll();
    }

    @GetMapping("/persona/{id}")
    public ResponseEntity<Person> getUserById(@PathVariable("id") Integer id) throws ServiceException {
        Person entity = service.findPersonEntityById(id);
        return new ResponseEntity<>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(value = "/persona", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> createUser(@RequestBody PersonDTO entity) throws ServiceException {
        Person updated = service.save(entity);
        return new ResponseEntity<>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @PatchMapping("/persona/{id}/procesado/{procesado}")
    public ResponseEntity<Person> updateStatus(@PathVariable Boolean procesado, @PathVariable Integer id)
            throws ServiceException {
        return new ResponseEntity<>(service.updateStatus(id, procesado), HttpStatus.OK);
    }

    @PutMapping(value = "/personUpdate", consumes = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<Person> update(@RequestBody PersonDTO personDTO) throws ServiceException{
        Person updated = service.update(personDTO);
        return new ResponseEntity<>(updated, new HttpHeaders(),HttpStatus.OK);
    }

}
