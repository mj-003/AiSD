import java.util.Objects;

public class Lista2<E> {
    private class Element {
        E value;
        Element next;
        Element prev;

        public Element getPrev() {
            return prev;
        }

        public void setPrev(Element prev) {
            this.prev = prev;
        }

        public Element(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Element getNext() {
            return next;
        }

        public void setNext(Element next) {
            this.next = next;
        }

        public void insertAfter(Element element) {
            element.setNext(this.getNext());
            element.setPrev(this);
            this.getNext().setPrev(element);
            this.setNext(element);
        }

        public void insertBefore(Element element) {
            element.setNext(this);
            element.setPrev(this.getPrev());
            this.getPrev().setNext(element);
            this.setPrev(element);
        }

        public void remove() {
            this.getNext().setPrev(this.getPrev());
            this.getPrev().setNext(this.getNext());
        }


    }

    Element head = null;

    public Lista2() {
        this.head = null;

    }


}

