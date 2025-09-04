/**
 * App: common
 * Package: com.bobwares.common.person
 * File: PersonController.java
 * Version: 0.1.0
 * Turn #: 1
 * Author: AI
 * Date: 2025-09-04T23:36:46Z
 * Exports: PersonController, getPerson, putPerson, updatePerson, deletePerson
 * Description: REST controller providing asynchronous CRUD endpoints for Person records.
 *              Delegates operations to PersonService.
 */

package com.bobwares.common.person;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public Mono<Person> getPerson(@PathVariable String id) {
        return personService.get(id);
    }

    @PutMapping("/{id}")
    public Mono<Person> putPerson(@PathVariable String id, @Valid @RequestBody Person person) {
        return personService.put(id, person);
    }

    @PostMapping("/{id}")
    public Mono<Person> updatePerson(@PathVariable String id, @Valid @RequestBody Person person) {
        return personService.update(id, person);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deletePerson(@PathVariable String id) {
        return personService.delete(id);
    }
}
