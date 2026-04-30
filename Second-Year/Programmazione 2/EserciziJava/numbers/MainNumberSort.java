package numbers;

import java.util.Arrays;

public class MainNumberSort {
    public static void main(String[] args) {

        Number[] numbers = {
                new DecimalNumber(2024),
                new BinaryNumber(113),
                new BinaryNumber(158),
                new OctalNumber(827),
                new HexNumber(2066),
                new Base58(8092)
        };

        Arrays.sort(numbers); // Merge Sort lol
        System.out.println(Arrays.toString(numbers));
    }
}
