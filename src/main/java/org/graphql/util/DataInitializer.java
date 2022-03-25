package org.graphql.util;

import io.quarkus.runtime.StartupEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.graphql.dom.Comment;
import org.graphql.dom.Post;
import org.graphql.service.PostService;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@ApplicationScoped
@RequiredArgsConstructor
@Slf4j
public class DataInitializer {
  private final PostService postService;

  public void onStartup(@Observes StartupEvent event) {
    List<Post> posts = IntStream.range(1, 5).mapToObj(id -> Post.builder()
        .id(UUID.randomUUID().toString())
        .title("Post # " + id)
        .content("Content of post # " + id)
        .comments(List.of(
            Comment.builder()
                .id(UUID.randomUUID().toString())
                .content("comment #1")
                .build(),
            Comment.builder()
                .id(UUID.randomUUID().toString())
                .content("comment #2")
                .build(),
            Comment.builder()
                .id(UUID.randomUUID().toString())
                .content("comment #3")
                .build())
            )
        .build())
        .collect(Collectors.toList());
    postService.init(posts);
    posts.forEach(p -> log.info("Post with id: {} has been added.", p.getId()));
  }
}
