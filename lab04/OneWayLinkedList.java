import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class OneWayLinkedList<E> implements IList<E> {

    class Node {
        E value;
        Node next;
        public Node(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void insertAfter(Node node) {
            node.setNext(this.getNext());
            this.setNext(node);
        }

    }

    Node head = null;
    Node tail = null;

    public Node getTail() {
        return tail;
    }

    private Node findPrev(Node node) {
        if(getHead() == getTail()) return null;
        Node currNode = getHead();

        while (currNode.getNext() != null && currNode.getNext() != node) {
            currNode = currNode.getNext();
        }
        return currNode;
    }




    public Node getHead() {
        return head;
    }

    @Override
    public boolean isEmpty() {
        return getHead() == null;
    }

    @Override
    public Node searchWithKey(Object key, Function<E, ?> keyFunction) {
        Node currNode = getHead();
        while (currNode != getTail()) {
            Object thisKey = keyFunction.apply(currNode.getValue());
            if (key.equals(thisKey)) {
                return currNode;
            }
            currNode = currNode.getNext();
        }
        return null;
    }



    @Override
    public boolean remove(Object key, Function<E, ?> keyFunction) {
        if (head == null) {
            return false;
        }
        Node nodeToRemove = searchWithKey(key, keyFunction);
        if (nodeToRemove != null) {
            if(nodeToRemove == getHead()) {
                head = getHead().getNext();
                return true;
            }
            Node currNode = getHead();
            while (currNode.getNext() != getTail() && currNode.getNext().getValue() != nodeToRemove.getValue()) {
                currNode = currNode.getNext();
            }
            if(currNode.getNext() == null) {
                return false;
            }
            currNode.setNext(currNode.getNext().getNext());
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public void addEnd(E value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;

        } else {
            Node lastNode = getHead();
            while (lastNode.getNext() != getTail()) {
                lastNode = lastNode.getNext();
            }
            lastNode.setNext(newNode);
            tail = newNode;
        }
    }

    @Override
    public void addBeg(E value) {
        Node newNode = new Node(value);
        if(getHead() == getTail()) {
            tail = newNode;
        }
        newNode.setNext(head);
        head = newNode;
    }

    @Override
    public boolean addBefore(E value, Object key, Function<E, ?> keyFunction) {
        Node searchNode = searchWithKey(key, keyFunction);
        if (head != tail && findPrev(searchNode) != null) {
            Node prevNode = findPrev(searchNode);
            prevNode.insertAfter(new Node(value));
            return true;
        }
        return false;
    }

    @Override
    public boolean addAfter(E value, Object key, Function<E, ?> keyFunction) {
        Node searchNode = searchWithKey(key, keyFunction);
        Node newNode = new Node(value);
        if (searchNode != null) {
            if (searchNode.getValue() != null) {
                if(searchNode == head) {
                    tail = newNode;
                }
                searchNode.insertAfter(newNode);
                return true;
            }
        }
        return false;
    }

    public <K extends Comparable<? super K>> void bubbleSortByKey(Function<E, K> keyFunction) {
        if (head == null) {   // pusta lista
            return;
        }

        boolean toSwap = true;
        while (toSwap) {
            toSwap = false;
            Node currNode = head;
            while (currNode.getNext() != null) {
                if (keyFunction.apply(currNode.getValue()).compareTo(keyFunction.apply(currNode.getNext().getValue())) > 0) {
                    E temp = currNode.getValue();
                    currNode.setValue(currNode.getNext().getValue());
                    currNode.getNext().setValue(temp);
                    toSwap = true;
                }
                currNode = currNode.getNext();
            }
        }
    }


    private class InnerIterator implements Iterator<E> {
        private Node current;

        public InnerIterator() {
            this.current = head;
        }

        public boolean hasNext() {
            return current != null;
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E value = current.getValue();
            current = current.getNext();
            return value;
        }
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<E> iterator() {
        return new InnerIterator();
    }
}
