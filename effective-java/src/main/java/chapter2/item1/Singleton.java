package chapter2.item1;

public class Singleton {

    private static final Singleton instance = new Singleton();

    private Singleton() {
    }

    public static Singleton getSingleton() {
        return instance;
    }
}
