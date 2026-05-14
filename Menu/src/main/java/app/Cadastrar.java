package app;

import java.util.HashMap;
import java.util.Scanner;

public class Cadastrar {

    private HashMap<String, perfil> pessoas;
    private Scanner entrada = new Scanner(System.in);
    private IdadePessoas idades;

    public Cadastrar(HashMap<String, perfil> pessoas, IdadePessoas idades) {
        this.pessoas = pessoas;
        this.idades = idades;
    }

    public void cadastrarPessoas() {
        System.out.print("DIGITE SEU NOME:");
        String nome = entrada.nextLine();

        System.out.print("Sua idade:");
        int idade = entrada.nextInt();
        idades.append(idade);
        entrada.nextLine();

        System.out.print("Qual é a sua cidade: ");
        String cidade = entrada.nextLine();

        System.out.println("\n===== CADASTRO REALIZADO =====");
        System.out.println("Nome:   " + nome);
        System.out.println("Idade:  " + idade + " anos");
        System.out.println("Cidade: " + cidade);
        System.out.println("==============================");

        pessoas.put(nome, new perfil(idade, cidade));
    }
}
