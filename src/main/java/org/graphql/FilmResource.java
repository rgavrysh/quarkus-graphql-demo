package org.graphql;

import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.graphql.Source;
import org.graphql.dom.Film;
import org.graphql.dom.Hero;
import org.graphql.service.GalaxyService;

import javax.inject.Inject;
import java.util.List;

@GraphQLApi
public class FilmResource {

  @Inject
  private GalaxyService galaxyService;

  @Query("allFilms")
  @Description("Get all films from a galaxy")
  public List<Film> getAllFilms() {
    return galaxyService.getAllFilms();
  }

  @Query
  @Description("Get a Film by id")
  public Film getFilmById(@Name("filmId") int id) {
    return galaxyService.getFilm(id);
  }

  public List<Hero> heroes(@Source(name = "filmById") Film film) {
    return galaxyService.getHeroesByFile(film);
  }
}
