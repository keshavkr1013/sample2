
import javafx.util.Pair;

public class hello {

     public static void main(String[] args) {
        System.out.println("Hello world");
        Pair<Integer, Integer> pp = new Pair<>(5, 7);
        System.out.println(pp.getKey());
        System.out.println(pp.getValue());
     }
}
