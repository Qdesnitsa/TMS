package by.tms.lesson36_collections_advanced.list;

public interface MyIterator<E> {
    boolean hasNext();
    E next();
    void remove();
}
