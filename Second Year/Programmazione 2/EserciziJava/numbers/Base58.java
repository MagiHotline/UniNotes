package numbers;

public class Base58 extends AbstractNumber {

    protected Base58(int value) {
        super(value);
    }

    @Override
    protected int getBase() {
        return 58;
    }

    @Override
    protected char getCharForDigit(int digit) {
        String s = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz";
        return s.charAt(digit);
    }
}
