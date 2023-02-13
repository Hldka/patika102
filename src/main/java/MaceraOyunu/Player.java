package MaceraOyunu;

import java.util.Scanner;

public class Player {

    private  int damage;
    private  int health;
    private  int money;
    private Inventory inventory;

    public Inventory getInventory() {
        return inventory;
    }
    public void printInfo(){
        System.out.println(
                        "silahiniz : "+this.getInventory().getWeapon().getName()+
                                ", Zirh : "+this.getInventory().getArmor().getName()+
                                ", Bloklama : "+this.getInventory().getArmor().getBlock()+
                                ", Hasariniz : "+this.getTotalDamage()+
                                 " ,Saglik : "+this.getHealth()+
                             " ,Para : "+this.getMoney());
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private String name;
    private String charName;
    Scanner scan=new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inventory=new Inventory();
    }
    public void selectChar(){
        GameChar[] charList={new Samurai(),new Archer(),new Knight()};

        System.out.println("************************************************************");
        for (GameChar gameChar:charList) {System.out.println("ID : "+gameChar.getId()+"\tKarakter: "+gameChar.getName()+
                "\tHasar :"+gameChar.getDamage()
        +"\tSaglik : "+gameChar.getHealth()+
                "\tPara : "+gameChar.getMoney());

        }
        System.out.println("*****************************");
        System.out.println("Lütfen bir karakter giriniz !");
        int selectChar=scan.nextInt();
        switch (selectChar){
            case 1:initPlayer(new Samurai());
            break;
            case 2:initPlayer(new Archer());
            break;
            case 3:initPlayer(new Knight());
            break;
            default:
                initPlayer(new Samurai());
        }
        System.out.println("Karakter : "+ this.getCharName()+"\tHasar : "+this.getDamage()+
                "\t Saglik : "+this.getHealth()+"\tPara : "+this.getMoney());


    }

public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
      this.setId(gameChar.getId());
}
public int getTotalDamage(){
        return damage+this.getInventory().getWeapon().getDamage();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }


}
