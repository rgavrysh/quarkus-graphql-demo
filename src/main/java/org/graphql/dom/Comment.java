package org.graphql.dom;

import lombok.Builder;
import lombok.Data;
import org.eclipse.microprofile.graphql.Id;
import org.eclipse.microprofile.graphql.Type;

@Data
@Builder
@Type
public class Comment {

  @Id String id;
  String content;
}
