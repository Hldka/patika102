package MaceraOyunu;

public abstract class BattleLoc extends Location{
    public BattleLoc(Player player, String name) {
        super(player, name);
    }

    @Override
    boolean onLocation() {
        return false;
    }
}
