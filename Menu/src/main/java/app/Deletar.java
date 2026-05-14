package app;

import java.util.HashMap;
import java.util.Scanner;

public class Deletar {

    private HashMap<String, perfil> pessoas;
    private Scanner entrada = new Scanner(System.in);

    public Deletar(HashMap<String, perfil> pessoas) {
        this.pessoas = pessoas;
    }

    public void deletarPessoas() {

        System.out.print("Digite o nome que deseja excluir:");
        String remover = entrada.nextLine();
        pessoas.remove(remover);

    }

}