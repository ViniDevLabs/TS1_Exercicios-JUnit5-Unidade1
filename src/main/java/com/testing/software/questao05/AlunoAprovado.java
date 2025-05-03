package com.testing.software.questao05;

/* a) Refatore a classe para lançar uma exceção MediaInvalidaException caso uma das notas seja negativa. 
 * b) Após o reparo, realize testes parametrizados utilizando JUnit, e que trabalhe as 3 situações existentes retornadas pela String situacao.
 */

public class AlunoAprovado {
  private AlunoAprovado() {
  }

  public static String calculaMediaFinal(int primeiraNota, int segundaNota) throws MediaInvalidaException {
    if (primeiraNota < 0 || segundaNota < 0) {
      throw new MediaInvalidaException();
    }

    int mediaAprovado = 7;
    int mediaRecuperacao = 5;

    int media = (primeiraNota + segundaNota) / 2;

    String situacao = "Aprovado";

    if (media >= mediaAprovado) {
      return situacao;
    } else if (media >= mediaRecuperacao) {
      situacao = "Recuperação";
      return situacao;
    } else {
      situacao = "Reprovado";
      return situacao;
    }
  }
}
