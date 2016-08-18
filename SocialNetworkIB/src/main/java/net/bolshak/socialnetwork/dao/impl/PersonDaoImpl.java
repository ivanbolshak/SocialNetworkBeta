package net.bolshak.socialnetwork.dao.impl;


import net.bolshak.socialnetwork.dao.PersonDao;
import net.bolshak.socialnetwork.entity.Person;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Ivan on 21.06.2016.
 */

@Repository
public class PersonDaoImpl implements PersonDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Person findByID(Integer id) {
        Person person = (Person) sessionFactory.getCurrentSession()
                .createQuery("select p From Person p where p.id=:id")
                .setParameter("id", id).uniqueResult();
        return person;
    }

    @Override
    public Person findByNickname(String nickname) {
        Person person = (Person) sessionFactory.getCurrentSession().
                createQuery("SELECT p FROM Person p where p.nickname=:nickname")
                .setParameter("nickname", nickname).uniqueResult();
        return person;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Person> listPerson() {

        return sessionFactory.getCurrentSession().createQuery("FROM Person").list();
    }

    @Override
    public Integer create(Person person) {
        sessionFactory.getCurrentSession().save(person);
        return person.getId();
    }

    @Override
    public void update(Person person) {
        sessionFactory.getCurrentSession().update(person);
    }

    @Override
    public void delete(Person person) {
        sessionFactory.getCurrentSession().delete(person);

    }
}
