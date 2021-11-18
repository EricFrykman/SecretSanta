import java.util.*;

public class Application {
    //yagni = you ain't gonna need it.
    //Rule of 3.


    //Array.asList is a helper to make things easy
    private static class Pair{
        private final String left, right;

        public Pair(String left, String right) {
            this.left = left;
            this.right = right;
        }
        public Boolean match(Pair that){
            return (Objects.equals(this.left, that.left) && Objects.equals(this.right, that.right))
                    || (Objects.equals(this.left, that.right) && Objects.equals(this.right, that.left));
        }
    }
    private static final List<String> names = Arrays.asList("Aaron", "Monica", "Christina", "Derek", "Eric", "Zach", "Roxy", "Carmon", "Nick");
    private static final List<Pair> invalidPairs = Arrays.asList(
            new Pair("Aaron","Monica"),
            new Pair("Eric", "Christina"),
            new Pair("Eric", "Derek"),
            new Pair("Zach", "Roxy"),
            new Pair("Carmon", "Nick")
    );


//At the moment there could be an infinite loop, so maybe limit the while loop with counter
    public static void main(String[] args) {
        //another helper called "Collections"
        //System.out.println(names);
        Boolean invalid = true;
        outer:
        while (invalid){
            Collections.shuffle(names);
            List<Pair> pairs = new ArrayList<>();
            for (int i = 0; i < names.size(); i++) {
                int j = i + 1;
                if (j < names.size()) {
                    pairs.add(new Pair(names.get(i), names.get(j)));
                } else {
                    pairs.add(new Pair(names.get(i), names.get(0)));
                }
            }
            for (Pair pair: pairs){
               for (Pair invalidPair: invalidPairs){
                   if (pair.match(invalidPair)){
                       System.out.println("invalid Pair");
                       continue outer;
                   }
               }
            }
            invalid = false;
            for (Pair pair: pairs){
                System.out.println(pair.left + "-->" + pair.right);
            }
        }
    }
}