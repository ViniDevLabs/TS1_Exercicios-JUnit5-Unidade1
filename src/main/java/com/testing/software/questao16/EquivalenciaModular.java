package com.testing.software.questao16;

/*
 * Considere a seguinte classe EquivalenciaModular que contém o método calcularEquivalencia que
 * retorna true se dois números são equivalentes mod, e false se não forem equivalentes.
 * Crie testes de unidade para verificar o funcionamento do método calcularEquivalencia.
 */

public class EquivalenciaModular {
  private EquivalenciaModular() {
  }

  public static boolean calcularEquivalencia(int a, int b, int m) {
    return (a % m) == (b % m);
  }
}
