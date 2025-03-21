package it.univr.file;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractComponent implements Component {
    private final String name;

    /**
     * Costruisce una componente con il nome indicato.
     */
    protected AbstractComponent(String name) {
        this.name = name;
    }

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public final String toString() {
        return toString("");
    }

    // sotto potete aggiungere solo cose private, se servissero;
    // quindi non aggiungete metodi public sotto
}