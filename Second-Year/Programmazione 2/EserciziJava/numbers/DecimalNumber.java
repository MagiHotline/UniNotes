package numbers;

public class DecimalNumber extends AbstractNumber {

    protected DecimalNumber(int value) {
        super(value);
    }

    @Override
    protected int getBase() {
        return 10;
    }

    @Override
    protected char getCharForDigit(int digit) {
        char[] digits = {'0','1','2','3','4','5','6','7','8','9'};
        return digits[digit];
    }
}
