package com.example.mongo.springbootmongodb.repository;

import com.example.mongo.springbootmongodb.entity.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PersonRepository extends MongoRepository<Person, String> {

    @Query("{name:'?0'}")
    Person findPersonByName(String name);

    @Query(value="{gender:'?0'}", fields="{'name' : 1, 'age' : 1}") // does not fetch field gender from db
    List<Person> findAll(String gender);

    public long count();


}
