import java.util.stream.Stream;

public class Main {

    public static String encrypt(String input, int shift) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz"; // Alfabeto completo
        String newString = "";

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (Character.isLetter(currentChar)) {
                boolean isUpperCase = Character.isUpperCase(currentChar);
                currentChar = Character.toLowerCase(currentChar);

                int currentIndex = alphabet.indexOf(currentChar);
                int newIndex = (currentIndex + shift) % alphabet.length();
                char newChar = alphabet.charAt(newIndex);

                newString += isUpperCase ? Character.toUpperCase(newChar) : newChar;
            } else {
                // Aggiungi caratteri non alfabetici così come sono
                newString += currentChar;
            }
        }

        return newString;
    }

    public static String decrypt(String input, int shift) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz"; // Alfabeto completo
        String newString = "";

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (Character.isLetter(currentChar)) {
                boolean isUpperCase = Character.isUpperCase(currentChar);
                currentChar = Character.toLowerCase(currentChar);

                int currentIndex = alphabet.indexOf(currentChar);
                int newIndex = (currentIndex - shift + alphabet.length()) % alphabet.length();
                char newChar = alphabet.charAt(newIndex);

                newString += isUpperCase ? Character.toUpperCase(newChar) : newChar;
            } else {
                // Aggiungi caratteri non alfabetici così come sono
                newString += currentChar;
            }
        }

        return newString;
    }

    public static void main(String[] args) {

        String saluto = "ziopera";
        System.out.println(saluto);
        System.out.println(encrypt(saluto,2));
        System.out.println(decrypt(encrypt(saluto,2),2));


    }
}
