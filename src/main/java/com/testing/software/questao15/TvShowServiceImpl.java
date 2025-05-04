package com.testing.software.questao15;

import java.time.LocalTime;

public class TvShowServiceImpl {
  public TvShow buildTvShowFromInput(String input) {
    String[] lines = input.split("\"");
    TvShow tvShow = new TvShow(lines[1], lines[3]);

    lines = input.substring(input.lastIndexOf("\"") + 1).trim().split(" ");
    tvShow.setBeginning(LocalTime.parse(lines[lines.length - 2]));
    tvShow.setEnd(LocalTime.parse(lines[lines.length - 1]));
    return tvShow;
  }
}
