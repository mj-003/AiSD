import java.util.Iterator;
import java.util.ListIterator;
import java.util.function.Function;

public class OneWayCycledList<E> extends OneWayLinkedList<E>{
    Node head = null;
    Node tail = null;

    @Override
    public Node getHead() {
        return head;
    }

    @Override
    public Node getTail() {
        return tail;
    }

    private Node findPrev(Node node) {
        if (node == head) {
            return null;
        }
        Node current = head.getNext();
        Node prev = head;
        while (current != null) {
            if (current == node) {
                return prev;
            }
            prev = current;
            current = current.getNext();
        }
        return null; // nie znaleziono poprzednika
    }

    @Override
    public Node searchWithKey(Object key, Function<E, ?> keyFunction) {     // ? - dowolny podtyp Object
        Node currNode = head;
        while (currNode != tail) {
            Object thisKey = keyFunction.apply(currNode.getValue());
            if (key.equals(thisKey)) {
                return currNode;
            }
            currNode = currNode.getNext();
        }
        Object thisKey = keyFunction.apply(currNode.getValue());
        if (key.equals(thisKey)) {
            return currNode;
        }
        return null;
    }

    public boolean addBefore(E value, Object key, Function<E, ?> keyFunction) {
        Node searchNode = searchWithKey(key, keyFunction);
        Node newNode = new Node(value);
        if(searchNode != null) {
            if(searchNode == head) {
                newNode.setNext(head);
                head = newNode;
                return true;
            }
            Node prevNode = findPrev(searchNode);
            prevNode.insertAfter(newNode);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove (Object key, Function<E, ?> keyFunction) {
        Node nodeToRemove = searchWithKey(key, keyFunction);
        if (nodeToRemove == head) {
            head = head.getNext();
            return true;
        }
        if (nodeToRemove != null) {
            Node prevNode = findPrev(nodeToRemove);
            prevNode.setNext(nodeToRemove.getNext());
            return true;
        }
        return false;
    }

    public void addEnd(E value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        tail.setNext(head);
    }

    // dodawanie elementu na początek struktury
    public void addBeg(E value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.setNext(head);
        }
        else {
            newNode.setNext(head);
            head = newNode;
            tail.setNext(head);
        }
    }

    @Override
    public boolean addAfter(E value, Object key, Function<E, ?> keyFunction) {
        Node node = searchWithKey(key, keyFunction);
        Node newNode = new Node(value);
        if (node != null) {
            if(node.getNext() == head) {
                newNode.setNext(head);
                tail = newNode;
                newNode.setNext(head);
            }
            node.insertAfter(newNode);
            return true;
        }
        return false;
    }
    public <K extends Comparable<? super K>> void bubbleSortByKey(Function<E, K> keyFunction) {
        if (head == null) {   // pusta lista
            return;
        }

        boolean toSwap;
        do {
            toSwap = false;
            Node currNode = head;
            while (currNode.getNext() != head) {
                if (keyFunction.apply(currNode.getValue()).compareTo(keyFunction.apply(currNode.getNext().getValue())) > 0) {
                    E temp = currNode.getValue();
                    currNode.setValue(currNode.getNext().getValue());
                    currNode.getNext().setValue(temp);
                    toSwap = true;
                }
                currNode = currNode.getNext();
            }
        } while (toSwap);
    }


    private class InnerIterator implements Iterator<E> {
        Node currNode;
        boolean isFirst;

        public InnerIterator() {
            this.currNode = head;
            this.isFirst = true;
        }

        @Override
        public boolean hasNext() {
            if(isFirst) {
                return currNode != null;
            }
            else return currNode != head;
        }


        @Override
        public E next() {
            E value = currNode.getValue();
            currNode = currNode.getNext();
            isFirst = false;
            return value;
        }

    }

    @Override
    public Iterator<E> iterator() {
        return new InnerIterator();
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

}