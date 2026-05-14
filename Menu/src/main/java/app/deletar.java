public void deletar() {
    System.out.print("Digite o nome que deseja excluir:");
    String buscar = entrada.nextLine();

    pessoas.remove(buscar);
}

int pegarInputInt() {
    if (entrada.hasNextInt()) {
        int numero = entrada.nextInt();
        entrada.nextLine();

        return numero;
    } else {
        entrada.nextLine();

        return -1;
    }
}
