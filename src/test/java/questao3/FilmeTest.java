package questao3;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.testing.software.questao3.Filme;
import com.testing.software.questao3.FilmeNaoValidoException;

class FilmeTest {

  @Test
  void shouldCreateFilme() {
    assertDoesNotThrow(() -> {
      Filme filme = new Filme("A", 100, "B");
      assertEquals("A", filme.getTitulo());
      assertEquals(100, filme.getDuracaoMin());
      assertEquals("B", filme.getDiretor());
    });
  }

  @Test
  void shouldThrowException_WhenCreateFilmeParamsAreInvalid() {
    assertThrows(FilmeNaoValidoException.class, () -> {
      new Filme("", 100, "B");
    });
    assertThrows(FilmeNaoValidoException.class, () -> {
      new Filme("A", 0, "B");
    });
    assertThrows(FilmeNaoValidoException.class, () -> {
      new Filme("A", 100, "");
    });
  }

  @Test
  void shouldReturnFilmeWithMenorDuracao_WhenComparingDifferentDuracao() {
    assertDoesNotThrow(() -> {
      Filme filme1 = new Filme("A", 100, "B");
      Filme filme2 = new Filme("C", 200, "D");
      String resultado = filme1.getFilmeMenorDuracao(filme2);
      assertEquals("A", resultado);
    });
  }

  @Test
  void shouldThrowException_WhenFilmeDuracaoIsEqual() {
    assertThrows(FilmeNaoValidoException.class, () -> {
      Filme filme1 = new Filme("A", 100, "B");
      Filme filme2 = new Filme("C", 100, "D");
      filme1.getFilmeMenorDuracao(filme2);
    });
  }

  @Test
  void shouldGetMesmoDiretor() {
    assertDoesNotThrow(() -> {
      Filme filme1 = new Filme("A", 100, "B");
      Filme filme2 = new Filme("C", 200, "B");
      Filme filme3 = new Filme("E", 150, "C");
      boolean resultado1 = filme1.isMesmoDiretor(filme2);
      boolean resultado2 = filme1.isMesmoDiretor(filme3);
      assertTrue(resultado1);
      assertFalse(resultado2);
    });
  }

  @Test
  void shouldThrowException_WhenGetMesmoDiretorFromEqualFilme() {
    assertThrows(FilmeNaoValidoException.class, () -> {
      Filme filme1 = new Filme("A", 100, "B");
      Filme filme2 = new Filme("A", 100, "B");
      filme1.isMesmoDiretor(filme2);
    });
  }
}
