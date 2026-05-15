package app;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public HashMap<String, Perfil> pessoas = new HashMap<>();
    public Scanner entrada = new Scanner(System.in);
    public IdadePessoas idades = new IdadePessoas();

    public static void main(String[] args) {
        Main menu = new Main();
        Buscar buscar = new Buscar(menu.pessoas, menu.entrada);
        Cadastrar cadastrar = new Cadastrar(menu.pessoas, menu.idades, menu.entrada);
        Lista lista = new Lista(menu.pessoas);
        Deletar deletar = new Deletar(menu.pessoas, menu.entrada);
        FichaPessoa fichaPessoa = new FichaPessoa(menu.pessoas, menu.entrada);
        Relatorios relatorios = new Relatorios(menu.pessoas, menu.entrada);
        ArquivosCadastro arquivosCadastro = new ArquivosCadastro(menu.pessoas);

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
                    fichaPessoa.verFichaCompleta();
                    break;

                case 6:
                    fichaPessoa.editarContato();
                    break;

                case 7:
                    fichaPessoa.adicionarObservacao();
                    break;

                case 8:
                    buscar.buscarPorTelefone();
                    break;

                case 9:
                    buscar.buscarPorEmail();
                    break;

                case 10:
                    buscar.filtrarPorCidade();
                    break;

                case 11:
                    relatorios.relatorioPessoa();
                    break;

                case 12:
                    relatorios.relatorioGeral();
                    break;

                case 13:
                    arquivosCadastro.exportarDados();
                    break;

                case 14:
                    arquivosCadastro.fazerBackup();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opcao invalida.");
                    break;
            }
        }
    }

    void mostrarMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1. Cadastrar pessoa");
        System.out.println("2. Listar pessoas");
        System.out.println("3. Buscar pessoa");
        System.out.println("4. Deletar pessoa");
        System.out.println("5. Ver ficha completa da pessoa");
        System.out.println("6. Editar dados de contato");
        System.out.println("7. Adicionar observacao ao cadastro");
        System.out.println("8. Buscar por telefone");
        System.out.println("9. Buscar por email");
        System.out.println("10. Filtrar pessoas por cidade");
        System.out.println("11. Gerar relatorio de uma pessoa");
        System.out.println("12. Gerar relatorio geral");
        System.out.println("13. Exportar dados");
        System.out.println("14. Fazer backup dos cadastros");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opcao: ");
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
