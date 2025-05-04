Considere as seguintes afirmativas a respeito do framework JUnit e marque V ou F para cada uma delas.

(V) I. Até a versão 3.8.1 do JUnit, todas as classes de testes precisavam herdar da classe TestCase do framework JUnit.

(F) II. A partir da versão 4 do JUnit, para se construir uma classe de teste, precisa-se apenas associar a anotação @Test à declaração de qualquer classe pública.

(V) III. Com a anotação @Test(timeout= ), é possível definir o tempo de duração do teste em milissegundos. Se a execução ultrapassar o tempo definido, o teste irá acusar a falha.

(F) IV. Para que um determinado objeto seja compartilhado entre vários métodos de testes JUnit, deve-se colocar a inicialização do objeto no construtor da classe.

Sobre as afirmativas:

II - A anotação @Test deve ser aplicada aos métodos, não à classe. </br>
IV - Para inicializar um estado comum entre os testes, utiliza-se o @Before (JUnit 4) ou o @BeforeEach (JUnit 5), garantindo que cada teste tenha seu próprio ambiente isolado.
