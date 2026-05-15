package app;

import java.util.HashMap;
import java.util.Scanner;

public class Cadastrar {

    private HashMap<String, Perfil> pessoas;
    private Scanner entrada = new Scanner(System.in);
    private IdadePessoas idades;

    public Cadastrar(HashMap<String, Perfil> pessoas, IdadePessoas idades) {
        this.pessoas = pessoas;
        this.idades = idades;
    }

    public void cadastrarPessoas() {
        System.out.print("Nome: ");
        String nome = entrada.nextLine();

        System.out.print("Idade: ");
        int idade = entrada.nextInt();
        idades.append(idade);
        entrada.nextLine();

        System.out.print("Cidade: ");
        String cidade = entrada.nextLine();

        System.out.print("Email: ");
        String email = entrada.nextLine();

        System.out.print("Telefone: ");
        String telefone = entrada.nextLine();

        System.out.print("Endereço: ");
        String endereco = entrada.nextLine();

        System.out.println("\n===== CADASTRO REALIZADO =====");
        System.out.println("Nome:     " + nome);
        System.out.println("Idade:    " + idade + " anos");
        System.out.println("Cidade:   " + cidade);
        System.out.println("Email:    " + email);
        System.out.println("Telefone: " + telefone);
        System.out.println("Endereço: " + endereco);
        System.out.println("==============================");

        pessoas.put(nome, new Perfil(idade, cidade, email, telefone, endereco));
    }
}
