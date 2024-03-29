
import java.util.Iterator;
import java.util.ListIterator;
import java.util.function.Function;

public interface IList<E> extends Iterable<E> {
    boolean	isEmpty();
    Object searchWithKey(Object key, Function<E, ?> keyFunction);
    boolean	remove(Object key, Function<E, ?> keyFunction);
    void clear();
    void addEnd(E value);
    void addBeg(E value);
    boolean addBefore(E value, Object key, Function<E, ?> keyFunction);
    boolean addAfter(E value, Object key, Function<E, ?> keyFunction);
    <K extends Comparable<? super K>> void bubbleSortByKey(Function<E, K> keyFunction);
    Iterator<E> iterator();
    ListIterator<E> listIterator();
}
