package chapter2.item3;

public class SingletonWithFactory {
    private static final SingletonWithFactory INSTANCE = new SingletonWithFactory();

    private SingletonWithFactory() {
    }

    public static SingletonWithFactory getINSTANCE() {
        return INSTANCE;
    }
}
