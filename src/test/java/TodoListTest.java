import org.example.TodoList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TodoListTest {

    @Test
    void addAndList() {
        TodoList t = new TodoList();
        t.add("  task1  ");
        assertEquals(1, t.size());
        assertEquals("task1", t.getAll().getFirst());
    }

    @Test
    void remove() {
        TodoList t = new TodoList();
        t.add("a");
        t.add("b");
        assertTrue(t.remove(0));
        assertEquals(1, t.size());
        assertFalse(t.remove(10));
    }

    @Test
    void addEmptyIgnored() {
        TodoList t = new TodoList();
        t.add("   ");
        assertEquals(0, t.size());
    }

    @Test
    void markDoneSetsFlag() {
        TodoList t = new TodoList();
        t.add("a");
        assertFalse(t.isDone(0));
        assertTrue(t.markDone(0));
        assertTrue(t.isDone(0));
    }

    @Test
    void markDoneInvalidIndex() {
        TodoList t = new TodoList();
        t.add("a");
        assertFalse(t.markDone(5));
        assertFalse(t.markDone(-1));
    }

    @Test
    void removeKeepsDoneFlagsAligned() {
        TodoList t = new TodoList();
        t.add("a");
        t.add("b");
        t.markDone(1);
        t.remove(0);
        assertTrue(t.isDone(0));
    }

    @Test
    void clearRemovesAll() {
        TodoList t = new TodoList();
        t.add("a");
        t.add("b");
        t.clear();
        assertEquals(0, t.size());
        assertTrue(t.getAll().isEmpty());
    }

    @Test
    void searchFindsBySubstringIgnoringCase() {
        TodoList t = new TodoList();
        t.add("Buy milk");
        t.add("Call mom");
        t.add("Buy bread");
        List<String> result = t.search("buy");
        assertEquals(2, result.size());
        assertTrue(result.contains("Buy milk"));
        assertTrue(result.contains("Buy bread"));
    }

    @Test
    void searchNothingFound() {
        TodoList t = new TodoList();
        t.add("Buy milk");
        assertTrue(t.search("xyz").isEmpty());
    }

    @Test
    void searchEmptyQueryReturnsEmpty() {
        TodoList t = new TodoList();
        t.add("Buy milk");
        assertTrue(t.search("  ").isEmpty());
        assertTrue(t.search(null).isEmpty());
    }
}