package it.univr.pl.type;

import it.univr.pl.value.BoolValue;
import it.univr.pl.value.ExpValue;
import it.univr.pl.value.FloatValue;
import it.univr.pl.value.IntValue;
import it.univr.pl.value.StringValue;

public enum SimpleType implements ExpType {
    INT("int"),
    FLOAT("float"),
    BOOL("bool"),
    STRING("string");

    private final String name;

    private SimpleType(String name) {
        this.name = name;
    }

    @Override
    public String getName() { return name; }

    public static SimpleType fromString(String str) {
        return switch (str) {
            case "int" -> SimpleType.INT;
            case "bool" -> SimpleType.BOOL;
            case "string" -> SimpleType.STRING;
            case "float" -> SimpleType.FLOAT;
            default -> null;
        };
    }

    public static SimpleType fromValue(ExpValue<?> value) {
        if (value instanceof IntValue)
            return SimpleType.INT;
        if (value instanceof FloatValue)
            return SimpleType.FLOAT;
        if (value instanceof BoolValue)
            return SimpleType.BOOL;
        if (value instanceof StringValue)
            return SimpleType.STRING;

        return null;
    }

	@Override
	public boolean isCompatible(Type other) {
		return this == other;
	}
}
