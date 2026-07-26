package io.github.mendoza.katas;

import java.util.*;

/**
 * /Anagramas input: ["tea","ate","tab","eta","bat"] return: grupos de anagramas: [ate,tea,eta] y
 * [tab,bat]]
 */
public class AnagramGroups {

    public static String[][] anagramGroups(String[] input) {
      Map<String, Set<String>> keyToAnagramsMap = new HashMap<>();

      for (String s : input) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        // each element in an anagram group has the same signature (in this case, the signature/key
        // is the word sorted alphabetically.
        String signature = new String(c);

        if (!keyToAnagramsMap.containsKey(signature)) {
          keyToAnagramsMap.put(signature, new HashSet<>());
        }

        keyToAnagramsMap.computeIfPresent(signature, (k,anagramList) -> {
          anagramList.add(s);
          return anagramList;
        });
      }


      return keyToAnagramsMap.values().stream()
              .map(s -> s.toArray(new String[s.size()]))
              .toArray(String[][]::new);
    }

//  private static class AnagramGroup {
//    private final Predicate<String> condition;
//    private final Set<String> elements;
//
//    private AnagramGroup(Predicate<String> condition, Set<String> elements) {
//      this.condition = condition;
//      this.elements = elements;
//    }
//
//    private boolean evaluate(String newMember) {
//      return this.condition.test(newMember);
//    }
//
//    private void add(String newMember) {
//      this.elements.add(newMember);
//    }
//
//    public static AnagramGroup newAnagramGroup(String conditionElement) {
//      return new AnagramGroup((e) -> isAnagram(conditionElement, e), new HashSet<>());
//    }
//  }
//
//  /**
//   * First approach. Brute force, basically.
//   * Storing groups in an anagram group structure that contains a evaluation function to check
//   * if the element is an anagram.
//   *
//   * Bad performance
//   *
//   */
//  public static String[][] anagramGroups(String[] input) {
//    if (input.length == 0) {
//      return new String[][] {};
//    }
//
//    List<AnagramGroup> groupList = new ArrayList<>();
//
//    for (String s : input) {
//      AnagramGroup group = findGroupOrCreate(groupList, s);
//      group.add(s);
//    }
//
//    return groupList.stream()
//        .map(g -> g.elements.toArray(new String[g.elements.size()]))
//        .toArray(String[][]::new);
//  }
//
//  private static AnagramGroup findGroupOrCreate(List<AnagramGroup> groupList, String s) {
//    Optional<AnagramGroup> matchingGroup = groupList.stream()
//            .filter(g -> g.evaluate(s))
//            .findAny();
//
//    if (matchingGroup.isPresent()) {
//        return matchingGroup.get();
//    }
//
//    AnagramGroup newGroup = AnagramGroup.newAnagramGroup(s);
//    groupList.add(newGroup);
//
//     return newGroup;
//  }
//
//  private static boolean isAnagram(String a, String b) {
//    if (a.length() != b.length()) {
//      return false;
//    }
//
//    Map<Character, Integer> charFrequencyMap = new HashMap<>();
//
//    for (Character c : a.toCharArray()) {
//        charFrequencyMap.merge(c, 1, Integer::sum);
//    }
//
//    for (Character c : b.toCharArray()) {
//        int frequency = charFrequencyMap.getOrDefault(c, 0);
//
//        if (frequency == 0) {
//            return false;
//        }
//
//        charFrequencyMap.replace(c, frequency - 1);
//    }
//
//    return true;
//  }
}
