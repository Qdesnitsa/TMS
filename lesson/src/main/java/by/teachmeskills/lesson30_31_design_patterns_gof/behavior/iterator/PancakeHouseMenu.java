package by.teachmeskills.lesson30_31_design_patterns_gof.behavior.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PancakeHouseMenu implements Menu {
    private List<MenuItem> menuItems;

    public PancakeHouseMenu() {
        menuItems = new ArrayList<>();
        addItem("Pancake1", "Pancake1 description", true, 2.99);
        addItem("Pancake2", "Pancake2 description", false, 3.99);
        addItem("Pancake3", "Pancake3 description", true, 1.99);
        addItem("Pancake4", "Pancake4 description", false, 4.99);
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.add(menuItem);
    }

    public Iterator createIterator() {
        return menuItems.iterator();
    }
}
