package com.testing.software.questao11;

import java.util.List;

/*
 * Considere a classe para calcular a média ponderada abaixo
 * A função calculaMediaPonderada recebe uma lista de valores e uma lista de pesos, crie testes parametrizados utilizando JUnit4 para essa classe.
 */

public class CalculaMediaPonderada {
  private CalculaMediaPonderada() {
  }

  public static double calculaMediaPonderada(List<Double> valores, List<Integer> pesos) throws Exception {
    if (valores.size() != pesos.size() && (valores.size() == 0 || pesos.size() == 0)) {
      throw new Exception();
    }

    double resultado = 0;
    for (int i = 0; i < valores.size(); i++) {
      resultado += valores.get(i) * pesos.get(i);
    }

    double somaPesos = 0;
    for (int i = 0; i < pesos.size(); i++) {
      somaPesos += pesos.get(i);
    }
    return resultado / somaPesos;
  }
}