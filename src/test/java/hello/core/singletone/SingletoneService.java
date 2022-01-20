package hello.core.singletone;

public class SingletoneService {

    private static final SingletoneService instance = new SingletoneService();

    public static SingletoneService getInstance() {
        return instance;
    }

    private SingletoneService() {//생성자를 private으로 제한하여 외부클래스에서 new 생성자 막
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
