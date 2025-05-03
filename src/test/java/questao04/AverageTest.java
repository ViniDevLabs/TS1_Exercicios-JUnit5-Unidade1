package questao04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.testing.software.questao04.Average;

class AverageTest {

  @ParameterizedTest
  @MethodSource("valoresValidos")
  void semestreTest(int num1, int num2, int num3, double expected) {
    assertEquals(expected, Average.semester(num1, num2, num3), 0.01);
  }

  static Stream<Arguments> valoresValidos() {
    return Stream.of(
        Arguments.of(90, 85, 95, 90.0),
        Arguments.of(100, 100, 100, 100.0),
        Arguments.of(70, 80, 90, 80.0),
        Arguments.of(60, 75, 85, 73.33),
        Arguments.of(95, 88, 92, 91.66));
  }

}
