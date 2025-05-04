package com.testing.software.questao17;

/*
 * Complete o teste MonstroTest JUnit para verificar se o método "receberGolpe" da classe "Monstro"
 * está diminuindo corretamente a vida do monstro
 */

public class Monstro {
  private int vida;

  public Monstro(int vida) {
    this.vida = vida;
  }

  public void receberGolpe(int forcaGolpe) {
    this.vida -= forcaGolpe;
    if (vida <= 0) {
      throw new MorteException();
    }
  }

  public void antidoto(int restaura) {
    this.vida += restaura;
  }

  public int getVida() {
    return vida;
  }
}
