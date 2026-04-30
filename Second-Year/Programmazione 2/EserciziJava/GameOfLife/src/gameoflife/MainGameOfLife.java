package gameoflife;

import java.io.IOException;

public class MainGameOfLife {
    public static void main(String[] args) throws InterruptedException {
        Board board = new Board(40, 20, 100);
        // Creiamo un processore
        NextAliveProcessor processor = new GolProcessor(board);
        board.play(processor);
    }

    private static class GolProcessor implements NextAliveProcessor {
        private Board board;
        public GolProcessor(Board board) {
            this.board = board;
        }

        public boolean nextAlive(int x, int y) {
            // If the cell is not alive the only way to become alive is if theres exactly three
            // neightbour cell alive
            if(!board.isAliveAt(x, y)) {
                return countNeighbors(board, x, y) == 3;
            } else {
                // Altrimenti se la cella è viva, l'unico modo per rimanere in vita è si ha 2 o 3 celle vive adiacenti
                return countNeighbors(board, x, y) == 2 || countNeighbors(board, x, y) == 3;
            }
        }
    }

    private static int countNeighbors(Board board, int x, int y) {
        int counter = 0;
        for (int xx = x - 1; xx <= x + 1; xx++) {
            for (int yy = y - 1; yy <= y + 1; yy++) {
                if ( xx >= 0 && xx < board.getWidth() // Se si è nei bounds
                     && yy >= 0 && yy < board.getHeight()
                     && (xx != x || yy != y) && board.isAliveAt(xx, yy) ) // E non siamo la cella stessa e la cella è viva
                    counter++;
            }
        }

        return counter;
    }
}
