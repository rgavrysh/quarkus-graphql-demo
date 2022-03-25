package org.graphql;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import lombok.Builder;
import lombok.Data;
import org.graphql.dom.Employee;
//import org.jboss.resteasy.reactive.RestSseElementType;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.time.Duration;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Path("/")
public class GreetingResource {

  @GET
  @Path("/greet")
  @Produces(MediaType.APPLICATION_JSON)
  public String hello(@QueryParam("name") String name) {
    return "Hello " + name;
  }

  @GET
  @Path("/v2/employee")
  @Produces(MediaType.APPLICATION_JSON)
  public Uni<Employee> getEmployeeAsync() {
    return Uni.createFrom().item(new Employee(UUID.randomUUID().toString(), "Roman", "architect"));
  }

  @GET
  @Path("/employee")
  public String getEmployee() throws InterruptedException {
//    Thread.sleep(500L);
    return new Employee(UUID.randomUUID().toString(), "Roman", "architect").toString();
  }

  @GET
  @Path("/v2/employees")
  @Produces(MediaType.APPLICATION_JSON)
  public Multi<Employee> getEmployeesAsync() {
    Stream<Employee> employees = Stream.of(
        new Employee(UUID.randomUUID().toString(), "Roman", "architect"),
        new Employee(UUID.randomUUID().toString(), "Ruslan", "solution architect"),
        new Employee(UUID.randomUUID().toString(), "Alex", "devOps architect")
    );
    return Multi.createFrom().items(employees);
  }

  @GET
  @Path("/employees")
  public List<String> getEmployees() {
    return List.of(
        new Employee(UUID.randomUUID().toString(), "Roman", "architect").toString(),
        new Employee(UUID.randomUUID().toString(), "Ruslan", "solution architect").toString(),
        new Employee(UUID.randomUUID().toString(), "Alex", "devOps architect").toString()
    );
  }

  @GET
  @Path("/counter")
  @Produces(MediaType.SERVER_SENT_EVENTS)
//    @RestSseElementType(MediaType.APPLICATION_JSON)
  public Multi<Long> counter() {
    return Multi.createFrom().ticks().every(Duration.ofSeconds(1));
  }
}

@Data
@Builder
class Person{
  private String name;
  String surname;
}