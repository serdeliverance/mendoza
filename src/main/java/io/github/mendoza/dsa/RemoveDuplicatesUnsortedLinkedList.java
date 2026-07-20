package io.github.mendoza.dsa;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/**
 * Remove duplicates from an unsorted linked list
 *
 */
public class RemoveDuplicatesUnsortedLinkedList {

    public static void removeDuplicates(LinkedList<Integer> list) {
        Set<Integer> seen = new HashSet<>();
        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            int value = iterator.next();

            if (seen.contains(value)) {
                iterator.remove();
            } else {
                seen.add(value);
            }
        }
    }
}
