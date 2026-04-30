package it.univr.pl.exception;

public class UnknownVariableException extends RuntimeException {
    public UnknownVariableException(String err) {
        super(err);
    }
}
