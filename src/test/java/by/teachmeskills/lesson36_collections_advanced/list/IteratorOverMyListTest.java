package by.teachmeskills.lesson36_collections_advanced.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Tag("utils")
public class IteratorOverMyListTest {
    private MyList<String> myList;
    private MyList<String> myEmptyList;
    private MyIterator<String> iterator;
    private MyIterator<String> iteratorEmptyList;

    @BeforeEach
    public void setUp() {
        myEmptyList = new DoublyLinkedList<>();
        myList = new DoublyLinkedList<>();
        myList.add("A");
        myList.add("B");
        myList.add("C");
        myList.add("D");
        myList.add("E");
        iterator = myList.iterator();
        iteratorEmptyList = myEmptyList.iterator();
    }

    @DisplayName("Not empty list has the next element")
    @Test
    public void testListHasNextElement() {
        assertTrue(iterator.hasNext(), "Not empty list should contain item");
    }

    @DisplayName("Empty list has not the next element")
    @Test
    public void testListHasNotNextElement() {
        assertFalse(iteratorEmptyList.hasNext(), "Empty list should not contain item");
    }

    @DisplayName("Empty list can not return the next element, expected NoSuchElementException")
    @Test
    public void testNextReturnsExceptionIfHasNextFalse() {
        assertThrows(NoSuchElementException.class, () -> {
            iteratorEmptyList.next();
        });
    }

    @DisplayName("Not Empty list returns the next (first) element")
    @Test
    public void testNextReturnsElementIfHasNextTrue() {
        assertThat(iterator.next()).isEqualTo("A");
    }

    @DisplayName("End of the list can not return the next element, expected NoSuchElementException")
    @Test
    public void testNextReturnsExceptionIfListEnd() {
        assertThrows(NoSuchElementException.class, () -> {
            while (iterator.hasNext()) {
                iterator.next();
                iterator.next();
            }
        });
    }

    @DisplayName("Removal of element bypassing iterator, expected ConcurrentModificationException")
    @Test
    public void testNextReturnsExceptionIfModifiedOutside() {
        assertThrows(ConcurrentModificationException.class, () -> {
            while (iterator.hasNext()) {
                String str = iterator.next();
                if (str.equals("A")) {
                    myList.remove(2);
                    iterator.remove();
                }
            }
        });
    }

    @DisplayName("Removal of element bypassing next, expected IllegalStateException")
    @Test
    public void testRemoveReturnsExceptionIfNextIsNotCalled() {
        assertThrows(IllegalStateException.class, () -> {
            iterator.remove();
        });
    }

    @DisplayName("Removal of element while iteration after calling next")
    @Test
    public void testRemoveElementAfterNextIsCalled() {
        assertThat(myList.get(0).equals("A"));
        while (iterator.hasNext()) {
            String str = iterator.next();
            if (str.equals("A")) {
                iterator.remove();
            }
        }
        assertThat(myList.get(0).equals("B"));
    }
}
