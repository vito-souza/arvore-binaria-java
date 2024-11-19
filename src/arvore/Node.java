package arvore;

public class Node {
    /** Valor inserido dentro do nó */
    private int value;

    /** Nó inserido à esquerda */
    private Node left;

    /** Nó inserido à direita */
    private Node right;

    // Construtor
    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
