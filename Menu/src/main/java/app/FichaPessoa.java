package app;

import java.util.HashMap;
import java.util.Scanner;

class FichaPessoa {

    private HashMap<String, Perfil> pessoas;
    private Scanner entrada = new Scanner(System.in);

    public FichaPessoa(HashMap<String, Perfil> pessoas) {
        this.pessoas = pessoas;
    }

    public void editarContato() {

        System.out.print("Deseja o cadrastro: ");
        String cadastro = entrada.nextLine();

        if (pessoas.containsKey(cadastro)) {

        } else {


        }



    }
}
