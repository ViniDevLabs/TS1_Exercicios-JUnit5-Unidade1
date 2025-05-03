package questao05;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.testing.software.questao05.AlunoAprovado;
import com.testing.software.questao05.MediaInvalidaException;

class AlunoAprovadoTest {

  @ParameterizedTest
  @MethodSource("valoresValidos")
  void shouldReturnSituacaoCorreta(int primeiraNota, int segundaNota, String expected) {
    assertDoesNotThrow(() -> {
      assertEquals(expected, AlunoAprovado.calculaMediaFinal(primeiraNota, segundaNota));
    });
  }

  static Stream<Arguments> valoresValidos() {
    return Stream.of(
        Arguments.of(8, 7, "Aprovado"),
        Arguments.of(7, 7, "Aprovado"),
        Arguments.of(6, 5, "Recuperação"),
        Arguments.of(5, 5, "Recuperação"),
        Arguments.of(3, 4, "Reprovado"),
        Arguments.of(0, 4, "Reprovado"));
  }

  @ParameterizedTest
  @MethodSource("valoresInvalidos")
  void shouldThrowExceptionForNotaNegativa(int primeiraNota, int segundaNota) {
    assertThrows(MediaInvalidaException.class, () -> {
      AlunoAprovado.calculaMediaFinal(primeiraNota, segundaNota);
    });
  }

  static Stream<Arguments> valoresInvalidos() {
    return Stream.of(
        Arguments.of(-1, 5),
        Arguments.of(7, -2),
        Arguments.of(-3, -4));
  }
}
