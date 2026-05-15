package app;

import java.util.HashMap;
import java.util.Scanner;

public class Deletar {

    private HashMap<String, Perfil> pessoas;
    private Scanner entrada;

    public Deletar(HashMap<String, Perfil> pessoas, Scanner entrada) {
        this.pessoas = pessoas;
        this.entrada = entrada;
    }

    public void deletarPessoas() {
        System.out.print("Nome para deletar: ");
        String remover = entrada.nextLine();

        if (pessoas.remove(remover) != null) {
            System.out.println("Pessoa removida.");
        } else {
            System.out.println("Pessoa nao encontrada.");
        }
    }
}
