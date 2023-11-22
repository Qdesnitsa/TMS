package by.tms.lesson30_31_design_patterns_gof.behavioral.iterator;

import java.util.Iterator;

public interface Menu {
    Iterator<MenuItem> createIterator();
}
