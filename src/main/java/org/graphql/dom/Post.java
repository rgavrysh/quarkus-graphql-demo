package org.graphql.dom;

import lombok.Builder;
import lombok.Data;
import org.eclipse.microprofile.graphql.Id;
import org.eclipse.microprofile.graphql.Type;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Type
public class Post {
  @Id
  String id;
  String title;
  String content;
  int countOfComments;

  @Builder.Default
  List<Comment> comments = new ArrayList<>();
}
