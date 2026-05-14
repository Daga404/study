# Anotações Java do projeto

## `new`

`new` cria um objeto novo.

Exemplo:

```java
Main menu = new Main();
```

Isso significa:

- cria um objeto da classe `Main`
- guarda esse objeto na variável `menu`

Use `new` quando você precisa criar um objeto real a partir de uma classe.

Exemplos do projeto:

```java
new Main()
new Buscar(menu.pessoas)
new Cadastrar(menu.pessoas, menu.idades)
new Scanner(System.in)
new HashMap<>()
new perfil(idade, cidade)
new Node()
```

Não use `new` quando você só quer chamar um método de um objeto que já existe.

---

## Classe

Classe é o molde.

Exemplo:

```java
class Lista {
}
```

A classe define o que um objeto pode ter e fazer.

Analogia:

- classe = forma de bolo
- objeto = bolo pronto

---

## Objeto

Objeto é uma coisa criada a partir de uma classe.

Exemplo:

```java
Lista lista = new Lista(menu.pessoas);
```

Aqui `lista` é um objeto da classe `Lista`.

---

## Construtor

Construtor prepara o objeto quando ele nasce.

Exemplo:

```java
public Lista(HashMap<String, perfil> pessoas) {
    this.pessoas = pessoas;
}
```

Regras:

- tem o mesmo nome da classe
- não tem `void`
- não tem tipo de retorno
- roda quando usamos `new`

Use construtor quando o objeto precisa nascer já com alguma informação.

Exemplo do projeto:

```java
Lista lista = new Lista(menu.pessoas);
```

A `Lista` precisa do `HashMap` para saber quais pessoas listar.

---

## Atributo

Atributo guarda algo que o objeto precisa lembrar.

Exemplo:

```java
private HashMap<String, perfil> pessoas;
```

Esse atributo guarda o `HashMap` dentro da classe.

Use atributo quando a classe vai precisar daquela informação em vários métodos.

---

## Variável local

Variável local existe só dentro de um método.

Exemplo:

```java
String cidade = entrada.nextLine();
```

Essa variável `cidade` só existe dentro do método onde foi criada.

Use variável local quando o valor só é necessário naquela ação.

---

## `this`

`this` aponta para o atributo do objeto.

Exemplo:

```java
this.pessoas = pessoas;
```

Significa:

- `this.pessoas`: atributo da classe
- `pessoas`: parâmetro que chegou no construtor

Use `this` quando o atributo e o parâmetro têm o mesmo nome.

---

## `static`

O `main` precisa ser `static` porque o Java precisa começar o programa sem criar um objeto antes.

Exemplo:

```java
public static void main(String[] args) {
}
```

Mas o resto do projeto não precisa virar `static`.

Ideia simples:

- `main` é a porta de entrada do programa
- as outras classes podem ser objetos normais

---

## `HashMap`

`HashMap` guarda pares de chave e valor.

No projeto:

```java
HashMap<String, perfil> pessoas
```

Significa:

- chave: `String`, o nome da pessoa
- valor: `perfil`, que guarda idade e cidade

Exemplo mental:

```text
"Carol" -> perfil(20, "São Paulo")
```

O `HashMap` principal não deve ser recriado em cada método.

Ele deve nascer uma vez no `Main` e ser compartilhado com as outras classes.

---

## `record perfil`

O `record` guarda dados de forma simples.

No projeto:

```java
public record perfil(int idade, String cidade) {
}
```

Ele guarda:

- idade
- cidade

O nome da pessoa fica como chave no `HashMap`.

---

## `Scanner`

`Scanner` lê entrada do usuário.

Exemplo:

```java
Scanner entrada = new Scanner(System.in);
```

`System.in` significa entrada pelo teclado.

Declarar `Scanner` não basta.

Errado:

```java
private Scanner entrada;
```

Assim ele existe como variável, mas ainda não tem um Scanner real.

Certo:

```java
private Scanner entrada = new Scanner(System.in);
```

---

## `nextInt()`

`nextInt()` lê um número inteiro.

Exemplo:

```java
int idade = entrada.nextInt();
```

Se o usuário digitar `20`, a variável `idade` recebe `20`.

Cuidado: `nextInt()` não limpa o Enter.

---

## `nextLine()`

`nextLine()` lê uma linha inteira.

Também usamos depois do `nextInt()` para limpar o Enter que sobra.

Exemplo:

```java
int idade = entrada.nextInt();
entrada.nextLine();
```

Ordem:

1. pega o número
2. limpa o Enter

---

## `hasNextInt()`

`hasNextInt()` verifica se o próximo valor digitado é um número inteiro.

Exemplo:

```java
if (entrada.hasNextInt()) {
    int numero = entrada.nextInt();
}
```

Use para evitar erro quando o usuário digita texto no lugar de número.

---

## `return`

`return` devolve um valor para quem chamou o método.

Exemplo:

```java
return opcao;
```

Se o método começa com `int`, ele promete devolver um número.

Exemplo:

```java
int pegarInputInt() {
    return opcao;
}
```

Se o método é `void`, ele não devolve nada.

---

## `void`

`void` significa que o método não devolve valor.

Exemplo:

```java
public void listaPessoas() {
}
```

Esse método só executa uma ação, como imprimir no terminal.

---

## `for`

`for` repete um bloco de código.

No projeto:

```java
for (String pessoa : pessoas.keySet()) {
}
```

Significa:

- para cada nome dentro do `HashMap`
- execute o bloco

`pessoas.keySet()` pega todas as chaves do `HashMap`.

No seu caso, as chaves são os nomes das pessoas.

---

## `pessoas.get(pessoa)`

Pega o `perfil` de uma pessoa dentro do `HashMap`.

Exemplo:

```java
pessoas.get(pessoa).idade()
```

Significa:

- pegue o perfil da pessoa
- depois pegue a idade desse perfil

---

## `Node`

`Node` é uma caixinha da lista.

No projeto:

```java
class Node {
    int idade;
    Node next;
}
```

Ele guarda:

- uma idade
- o caminho para o próximo `Node`

Analogia:

`Node` é um vagão.

---

## `IdadePessoas`

`IdadePessoas` é a lista inteira.

Ela controla:

- `head`: primeiro nó
- `tail`: último nó
- `append`: adiciona idade no final
- `getByIndex`: busca pela posição

Analogia:

- `Node` = vagão
- `IdadePessoas` = trem inteiro

---

## `package`

`package` precisa combinar com a pasta.

Se o arquivo está em:

```text
src/main/java/app
```

O começo do arquivo deve ser:

```java
package app;
```

---

## Ideia das classes do projeto

### `Main`

Mostra o menu e controla o fluxo.

### `Cadastrar`

Cadastra uma pessoa.

### `Buscar`

Busca uma pessoa no `HashMap`.

### `Lista`

Lista todas as pessoas cadastradas.

### `deletar`

Remove uma pessoa.

### `perfil`

Guarda idade e cidade.

### `Node`

Guarda uma idade e aponta para o próximo nó.

### `IdadePessoas`

Controla a lista manual de idades.

