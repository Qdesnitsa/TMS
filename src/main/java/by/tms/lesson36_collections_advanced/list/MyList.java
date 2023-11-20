package by.tms.lesson36_collections_advanced.list;

public interface MyList<E> {
    MyIterator<E> iterator();
    void add(E element);
    E remove(int index);
    E get(int index);
    boolean isEmpty();
    int size();
}
