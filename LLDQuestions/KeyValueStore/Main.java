package LLDQuestions.KeyValueStore;

import javafx.util.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        KeyValueStore kValueStore = new KeyValueStore();
        kValueStore.put("ramesh", List.of(new Pair<>("class", "1"), new Pair<>("school", "adarsh vid")));
        kValueStore.put("suresh", List.of(new Pair<>("class", "2"), new Pair<>("school", "krsvm"), new Pair<>("location", "India")));
        kValueStore.put("prateek", List.of(new Pair<>("class", "2"), new Pair<>("school", "navodaya"), new Pair<>("location", "USA")));
        ValueObject obj1 = kValueStore.get("ramesh");
        ValueObject obj2 = kValueStore.get("suresh");
        System.out.println(obj1.toString());
        System.out.println(obj2.toString());
        List<String> search1 = kValueStore.search("class", "2");
        for(String x: search1)
        {
            System.out.print(x+" ");
        }
        System.out.println();
        kValueStore.put("ramesh", List.of(new Pair<>("class", "3"), new Pair<>("school", "adarsh vid")));
        kValueStore.delete("suresh");
        kValueStore.put("ramesh", List.of(new Pair<>("class", "unknown"), new Pair<>("school", "adarsh vid")));   
    }
}
