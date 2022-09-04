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
        boolean isRemoved = false;
        int indexOfRemovedElement = this.indexOf(o);
        if (indexOfRemovedElement != -1) {
            super.remove(o);
            listOfRemovedElements.put(indexOfRemovedElement, (T) o);
            isRemoved = true;
        }
        return isRemoved;
    }


    @Override
    public T remove(int index) {
        if (index < this.size()) {
            super.remove(index);
            listOfRemovedElements.put(index, this.get(index));
        }
        return listOfRemovedElements.get(index);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean isRemoved = false;
        for (int i = this.size() - 1; i >= 0; i--) {
            for (Object element : c) {
                if (null != this.get(i) && this.get(i).equals(element)) {
                    listOfRemovedElements.put(i, this.get(i));
                    super.removeAll(c);
                    isRemoved = true;
                }
            }
        }
        return isRemoved;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean isRemoved = false;
        for (int i = this.size() - 1; i >= 0; i--) {
            for (Object element : c) {
                if (null != this.get(i) && !this.get(i).equals(element)) {
                    listOfRemovedElements.put(i, this.get(i));
                    super.retainAll(c);
                    isRemoved = true;
                }
            }
        }
        return isRemoved;
    }
}
