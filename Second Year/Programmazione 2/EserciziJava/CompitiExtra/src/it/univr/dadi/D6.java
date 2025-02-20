package it.univr.dadi;

public class D6 extends Dado{
    /**
     * Costruisce un dado con un numero prefissato di facce.
     * Lancia IllegalArgumentException il numero di facce non e' positivo.
     *
     * @param facce
     */
    protected D6() {
        super(6);
    }
}
