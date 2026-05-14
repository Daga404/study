package app;

class idadePessoas {
    Node head;
    Node tail;

    public Node getByIndex(int index) {
        Node aux = head;
        if (head == null) {
            return null;
        }

        int contador = 0;
        while (aux.next != null && contador < index) {
            aux = aux.next;
            contador++;
        }
        return aux;
    }
}
