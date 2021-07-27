package chapter2.item3;

public class SingletonWithMember {
    public static final SingletonWithMember INSTANCE = new SingletonWithMember();

    private SingletonWithMember() {
    }
}
