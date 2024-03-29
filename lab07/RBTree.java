import java.util.Comparator;

public class RBTree<T> implements Tree<T> {
    private static final boolean RED = false;
    private static final boolean BLACK = true;

    private class Node {
        T value;
        Node parent;
        Node left;
        Node right;
        boolean color;

        Node(T value) {
            this.value = value;
            this.color = RED;
        }

        void toString(StringBuilder prefix, boolean isTail, StringBuilder sb) {
            if (right != null) {
                right.toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, sb);
            }
            sb.append(prefix).append(isTail ? "└── " : "┌── ").append(value.toString()).append(color == RED ? " (R)" : " (B)").append("\n");
            if (left != null) {
                left.toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb);
            }
        }
    }

    private final Comparator<? super T> comparator;
    private Node root;

    public RBTree(Comparator<? super T> comparator) {
        this.comparator = comparator;
        root = null;
    }

    public void insert(T elem) {
        Node node = new Node(elem);
        if (root == null) {
            node.color = BLACK;
            root = node;
        } else {
            Node current = root;
            Node parent = null;
            while (current != null) {
                parent = current;
                if (comparator.compare(elem, current.value) < 0) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }
            node.parent = parent;
            if (comparator.compare(elem, parent.value) < 0) {
                parent.left = node;
            } else {
                parent.right = node;
            }
            fixRedRed(node);
        }
    }

    private void fixRedRed(Node node) {
        while (node != root && node.parent.color == RED) {
            if (node.parent == node.parent.parent.left) {
                Node uncle = node.parent.parent.right;
                if (uncle != null && uncle.color == RED) {
                    node.parent.color = BLACK;
                    uncle.color = BLACK;
                    node.parent.parent.color = RED;
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.right) {
                        node = node.parent;
                        rotateLeft(node);
                    }
                    node.parent.color = BLACK;
                    node.parent.parent.color = RED;
                    rotateRight(node.parent.parent);
                }
            } else {
                Node uncle = node.parent.parent.left;
                if (uncle != null && uncle.color == RED) {
                    node.parent.color = BLACK;
                    uncle.color = BLACK;
                    node.parent.parent.color = RED;
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.left) {
                        node = node.parent;
                        rotateRight(node);
                    }
                    node.parent.color = BLACK;
                    node.parent.parent.color = RED;
                    rotateLeft(node.parent.parent);
                }
            }
        }
        root.color = BLACK;
    }

    private void rotateLeft(Node node) {
        Node rightChild = node.right;
        node.right = rightChild.left;
        if (rightChild.left != null) {
            rightChild.left.parent = node;
        }
        rightChild.parent = node.parent;
        if (node.parent == null) {
            root = rightChild;
        } else if (node == node.parent.left) {
            node.parent.left = rightChild;
        } else {
            node.parent.right = rightChild;
        }
        rightChild.left = node;
        node.parent = rightChild;
    }

    private void rotateRight(Node node) {
        Node leftChild = node.left;
        node.left = leftChild.right;
        if (leftChild.right != null) {
            leftChild.right.parent = node;
        }
        leftChild.parent = node.parent;
        if (node.parent == null) {
            root = leftChild;
        } else if (node == node.parent.right) {
            node.parent.right = leftChild;
        } else {
            node.parent.left = leftChild;
        }
        leftChild.right = node;
        node.parent = leftChild;
    }

    public void delete(T elem) {
        Node node = findNode(elem);
        if (node == null) {
            return; // Element not found, nothing to delete
        }

        Node successor;
        if (node.left != null && node.right != null) {
            successor = getSuccessor(node);
            node.value = successor.value;
            node = successor;
        }

        Node child = node.left != null ? node.left : node.right;
        boolean isBlack = (node.color == BLACK);
        replaceNode(node, child);

        if (root == null) {
            return;
        }

        if (isBlack) {
            if (child != null && child.color == RED) {
                child.color = BLACK;
            } else {
                fixDoubleBlack(child);
            }
        }
    }

    private void replaceNode(Node node, Node child) {
        if (node.parent == null) {
            root = child;
        } else if (node == node.parent.left) {
            node.parent.left = child;
        } else {
            node.parent.right = child;
        }

        if (child != null) {
            child.parent = node.parent;
        }
    }

    private Node findNode(T elem) {
        Node current = root;
        while (current != null) {
            int comp = comparator.compare(elem, current.value);
            if (comp == 0) {
                return current;
            } else if (comp < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    private Node getSuccessor(Node node) {
        Node current = node.right;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    private void fixDoubleBlack(Node node) {
        while (node != root && isBlack(node) && node != null) {
            if (node == node.parent.left) {
                Node sibling = node.parent.right;
                if (isRed(sibling)) {
                    sibling.color = BLACK;
                    node.parent.color = RED;
                    rotateLeft(node.parent);
                    sibling = node.parent.right;
                }
                if (isBlack(sibling.left) && isBlack(sibling.right)) {
                    sibling.color = RED;
                    node = node.parent;
                } else {
                    if (isBlack(sibling.right)) {
                        sibling.left.color = BLACK;
                        sibling.color = RED;
                        rotateRight(sibling);
                        sibling = node.parent.right;
                    }
                    sibling.color = node.parent.color;
                    node.parent.color = BLACK;
                    sibling.right.color = BLACK;
                    rotateLeft(node.parent);
                    node = root;
                }
            } else {
                Node sibling = node.parent.left;
                if (isRed(sibling)) {
                    sibling.color = BLACK;
                    node.parent.color = RED;
                    rotateRight(node.parent);
                    sibling = node.parent.left;
                }
                if (isBlack(sibling.right) && isBlack(sibling.left)) {
                    sibling.color = RED;
                    node = node.parent;
                } else {
                    if (isBlack(sibling.left)) {
                        sibling.right.color = BLACK;
                        sibling.color = RED;
                        rotateLeft(sibling);
                        sibling = node.parent.left;
                    }
                    sibling.color = node.parent.color;
                    node.parent.color = BLACK;
                    sibling.left.color = BLACK;
                    rotateRight(node.parent);
                    node = root;
                }
            }
        }
        if (node != null) {
            node.color = BLACK;
        }
    }

    public boolean search(T element) {
        Node node = searchHelper(element);
        return node != null;
    }

    private Node searchHelper(T element) {
        Node node = root;
        int comp;
        while (node != null && (comp = comparator.compare(element, node.value)) != 0) {
            node = comp < 0 ? node.left : node.right;
        }
        return node;
    }

    private boolean isRed(Node node) {
        return node != null && node.color == RED;
    }

    private boolean isBlack(Node node) {
        return node == null || node.color == BLACK;
    }

    public String toString() {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        root.toString(new StringBuilder(), true, sb);
        return sb.toString();
    }
}
