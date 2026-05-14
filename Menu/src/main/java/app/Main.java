package app;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public HashMap<String, perfil> pessoas = new HashMap<>();
    public Scanner entrada = new Scanner(System.in);
    public IdadePessoas idades = new IdadePessoas();

    public static void main(String[] args) {
        Main menu = new Main();
        Buscar buscar = new Buscar(menu.pessoas);
        Cadastrar cadastrar = new Cadastrar(menu.pessoas, menu.idades);
        Lista lista = new Lista(menu.pessoas);
        Deletar deletar = new Deletar(menu.pessoas);

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("1. Cadastrar");
            System.out.println("2. Lista");
            System.out.println("3. Buscar");
            System.out.println("4. Deletar");
            System.out.println("5. Mostrar última pessoa cadastrada");
            System.out.println("6. Mostrar primeira pessoa cadastrada");
            System.out.println("7. Buscar idade por posição");
            System.out.println("8. Remover última idade cadastrada");
            System.out.println("9. Mostrar todas as idades em ordem");
            System.out.println("10. Contar quantas idades existem");
            System.out.println("11. Verificar se uma idade existe");
            System.out.println("12. Mostrar maior idade");
            System.out.println("13. Mostrar menor idade");
            System.out.println("14. Mostrar média das idades");
            System.out.println("15. Mostrar estrutura da lista");
            System.out.println("0. Sair");

            opcao = menu.pegarInputInt();

            switch (opcao) {
                case 1:
                    cadastrar.cadastrarPessoas();
                    break;

                case 2:
                    lista.listaPessoas();
                    break;

                case 3:
                    buscar.buscarPessoas();
                    break;

                case 4:
                    deletar.deletarPessoas();
                    break;

                case 0:
                    break;
            }
        }
    }

    int pegarInputInt() {
        int opcao = -1;

        if (entrada.hasNextInt()) {
            opcao = entrada.nextInt();
            entrada.nextLine();

            return opcao;
        }

        entrada.nextLine();
        return opcao;
    }
}
