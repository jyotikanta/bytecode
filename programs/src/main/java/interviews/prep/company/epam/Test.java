package interviews.prep.company.epam;

public class Test <T>{
    private T t;

    public T get(){
        return t;
    }

    public void set(T t){
        this.t = t;
    }

    public static void main(StringDemo[] args) {
        Test obj = new Test();
        obj.set("demo");
        obj.set(10);
        obj.set("%");
        System.out.println(obj.get());

    }
}
