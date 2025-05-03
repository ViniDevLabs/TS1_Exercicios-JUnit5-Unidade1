package questao13;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.testing.software.questao13.ConversorMoeda;

class ConversorMoedaTest {

  @Test
  void testValorZero() {
    double valor = 0.0;
    double resultado1 = ConversorMoeda.converterUSDBRL(valor);
    double resultado2 = ConversorMoeda.converterEURBRL(valor);
    assertEquals(0.0, resultado1, 0);
    assertEquals(0.0, resultado2, 0);
  }

  @Test
  void testValorNegativo() {
    double valor = -10.0;

    IllegalArgumentException ex1 = assertThrows(IllegalArgumentException.class, () -> {
      ConversorMoeda.converterUSDBRL(valor);
    });
    assertEquals("O valor não pode ser negativo!", ex1.getMessage());

    IllegalArgumentException ex2 = assertThrows(IllegalArgumentException.class, () -> {
      ConversorMoeda.converterEURBRL(valor);
    });
    assertEquals("O valor não pode ser negativo!", ex2.getMessage());
  }

  @ParameterizedTest
  @CsvSource({
      "1.0, 5.20",
      "2.0, 10.40",
      "0.0, 0.0",
      "10.0, 52.0"
  })
  void testConverterUSDBRL(double input, double expected) {
    assertEquals(expected, ConversorMoeda.converterUSDBRL(input), 0.01);
  }

  @ParameterizedTest
  @CsvSource({
      "1.0, 6.15",
      "2.0, 12.30",
      "0.0, 0.0",
      "10.0, 61.5"
  })
  void testConverterEURBRL(double input, double expected) {
    assertEquals(expected, ConversorMoeda.converterEURBRL(input), 0.01);
  }
}
