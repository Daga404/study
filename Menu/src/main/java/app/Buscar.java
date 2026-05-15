package app;

import java.util.HashMap;
import java.util.Scanner;

public class Buscar {

    private HashMap<String, Perfil> pessoas;
    private Scanner entrada = new Scanner(System.in);

    public Buscar(HashMap<String, Perfil> pessoas) {
        this.pessoas = pessoas;
    }

    public void buscarPessoas() {
        System.out.print("Nome para buscar: ");
        String buscar = entrada.nextLine();

        if (pessoas.containsKey(buscar)) {
            Perfil perfil = pessoas.get(buscar);

            System.out.println("\n===== PESSOA ENCONTRADA =====");
            System.out.println("Nome:     " + buscar);
            System.out.println("Idade:    " + perfil.idade() + " anos");
            System.out.println("Cidade:   " + perfil.cidade());
            System.out.println("Email:    " + perfil.email());
            System.out.println("Telefone: " + perfil.telefone());
            System.out.println("Endereço: " + perfil.endereco());
            System.out.println("==============================");
        } else {
            System.out.println("Pessoa não cadastrada.");
        }
    }
}
