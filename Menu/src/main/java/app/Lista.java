package app;

import java.util.HashMap;

class Lista {

    private HashMap<String, Perfil> pessoas;

    public Lista(HashMap<String, Perfil> pessoas) {
        this.pessoas = pessoas;
    }

    public void listaPessoas() {
        for (String pessoa : pessoas.keySet()) {
            System.out.println("Nome: " + pessoa);
            System.out.println("Idade: " + pessoas.get(pessoa).idade());
            System.out.println("Cidade: " + pessoas.get(pessoa).cidade());
        }
    }
}
