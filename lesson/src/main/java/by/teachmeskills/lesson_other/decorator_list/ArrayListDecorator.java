package by.teachmeskills.lesson_other.decorator_list;

import java.util.*;
import java.util.function.UnaryOperator;

public class ArrayListDecorator<T> extends ArrayList<T> {
    private List<T> listOfElements;
    private Map<Integer, T> listOfRemovedElements;

    public ArrayListDecorator(List<T> listOfElements) {
        this.listOfElements = listOfElements;
        listOfRemovedElements = new TreeMap();
    }

    public List<T> getListOfElements() {
        return listOfElements;
    }

    public Map<Integer, T> getListOfRemovedElements() {
        return listOfRemovedElements;
    }

    public List<T> restoreRemovedElementsBackToList() {
        for (Map.Entry<Integer, T> entry : listOfRemovedElements.entrySet()) {
            if (entry.getKey() >= listOfElements.size()) {
                for (int i = listOfElements.size(); i < entry.getKey() - 1; i++) {
                    listOfElements.add(i, null);
                }
            }
            listOfElements.add(entry.getKey(), entry.getValue());
        }
        return listOfElements;
    }

    public void cleanListOfRemovedElements() {
        listOfRemovedElements.clear();
    }

    @Override
    public boolean add(T t) {
        super.add(t);
        return listOfElements.add(t);
    }

    @Override
    public void add(int index, T element) {
        listOfElements.add(index, element);
    }

    @Override
    public boolean remove(Object o) {
        int indexOfRemovedElement = listOfElements.indexOf(o);
        if (indexOfRemovedElement != -1) {
            listOfRemovedElements.put(indexOfRemovedElement, (T) o);
        }
        return listOfElements.remove(o);
    }


    @Override
    public T remove(int index) {
        listOfRemovedElements.put(index, listOfElements.get(index));
        return listOfElements.remove(index);
    }

    @Override
    public T set(int index, T element) {
        return listOfElements.set(index, element);
    }

    @Override
    public void clear() {
        listOfElements.clear();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return listOfElements.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return listOfElements.addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (int i = listOfElements.size() - 1; i >= 0; i--) {
            for (Object element : c) {
                if (null != listOfElements.get(i) && listOfElements.get(i).equals(element)) {
                    listOfRemovedElements.put(i, listOfElements.get(i));
                }
            }
        }
        return listOfElements.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        for (int i = listOfElements.size() - 1; i >= 0; i--) {
            for (Object element : c) {
                if (null != listOfElements.get(i) && !listOfElements.get(i).equals(element)) {
                    listOfRemovedElements.put(i, listOfElements.get(i));
                }
            }
        }
        return listOfElements.retainAll(c);
    }

    @Override
    public void replaceAll(UnaryOperator<T> operator) {
        listOfElements.replaceAll(operator);
    }

    @Override
    public void sort(Comparator<? super T> c) {
        listOfElements.sort(c);
    }
}
