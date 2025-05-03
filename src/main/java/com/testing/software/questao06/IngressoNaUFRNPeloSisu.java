package com.testing.software.questao06;

import lombok.Getter;

/*
 * Construa uma classe chamada IngressoNaUFRNPeloSisu que deve conter:
 * a) Construtor com 7 valores que indique o valor das seguintes situações:
 * - Ano do último enem realizado;
 * - Nota tirada na área de Linguagens;
 * - Nota tirada na área de Matemática;
 * - Nota tirada na área de Humanas;
 * - Nota tirada na área de Natureza;
 * - Nota tirada na prova de redação;
 * - Área do curso que pretende ingressar.
 * b) Lance uma exceção InscricaoIrregularException caso o ano do último enem realizado não seja o ano de 2024.
 * c) De acordo com a tabela das notas de corte abaixo, crie um método booleano caso o estudante 
 * esteja apto a tentativa de ingresso na área que pretende ingressar.
 *  +------------------+------------+-------------+-------------+-------------+----------+
 *  | Área             | Linguagens | Matemática  | C. Humanas  | C. Natureza | Redação  |
 *  +------------------+------------+-------------+-------------+-------------+----------+
 *  | Biomédica        |   450      |   450       |    450      |    450      |   500    |
 *  | Humanística I    |   450      |   450       |    450      |    450      |   500    |
 *  | Humanística II   |   450      |   450       |    450      |    450      |   500    |
 *  | Tecnológica I    |   450      |   450       |    450      |    450      |   500    |
 *  | Tecnológica II   |   450      |   450       |    450      |    450      |   500    |
 *  +------------------+------------+-------------+-------------+-------------+----------+
 * d) Criar uma classe de testes parametrizados que verifique os métodos desta
 * classe, inclusive o lançamento das exceções quando lançadas.
 */

@Getter
public class IngressoNaUFRNPeloSisu {
  private int anoUltimoEnem;
  private double notaLinguagens;
  private double notaMatematica;
  private double notaHumanas;
  private double notaNatureza;
  private double notaRedacao;
  private AreaCursoEnum areaCurso;

  public IngressoNaUFRNPeloSisu(int anoUltimoEnem, double notaLinguagens, double notaMatematica, double notaHumanas,
      double notaNatureza, double notaRedacao, AreaCursoEnum areaCurso) throws InscricaoIrregularException {
    if (anoUltimoEnem != 2024) {
      throw new InscricaoIrregularException();
    }
    this.anoUltimoEnem = anoUltimoEnem;
    this.notaLinguagens = notaLinguagens;
    this.notaMatematica = notaMatematica;
    this.notaHumanas = notaHumanas;
    this.notaNatureza = notaNatureza;
    this.notaRedacao = notaRedacao;
    this.areaCurso = areaCurso;
  }

  public boolean isApto() {
    return notaLinguagens >= 450 && notaHumanas >= 450 && notaMatematica >= 450 && notaNatureza >= 450
        && notaRedacao >= 500;
  }
}
