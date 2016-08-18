package net.bolshak.socialnetwork.dao.impl;

import net.bolshak.socialnetwork.dao.PostDao;
import net.bolshak.socialnetwork.entity.Person;
import net.bolshak.socialnetwork.entity.Post;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Ivan on 19.07.2016.
 */
@Repository
public class PostDaoImpl implements PostDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Post> findAllPostsByUserId(Integer userId) {


//        return sessionFactory.getCurrentSession()
//                .createQuery("from Post").list();

//        return sessionFactory.getCurrentSession()
//                .createQuery("select p from Post p where p.person.id=:userId")
//                .setParameter("userId", userId).list();
        Person person = (Person) sessionFactory.getCurrentSession()
                    .createQuery("select p FROM Person p where p.id =:userId ")
                    .setParameter("userId", userId).uniqueResult();

        person.getPosts().size();
        return  person.getPosts();
    }

    @Override
    public Post getPostByUserAndPostId(Integer userId, Integer postId) {

        return (Post) sessionFactory.getCurrentSession()
                .createQuery("select p from Post p where p.person.id = :userId and p.id = :postId")
                .setParameter("postId", postId)
                .setParameter("userId", userId)
                .uniqueResult();
    }

    @Override
    public Post getPostByPostId(Integer postId){
        Post post = (Post) sessionFactory.getCurrentSession()
                .createQuery("select p from Post p where p.id = :postId")
                .setParameter("postId", postId)
                .uniqueResult();

        return post;
    }

    @Override
    public Integer createPost(Post post) {
        sessionFactory.getCurrentSession().save(post);
        return post.getId();
    }

    @Override
    public void deletePost(Post post) {
        sessionFactory.getCurrentSession().delete(post);
    }
}
