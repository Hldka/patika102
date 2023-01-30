package MaceraOyunu;

public abstract class GameChar {
    private int damage;
    private  int health;
    private  int money;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public GameChar(int id,String name,int damage, int health, int money) {
        this.damage = damage;
        this.health = health;
        this.money = money;
        this.name=name;
        this.id=id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
