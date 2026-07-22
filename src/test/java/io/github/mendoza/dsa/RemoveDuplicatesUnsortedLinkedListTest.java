package io.github.mendoza.dsa;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

class RemoveDuplicatesUnsortedLinkedListTest {

    @Test
    public void whenHasDuplicatesItShouldRemoveThem() {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(2, 3, 15, 2, 5, 3, 7));

        RemoveDuplicatesUnsortedLinkedList.removeDuplicates(list);

        LinkedList<Integer> expected = new LinkedList<>(Arrays.asList(2, 3, 15, 5, 7));

        assertThat(list)
                .hasSize(5)
                .hasSameElementsAs(expected);
    }
}