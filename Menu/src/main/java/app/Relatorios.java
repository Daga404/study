package app;

import java.util.HashMap;
import java.util.Scanner;

class Relatorios {

    private HashMap<String, Perfil> pessoas;
    private Scanner entrada;

    public Relatorios(HashMap<String, Perfil> pessoas, Scanner entrada) {
        this.pessoas = pessoas;
        this.entrada = entrada;
    }

    public void relatorioPessoa() {
        System.out.print("Nome para gerar relatorio: ");
        String nome = entrada.nextLine();

        if (!pessoas.containsKey(nome)) {
            System.out.println("Pessoa nao cadastrada.");
            return;
        }

        Perfil perfil = pessoas.get(nome);

        System.out.println("\n===== RELATORIO DA PESSOA =====");
        System.out.println("Nome:       " + nome);
        System.out.println("Idade:      " + perfil.idade() + " anos");
        System.out.println("Cidade:     " + perfil.cidade());
        System.out.println("Email:      " + perfil.email());
        System.out.println("Telefone:   " + perfil.telefone());
        System.out.println("Endereco:   " + perfil.endereco());
        System.out.println("Observacao: " + perfil.observacao());
        System.out.println("===============================");
    }

    public void relatorioGeral() {
        if (pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
            return;
        }

        int total = pessoas.size();
        int somaIdades = 0;
        int maiorIdade = Integer.MIN_VALUE;
        int menorIdade = Integer.MAX_VALUE;

        for (Perfil perfil : pessoas.values()) {
            int idade = perfil.idade();
            somaIdades += idade;

            if (idade > maiorIdade) {
                maiorIdade = idade;
            }

            if (idade < menorIdade) {
                menorIdade = idade;
            }
        }

        double media = (double) somaIdades / total;

        System.out.println("\n===== RELATORIO GERAL =====");
        System.out.println("Total de pessoas: " + total);
        System.out.println("Maior idade:      " + maiorIdade);
        System.out.println("Menor idade:      " + menorIdade);
        System.out.printf("Media das idades: %.2f%n", media);
        System.out.println("===========================");
    }
}
