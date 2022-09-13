package by.teachmeskills.lesson36_collections_advanced.list;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag("utils")
public class GetTest {
    static MyList<String> myList;

    @BeforeAll
    static void setUp() {
        myList = new DoublyLinkedList<>();
        myList.add("A");
        myList.add("B");
        myList.add("C");
        myList.add("D");
        myList.add("E");
    }

    @DisplayName("Correct element is returned by index")
    @Test
    void testGetElementByIndex() {
        assertEquals("A", myList.get(0), "first get element is incorrect");
    }

    @DisplayName("Element is not removed from list")
    @Test
    void testGetElementByIndexDoesNotRemoveElement() {
        myList.get(0);
        assertEquals("A", myList.get(0), "first get element was removed");
    }

    @DisplayName("Index is less than 0, expected IndexOutOfBoundsException")
    @Test
    void testGetElementByIndexLessThanZero() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            myList.get(-1);
        });
    }

    @DisplayName("Index is greater than list size, expected IndexOutOfBoundsException")
    @Test
    void testGetElementByIndexGreaterThanListSize() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            myList.get(100);
        });
    }
}
