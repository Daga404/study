package app;

import java.util.HashMap;
import java.util.Scanner;

public class Cadastrar {

    private HashMap<String, Perfil> pessoas;
    private Scanner entrada;
    private IdadePessoas idades;

    public Cadastrar(HashMap<String, Perfil> pessoas, IdadePessoas idades, Scanner entrada) {
        this.pessoas = pessoas;
        this.idades = idades;
        this.entrada = entrada;
    }

    public void cadastrarPessoas() {
        System.out.print("Nome: ");
        String nome = entrada.nextLine();

        if (pessoas.containsKey(nome)) {
            System.out.println("Pessoa ja cadastrada.");
            return;
        }

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

        System.out.print("Endereco: ");
        String endereco = entrada.nextLine();

        Perfil perfil = new Perfil(idade, cidade, email, telefone, endereco, "");
        pessoas.put(nome, perfil);

        System.out.println("\n===== CADASTRO REALIZADO =====");
        imprimirPessoa(nome, perfil);
        System.out.println("==============================");
    }

    private void imprimirPessoa(String nome, Perfil perfil) {
        System.out.println("Nome:       " + nome);
        System.out.println("Idade:      " + perfil.idade() + " anos");
        System.out.println("Cidade:     " + perfil.cidade());
        System.out.println("Email:      " + perfil.email());
        System.out.println("Telefone:   " + perfil.telefone());
        System.out.println("Endereco:   " + perfil.endereco());
        System.out.println("Observacao: " + perfil.observacao());
    }
}
