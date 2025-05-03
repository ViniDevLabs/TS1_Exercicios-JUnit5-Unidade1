package questao06;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.testing.software.questao06.AreaCursoEnum;
import com.testing.software.questao06.IngressoNaUFRNPeloSisu;
import com.testing.software.questao06.InscricaoIrregularException;

class IngressoNaUFRNPeloSisuTest {

  @ParameterizedTest
  @MethodSource("casosDeNotas")
  void shouldCreateIngresoNaUFRNPeloSisuTest(double linguagens, double matematica, double humanas,
      double natureza, double redacao, AreaCursoEnum areaCurso, boolean isApto) {
    assertDoesNotThrow(() -> {
      IngressoNaUFRNPeloSisu ingresso = new IngressoNaUFRNPeloSisu(2024, linguagens, matematica, humanas, natureza,
          redacao, areaCurso);
      assertEquals(linguagens, ingresso.getNotaLinguagens());
      assertEquals(matematica, ingresso.getNotaMatematica());
      assertEquals(humanas, ingresso.getNotaHumanas());
      assertEquals(natureza, ingresso.getNotaNatureza());
      assertEquals(redacao, ingresso.getNotaRedacao());
      assertEquals(areaCurso, ingresso.getAreaCurso());
      assertEquals(isApto, ingresso.isApto());
    });
  }

  @ParameterizedTest
  @MethodSource("casosDeNotas")
  void shouldThrowExceptionForConstructor_WhenAnoUltimoEnemDifferentThan2024(double linguagens, double matematica,
      double humanas,
      double natureza, double redacao, AreaCursoEnum areaCurso, boolean isApto) {
    assertThrows(InscricaoIrregularException.class, () -> {
      new IngressoNaUFRNPeloSisu(2023, linguagens, matematica, humanas, natureza, redacao, areaCurso);
    });
  }

  static Stream<Arguments> casosDeNotas() {
    return Stream.of(
        Arguments.of(460, 470, 480, 490, 510, AreaCursoEnum.BIOMEDICA, true),
        Arguments.of(449, 470, 480, 490, 510, AreaCursoEnum.BIOMEDICA, false),
        Arguments.of(460, 440, 480, 490, 510, AreaCursoEnum.HUMANISTICA1, false),
        Arguments.of(460, 470, 445, 490, 510, AreaCursoEnum.HUMANISTICA2, false),
        Arguments.of(460, 470, 480, 440, 510, AreaCursoEnum.TECNOLOGICA1, false),
        Arguments.of(460, 470, 480, 490, 499, AreaCursoEnum.TECNOLOGICA2, false),
        Arguments.of(450, 450, 450, 450, 500, AreaCursoEnum.BIOMEDICA, true),
        Arguments.of(450, 450, 450, 449.9, 500, AreaCursoEnum.TECNOLOGICA1, false),
        Arguments.of(450.0, 450.0, 450.0, 450.0, 500.0, AreaCursoEnum.HUMANISTICA1, true));
  }

}
