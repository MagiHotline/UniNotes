package gameoflife;

public class MainCostant {
    public static void main(String[] args) throws InterruptedException {
        Board board = new Board(40, 20, 100);
        NextAliveProcessor processor = new costantProcessor(board);
        board.play(processor);
    }

    // costantProcessor è un processore che fa rimanere costante il gioco
    private static class costantProcessor implements NextAliveProcessor {
        private final Board board;
        public costantProcessor(Board board) {
            this.board = board;
        }

        public boolean nextAlive(int x, int y) {
            return board.isAliveAt(x, y);
        }
    }

}
