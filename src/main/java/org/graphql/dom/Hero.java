package org.graphql.dom;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Hero {
  private String name;
  private String surname;
  private Double height;
  private Integer mass;
  private Boolean darkSide;
  private LightSaber lightSaber;
  private List<Integer> episodeIds = new ArrayList<>();
}


