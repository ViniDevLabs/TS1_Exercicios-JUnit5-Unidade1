package questao01;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.testing.software.questao01.NaoTrianguloException;
import com.testing.software.questao01.Triangulo;

import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

class TrianguloTest {

  @ParameterizedTest
  @MethodSource("ladosValidos")
  void shouldCreateTriangulo(double lado1, double lado2, double lado3) {
    assertDoesNotThrow(() -> {
      Triangulo triangulo = new Triangulo(lado1, lado2, lado3);
      assertEquals(lado1, triangulo.getLado1(), 0);
      assertEquals(lado2, triangulo.getLado2(), 0);
      assertEquals(lado3, triangulo.getLado3(), 0);
    });
  }

  static Stream<Arguments> ladosValidos() {
    return Stream.of(
        Arguments.of(3, 4, 5),
        Arguments.of(5, 5, 5),
        Arguments.of(7, 10, 5),
        Arguments.of(8, 6, 10));
  }

  @ParameterizedTest
  @MethodSource("ladosInvalidos")
  void shouldNotCreateTriangulo(double lado1, double lado2, double lado3) {
    assertThrows(NaoTrianguloException.class, () -> {
      new Triangulo(lado1, lado2, lado3);
    });
  }

  static Stream<Arguments> ladosInvalidos() {
    return Stream.of(
        Arguments.of(1, 2, 3),
        Arguments.of(10, 2, 7),
        Arguments.of(1, 5, 1),
        Arguments.of(0, 0, 0));
  }

  @ParameterizedTest
  @MethodSource("tiposTriangulo")
  void shouldCreateTrianguloAndGetTipo(double lado1, double lado2, double lado3, String tipo) {
    assertDoesNotThrow(() -> {
      Triangulo triangulo = new Triangulo(lado1, lado2, lado3);
      assertEquals(tipo, triangulo.getTipo());
    });
  }

  static Stream<Arguments> tiposTriangulo() {
    return Stream.of(
        Arguments.of(3, 4, 5, "Escaleno"),
        Arguments.of(5, 5, 5, "Equilátero"),
        Arguments.of(7, 7, 10, "Isósceles"),
        Arguments.of(8, 6, 10, "Escaleno"));
  }
}
