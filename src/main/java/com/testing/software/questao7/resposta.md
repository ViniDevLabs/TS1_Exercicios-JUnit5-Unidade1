### a) Qual é a diferença entre o uso de assertThrows() e @Test (expected=...) utilizados no JUnit5 e JUnit4 respectivamente?

Ao utilizar o @Test (expected=...), qualquer linha do método pode lançar a exceção, e não somente a da operação desejada, além de não poder acessar o objeto da exceção. Já com o assertThrows, define-se exatamente qual o bloco de código que deve lançar a exceção, além de poder verificar o conteúdo do objeto da exceção.

### b) Como eles podem ser utilizados para testar exceções em métodos de uma classe? Explique usando exemplos.

Tomando como exemplo o código a seguir:

```java
public class Nota {
  public void setNota(double nota) throws IllegalArgumentException {
    if (nota < 0) {
      throw new IllegalArgumentException("Idade não pode ser negativa");
    }
    .
    .
    .
  }
}
```

Para utilizar o @Test (expected=...), uma maneira é assim:

```java
public class NotaTest {

  @Test(expected = IllegalArgumentException.class)
  public void shouldThrowExceptionIfNotaNegativa(double nota) {
    Nota n = new Nota();
    n.setNota(-1);
  }
}
```

Enquanto o uso do assertThrows, capturando o objeto da exceção, pode ser assim:

```java
public class NotaTest {

  @Test
  public void shouldThrowExceptionIfNotaNegativa(double nota) {
    Nota n = new Nota();

    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      n.setNota(-1);
    });

    assertEquals("Idade não pode ser negativa", exception.getMessage());
  }
}
```

### c) Quais são os principais benefícios de utilizar testes unitários com JUnit em um projeto de software? Além disso, explique como esses testes podem ajudar a garantir a qualidade do código e a facilitar a manutenção do sistema.

Os testes unitários permitem, dentre outras coisas:

- Detecção precoce de erros, por verificarem métodos individuais de forma isolada, antes que sejam integrados com outras partes de um sistema;
- Facilitar refatorações, pois os testes irão falhar se alguma lógica de negócio ou do programa não estiverem implementadas corretamente;
- Verificar se as regras de negócio que se aplicam a métodos individuais estão corretamente implementadas;
- Melhora o design do código, por forçar o desenvolvedor a escrever métodos mais claros e com responsabilidades bem definidas (a fim de serem testados);
- Junto à artefatos de documentação externos, podem servir como uma documentação do que se espera de cada parte do sistema, se mantendo atualizada junto do código.
