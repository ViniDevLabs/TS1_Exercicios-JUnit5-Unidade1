package questao16;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.testing.software.questao16.EquivalenciaModular;

class EquivalenciaModularTest {

  @ParameterizedTest
  @CsvSource({
      "10, 22, 4, true",
      "15, 8, 7, true",
      "9, 4, 3, false",
      "20, 5, 5, true"
  })
  void testCalcularEquivalencia(int a, int b, int m, boolean expected) {
    boolean resultado = EquivalenciaModular.calcularEquivalencia(a, b, m);
    assertEquals(expected, resultado);
  }
}
