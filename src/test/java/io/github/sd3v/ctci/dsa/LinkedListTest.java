package io.github.sd3v.ctci.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    public void addElement() {
        var linkedList = new LinkedList<Integer>();
        linkedList.append(2);

        assertEquals(1, linkedList.size());
    }

    @Test
    public void removeElement() {
        var linkedList = new LinkedList<Integer>();
        linkedList.append(2);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);

        linkedList.remove(5);

        assertEquals(3, linkedList.size());
    }

    @Test
    public void whenLinkedListIsEmpty_thenSizeIs0() {
        var linkedList = new LinkedList<Integer>();

        assertEquals(0, linkedList.size());
    }

    @Test
    public void size() {
        var linkedList = new LinkedList<Integer>();

        linkedList.append(2);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);

        assertEquals(4, linkedList.size());
    }

    @Test
    public void removeElement_whenElementNotExists() {
        var linkedList = new LinkedList<Integer>();
        linkedList.append(2);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);

        linkedList.remove(3);

        assertEquals(4, linkedList.size());
    }
}