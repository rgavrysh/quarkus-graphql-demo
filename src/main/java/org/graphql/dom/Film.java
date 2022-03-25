package org.graphql.dom;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Film {
  private String title;
  private Integer episodeID;
  private String director;
  private LocalDate releaseDate;
}
