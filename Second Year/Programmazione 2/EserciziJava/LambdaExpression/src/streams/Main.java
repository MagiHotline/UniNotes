package streams;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<String> l = new ArrayList<>();
        Set<String> copy = new HashSet<>();

        l.add("Ciao");
        l.add("Cuckoo");
        l.add("Rhododendron");


        l.forEach(s -> System.out.println(s));
        l.forEach(s -> copy.add(s));

        l.forEach(System.out::println);
        l.forEach(copy::add);

        copy.stream().sorted().forEach(System.out::println);

        // Gli stream sono algoritmi che partono da una sorgente di dati
        //  e alla fine calcolano un risultato terminato (Stream Lazy)
        /*
        (An Array, a collection, I/O Channel)
        Stream Source -> create Stream Istance -> [Intermediate Operations] -> Operation Result
         */

        long howMany = copy.stream()
                           .filter(s -> s.startsWith("a"))
                           .count();

        Optional<String> found = copy.stream()
                                    .filter(s -> s.startsWith("a"))
                                    .filter(s -> s.length() >= 42)
                                    .findAny();

        boolean allAtLeast42 = copy.stream().allMatch(s -> s.length() >=  42);





    }
}