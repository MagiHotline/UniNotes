package it.univr.pl.value;

public class ComValue extends Value {

    public static final ComValue INSTANCE = new ComValue();

    private ComValue() {}

    @Override
    public boolean equals(Object o) {
        return true;
    }

    @Override
    public int hashCode()
    {
        return 42;
    }
}
