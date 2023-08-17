package io.github.sd3v.ctci;

import java.util.LinkedList;
import java.util.Optional;

public class HashTable {

    private static final int ARRAY_LENGTH = 16;

    private LinkedList<Entry>[] array = new LinkedList[ARRAY_LENGTH];

    private record Entry(String key, String value) {
    }

    public void put(String key, String value) {
        var hash = getHashCode(key);
        var idx = hash % ARRAY_LENGTH;

        if (array[idx] == null) {
            array[idx] = new LinkedList<>();
        }

        array[idx].add(new Entry(key, value));
    }

    public Optional<String> get(String key) {
        var hash = getHashCode(key);
        var idx = hash % ARRAY_LENGTH;

        if (array[idx] == null) {
            return Optional.empty();
        }

        for (int i = 0; i < array[idx].size(); i++) {
            if (array[idx].get(i).key.equals(key)) {
                return Optional.of(array[idx].get(i).value);
            }
        }

        return Optional.empty();
    }

    private int getHashCode(String key) {
        var hash = key.hashCode();
        return hash < 0 ? -hash : hash;
    }
}
