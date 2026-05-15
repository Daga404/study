package app;

import java.util.HashMap;
import java.util.Scanner;

class FichaPessoa {

    private HashMap<String, Perfil> pessoas;
    private Scanner entrada;

    public FichaPessoa(HashMap<String, Perfil> pessoas, Scanner entrada) {
        this.pessoas = pessoas;
        this.entrada = entrada;
    }

    public void verFichaCompleta() {
        System.out.print("Nome do cadastro: ");
        String nome = entrada.nextLine();

        if (pessoas.containsKey(nome)) {
            imprimirFicha(nome, pessoas.get(nome));
        } else {
            System.out.println("Pessoa nao cadastrada.");
        }
    }

    public void editarContato() {
        System.out.print("Nome do cadastro: ");
        String nome = entrada.nextLine();

        if (!pessoas.containsKey(nome)) {
            System.out.println("Pessoa nao cadastrada.");
            return;
        }

        Perfil perfilAtual = pessoas.get(nome);

        System.out.print("Novo email: ");
        String novoEmail = entrada.nextLine();

        System.out.print("Novo telefone: ");
        String novoTelefone = entrada.nextLine();

        Perfil perfilAtualizado = new Perfil(
                perfilAtual.idade(),
                perfilAtual.cidade(),
                novoEmail,
                novoTelefone,
                perfilAtual.endereco(),
                perfilAtual.observacao()
        );

        pessoas.put(nome, perfilAtualizado);
        System.out.println("Contato atualizado.");
    }

    public void adicionarObservacao() {
        System.out.print("Nome do cadastro: ");
        String nome = entrada.nextLine();

        if (!pessoas.containsKey(nome)) {
            System.out.println("Pessoa nao cadastrada.");
            return;
        }

        Perfil perfilAtual = pessoas.get(nome);

        System.out.print("Observacao: ");
        String observacao = entrada.nextLine();

        Perfil perfilAtualizado = new Perfil(
                perfilAtual.idade(),
                perfilAtual.cidade(),
                perfilAtual.email(),
                perfilAtual.telefone(),
                perfilAtual.endereco(),
                observacao
        );

        pessoas.put(nome, perfilAtualizado);
        System.out.println("Observacao adicionada.");
    }

    private void imprimirFicha(String nome, Perfil perfil) {
        System.out.println("\n===== FICHA COMPLETA =====");
        System.out.println("Nome:       " + nome);
        System.out.println("Idade:      " + perfil.idade() + " anos");
        System.out.println("Cidade:     " + perfil.cidade());
        System.out.println("Email:      " + perfil.email());
        System.out.println("Telefone:   " + perfil.telefone());
        System.out.println("Endereco:   " + perfil.endereco());
        System.out.println("Observacao: " + perfil.observacao());
        System.out.println("==========================");
    }
}
