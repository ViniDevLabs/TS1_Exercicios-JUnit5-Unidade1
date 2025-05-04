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

  public static void main(String[] args) {
    // Teste de exemplo
    System.out.println(calcularEquivalencia(10, 22, 4)); // true
    System.out.println(calcularEquivalencia(15, 8, 7)); // true
    System.out.println(calcularEquivalencia(9, 4, 3)); // false
    System.out.println(calcularEquivalencia(20, 5, 5)); // false
  }
}
