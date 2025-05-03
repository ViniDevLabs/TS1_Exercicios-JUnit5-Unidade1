Considere a classe Java abaixo:

```java
public class Prova {
  static int vetor(int n, int vet[]) {
    int val;
    val = vet[0];
    for (int j = 1; j < n; j += 1) {
      if (val < vet[j]) {
        val = vet[j];
      }
    }
    return val;
  }
}
```

Para a classe Prova, foi criada uma classe de teste utilizando o JUnit, contendo o método de teste abaixo:

```java
@Test
public void testVetor() {
  int[] vet = {89, 90, 84, 91};
  int r = Prova.vetor(vet.length, vet);
  I;
}
```

Para que o teste seja aprovado, a lacuna I deve ser corretamente preenchida com

A) assertTrue(91, r)</br>
B) assertValue(84, r)</br>
C) assertEquals(91, r)</br>
D) assertEquals(90, r, true)</br>
E) assertEquals(84, r)

Resposta: Alternativa C)

O método vetor da classe Prova basicamente percorre todo o vetor recebido e vai retornar o elemento de maior valor da lista.
