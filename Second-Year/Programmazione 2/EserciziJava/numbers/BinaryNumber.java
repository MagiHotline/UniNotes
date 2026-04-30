package numbers;

public class BinaryNumber extends AbstractNumber {

    protected BinaryNumber(int value) {
        super(value);
    }

    @Override
    protected int getBase() {
        return 2;
    }

    @Override
    protected char getCharForDigit(int digit) {
        char[] digits = {'0', '1'};
        return digits[digit];
    }
}
