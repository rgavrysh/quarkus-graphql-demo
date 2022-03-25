package org.graphql.dom;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.graphql.Input;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Input
public class CreatePost {
  String title;
  String content;
}
