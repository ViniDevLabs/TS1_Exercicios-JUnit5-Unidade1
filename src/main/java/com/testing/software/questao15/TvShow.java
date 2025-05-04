package com.testing.software.questao15;

import java.time.LocalTime;

import lombok.Getter;
import lombok.Setter;

/*
 * Considerando as classes TvShow e TvShowServiceImpl, crie testes de unidade para a função (buildTvShowFromInput)
 * que constrói o objeto (TvShow) de uma entrada (string) (ex: "BR" "Jornal Cultura" 19:00 00:00)
 */

@Getter
@Setter
public class TvShow {
  private String region;
  private String name;
  private LocalTime beginning;
  private LocalTime end;

  public TvShow(String region, String name) {
    this.region = region;
    this.name = name;
  }

  public TvShow(String region, String name, LocalTime beginning, LocalTime end) {
    super();
    this.region = region;
    this.name = name;
    this.beginning = beginning;
    this.end = end;
  }
}
