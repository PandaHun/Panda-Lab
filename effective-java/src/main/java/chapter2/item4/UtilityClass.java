package chapter2.item4;

public class UtilityClass {
    /*
    만약 생성자를 명시 하지 않는다면
    컴파일러가 자동으로 매개변수가 없는 아래와 같은 public 생성자를 만든다

    public UtilityClass() {

    }
     */
    private UtilityClass() {
        throw new AssertionError();
    }
}
