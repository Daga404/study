package app;

import java.util.HashMap;
import java.util.Scanner;

public class Buscar {

    private HashMap<String, perfil> pessoas;
    private Scanner entrada = new Scanner(System.in);

    public Buscar(HashMap<String, perfil> pessoas) {
        this.pessoas = pessoas;
    }

    public void buscarPessoas() {
        System.out.print("Qual nome deseja procurar? ");
        String buscar = entrada.nextLine();

        if (pessoas.containsKey(buscar)) {
            System.out.println("\n===== PESSOA ENCONTRADA =====");
            System.out.println("Nome: " + buscar);
            System.out.println("IDADE: " + pessoas.get(buscar).idade());
            System.out.println("CIDADE: " + pessoas.get(buscar).cidade());
            System.out.println("==============================");
        } else {
            System.out.println("Não cadastrado");
        }
    }
}
