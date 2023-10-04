package io.github.sd3v.ctci.dsa;

public class LinkedList<T> {

    private Node<T> head;

    public void append(T elem) {

        if (head == null) {
            head = new Node<>();
            head.setValue(elem);
            return;
        }

        var pointer = head;

        while (pointer.next != null) {
            pointer = pointer.next;
        }

        var newNode = new Node<T>();
        newNode.setValue(elem);
        newNode.setPrev(pointer);
        pointer.setNext(newNode);
    }

    public void insertAt(T elem, int index) {
        // TODO implement
    }

    public void remove(T elem) {
        // TODO implement
    }

    public void removeAt(T elem, int index) {
        // TODO implement
    }

    public T get(int index) {
        // TODO implement
        return null;
    }

    public int size() {

        if (head == null) {
            return 0;
        }

        var pointer = head;
        int size = 1;
        while (pointer.next != null) {
            pointer = pointer.next;
            size++;
        }

        return size;
    }

    private static class Node<T> {
        private T value;
        private Node<T> prev;
        private Node<T> next;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
