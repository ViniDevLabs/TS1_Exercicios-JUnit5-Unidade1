package com.testing.software.questao02;

public class SmartWatch {

  public SmartWatch() {
  }

  /*
   * Se a quantidade de batimentos por minuto for superior a 100 e se a
   * distância percorrida for maior que 10km o método retorna a string
   * "ALTO_RISCO", caso contrário retorna "NAO_HA_RISCO" ou a
   * Exceção ArgumentoInvalido se algum dos valores for negativo
   */
  public String calcRiscoOverTraining(int bpm, double distancia) throws ArgumentoInvalidoException {
    if (bpm < 0 || distancia < 0) {
      throw new ArgumentoInvalidoException();
    } else if (bpm > 100 && distancia > 10) {
      return "ALTO_RISCO";
    } else {
      return "NAO_HA_RISCO";
    }
  }

}
