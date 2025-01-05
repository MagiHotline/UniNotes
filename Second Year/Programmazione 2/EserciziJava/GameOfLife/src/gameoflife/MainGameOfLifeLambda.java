package gameoflife;

public class MainGameOfLifeLambda {
    public static void main(String[] args) throws InterruptedException {
        Board board = new Board(40, 20, 100);
        NextAliveProcessor processor = (x, y) ->
                board.isAliveAt(x, y) ? countNeighbors(board, x, y) == 3 || countNeighbors(board, x, y) == 2
                        : countNeighbors(board, x, y) == 3;
        board.play(processor);
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
