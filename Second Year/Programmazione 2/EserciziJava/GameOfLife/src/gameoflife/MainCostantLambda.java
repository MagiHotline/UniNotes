package gameoflife;

public class MainCostantLambda {
    public static void main(String[] args) throws InterruptedException {
        Board board = new Board(40, 20, 100);
        NextAliveProcessor processor = board::isAliveAt;
        board.play(processor);
    }
}
