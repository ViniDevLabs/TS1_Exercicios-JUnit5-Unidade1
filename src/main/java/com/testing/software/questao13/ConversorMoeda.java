package com.testing.software.questao13;

/*
 * Considere a seguinte classe ConversorMoeda que realiza conversões entre diferentes moedas.
 * Implemente testes de unidade para a classe ConversorMoeda usando JUnit, com os seguintes requisitos:
 * - Teste a conversão de um valor zero.
 * - Teste a conversão de um valor negativo, onde uma exceção IllegalArgumentException é esperada.
 * - Use o método assertEquals do JUnit para verificar os resultados esperados.
 */

public class ConversorMoeda {

  private ConversorMoeda() {
  }

  private static final double TAXA_CONVERSAO_USD_BRL = 5.20;
  private static final double TAXA_CONVERSAO_EUR_BRL = 6.15;

  public static double converterUSDBRL(double valor) {
    if (valor < 0) {
      throw new IllegalArgumentException("O valor não pode ser negativo!");
    }
    return valor * TAXA_CONVERSAO_USD_BRL;
  }

  public static double converterEURBRL(double valor) {
    if (valor < 0) {
      throw new IllegalArgumentException("O valor não pode ser negativo!");
    }
    return valor * TAXA_CONVERSAO_EUR_BRL;
  }
}
