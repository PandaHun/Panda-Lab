package chapter2.item5;

import java.util.List;

public class SpellCheckerStaticUtility {
    private static final Lexicon dictionary = ...;

    private SpellCheckerStaticUtility() {
    }

    public static boolean isValid(String word) {...}

    public static List<String> suggestions(String typo) {...}
}
