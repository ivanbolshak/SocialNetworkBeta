package net.bolshak.socialnetwork;

import net.bolshak.socialnetwork.dao.PersonDao;
import net.bolshak.socialnetwork.dao.PostDao;
import net.bolshak.socialnetwork.entity.Person;
import net.bolshak.socialnetwork.entity.Post;
import net.bolshak.socialnetwork.service.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Ivan on 24.06.2016.
 */
public class appTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");

        PersonDao personDao =context.getBean(PersonDao.class);
        PersonService personService = context.getBean(PersonService.class);
        PostDao postDao = context.getBean(PostDao.class);

        System.out.println("All users from person table: ");

        for (Person person: personService.listPerson()){
            System.out.println("Person: " + person);
        }
//---------------------------------------
//        Integer id = 1;
//        Person person = personService.findByID(id);
//        System.out.println("All posts from person nickname: " +person.getNickname()+"   .With id: "+id);
//
//        for (Post post: personService.listPosts(person.getId())){
//            System.out.println("Post: "+post);
//        }

//        String nickname = "crack";
//        System.out.println("Datails from nickname "+nickname);
//        System.out.println(personService.findByNickname(nickname));
//---------------------------------------
//        Ceate new person in DB
//        System.out.println("Add new person:");
//        Person personCreate = new Person("Sergey", "Beliy", "19.03.1990", "maliy");
//        System.out.println("New Person:"+personCreate);
//        personService.create(personCreate);
//        System.out.println("Show all persons after add: ");
//        for (Person person2: personService.listPerson()){
//            System.out.println("Person: " + person2);
//        }
//---------------------------------------------
//        Create new Post in DB
//        Create post in DB
//        Integer id = 3;
//        Person person = personService.findByID(id);
//        System.out.println("Create new post for person id = "+id);
//          Post post = new Post("First insert post", "Different blablablablab in the first insert post", id);
////        Post post = new Post();
//        System.out.println("Save post to DB");
//        personService.createPost(post);
//
//        System.out.println("All posts from person nickname: " +person.getNickname()+"   .With id: "+id);
//
//        for (Post post2: personService.listPosts(person.getId())){
//            System.out.println("Post: "+post2);
//        }
//        ----------------------------------
//        Delete person from DB
//        Integer id = 6;
//        Person person = personService.findByID(id);
//        System.out.println("Delete person: "+person);
//        personService.delete(person);
//        System.out.println("Show all person from DB:");
//        for (Person person1: personService.listPerson()){
//            System.out.println(person1);
//        }
//        -----------------------------------
////        Delete post by user and post id
//        Integer postId = 25;
//        Integer userId = 1;
//        Post post = personService.getPostByUserAndPostId(userId, postId);
//        personService.deletePost(post);
////        -----------------------------------
////        Delete post by post id
//        Integer postId = 26;
//        Post post = personService.getPostByPostId(postId);
//        personService.deletePost(post);
//////        -----------------------------------









    }
}
