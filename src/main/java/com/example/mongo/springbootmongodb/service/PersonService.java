package com.example.mongo.springbootmongodb.service;


import com.example.mongo.springbootmongodb.entity.Person;
import com.example.mongo.springbootmongodb.repository.PersonRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("java:S106")
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    @PostConstruct
    public void postConstruct(){
        personRepository.save(new Person("1","John", 31, "M"));
        personRepository.save(new Person("2","Bob", 52, "M"));
        personRepository.save(new Person("3","Jane", 26, "V"));
        personRepository.save(new Person("4","Sarah", 27, "V"));
        personRepository.save(new Person("5","Missy", 31, "V"));


        personRepository.findAll("M").forEach(System.err::println);


        Person person1 = personRepository.findPersonByName("Jane");
        System.err.println(person1);

        Person person2 = personRepository.findPersonByName("jane");
        System.err.println(person2); // Not found, because is case senstive

        System.err.println("Number of records " + personRepository.count());
    }

}
