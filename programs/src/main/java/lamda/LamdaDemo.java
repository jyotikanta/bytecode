package lamda;
@FunctionalInterface
interface MyLamda{
    public void disply();
}

class My implements MyLamda{
    @Override
    public void disply() {
        System.out.println("Hello World!");
    }
}
public class LamdaDemo {
    public static void main(String[] args) {

    }
}
