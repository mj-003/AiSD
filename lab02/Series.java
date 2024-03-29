import java.util.Iterator;

public class Series<E> implements Iterable<E> {     // interfejs iterable umozliwia iterowanie foreach
    private final SeriesGenerator<E> generator;     // sposob generowania wartosci ciagu
    int maks;

    public Series(SeriesGenerator<E> generator, int maks) {
        this.generator = generator;
        this.maks = maks;
    }

    @Override
    public Iterator<E> iterator() {
        return new SeriesIterator<>(generator, maks);
    }
}
