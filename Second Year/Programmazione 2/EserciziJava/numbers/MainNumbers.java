package numbers;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MainNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int choice = scanner.nextInt();

        for(int i = 0; i < 6; i++) {
            switch(i) {
                case 0: {
                    System.out.println(new DecimalNumber(choice));
                    break;
                }
                case 1: {
                    System.out.println(new BinaryNumber(choice));
                    break;
                }
                case 2: {
                    System.out.println(new BinaryNumberWithParity(choice));
                    break;
                }
                case 3: {
                    System.out.println(new OctalNumber(choice));
                    break;
                }
                case 4: {
                    System.out.println(new HexNumber(choice));
                    break;
                }
                case 5: {
                    System.out.println(new Base58(choice));
                    break;
                }
            }
        }

    }
}