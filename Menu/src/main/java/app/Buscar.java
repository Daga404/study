package app;

import java.util.HashMap;
import java.util.Scanner;

public class Buscar {

    private HashMap<String, Perfil> pessoas;
    private Scanner entrada;

    public Buscar(HashMap<String, Perfil> pessoas, Scanner entrada) {
        this.pessoas = pessoas;
        this.entrada = entrada;
    }

    public void buscarPessoas() {
        System.out.print("Nome para buscar: ");
        String buscar = entrada.nextLine();

        if (pessoas.containsKey(buscar)) {
            imprimirPessoa(buscar, pessoas.get(buscar));
        } else {
            System.out.println("Pessoa nao cadastrada.");
        }
    }

    public void buscarPorTelefone() {
        System.out.print("Telefone para buscar: ");
        String telefone = entrada.nextLine();

        boolean encontrou = false;
        for (String nome : pessoas.keySet()) {
            Perfil perfil = pessoas.get(nome);
            if (perfil.telefone().equals(telefone)) {
                imprimirPessoa(nome, perfil);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhuma pessoa encontrada com esse telefone.");
        }
    }

    public void buscarPorEmail() {
        System.out.print("Email para buscar: ");
        String email = entrada.nextLine();

        boolean encontrou = false;
        for (String nome : pessoas.keySet()) {
            Perfil perfil = pessoas.get(nome);
            if (perfil.email().equalsIgnoreCase(email)) {
                imprimirPessoa(nome, perfil);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhuma pessoa encontrada com esse email.");
        }
    }

    public void filtrarPorCidade() {
        System.out.print("Cidade para filtrar: ");
        String cidade = entrada.nextLine();

        boolean encontrou = false;
        for (String nome : pessoas.keySet()) {
            Perfil perfil = pessoas.get(nome);
            if (perfil.cidade().equalsIgnoreCase(cidade)) {
                imprimirPessoa(nome, perfil);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhuma pessoa encontrada nessa cidade.");
        }
    }

    private void imprimirPessoa(String nome, Perfil perfil) {
        System.out.println("\n===== PESSOA ENCONTRADA =====");
        System.out.println("Nome:       " + nome);
        System.out.println("Idade:      " + perfil.idade() + " anos");
        System.out.println("Cidade:     " + perfil.cidade());
        System.out.println("Email:      " + perfil.email());
        System.out.println("Telefone:   " + perfil.telefone());
        System.out.println("Endereco:   " + perfil.endereco());
        System.out.println("Observacao: " + perfil.observacao());
        System.out.println("==============================");
    }
}
