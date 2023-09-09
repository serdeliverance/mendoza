package io.github.sd3v.challenges;

import org.junit.jupiter.api.Test;

import java.util.List;

import static io.github.sd3v.challenges.WordBreak.wordBreak;
import static org.junit.jupiter.api.Assertions.*;

class WordBreakTest {

    @Test
    public void basicScenario() {
        var result = wordBreak("leetcode", List.of("leet", "code"));
        assertTrue(result);
    }

    @Test
    public void repeatedWordScenario() {
        var result = wordBreak("applepenapple", List.of("apple", "pen"));
        assertTrue(result);
    }

    @Test
    public void unbreakableWord() {
        var result = wordBreak("catsandog", List.of("cats","dog","sand","and","cat"));
        assertFalse(result);
    }
}