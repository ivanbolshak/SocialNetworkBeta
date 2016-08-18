package net.bolshak.socialnetwork.service.impl;

import net.bolshak.socialnetwork.dao.PersonDao;
import net.bolshak.socialnetwork.dao.PostDao;
import net.bolshak.socialnetwork.entity.Person;
import net.bolshak.socialnetwork.entity.Post;
import net.bolshak.socialnetwork.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ivan on 24.06.2016.
 */

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonDao personDAO;
    @Autowired
    PostDao postDao;

    @Override
    public Person findByID(Integer id) {
        return personDAO.findByID(id);
    }

    @Override
    public Person findByNickname(String nickname) {
        return personDAO.findByNickname(nickname);
    }

    @Override
    public List<Person> listPerson() {
        return personDAO.listPerson();
    }

    @Override
    public void create(Person person) {
        personDAO.create(person);

    }

    @Override
    public void update(Person person) {
        personDAO.update(person);

    }

    @Override
    public void delete(Person person) {
        personDAO.delete(person);
    }

    @Override
    public List<Post> listPosts(Integer userId) {
        return postDao.findAllPostsByUserId(userId);
    }

    @Override
    public Post getPostByUserAndPostId(Integer userId, Integer postId) {
        return postDao.getPostByUserAndPostId(userId, postId);
    }
    @Override
    public Post getPostByPostId(Integer postId){
        return postDao.getPostByPostId(postId);
    }

    @Override
    public void createPost(Post post) {
        postDao.createPost(post);

    }

    @Override
    public void deletePost(Post post) {
        postDao.deletePost(post);
    }
}
