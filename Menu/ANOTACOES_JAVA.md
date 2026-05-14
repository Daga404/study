# Anotacoes Java do projeto

Este arquivo e um resumo simples dos conceitos que apareceram no CRUD.

## Ideia geral do projeto

O projeto tem um menu no terminal.

O `Main` mostra as opcoes e chama outras classes:

- `Cadastrar`: cadastra pessoas.
- `Buscar`: procura pessoas.
- `Lista`: mostra pessoas cadastradas.
- `Deletar`: remove pessoas.
- `perfil`: guarda idade e cidade.
- `Node`: representa um item da lista de idades.
- `IdadePessoas`: controla a lista manual de idades.

---

## `new`

`new` cria um objeto novo.

Exemplo:

```java
Main menu = new Main();
```

Leia assim:

```text
Crie um objeto da classe Main e guarde na variavel menu.
```

Outro exemplo:

```java
Buscar buscar = new Buscar(menu.pessoas);
```

Leia assim:

```text
Crie um objeto Buscar e entregue para ele o HashMap pessoas.
```

Use `new` quando voce precisa criar um objeto.

Nao use `new` para chamar metodo de objeto que ja existe.

Exemplo:

```java
buscar.buscarPessoas();
```

Aqui nao precisa de `new`, porque `buscar` ja existe.

---

## Classe

Classe e o molde.

Exemplo:

```java
class Lista {
}
```

A classe diz o que um objeto daquele tipo pode ter e fazer.

Analogia:

```text
classe = forma de bolo
objeto = bolo pronto
```

---

## Objeto

Objeto e algo criado a partir de uma classe.

Exemplo:

```java
Lista lista = new Lista(menu.pessoas);
```

Aqui:

- `Lista` e a classe.
- `lista` e o objeto.
- `new Lista(...)` cria o objeto.

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
- nao tem `void`
- nao tem tipo de retorno
- roda quando usamos `new`

Exemplo de uso:

```java
Lista lista = new Lista(menu.pessoas);
```

O construtor recebe `menu.pessoas` e guarda dentro da classe `Lista`.

---

## Atributo

Atributo e uma informacao que o objeto precisa lembrar.

Exemplo:

```java
private HashMap<String, perfil> pessoas;
```

Esse atributo guarda o `HashMap` dentro da classe.

Use atributo quando a classe vai precisar daquele valor em varios metodos.

---

## Variavel local

Variavel local existe so dentro do metodo.

Exemplo:

```java
String cidade = entrada.nextLine();
```

Essa variavel so existe dentro daquele metodo.

Use variavel local quando o valor so serve para aquela acao.

---

## `this`

`this` aponta para o atributo do objeto.

Exemplo:

```java
this.pessoas = pessoas;
```

Leia assim:

```text
Pegue o parametro pessoas e guarde no atributo pessoas.
```

Diferença:

- `this.pessoas`: atributo da classe.
- `pessoas`: parametro recebido no construtor.

---

## `static`

O `main` precisa ser `static`.

Exemplo:

```java
public static void main(String[] args) {
}
```

Motivo:

```text
O Java precisa de um ponto inicial para comecar o programa.
```

Mas isso nao significa que tudo precisa ser `static`.

No seu projeto, o resto pode ser objeto normal:

```java
Main menu = new Main();
Buscar buscar = new Buscar(menu.pessoas);
```

---

## `HashMap`

`HashMap` guarda pares de chave e valor.

No seu projeto:

```java
HashMap<String, perfil> pessoas = new HashMap<>();
```

Leia assim:

```text
Um mapa onde a chave e um texto e o valor e um perfil.
```

No seu caso:

- chave: nome da pessoa
- valor: perfil com idade e cidade

Exemplo mental:

```text
"Ana" -> perfil(20, "Santos")
"Joao" -> perfil(31, "Curitiba")
```

### `put`

`put` adiciona ou atualiza um valor no `HashMap`.

Exemplo:

```java
pessoas.put(nome, new perfil(idade, cidade));
```

Leia assim:

```text
Guarde no mapa pessoas:
chave = nome
valor = perfil com idade e cidade
```

### `get`

`get` pega um valor pela chave.

Exemplo:

```java
pessoas.get(nome)
```

Se `nome` for `"Ana"`, ele busca o perfil da Ana.

### `containsKey`

`containsKey` verifica se a chave existe.

Exemplo:

```java
if (pessoas.containsKey(buscar)) {
}
```

Leia assim:

```text
Se o mapa pessoas contem esse nome, faca alguma coisa.
```

### `remove`

`remove` apaga um item pela chave.

Exemplo:

```java
pessoas.remove(remover);
```

Leia assim:

```text
Remova do mapa a pessoa com esse nome.
```

### `keySet`

`keySet` pega todas as chaves.

Exemplo:

```java
for (String pessoa : pessoas.keySet()) {
}
```

No seu projeto, as chaves sao os nomes.

### Regra importante

O `HashMap` principal nao deve ser criado de novo em cada classe.

Melhor:

```text
Main cria o HashMap uma vez.
As outras classes recebem esse mesmo HashMap.
```

Assim `Cadastrar`, `Buscar`, `Lista` e `Deletar` olham para os mesmos dados.

---

## `record perfil`

`perfil` e a ficha da pessoa.

```java
public record perfil(int idade, String cidade) {
}
```

Ele guarda:

- idade
- cidade

O nome nao fica no `perfil`.
O nome fica como chave no `HashMap`.

---

## `Scanner`

`Scanner` le dados digitados pelo usuario.

Exemplo:

```java
Scanner entrada = new Scanner(System.in);
```

`System.in` representa o teclado.

Declarar nao basta:

```java
private Scanner entrada;
```

Isso so cria o espaco da variavel.

Para usar `nextLine()` ou `nextInt()`, precisa ter um Scanner real:

```java
private Scanner entrada = new Scanner(System.in);
```

---

## `nextLine`

`nextLine()` le uma linha de texto.

Exemplo:

```java
String nome = entrada.nextLine();
```

Use para ler nome, cidade e textos em geral.

---

## `nextInt`

`nextInt()` le um numero inteiro.

Exemplo:

```java
int idade = entrada.nextInt();
```

Cuidado:

```text
nextInt pega o numero, mas deixa o Enter sobrando.
```

Por isso normalmente fazemos:

```java
int idade = entrada.nextInt();
entrada.nextLine();
```

---

## `hasNextInt`

`hasNextInt()` pergunta se o proximo valor e um numero inteiro.

Exemplo:

```java
if (entrada.hasNextInt()) {
    int opcao = entrada.nextInt();
}
```

Use para evitar erro quando a pessoa digita letra no menu.

---

## `return`

`return` devolve um valor para quem chamou o metodo.

Exemplo:

```java
return opcao;
```

Se o metodo promete devolver `int`, ele precisa retornar um numero.

Exemplo:

```java
int pegarInputInt() {
    return opcao;
}
```

---

## `void`

`void` significa que o metodo nao devolve nada.

Exemplo:

```java
public void listaPessoas() {
}
```

Esse metodo apenas executa uma acao.

---

## `for`

`for` repete um bloco.

No projeto:

```java
for (String pessoa : pessoas.keySet()) {
    System.out.println("Nome: " + pessoa);
}
```

Leia assim:

```text
Para cada nome dentro do HashMap pessoas, imprima o nome.
```

---

## `Node`

`Node` e uma caixinha da lista manual.

```java
class Node {
    int idade;
    Node next;
}
```

Ele guarda:

- uma idade
- o caminho para o proximo item

Analogia:

```text
Node = um vagao
```

---

## `IdadePessoas`

`IdadePessoas` controla a lista de idades.

Ela usa:

- `head`: primeiro item
- `tail`: ultimo item
- `append`: adiciona no final
- `getByIndex`: busca por posicao

Analogia:

```text
Node = vagao
IdadePessoas = trem inteiro
```

---

## Como pensar nas classes

### `Main`

Mostra o menu e chama as outras classes.

### `Cadastrar`

Le dados do usuario e salva no `HashMap`.

### `Buscar`

Procura uma pessoa no `HashMap`.

### `Lista`

Mostra todas as pessoas do `HashMap`.

### `Deletar`

Remove uma pessoa do `HashMap`.

### `perfil`

Guarda idade e cidade.

### `Node`

Guarda uma idade na lista manual.

### `IdadePessoas`

Controla a lista manual de idades.

