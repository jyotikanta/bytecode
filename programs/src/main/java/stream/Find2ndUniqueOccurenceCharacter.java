package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Find2ndUniqueOccurenceCharacter {
    public static void main(String[] args) {
        String name = "Odisha Hockey Premiere League".toUpperCase();
        name = name.replaceAll("[^a-zA-Z0-9]","");
        Stream<Character> characterStream = name.chars().mapToObj(c->(char) c);
        System.out.println(characterStream.distinct().collect(Collectors.toSet()));
    }
}
