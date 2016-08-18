package net.bolshak.socialnetwork.service;

import net.bolshak.socialnetwork.entity.Person;
import net.bolshak.socialnetwork.entity.Post;

import java.util.List;

/**
 * Created by Ivan on 24.06.2016.
 */
public interface PersonService {

    //Service for working with person's details
    Person findByID(Integer id);
    Person findByNickname(String nickname);
    List<Person> listPerson();
    void create(Person person);
    void update(Person person);
    void delete(Person person);

    //Service for work with person's posts....
    List<Post> listPosts(Integer userId);
    Post getPostByUserAndPostId(Integer userId, Integer postId);
    public Post getPostByPostId(Integer postId);
    void createPost(Post post);
    void deletePost(Post post);


}
