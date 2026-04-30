package numbers;

public abstract class AbstractNumber implements Number {

    private final int value;

    protected AbstractNumber(int value) {
        this.value = value;
        if(!isValid())
            throw new IllegalArgumentException("Invalid number. Must be negative");
    }

    protected boolean isValid() {
        return value > 0;
    }

    public final int getValue() {
        return value;
    }

    protected abstract int getBase();

    protected abstract char getCharForDigit(int digit);

    protected String reverse(String s1) {
        String s2 = "";
        for(int i = s1.length() - 1; i >= 0; i--) {
            s2 += s1.charAt(i);
        }
        return s2;
    }

    // 4 -> 100
    public String toString() {
        String str = "";
        int n = getValue(); // 4
        while(n > 0) {
            str += getCharForDigit(n%getBase());  // 4 % 2 -> 2 con il resto di 0 o 1
            n = n / getBase(); // 4 / 2 -> 2
        }

        return reverse(str);
    }

    public final boolean equals(Object other) {
        return other instanceof Number && this.value == ((Number) other).getValue();
    }

    public final int compareTo(Number other) {
        if(other == null)  {
            throw new NullPointerException();
        }

        return Integer.compare(this.getValue(), other.getValue());
    }

}
