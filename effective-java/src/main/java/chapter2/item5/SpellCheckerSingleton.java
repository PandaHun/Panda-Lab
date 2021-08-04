package chapter2.item5;

import java.util.List;

public class SpellCheckerSingleton {
    private final Lexicon dictionary = ...;

    private SpellCheckerSingleton() {
    }

    public static SpellCheckerSingleton INSTANCE = new SpellCheckerSingleton();

    public boolean isValid(String word) {...}

    public List<String> suggestions(String typo) {...}
}
