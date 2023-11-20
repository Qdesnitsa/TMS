package by.tms.lesson36_collections_advanced.list;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("utils")
class AddElementToMyListTest {
    private static MyList<String> myList;

    @BeforeAll
    public static void setUp() {
        myList = new DoublyLinkedList<>();
        myList.add("A");
        myList.add("B");
        myList.add("C");
        myList.add("D");
        myList.add("E");
    }

    @DisplayName("Correct addition of element to the end of the List")
    @Test
    public void testAddElementToTheEndLinkedList() {
        assertThat(myList).matches(p -> p.get(4).equals("E"))
                .as("Last added element is not the last in the list");
        assertThat(myList).matches(p -> p.get(0).equals("A"))
                .as("First added element is not the first in the list");
    }
}