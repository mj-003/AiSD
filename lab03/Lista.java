import java.util.Objects;

public class Lista<E> {
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

    Element sentinel = null;

    public Lista() {
        sentinel = new Element(null);
        sentinel.setNext(sentinel);
        sentinel.setPrev(sentinel);
    }

    private Element getElement(int index) {
        if(index == -1) return sentinel;
        Element element = sentinel.getNext();
        int count = 0;
        while (element != null && count < index){
            element = element.getNext();
            count++;
        }
        return element;
    }

    private Element getElement(E value) {
        Element element = sentinel.getNext();
        while(element != sentinel && !value.equals(element.getValue())){
            element = element.getNext();
        }
        if(element == sentinel)
            return null;
        return element;
    }

    public boolean add(E value) {
        Element newElement = new Element(value);
        // System.out.println(newElement.getValue());
        sentinel.insertBefore(newElement); // lista cyklizczna - prev sentinela to ostatni el
        return true;
    }

    public boolean add(int index, E value) {
        if(index < 0) {
            return false;
        }
        Element newElement = new Element(value);
        if(index == 0) {
            sentinel.insertAfter(newElement);
        }
        else {
            Element actElement = getElement(index - 1);
            actElement.insertAfter(newElement);
        }
        return true;
    }

    public void clear() {
        sentinel.setNext(null);
    }

    public int indexOf(E value) {
        Element element = sentinel.getNext();
        int count = 0;
        while (element != null && !element.getValue().equals(value)) {
            count++;
            element = element.getNext();
        }
        if(element == null) {
            return -1;
        }
        return count;
    }

    public boolean contains(E value) {
        return indexOf(value) != -1;
    }

    public E get(int index) {
        Element element = getElement(index);
        return element.getValue();
    }

    public E set(int index, E value) {
        Element element = getElement(index);
        E retValue = element.getValue();
        element.setValue(value);
        return retValue;
    }

    public boolean isEmpty() {
        return sentinel.getNext() == sentinel;
    }

    public E remove(int index) {
        if(index >= 0) {
            Element element = getElement(index);
            element.remove();
            return element.getValue();
        }
        else return null;
    }


    public int size() {
        int count = 0;
        Element element = sentinel.getNext();
        while (element != null) {
            count++;
            element = element.getNext();
        }
        return count;
    }

    public void wypisz() {
        Element e = sentinel.getNext();
        while (e != null) {
            System.out.print(e.getValue() + " ");
            e = e.getNext();
        }
    }


    // zadania laby
    public boolean remove(E value){
        Element element = getElement(value);
        if(element == null) {
            return false;
        }
        element.remove();
        return true;

    }

    public void wypiszOdPrzodu() {
        Element e = sentinel.getNext();
        while (e != sentinel) {
            System.out.print(e.getValue() + " ");
            e = e.getNext();
        }
    }

    public void wypiszOdTylu() {
        Element e = sentinel.getPrev();
        while (e != sentinel) {
            System.out.print(e.getValue() + " ");
            e = e.getPrev();
        }
    }


}
