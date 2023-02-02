package MaceraOyunu;

public class Inventory {
    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    private Armor armor;
    private Weapon weapon;

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Inventory(){
      this.weapon=new Weapon("Yumruk",0,0,0);
      this.armor=new Armor(0,"Pacavra",0,0);
  }
}
