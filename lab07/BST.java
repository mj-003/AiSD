import java.util.*;

class BST<T> implements Tree<T> {
    class Node {
        T value;
        Node left;
        Node right;

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public T getValue() {
            return value;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb) {
            if (right != null) {
                right.toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, sb);
            }
            sb.append(prefix).append(isTail ? "└── " : "┌── ").append(value.toString()).append("\n");
            if (left != null) {
                left.toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb);
            }
            return sb;
        }

    }

    private final Comparator<T> COMPARATOR;
    Node ROOT;
    public BST (Comparator<T> comp){
        COMPARATOR = comp;
        ROOT = null;
    }

    // ----- WYSZUKIWANIE ELEMENTU -----
    public boolean search(T element) {
        Node node = searchHelper(element);
        return node != null;
    }

    private Node searchHelper(T element) {
        Node node = ROOT;
        int comp;
        while (node != null && (comp = COMPARATOR.compare(element, node.value)) != 0) {
            node = comp < 0 ? node.left : node.right;
        }
        return node;
    }


    // ----- DODAWANIE ELEMENTU -----
    public void insert(T element) {
        ROOT = insertHelper (ROOT, element);
    }
    private Node insertHelper(Node node, T element) {
        if (node == null) {
            node = new Node(element);
        }
        else {
            int comp = COMPARATOR.compare(element, node.value);
            if (comp < 0)
                node.left = insertHelper(node.left, element);
            else if (comp > 0)
                node.right = insertHelper(node.right, element);
            else
                System.out.println("element: " + element.toString() + " jest juz w drzewie");
        }
        return node;
    }

    // ----- USUWANIE ELEMENTU -----
    public void delete(T element) {
        ROOT = deleteHelper(element, ROOT);
    }
    private Node deleteHelper(T element, Node node) {
        if (node == null) throw new NoSuchElementException();
        else {
        int comp = COMPARATOR.compare(element, node.value);
        if (comp < 0)
            node.left = deleteHelper(element, node.left);
        else if (comp > 0)
            node.right = deleteHelper(element, node.right);
        else if (node.left != null && node.right != null)
            node.right = detachMin(node, node.right);
        else node = (node.left != null) ? node.left : node.right;
    }
        return node; }
    private Node detachMin(Node del, Node node) {
        if (node.left != null)
            node.left = detachMin(del, node.left);
        else {
        del.value = node.value;
        node = node.right;
    }
        return node;
    }

    // ----- WYSWIETLENIE W KOLEJNOSCI -----
    public void printInOrder() {
        printInOrderHelper(ROOT);
    }
    private void printInOrderHelper(Node node) {
        if (node != null) {
            printInOrderHelper(node.getLeft());
            System.out.print(node.getValue() + " ");
            printInOrderHelper(node.getRight());
        }
    }

    public void printPreOrder() {
        printPreOrderHelper(ROOT);
    }
    private void printPreOrderHelper(Node node) {
        if (node != null) {
            System.out.print(node.getValue() + " ");
            printPreOrderHelper(node.getLeft());
            printPreOrderHelper(node.getRight());
        }
    }

    public void printPostOrder() {
        printPostOrderHelper(ROOT);
    }
    private void printPostOrderHelper(Node node) {
        if (node != null) {
            printPostOrderHelper(node.getLeft());
            printPostOrderHelper(node.getRight());
            System.out.print(node.getValue() + " ");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (ROOT != null) {
            ROOT.toString(new StringBuilder(), true, sb);
        }
        return sb.toString();
    }

    public void print(String prefix, Node n, boolean isLeft) {
        if (n != null) {
            print(prefix + "     ", n.right, false);
            System.out.println (prefix + ("|-- ") + n.value);
            print(prefix + "     ", n.left, true);
        }
    }






}