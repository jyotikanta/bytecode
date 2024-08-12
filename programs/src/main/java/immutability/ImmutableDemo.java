package immutability;

import java.lang.reflect.Field;
import java.util.Arrays;

public class ImmutableDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        ImmutableClass ic = new ImmutableClass(1, "Groceries", Arrays.asList("Bread", "Milk", "Banana", "Oil", "vegetables"));

        System.out.println(ic);
        ic.getItems().set(0, "Brod");
        System.out.println(ic);
        System.out.println("IC Name :" + ic.getName());
        Field name = ImmutableClass.class.getDeclaredField("name");
        name.setAccessible(true);
        name.set(ic, "hello");
        System.out.println("Modified Name :" + ic.getName());
    }
}
