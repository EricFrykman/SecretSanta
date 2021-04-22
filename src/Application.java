import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Application {
    //yagni = you ain't gonna need it.
    //Rule of 3.


    //Array.asList is a helper to make things easy
    private static List<String> names = Arrays.asList("Aaron", "Monica", "Christina", "Derek", "Eric", "Zach", "Roxy", "Carmon", "Nick");





    public static void main(String[] args) {
        //another helper called "Collections"
        System.out.println(names);
        Collections.shuffle(names);
        System.out.println(names);
    }
}