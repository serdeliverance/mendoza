package io.github.sd3v.ctci.dsa;

import java.util.LinkedList;
import java.util.Optional;

public class HashTable {

  private static final int ARRAY_LENGTH = 16;

  private final LinkedList<Entry>[] internalArray = new LinkedList[ARRAY_LENGTH];

  private record Entry(String key, String value) {}

  public void put(String key, String value) {
    var hash = getHashCode(key);
    var idx = hash % ARRAY_LENGTH;

    if (internalArray[idx] == null) {
      internalArray[idx] = new LinkedList<>();
    }

    internalArray[idx].add(new Entry(key, value));
  }

  public Optional<String> get(String key) {
    var hash = getHashCode(key);
    var idx = hash % ARRAY_LENGTH;

    if (internalArray[idx] == null) {
      return Optional.empty();
    }

    for (Entry entry : internalArray[idx]) {
      if (entry.key.equals(key)) {
        return Optional.of(entry.value);
      }
    }

    return Optional.empty();
  }

  private int getHashCode(String key) {
    var hash = key.hashCode();
    return hash < 0 ? -hash : hash;
  }
}
