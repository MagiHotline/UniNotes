package it.univr.dadi;

/**
 * Un tipo speciale di classe Lanci dove le barre degli istogrammi
 * sono stampate usando alternativamente i caratteri *, @ e +
 * (la prima barra usa *, la second @, la terza + e cosi' via
 * ciclicamente).
 */
public class LanciBarreDiverse extends Lanci {

    public LanciBarreDiverse(int quanti, Dado... dadi) {
        super(quanti, dadi);
    }

    protected String barra(int i, double frequenza) {
        String ris = i + ": ";
        for(int j = 1; j <= frequenza; j++) {
            ris += "*@+".charAt(i % 3);
        }

        return ris;
    }
}