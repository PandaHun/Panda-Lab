package chapter2.item5;

import java.util.List;
import java.util.Objects;

public class SpellChecker {
    private final Lexicon dictionary;

    public SpellChecker(Lexicon dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    public boolean isValid(String word) {...}

    public List<String> suggestions(String typo) {...}
}
