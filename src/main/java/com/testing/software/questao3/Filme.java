package com.testing.software.questao3;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/*
 * De acordo com a classe Filme abaixo, implemente:
 * a) 1 Método que retorna o filme com menor duração entre os dois e lança uma exceção FilmeNaoValidoException caso as durações sejam iguais;
 * b) 1 método que retorna true caso os filmes forem do mesmo diretor e false caso contrário, além disso lança uma exceção FilmeNaoValidoException caso sejam iguais;
 * c) Por último, crie uma classe FilmeTest e crie testes de unidade para checar os cenários.
 */

@Getter
@EqualsAndHashCode
public class Filme {
  private String titulo;
  private double duracaoMin;
  private String diretor;

  public Filme(String titulo, double duracaoMin, String diretor) throws FilmeNaoValidoException {
    if (duracaoMin < 45 || titulo.isBlank() || diretor.isBlank()) {
      throw new FilmeNaoValidoException();
    } else {
      this.titulo = titulo;
      this.duracaoMin = duracaoMin;
      this.diretor = diretor;
    }
  }

  public String getFilmeMenorDuracao(Filme filme2) throws FilmeNaoValidoException {
    if (this.duracaoMin == filme2.duracaoMin) {
      throw new FilmeNaoValidoException();
    } else if (this.duracaoMin < filme2.duracaoMin) {
      return this.titulo;
    } else {
      return filme2.titulo;
    }
  }

  public boolean isMesmoDiretor(Filme filme2) throws FilmeNaoValidoException {
    if (this.equals(filme2)) {
      throw new FilmeNaoValidoException();
    } else {
      return this.diretor.equals(filme2.diretor);
    }
  }
}
