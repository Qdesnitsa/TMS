package by.tms.lesson36_collections_advanced.list;

import java.util.*;

public class DoublyLinkedList<E> implements MyList<E> {
    private transient int modificationCount = 0;
    private transient int size = 0;
    private transient Node<E> first;
    private transient Node<E> last;

    public DoublyLinkedList() {
    }

    private static class Node<E> {

        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public void add(E element) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, element, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        modificationCount++;
    }

    @Override
    public E remove(int index) {
        Node<E> x;
//Tells if the argument is the index of an existing element.
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        } else {
//Returns the (non-null) Node at the specified element index.
            if (index < (size >> 1)) {
                x = first;
                for (int i = 0; i < index; i++)
                    x = x.next;

            } else {
                x = last;
                for (int i = size - 1; i > index; i--)
                    x = x.prev;
            }
//Unlinks non-null node x.
            final E element = x.item;
            final Node<E> next = x.next;
            final Node<E> prev = x.prev;

            if (prev == null) {
                first = next;
            } else {
                prev.next = next;
                x.prev = null;
            }

            if (next == null) {
                last = prev;
            } else {
                next.prev = prev;
                x.next = null;
            }

            x.item = null;
            size--;
            modificationCount++;
            return element;
        }
    }

    @Override
    public E get(int index) {
//Tells if the argument is the index of an existing element.
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        } else {
//Returns the (non-null) Node at the specified element index.
            if (index < (size >> 1)) {
                Node<E> x = first;
                for (int i = 0; i < index; i++)
                    x = x.next;
                return x.item;
            } else {
                Node<E> x = last;
                for (int i = size - 1; i > index; i--)
                    x = x.prev;
                return x.item;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private class MySuperIterator implements MyIterator<E> {
        private Node<E> lastReturned;
        private Node<E> next;
        private int nextIndex;
        private int expectedModCount = modificationCount;

        public MySuperIterator(int index) {
            if (index == size) {
                next = null;
            } else {
                if (index < (size >> 1)) {
                    Node<E> x = first;
                    for (int i = 0; i < index; i++)
                        x = x.next;
                    next = x;
                } else {
                    Node<E> x = last;
                    for (int i = size - 1; i > index; i--)
                        x = x.prev;
                    next = x;
                }
            }
            nextIndex = index;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public E next() {
            if (modificationCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.item;
        }

        @Override
        public void remove() {
            if (modificationCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (lastReturned == null) {
                throw new IllegalStateException();
            }
            Node<E> lastNext = lastReturned.next;

//Unlinks non-null node x.
            final E element = lastReturned.item;
            final Node<E> next = lastReturned.next;
            final Node<E> prev = lastReturned.prev;

            if (prev == null) {
                first = next;
            } else {
                prev.next = next;
                lastReturned.prev = null;
            }

            if (next == null) {
                last = prev;
            } else {
                next.prev = prev;
                lastReturned.next = null;
            }

            lastReturned.item = null;
            size--;
            modificationCount++;
//?????????WTF
            if (this.next == lastReturned) {
                this.next = lastNext;
            } else {
                nextIndex--;
            }
            lastReturned = null;
            expectedModCount++;
        }
    }

    @Override
    public MyIterator<E> iterator() {
        return new MySuperIterator(0);
    }
}
