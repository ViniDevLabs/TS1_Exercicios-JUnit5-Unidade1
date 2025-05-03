No Código a seguir, porque o camando "buffRead.close()" está no bloco do finally? O que aconteceria se ele estivesse fora do bloco try/catch?

```java
static void readFile(String path, Charset encoding) throws IOException {
  BufferedReader buffRead = new BufferedReader(new FileReader(path));
  try {
    String linha = "";
    while (true) {
      if (linha != null) {
        System.out.println(linha);
      } else {
        break;
      }
      linha = buffRead.readLine();
    }
  } catch (IOException ex) {
    System.out.println("Erro de entrada e saída");
    throw ex;
  } catch (Throwable ex) {
    throw ex;
  } finally {
    buffRead.close();
  }
}
```

Resposta: É importante garantir que o buffer de leitura de um arquivo seja fechado quando ele não estiver mais sendo utilizado, independente de ocorrerem exceções ou não. O comando buffRead.close() no bloco finally garante que ele será executado no final do fluxo, mesmo diante de situações adversas. Caso ele não estivesse no bloco try/catch/finally, uma exceção poderia causar uma saída do método antes de chegar nele, podendo causar vazamento de recurso, no qual o arquivo permanece aberto pelo BufferedReader.
