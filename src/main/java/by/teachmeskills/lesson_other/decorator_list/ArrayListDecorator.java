package by.teachmeskills.lesson_other.decorator_list;

import java.util.*;

public class ArrayListDecorator<T> extends ArrayList<T> {
    private Map<Integer, T> listOfRemovedElements;

    public ArrayListDecorator(List<T> listOfElements) {
        new ArrayList<>(listOfElements);
        listOfRemovedElements = new TreeMap();
    }

    public List<T> getListOfElements() {
        return this;
    }

    public Map<Integer, T> getListOfRemovedElements() {
        return listOfRemovedElements;
    }

    public List<T> restoreRemovedElementsBackToList() {
        for (Map.Entry<Integer, T> entry : listOfRemovedElements.entrySet()) {
            if (entry.getKey() >= this.size()) {
                for (int i = this.size(); i < entry.getKey() - 1; i++) {
                    this.add(i, null);
                }
            }
            this.add(entry.getKey(), entry.getValue());
        }
        return this;
    }

    public void cleanListOfRemovedElements() {
        listOfRemovedElements.clear();
    }

    @Override
    public boolean remove(Object o) {
        int indexOfRemovedElement = this.indexOf(o);
        if (indexOfRemovedElement != -1) {
            listOfRemovedElements.put(indexOfRemovedElement, (T) o);
        }
        return super.remove(o);
    }


    @Override
    public T remove(int index) {
        if (index < this.size()) {
            listOfRemovedElements.put(index, this.get(index));
        }
        return super.remove(index);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (int i = this.size() - 1; i >= 0; i--) {
            for (Object element : c) {
                if (null != this.get(i) && this.get(i).equals(element)) {
                    listOfRemovedElements.put(i, this.get(i));
                }
            }
        }
        return super.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        for (int i = this.size() - 1; i >= 0; i--) {
            for (Object element : c) {
                if (null != this.get(i) && !this.get(i).equals(element)) {
                    listOfRemovedElements.put(i, this.get(i));
                }
            }
        }
        return super.retainAll(c);
    }
}
