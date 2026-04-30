package it.univr.dadi;

public class D8 extends Dado{
    /**
     * Costruisce un dado con un numero prefissato di facce.
     * Lancia IllegalArgumentException il numero di facce non e' positivo.
     *
     * @param facce
     */
    protected D8() {
        super(8);
    }
}
