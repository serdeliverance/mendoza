package io.github.mendoza.katas;

import java.util.*;
import java.util.function.Predicate;

/**
 * /Anagramas input: ["tea","ate","tab","eta","bat"] return: grupos de anagramas: [ate,tea,eta] y
 * [tab,bat]]
 */
public class AnagramGroups {

  private static class AnagramGroup {
    private final Predicate<String> condition;
    private final Set<String> elements;

    private AnagramGroup(Predicate<String> condition, Set<String> elements) {
      this.condition = condition;
      this.elements = elements;
    }

    private boolean evaluate(String newMember) {
      return this.condition.test(newMember);
    }

    private void add(String newMember) {
      this.elements.add(newMember);
    }

    public static AnagramGroup newAnagramGroup(String conditionElement) {
      return new AnagramGroup((e) -> isAnagram(conditionElement, e), new HashSet<>());
    }
  }

  public static String[][] anagramGroups(String[] input) {
    if (input.length == 0) {
      return new String[][] {};
    }

    List<AnagramGroup> groupList = new ArrayList<>();

    for (String s : input) {
      AnagramGroup group = findGroupOrCreate(groupList, s);
      group.add(s);
    }

    return groupList.stream()
        .map(g -> g.elements.toArray(new String[g.elements.size()]))
        .toArray(String[][]::new);
  }

  private static AnagramGroup findGroupOrCreate(List<AnagramGroup> groupList, String s) {
    Optional<AnagramGroup> matchingGroup = groupList.stream()
            .filter(g -> g.evaluate(s))
            .findAny();

    if (matchingGroup.isPresent()) {
        return matchingGroup.get();
    }

    AnagramGroup newGroup = AnagramGroup.newAnagramGroup(s);
    groupList.add(newGroup);

     return newGroup;
  }

  private static boolean isAnagram(String a, String b) {
    Map<Character, Integer> charFrequencyMap = new HashMap<>();

    for (Character c : a.toCharArray()) {
        charFrequencyMap.merge(c, 1, Integer::sum);
    }

    boolean isAnagram = true;

    for (Character c : b.toCharArray()) {
        int frequency = charFrequencyMap.getOrDefault(c, 0);
        if (frequency <= 0) {
            isAnagram = false;
            break;
        }
        charFrequencyMap.replace(c, frequency - 1);
    }

    return isAnagram;
  }
}
