package by.teachmeskills.lesson_other.decorator_list;

import static org.junit.Assert.assertSame;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) throws Throwable {
        ArrayListDecorator<Integer> arrayListDecorator = new ArrayListDecorator(new ArrayList());
        for (int i = 0; i < 10; i++) {
            arrayListDecorator.add(i, ThreadLocalRandom.current().nextInt(1, 10));
        }

        System.out.println(arrayListDecorator.getListOfElements());
        System.out.println(arrayListDecorator.getListOfRemovedElements());
        arrayListDecorator.add(null);
        arrayListDecorator.add(11);
        arrayListDecorator.add(0, null);
        arrayListDecorator.add(1, 123);
        System.out.println(arrayListDecorator.getListOfElements());
        System.out.println(arrayListDecorator.getListOfRemovedElements());
        arrayListDecorator.remove(Integer.valueOf(11));

        arrayListDecorator.remove(2);
        arrayListDecorator.remove(Integer.valueOf(9));
        arrayListDecorator.add(Integer.valueOf(5));
        arrayListDecorator.add(5);
        System.out.println(arrayListDecorator.getListOfElements());
        System.out.println(arrayListDecorator.getListOfRemovedElements());
        arrayListDecorator.restoreRemovedElementsBackToList();
        System.out.println(arrayListDecorator.getListOfElements());
        arrayListDecorator.restoreRemovedElementsBackToList();
        System.out.println(arrayListDecorator.getListOfElements());
        System.out.println(arrayListDecorator.getListOfRemovedElements());
        arrayListDecorator.cleanListOfRemovedElements();
    }
}
