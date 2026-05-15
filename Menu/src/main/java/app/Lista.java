package app;

import java.util.HashMap;

class Lista {

    private HashMap<String, Perfil> pessoas;

    public Lista(HashMap<String, Perfil> pessoas) {
        this.pessoas = pessoas;
    }

    public void listaPessoas() {
        if (pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
            return;
        }

        for (String pessoa : pessoas.keySet()) {
            Perfil perfil = pessoas.get(pessoa);

            System.out.println("\n===== PESSOA CADASTRADA =====");
            System.out.println("Nome:       " + pessoa);
            System.out.println("Idade:      " + perfil.idade() + " anos");
            System.out.println("Cidade:     " + perfil.cidade());
            System.out.println("Email:      " + perfil.email());
            System.out.println("Telefone:   " + perfil.telefone());
            System.out.println("Endereco:   " + perfil.endereco());
            System.out.println("Observacao: " + perfil.observacao());
            System.out.println("=============================");
        }
    }
}
