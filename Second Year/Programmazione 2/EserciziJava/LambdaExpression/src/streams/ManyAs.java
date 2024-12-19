package streams;

import java.util.stream.Stream;

public class ManyAs {

    private static boolean IsPrime(int n) {
        for(int d = 2; d * d <= n; d++) {
            if(n % d == 0) {
                return false;
            }
        }
        return n >= 2;
    }

    public static void main(String[] args) {
        // "a", "aa", "aaa", "aaaa"
        Stream.iterate("a", s -> s + "a")
                .filter(s -> IsPrime(s.length()))
                .limit(10)
                .map(s -> s + " [" + s.length() + "]")
                .forEach(System.out::println);

    }

}
