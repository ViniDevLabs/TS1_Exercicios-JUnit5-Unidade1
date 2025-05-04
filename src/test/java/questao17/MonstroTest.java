package questao17;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import com.testing.software.questao17.Monstro;
import com.testing.software.questao17.MorteException;

class MonstroTest {

  @Test
  void testReceberGolpe() {
    Monstro monstro = new Monstro(100);

    monstro.receberGolpe(99);
    assertEquals(1, monstro.getVida());

    assertThrows(MorteException.class, () -> {
      monstro.receberGolpe(1);
    });
  }
}
