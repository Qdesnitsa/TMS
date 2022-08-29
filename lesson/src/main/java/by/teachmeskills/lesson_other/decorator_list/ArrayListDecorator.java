package by.teachmeskills.lesson_other.decorator_list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.UnaryOperator;

public class ArrayListDecorator<T> extends ArrayList<T> {
    private List<T> listOfElements;
    private List<T> listOfRemovedElements;

    public ArrayListDecorator(List<T> listOfElements) {
        this.listOfElements = listOfElements;
        listOfRemovedElements = new ArrayList<>();
    }

    public List<T> getListOfElements() {
        return listOfElements;
    }

    public List<T> getListOfRemovedElements() {
        return listOfRemovedElements;
    }

    public List<T> restoreRemovedElementsBackToList() {
        for (int i = 0; i < listOfRemovedElements.size(); i++) {
            if (listOfRemovedElements.get(i) != null) {
                listOfElements.set(i, listOfRemovedElements.get(i));
            }
        }
        return listOfElements;
    }

    public void cleanListOfRemovedElements() {
        for (int i = 0; i < listOfRemovedElements.size(); i++) {
            listOfRemovedElements.set(i, null);
        }
    }

    private List<T> fillListOfRemovedElements(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            listOfRemovedElements.add(i, null);
        }
        return listOfRemovedElements;
    }

    private List<T> checkListOfRemovedElementsIsNotEmpty() {
        return listOfRemovedElements = listOfRemovedElements.isEmpty()
                ? fillListOfRemovedElements(listOfElements)
                : listOfRemovedElements;
    }

    @Override
    public boolean add(T t) {
        listOfRemovedElements = checkListOfRemovedElementsIsNotEmpty();
        listOfRemovedElements.add(null);
        return listOfElements.add(t);
    }

    @Override
    public void add(int index, T element) {
        listOfRemovedElements = checkListOfRemovedElementsIsNotEmpty();
        listOfRemovedElements.add(index, null);
        listOfElements.add(index, element);
    }

    @Override
    public boolean remove(Object o) {
        listOfRemovedElements = checkListOfRemovedElementsIsNotEmpty();
        boolean isRemoved = false;
        int indexOfRemovedElement = listOfElements.indexOf(o);
        if (indexOfRemovedElement > -1) {
            listOfElements.set(indexOfRemovedElement, null);
            listOfRemovedElements.set(indexOfRemovedElement, (T) o);
            isRemoved = true;
        }
        return isRemoved;
    }

    @Override
    public T remove(int index) {
        listOfRemovedElements = checkListOfRemovedElementsIsNotEmpty();
        listOfRemovedElements.set(index, listOfElements.get(index));
        return listOfElements.set(index, null);
    }

    @Override
    public T set(int index, T element) {
        return listOfElements.set(index, element);
    }

    @Override
    public void clear() {
        listOfElements.clear();
        listOfRemovedElements.clear();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        listOfRemovedElements = checkListOfRemovedElementsIsNotEmpty();
        for (int i = 0; i < c.size(); i++) {
            listOfRemovedElements.add(listOfRemovedElements.size() + i, null);
        }
        return listOfElements.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        listOfRemovedElements = checkListOfRemovedElementsIsNotEmpty();
        for (int i = index; i < (index + c.size() - 1); i++) {
            listOfRemovedElements.add(index, null);
        }
        return listOfElements.addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        listOfRemovedElements = checkListOfRemovedElementsIsNotEmpty();
        boolean isRemoved = false;
        for (int i = 0; i < listOfElements.size(); i++) {
            for (Object element : c) {
                if (listOfElements.get(i).equals(element)) {
                    listOfRemovedElements.set(i, listOfElements.get(i));
                    listOfElements.set(i, null);
                    isRemoved = true;
                }
            }
        }
        return isRemoved;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        listOfRemovedElements = checkListOfRemovedElementsIsNotEmpty();
        boolean isChanged = false;
        for (int i = 0; i < listOfElements.size(); i++) {
            for (Object element : c) {
                if (!listOfElements.get(i).equals(element)) {
                    listOfRemovedElements.set(i, listOfElements.get(i));
                    listOfElements.set(i, null);
                    isChanged = true;
                }
            }
        }
        return isChanged;
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
