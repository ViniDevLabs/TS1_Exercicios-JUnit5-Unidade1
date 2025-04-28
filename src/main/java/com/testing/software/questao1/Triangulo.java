package com.testing.software.questao1;

import lombok.Getter;
import lombok.Setter;

// Construa uma classe chamada Triangulo. Ela deve ter: 
// (a) um construtor que recebe os 3 lados de um triângulo, e lança a exceção NaoTrianguloException caso os 3 lados nao formem um triângulo;
// (b) 3 métodos que não recebem parâmetros e retornam um booleano e que diz se o triângulo é isósceles, escaleno ou equilátero;
// (c) uma classe de testes que checa o comportamento dos métodos desta classe.
// Quando criar os testes lembre-se de testar o lançamento das exceções.

@Getter
public class Triangulo {
  private double lado1;
  private double lado2;
  private double lado3;

  public Triangulo(double lado1, double lado2, double lado3) throws NaoTrianguloException {
    if (!isTriangulo(lado1, lado2, lado3)) {
      throw new NaoTrianguloException();
    }
    this.lado1 = lado1;
    this.lado2 = lado2;
    this.lado3 = lado3;
  }

  private boolean isTriangulo(double lado1, double lado2, double lado3) {
    return (lado1 + lado2 > lado3) && (lado1 + lado3 > lado2) && (lado2 + lado3 > lado1);
  }

  public String getTipo() {
    if (lado1 == lado2 && lado2 == lado3) {
      return "Equilátero";
    } else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
      return "Isósceles";
    } else {
      return "Escaleno";
    }
  }
}
