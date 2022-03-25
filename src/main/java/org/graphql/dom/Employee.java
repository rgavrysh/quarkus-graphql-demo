package org.graphql.dom;

import lombok.Getter;
import lombok.Setter;

// graalvm-ce-java17-21.3.0 native does not work with java17 Records
//public record Employee(String id, String name, String role) {}
@Getter
@Setter
public class Employee {
  private String id;
  private String name;
  private String role;

  public Employee(String id, String name, String role) {
    this.id = id;
    this.name = name;
    this.role = role;
  }
}