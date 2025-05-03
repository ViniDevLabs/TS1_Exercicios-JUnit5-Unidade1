package questao11;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.testing.software.questao11.CalculaMediaPonderada;

@RunWith(Parameterized.class)
public class CalculaMediaPonderadaTest {

  private final List<Double> valores;
  private final List<Integer> pesos;
  private final double expected;

  public CalculaMediaPonderadaTest(List<Double> valores, List<Integer> pesos, double expected) {
    this.valores = valores;
    this.pesos = pesos;
    this.expected = expected;
  }

  @Parameterized.Parameters
  public static Collection<Object[]> casosValidos() {
    return Arrays.asList(new Object[][] {
        { Arrays.asList(7.0, 8.0, 9.0), Arrays.asList(2, 3, 5), 8.3 },
        { Arrays.asList(10.0, 5.0), Arrays.asList(1, 1), 7.5 },
        { Arrays.asList(6.0, 9.0), Arrays.asList(1, 3), 8.25 },
        { Arrays.asList(10.0), Arrays.asList(1), 10.0 },
    });
  }

  @Test
  public void testCalculaMediaPonderada() throws Exception {
    double resultado = CalculaMediaPonderada.calculaMediaPonderada(valores, pesos);
    assertEquals(expected, resultado, 0.01);
  }

  @Test(expected = Exception.class)
  public void testListasInvalidas() throws Exception {
    CalculaMediaPonderada.calculaMediaPonderada(Arrays.asList(10.0), Arrays.asList());
  }
}
