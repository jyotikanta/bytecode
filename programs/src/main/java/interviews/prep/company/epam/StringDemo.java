package interviews.prep.company.epam;

import java.lang.reflect.Field;

public class StringDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//        String s = "Hello";
//        System.out.println(s);
//        String y = "Hello";
//        System.out.println(y);


        String str1 = "Hello";

        // Access the private 'value' field of the String class
        Field valueField = String.class.getDeclaredField("value");
        valueField.setAccessible(true);

        // Get the internal character array
        char[] charArray = (char[]) valueField.get(str1);

        String str2 = "Hello";

        //Here both str1 and str2 are pointing to the same object in string pool changina one character in one string will affect the other
        charArray[1] = 'z';
        System.out.println(str1);
        System.out.println(str2);

        String str3 = "Hello";
        System.out.println(str3);
        String str4 = new String("Hello"); //this will be created in Heap and not present in pool by
        System.out.println(str3==str4); //false
        str4.intern(); //this will put the string in string pool
        System.out.println(str3==str4); //false
        str4 = str4.intern();
        System.out.println(str3==str4); //this should be true but its giving false

        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        sb.append("World");
        System.out.println(sb);

        StringBuffer stringBuffer = new StringBuffer("Hello").append("World");
        System.out.println(stringBuffer);

        // Print the characters
//        for (char ch : charArray) {
//            System.out.print(ch); // Prints 'Hello'
//        }
    }
}
