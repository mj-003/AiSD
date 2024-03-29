import java.util.Iterator;
import java.util.NoSuchElementException;

public class SeriesIterator<E> implements Iterator<E>, SeriesGenerator<E>{
    private SeriesGenerator<E> generator;
    private int indeks;
    int maks;

    public SeriesIterator(SeriesGenerator<E> generator, int maks) {
        this.generator = generator;
        this.indeks = 0;
        this.maks = maks;
    }

    @Override
    public boolean hasNext() {
        if(indeks < maks) {
            return true;
        }
        else return false;
    }

    @Override
    public E next() {
        if(hasNext()) {
            E aktualnyElement = generator.generate(indeks + 1);
            indeks++;
            return aktualnyElement;
        }
        else throw new NoSuchElementException();

    }

    @Override
    public E generate(int n) {
        return null;
    }

    public static void main(String[] args) {

        // podpunkt a

        System.out.println("Podpunkt a:");

        SeriesGenerator<Integer> seriesGenerator = n -> n*2;
        SeriesIterator<Integer> iterator = new SeriesIterator<>(seriesGenerator, 5);

        System.out.println("przyklad pierwszy:");
        for(int i = 0; i < 5; i++) {
            System.out.println(iterator.next());
        }

        int maks = 5;
        SeriesGenerator<String> seriesGenerator1 = n -> "a".repeat(n);
        SeriesIterator<String> iterator1 = new SeriesIterator<>(seriesGenerator1, maks);

        System.out.println("przyklad drugi:");
        for(int i = 0; i < maks; i++) {
            System.out.println(iterator1.next());
        }


        // podpunkt b

        System.out.println();
        System.out.println("Podpunkt b: ");

        Series<Integer> series = new Series<>(seriesGenerator, 5);

        System.out.println("przyklad pierwszy:");
        for(int liczba : series) {
            System.out.print(liczba + " ");
        }

        Series<String> series1 = new Series<>(seriesGenerator1, 5);
        System.out.println();
        System.out.println("przyklad drugi:");
        for(String slowo : series1) {
            System.out.print(slowo + " ");
        }
    }


}
