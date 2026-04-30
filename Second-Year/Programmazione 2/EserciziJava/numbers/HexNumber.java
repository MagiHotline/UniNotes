package numbers;

public class HexNumber extends AbstractNumber {

    protected HexNumber(int value) {
        super(value);
    }

    @Override
    protected int getBase() {
        return 16;
    }

    @Override
    protected char getCharForDigit(int digit) {
        char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        return digits[digit];
    }
}
