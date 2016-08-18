package net.bolshak.socialnetwork.dao;

import net.bolshak.socialnetwork.entity.Post;

import java.util.List;

/**
 * Created by Ivan on 19.07.2016.
 */
public interface PostDao {
    List<Post> findAllPostsByUserId(Integer userId);
    Post getPostByUserAndPostId(Integer userId, Integer postId);
    public Post getPostByPostId(Integer postId);
    Integer createPost(Post post);
    void deletePost(Post post);
}
