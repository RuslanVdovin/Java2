package lesson3;

import java.util.*;

public class CollectionExample {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(Arrays.asList("table", "lamp", "chair", "bed",
                        "car", "table", "fridge", "chair", "kettle", "chair", "mobile",
                "lamp", "java", "javaFX", "java"));

        Set<String> unWords = new HashSet<String>(words);

        System.out.println(unWords);

        for (String key : unWords) {
            System.out.println(key + ": " + Collections.frequency(words, key));
        }
    }
}
