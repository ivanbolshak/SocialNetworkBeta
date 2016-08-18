package net.bolshak.socialnetwork.dao;


import net.bolshak.socialnetwork.entity.Person;

import java.util.List;

/**
 * Created by Ivan on 21.06.2016.
 */
public interface PersonDao {
    Person findByID(Integer id);
    Person findByNickname(String nickname);
    List<Person> listPerson();
    Integer create(Person person);
    void update(Person person);
    void delete(Person person);
}
