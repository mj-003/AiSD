import java.util.Iterator;
import java.util.ListIterator;
import java.util.function.Function;

public class TwoWayLinkedList<E> implements IList<E> {


    class Node {
        private E value;
        private Node next;
        private Node prev;
        public Node(E value) {
            this.value = value;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
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
            node.setPrev(this);
            if(node.getNext() != null) {
                node.getNext().setPrev(node);
            }
        }

        public void insertBefore(Node node) {
            node.setNext(this);
            node.setPrev(this.getPrev());
            this.getPrev().setNext(node);
            this.setPrev(node);

        }

        public void remove() {
            this.getNext().setPrev(this.getPrev());
            this.getPrev().setNext(this.getNext());

        }
    }

    Node sentinel;
    Node tail;

    public TwoWayLinkedList() {
        sentinel = new Node(null);
    }


    @Override
    public boolean isEmpty() {
        return sentinel.getNext() == null;
    }

    @Override
    public Node searchWithKey(Object key, Function<E, ?> keyFunction) {     // ? - dowolny podtyp Object
        Node currNode = sentinel.getNext();
        if (currNode.getValue() != null) {
            while (currNode != sentinel) {
                Object thisKey = keyFunction.apply(currNode.getValue());
                if (key.equals(thisKey)) {
                    return currNode;
                }
                currNode = currNode.getNext();
            }
        }
        return null;
    }


    @Override
    public boolean remove(Object key, Function<E, ?> keyFunction) {
        Node nodeRemove = searchWithKey(key, keyFunction);
        if (nodeRemove == null) {
            return false;
        }
        nodeRemove.remove();
        return true;
    }

    @Override
    public void clear() {
        sentinel.setNext(null);
    }

    @Override
    public void addEnd(E value) {
        Node newNode = new Node(value);
        if(sentinel.getNext() == null) {
            sentinel.insertAfter(newNode);
            tail = newNode;
        }
        else {
            tail.insertAfter(newNode);
        }
    }

    @Override
    public void addBeg(E value) {
        Node newNode = new Node(value);
        if(sentinel.getNext() == null) {
            tail = newNode;
        }
        sentinel.insertAfter(newNode);
    }

    @Override
    public boolean addBefore(E value, Object key, Function<E, ?> keyFunction) {
        Node node = searchWithKey(key, keyFunction);
        if (node.getPrev() != null) {
            node.getPrev().insertAfter(new Node(value));
            return true;
        }
        return false;
    }

    @Override
    public boolean addAfter(E value, Object key, Function<E, ?> keyFunction) {
        Node node = searchWithKey(key, keyFunction);
        Node newNode = new Node(value);
        if(node != null) {
            if(node == tail) {
                tail = newNode;
            }
            node.insertAfter(newNode);
            return true;
        }
        return false;
    }

    public <K extends Comparable<? super K>> void bubbleSortByKey(Function<E, K> keyFunction) {
        if (sentinel.getNext() == null) {   // pusta lista
            return;
        }

        boolean toSwap = true;
        while (toSwap) {
            toSwap = false;
            Node currNode = sentinel.getNext();
            while (currNode.getNext() != null) {
                if (keyFunction.apply(currNode.getValue()).compareTo(keyFunction.apply(currNode.getNext().getValue())) > 0){
                    E temp = currNode.getValue();
                    currNode.setValue(currNode.getNext().getValue());
                    currNode.getNext().setValue(temp);
                    toSwap = true;
                    toSwap = true;
                }
                currNode = currNode.getNext();
            }
        }

    }

    private class InnerIteratorList implements ListIterator<E> {
        boolean wasNext = false;
        boolean wasPrevious = false;
        Node currNode = sentinel;


        @Override
        public boolean hasNext() {
            return currNode.getNext() != null;
        }


        @Override
        public E next() {
            wasNext = true;
            wasPrevious = false;
            currNode = currNode.getNext();
            return currNode.getValue();
        }

        @Override
        public boolean hasPrevious() {
            return currNode != sentinel;
        }

        @Override
        public E previous() {
            wasNext = false;
            wasPrevious = true;
            E retValue = currNode.getValue();
            currNode = currNode.getPrev();
            return retValue;
        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(E e) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(E e) {
            throw new UnsupportedOperationException();
        }
    }


    private class InnerIterator implements Iterator<E>{

        Node currNode = sentinel;

        @Override
        public boolean hasNext() {
            return currNode.getNext() != sentinel;
        }

        @Override
        public E next() {
            currNode = currNode.getNext();
            return currNode.getValue();
        }

    }

    @Override
    public Iterator<E> iterator() {
        return new InnerIterator();
    }

    @Override
    public ListIterator<E> listIterator() {
        return new InnerIteratorList();
    }
}
