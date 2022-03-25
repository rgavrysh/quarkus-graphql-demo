package org.graphql.service;

import org.graphql.dom.CreatePost;
import org.graphql.dom.Post;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class PostService {
  private static List<Post> STORE = new ArrayList<>();

  public void init(List<Post> posts) {
    STORE.clear();
    STORE.addAll(posts);
  }

  public List<Post> getAllPosts() {
    return STORE;
  }

  public Optional<Post> getPostById(String id) {
    return STORE.stream().filter(p -> p.getId().equals(id)).findFirst();
  }

  public Post createPost(CreatePost newPost) {
    Post post = Post.builder().id(UUID.randomUUID().toString())
        .title(newPost.getTitle())
        .content(newPost.getContent())
        .build();
    STORE.add(post);
    return post;
  }
}
