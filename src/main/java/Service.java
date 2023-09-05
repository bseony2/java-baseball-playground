public class Service implements Runnable{
    @Override
    public void run() {
        Game game = new Game();

        while (!game.isGameOver) {

            game.setAnswer();
            game.setResult();
            game.reactToPlayer();
        }
    }
}
