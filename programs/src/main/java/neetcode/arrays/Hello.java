package neetcode.arrays;

import java.util.UUID;

public class Hello {
    public static void main(String[] args) {

        //        String guidString = "\\0d\\0c\\d3\\84\\4a\\83\\0f\\4a\\9c\\c6\\c3\\9b\\9a\\23\\d7\\f9";
        String guidString = "\\76\\0e\\e6\\51\\18\\b7\\f4\\46\\71\\aa\\76\\0e\\e6\\51\\18\\b7";
        UUID guid = UUID.fromString(guidString.replaceAll("\\\\", ""));
        String formattedGuid = guid.toString();
    }
}
