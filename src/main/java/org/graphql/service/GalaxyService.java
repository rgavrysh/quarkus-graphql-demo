package org.graphql.service;

import org.graphql.dom.Film;
import org.graphql.dom.Hero;
import org.graphql.dom.LightSaber;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class GalaxyService {
  private List<Hero> heroes = new ArrayList<>();
  private List<Film> films = new ArrayList<>();

  public GalaxyService() {

    Film aNewHope = Film.builder()
        .title("A New Hope")
        .releaseDate(LocalDate.of(1977, Month.MAY, 25))
        .episodeID(4)
        .director("George Lucas")
        .build();

    Film theEmpireStrikesBack = Film.builder()
        .title("The Empire Strikes Back")
        .releaseDate(LocalDate.of(1980, Month.MAY, 21))
        .episodeID(5)
        .director("George Lucas")
        .build();

    Film returnOfTheJedi = Film.builder()
        .title("Return Of The Jedi")
        .releaseDate(LocalDate.of(1983, Month.MAY, 25))
        .episodeID(6)
        .director("George Lucas")
        .build();

    films.add(aNewHope);
    films.add(theEmpireStrikesBack);
    films.add(returnOfTheJedi);

    Hero luke = Hero.builder()
        .name("Luke")
        .surname("Skywalker")
        .height(1.7)
        .mass(73)
        .lightSaber(LightSaber.GREEN)
        .darkSide(false)
        .episodeIds(List.of(4,5,6))
        .build();

    Hero leia = Hero.builder()
        .name("Leia")
        .surname("Organa")
        .height(1.5)
        .mass(51)
        .darkSide(false)
        .episodeIds(List.of(4,5,6))
        .build();

    Hero vader = Hero.builder()
        .name("Darth")
        .surname("Vader")
        .height(1.9)
        .mass(89)
        .darkSide(true)
        .lightSaber(LightSaber.RED)
        .episodeIds(List.of(4,5,6))
        .build();
    heroes.add(luke);
    heroes.add(leia);
    heroes.add(vader);
  }

  public List<Film> getAllFilms() {
    return films;
  }

  public Film getFilm(int id) {
    return films.get(id);
  }

  public List<Hero> getHeroesByFile(Film film) {
    return heroes.stream().filter(h -> h.getEpisodeIds().contains(film.getEpisodeID()))
        .collect(Collectors.toList());
  }

  public void addHero(Hero hero) {
    heroes.add(hero);
  }

  public Hero deleteHero(int id) {
    return heroes.remove(id);
  }

  public List<Hero> getHeroesBySurname(String surname) {
    return heroes.stream().filter(h -> h.getSurname().equals(surname))
        .collect(Collectors.toList());
  }
}
