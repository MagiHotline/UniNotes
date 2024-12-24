package gameoflife;

public class Board {
    private final int width;
    private final int height;
    private boolean[][] current;
    private final int howManyAlive;

    public interface NextAliveProcessor {
        boolean isAliveNextAt(int x, int y);
    }

    /**
     * Inizializza la tavola alle dimensioni indicate, in modo che
     * contenga esattamente howManyAlive cellule vive, posizionate
     * casualmente nella tavola.
     *
     * @param width la larghezza della tavola
     * @param height l'altezza della tavola
     * @param howManyAlive il numero di cellule vive della tavola
     * @throws IllegalArgumentException se width o height sono negative,
     *         oppure se howManyAlive è negativo o maggiore del numero di cellule della tavola
     */
    public Board(int width, int height, int howManyAlive) {
        this.width = width;
        this.height = height;
        this.howManyAlive = howManyAlive;
        this.current = new boolean[width][height];

        if(this.width < 0 || this.height < 0 || this.howManyAlive < 0 || this.howManyAlive > (width * height)) {
            throw new IllegalArgumentException();
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isAliveAt(int x, int y) {
        return current[x][y];
    }

    public String toString() {
        String result = "";
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++)
                result += isAliveAt(x, y) ? '*' : ' ';
            result += '\n';
        }
        return result;
    }

    /**
     * Stampa ripetutamente questa tavola, chiamando ogni volta
     * next() per farla passare alla generazione successiva. L'unico modo
     * per terminare questo metodo è con CTRL+C. In Eclipse, tale segnale
     * viene inviato cliccando sul pulsante quadrato rosso della console.
     *
     * @param processor la specifica di come si passa da una generazione alla successiva
     */
    public void play(NextAliveProcessor processor) throws InterruptedException {
        while (true) {
            System.out.println(this);
            System.out.println("----------------------------------------");
            next(processor);
            Thread.sleep(500); // aspetta mezzo secondo
        }
    }

    /**
     * Modifica la tavola in modo che la cellula (x,y) sarà viva
     * se e solo se processor.isAliveNextAt(x,y) è vero.
     */
    private void next(NextAliveProcessor processor) {
        if(processor.isAliveNextAt(, ) {
            current[width - 1][height - 1] = true;
        }
    }
}
