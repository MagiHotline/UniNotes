package numbers;

public class OctalNumber extends AbstractNumber {

    protected OctalNumber(int value) {
        super(value);
    }

    @Override
    protected int getBase() {
        return 8;
    }

    @Override
    protected char getCharForDigit(int digit) {
        char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7'};
        return digits[digit];
    }
}
