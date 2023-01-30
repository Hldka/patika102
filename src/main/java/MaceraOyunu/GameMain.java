package MaceraOyunu;

public class GameMain {
    public static void main(String[] args) {
        Samurai samurai=new Samurai();
        System.out.println(samurai.getDamage());
        Game game=new Game();
        game.start();

    }
}
