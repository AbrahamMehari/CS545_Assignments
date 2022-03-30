package com.spring.assignmentOne.repo;

import com.spring.assignmentOne.domain.Post;

import java.util.List;

public interface PostRepo {

    List<Post> getAll();

    Post getById(int id);

    boolean save(Post p);

    void delete(int id);

    void update(int id);
}
