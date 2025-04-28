package questao2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.testing.software.questao2.ArgumentoInvalidoException;
import com.testing.software.questao2.SmartWatch;

import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

class SmartWatchTest {

  @ParameterizedTest
  @MethodSource("valoresValidos")
  void shouldCalcRiscoOverTrainingCorrectly(int bpm, double distancia, String resultadoEsperado) {
    assertDoesNotThrow(() -> {
      SmartWatch smartWatch = new SmartWatch();
      String resultado = smartWatch.calcRiscoOverTraining(bpm, distancia);
      assertEquals(resultadoEsperado, resultado);
    });
  }

  static Stream<Arguments> valoresValidos() {
    return Stream.of(
        Arguments.of(101, 11, "ALTO_RISCO"),
        Arguments.of(101, 9, "NAO_HA_RISCO"),
        Arguments.of(99, 11, "NAO_HA_RISCO"));
  }

  @ParameterizedTest
  @MethodSource("valoresInvalidos")
  void shouldNotCalcRiscoOverTrainingCorrectly(int bpm, double distancia) {
    assertThrows(ArgumentoInvalidoException.class, () -> {
      SmartWatch smartWatch = new SmartWatch();
      smartWatch.calcRiscoOverTraining(bpm, distancia);
    });
  }

  static Stream<Arguments> valoresInvalidos() {
    return Stream.of(
        Arguments.of(-1, 5),
        Arguments.of(90, -1),
        Arguments.of(-1, -1));
  }
}
