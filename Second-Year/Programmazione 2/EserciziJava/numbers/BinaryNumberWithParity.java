package numbers;

public class BinaryNumberWithParity extends BinaryNumber {
    protected BinaryNumberWithParity(int value) {
        super(value);
    }

    public String toString() {
        String str = "";
        int n = getValue(); // 4
        while(n > 0) {
            str += getCharForDigit(n%getBase());  // 4 % 2 -> 2 con il resto di 0 o 1
            n = n / getBase(); // 4 / 2 -> 2
        }

        if(str.charAt(str.length()-1) == '1') {
            str += '0';
        }

        return reverse(str);
    }
}
