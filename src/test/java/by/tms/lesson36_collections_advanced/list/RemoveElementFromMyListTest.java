package by.tms.lesson36_collections_advanced.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("utils")
public class RemoveElementFromMyListTest {
    private MyList<String> myList;

    @BeforeEach
    public void setUp() {
        myList = new DoublyLinkedList<>();
        myList.add("A");
        myList.add("B");
        myList.add("C");
        myList.add("D");
        myList.add("E");
    }

    @DisplayName("Index is less than 0, expected IndexOutOfBoundsException")
    @Test
    public void testRemoveElementByIndexLessThanZero() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            myList.remove(-1);
        });
    }

    @DisplayName("Index is greater than list size, expected IndexOutOfBoundsException")
    @Test
    public void testRemoveElementByIndexGreaterThanListSize() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            myList.remove(100);
        });
    }

    @DisplayName("Correct removal of element by index from the List")
    @Test
    public void testRemoveElementByIndexFromLinkedList() {
        assertThat(myList).matches(p -> p.remove(3).equals("D"))
                .as("Last added element is not the last in the list");
        assertTrue(myList.get(3).equals("E"));
    }

    @DisplayName("Double removal the last element by index from the List, expected IndexOutOfBoundsException")
    @Test
    public void testRemoveLastElementByIndexFromLinkedList() {
        myList.remove(4);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            myList.remove(4);
        });
    }
}
