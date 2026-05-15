package app;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public HashMap<String, Perfil> pessoas = new HashMap<>();
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
            menu.mostrarMenu();
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

                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                    System.out.println("Funcionalidade ainda não implementada.");
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    void mostrarMenu() {
        System.out.println("1. Cadastrar pessoa");
        System.out.println("2. Listar pessoas");
        System.out.println("3. Buscar pessoa");
        System.out.println("4. Deletar pessoa");
        System.out.println("6. Editar dados de contato");
        System.out.println("7. Adicionar observação ao cadastro");
        System.out.println("8. Buscar por telefone");
        System.out.println("9. Buscar por email");
        System.out.println("10. Filtrar pessoas por cidade");
        System.out.println("11. Gerar relatório de uma pessoa");
        System.out.println("12. Gerar relatório geral");
        System.out.println("13. Exportar dados");
        System.out.println("14. Fazer backup dos cadastros");
        System.out.println("0. Sair");
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
