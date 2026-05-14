package app;

class Node {
    int idade;
    Node next;
}

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

    public Node get() {
        return tail;
    }

    public Node pop() {
        Node aux = head;
        Node removido = tail;

        while (aux.next != tail) {
            aux = aux.next;
        }
        tail = aux;
        aux.next = null;
        return removido;
    }

    public void remover() {
        Node aux = head;
        while (aux.next != tail) {
            aux = aux.next;
        }
        tail = aux;
        aux.next = null;
    }

    public void append(int idade) {
        Node newNode = new Node();
        newNode.idade = idade;

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }
}
