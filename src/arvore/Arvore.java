package arvore;

/** Árvore binária de pesquisa. */
public class Arvore {

    /** Nó raiz da árvore. */
    private Node root;

    /** Nó atual da lista. */
    private Node current;

    /**
     * Verifica se a árvore binária está vazia.
     * 
     * @return {@code true} se estiver vazia, caso contrário, {@code false}.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Insere um valor na árvore binária de pesquisa. Se a árvore estiver vazia,
     * cria um novo nó na raiz. Caso contrário, cria um novo nó e o insere na
     * posição correta com base na ordem binária.
     * 
     * @param value O valor a ser inserido na árvore.
     */
    public void insert(int value) {
        if (isEmpty()) {
            root = new Node(value, null, null); // Inserindo na raíz.
        } else {
            current = new Node(value, null, null); // Preenchendo o nó atual.
            insert(root); // Percorre toda a lista até encontrar uma posição para inserir o nó.
        }
    }

    /**
     * Insere o nó atual na árvore binária a partir do nó fornecido. Se o valor do
     * nó atual for menor, ele será inserido à esquerda; caso contrário, à direita.
     * A inserção ocorre recursivamente até encontrar uma posição disponível.
     * 
     * @param node O nó inicial para a inserção.
     */
    private void insert(Node node) {
        if (current.getValue() < node.getValue()) {
            if (node.getLeft() == null)
                node.setLeft(current); // Insere o nó atual à esquerda do nó utilizado para percorrer a árvore.
            else
                insert(node.getLeft()); // Continua a percorrer a esquerda da árvore.
        } else {
            if (node.getRight() == null)
                node.setRight(current); // Insere o nó atual à direita do nó utilizado para percorrer a árvore.
            else
                insert(node.getRight()); // Continua a percorrer a direita da árvore.
        }
    }

    /**
     * Percorre a árvore recursivamente, comparando o valor de cada nó com
     * o valor desejado. Se o valor for encontrado, retorna {@code true}. Caso
     * contrário, continua a busca na subárvore apropriada (à esquerda ou à
     * direita), ou retorna {@code false} se o valor não for encontrado.
     * 
     * @param node  O nó a partir do qual a busca será iniciada.
     * @param value O valor a ser buscado na árvore.
     * @return {@code true} se o valor for encontrado, {@code false} caso contrário.
     */
    public boolean search(Node node, int value) {
        if (node != null) {
            if (node.getValue() == value)
                return true; // Encontrou o nó.

            if (value > node.getValue()) // Está à direita da árvore.
                return search(node.getRight(), value); // Viaja até o nó à direita.

            if (value < node.getValue())
                return search(node.getLeft(), value); // Viaja até o nó à esquerda.
        }

        return false; // Não achou o nó.
    }

    /**
     * Realiza uma travessia pré-ordem (pré-fixado) na árvore binária. A
     * travessia pré-ordem visita primeiro o nó raiz, depois a subárvore esquerda,
     * e por último a subárvore direita.
     * 
     * @param node O nó atual da árvore a ser visitado.
     */
    public void preOrder(Node node) {
        System.out.println(node.getValue()); // Percorre o nó raiz.

        preOrder(node.getLeft()); // Percorre a subárvore à esquerda.

        preOrder(node.getRight()); // Percorre toda a subárvore à direita.
    }

    /**
     * Realiza uma travessia em ordem (central) na árvore binária. A travessia em
     * ordem visita primeiro a subárvore esquerda, depois o nó raiz, e por último a
     * subárvore direita.
     * 
     * @param node O nó atual da árvore a ser visitado.
     */
    public void order(Node node) {
        if (node != null) {
            order(node.getLeft()); // Percorre a subárvore à esquerda.

            System.out.println(node.getValue()); // Percorre o nó raiz.

            order(node.getRight()); // Percorre toda a subárvore à direita.
        }
    }

    /**
     * Realiza uma travessia em ordem (pós-fixado) na árvore binária. A
     * travessia em ordem visita primeiro a subárvore esquerda, depois o nó raiz,
     * e por último a subárvore direita.
     * 
     * @param node O nó atual da árvore a ser visitado.
     */
    public void postOrder(Node node) {
        postOrder(node.getLeft()); // Percorre a subárvore à esquerda.

        postOrder(node.getRight()); // Percorre toda a subárvore à direita.

        System.out.println(node.getValue()); // Percorre o nó raiz.
    }
}
