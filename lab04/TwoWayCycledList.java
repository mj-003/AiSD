import java.util.Iterator;
import java.util.ListIterator;
import java.util.function.Function;

public class TwoWayCycledList<E> extends TwoWayLinkedList<E> {
    public TwoWayCycledList() {
        sentinel = new Node(null);
        sentinel.setNext(sentinel);
        sentinel.setPrev(sentinel);
    }

    public boolean isEmpty() {
        return sentinel.getNext() == sentinel;
    }

    public void clear() {
        sentinel.setNext(sentinel);
        sentinel.setPrev(sentinel);
    }

    public void addEnd(E value) {
        sentinel.insertBefore(new Node(value));
    }

    public boolean addBefore(E value, Object key, Function<E, ?> functionKey) {
        Node node = searchWithKey(key, functionKey);
        if(node == null) {
            return false;
        }
        else {
            node.insertBefore(new Node(value));
            return true;
        }
    }

    public <K extends Comparable<? super K>> void bubbleSortByKey(Function<E, K> keyFunction) {
        if (sentinel.getNext() == sentinel) {   // pusta lista
            return;
        }

        boolean toSwap = true;
        while (toSwap) {
            toSwap = false;
            Node currNode = sentinel.getNext();
            while (currNode.getNext() != sentinel) {
                if (keyFunction.apply(currNode.getValue()).compareTo(keyFunction.apply(currNode.getNext().getValue())) > 0){
                    E temp = currNode.getValue();
                    currNode.setValue(currNode.getNext().getValue());
                    currNode.getNext().setValue(temp);
                    toSwap = true;
                }
                currNode = currNode.getNext();
            }
        }

    }

    private class InnerIteratorList implements ListIterator<E> {
        Node currNode = sentinel;
        Node head = sentinel.getNext();

        @Override
        public boolean hasNext() {
            return currNode.getNext() != sentinel;
        }

        @Override
        public E next() {
            currNode = currNode.getNext();
            return currNode.getValue();
        }

        @Override
        public boolean hasPrevious() {
            if(currNode.getPrev().getPrev() == head) {
                return true;
            }
            return currNode.getPrev() != sentinel;
        }

        @Override
        public E previous() {
            currNode = currNode.getPrev();
            return currNode.getValue();
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
