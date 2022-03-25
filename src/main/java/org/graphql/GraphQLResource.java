package org.graphql;

import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.graphql.Source;
import org.graphql.dom.CreatePost;
import org.graphql.dom.Post;
import org.graphql.exceptions.PostNotFoundException;
import org.graphql.service.PostService;

import java.util.List;

@GraphQLApi
@RequiredArgsConstructor
public class GraphQLResource {
  private final PostService postService;

  @Query
  @Description("Get all posts")
  public List<Post> getAllPosts() {
    return postService.getAllPosts();
  }

  @Query
  @Description("Get specific post by id")
  public Post getPostById(@Name("postId") String id) {
    return postService.getPostById(id).orElseThrow(() -> new PostNotFoundException(id));
  }

  @Mutation
  @Description("Create new post")
  public Post createPost(CreatePost newPost) {
    return postService.createPost(newPost);
  }

  public int comments(@Source Post post) {
    return post.getComments().size();
  }

}
