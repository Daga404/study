public class buscar {
    public void buscar() {
        System.out.print("Qual nome deseja procurar?");
        String buscar = entrada.nextLine();

        if (pessoas.containsKey(buscar)) {
            System.out.println("\n===== LISTA =====");
            System.out.println("Nome: " + buscar);
            System.out.println("IDADE:" + pessoas.get(buscar).idade());
            System.out.println("CIDADE:" + pessoas.get(buscar).cidade());
            System.out.println("==============================");
        } else {
            System.out.println("Não Cadastrado ");
        }
    }

}
