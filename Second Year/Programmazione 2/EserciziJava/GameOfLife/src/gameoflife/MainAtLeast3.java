package gameoflife;

public class MainAtLeast3 {
    public static void main(String[] args) throws InterruptedException {
        Board board = new Board(40, 20, 100);
        NextAliveProcessor processor = new AtLeast3(board);
        board.play(processor);
    }

    // AtLeast3 è una specifica di come si passa da una generazione alla successiva
    private static class AtLeast3 implements NextAliveProcessor {
        private final Board board;
        public AtLeast3(Board board) {
            this.board = board;
        }

        public boolean nextAlive(int x, int y) {
            return countNeighbors(board, x, y) >= 3;
        }
    }

    // Conta i vicini di una cella
    private static int countNeighbors(Board board, int x, int y) {
        int counter = 0;
        for (int xx = x - 1; xx <= x + 1; xx++) {
            for (int yy = y - 1; yy <= y + 1; yy++) {
                if (xx >= 0 && xx < board.getWidth()
                    && yy >= 0 && yy < board.getHeight()
                    && (xx != x || yy != y) && board.isAliveAt(xx, yy))
                    counter++;
            }
        }

        return counter;
    }


}
