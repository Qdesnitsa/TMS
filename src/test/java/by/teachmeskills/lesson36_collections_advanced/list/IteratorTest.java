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
public class IteratorTest {
   MyList<String> myList;
    MyList<String> myEmptyList;
    MyIterator<String> iterator;
    MyIterator<String> iteratorEmptyList;

    @BeforeEach
    void setUp() {
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
    void testListHasNextElement() {
        assertTrue(iterator.hasNext(), "Not empty list should contain item");
    }

    @DisplayName("Empty list has not the next element")
    @Test
    void testListHasNotNextElement() {
        assertFalse(iteratorEmptyList.hasNext(), "Empty list should not contain item");
    }

    @DisplayName("Empty list can not return the next element, expected NoSuchElementException")
    @Test
    void testNextReturnsExceptionIfHasNextFalse() {
        assertThrows(NoSuchElementException.class, () -> {
            iteratorEmptyList.next();
        });
    }

    @DisplayName("Not Empty list returns the next (first) element")
    @Test
    void testNextReturnsElementIfHasNextTrue() {
        assertThat(iterator.next()).isEqualTo("A");
    }

    @DisplayName("End of the list can not return the next element, expected NoSuchElementException")
    @Test
    void testNextReturnsExceptionIfListEnd() {
        assertThrows(NoSuchElementException.class, () -> {
            while (iterator.hasNext()) {
                iterator.next();
                iterator.next();
            }
        });
    }

    @DisplayName("Removal of element bypassing iterator, expected ConcurrentModificationException")
    @Test
    void testNextReturnsExceptionIfModifiedOutside() {
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
    void testRemoveReturnsExceptionIfNextIsNotCalled() {
        assertThrows(IllegalStateException.class, () -> {
            iterator.remove();
        });
    }

    @DisplayName("Removal of element while iteration after calling next")
    @Test
    void testRemoveElementAfterNextIsCalled() {
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
