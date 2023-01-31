package MaceraOyunu;

public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player, "Magaza");
    }

    @Override
    boolean onLocation() {
        System.out.println("---------Magaza'ya Hosgeldiniz----------- ");
        System.out.println("1- Silahlar");
        System.out.println("2- Zirhlar");
        System.out.println("3- Cikis yap");
        System.out.println("Seciminiz...");
        int selectCase=Location.scan.nextInt();
        while (selectCase<1 || selectCase >3){
            System.out.println("Gecersiz deger , teharar giriniz : ");
            selectCase=scan.nextInt();
        }switch (selectCase){
            case 1:printWeapon();
                   buyweapon();
            break;
            case 2:printArmor();
            break;
            case 3:
                System.out.println("Bir daha bekleriz...");

        }
        return true;
    }

    public void printArmor() {
        System.out.println("Silahlar");
    }
public void buyweapon(){
    System.out.println("Bir silah seciniz : ");
    int selectWeaponID =scan.nextInt();
    while (selectWeaponID<1 || selectWeaponID>Weapon.weapons().length){
        System.out.println("Gecersiz deger , tekarr giriniz : ");
        selectWeaponID=scan.nextInt();
    }
    Weapon selectedWeapon=Weapon.getWeaonObjById(selectWeaponID);
    if (selectedWeapon!=null) {
        if (selectedWeapon.getPrice()>this.getPlayer().getMoney()){
            System.out.println("yeterli paraniz bulunmamaktadir !");
        }else {
            //satin almanin gerceklesdigi alan
            System.out.println(selectedWeapon.getName()+" silahini satin aldiniz !");
            int balance=this.getPlayer().getMoney()- selectedWeapon.getPrice();
            this.getPlayer().setMoney(balance);
            System.out.println("Kalan paraniz : "+this.getPlayer().getMoney());
            System.out.println("Önceki silahiniz : "+this.getPlayer().getInventory().getWeapon().getName());
            this.getPlayer().getInventory().setWeapon(selectedWeapon);
            System.out.println("Yeni Silahiniz : "+this.getPlayer().getInventory().getWeapon().getName());
        }
    }
}
    public void printWeapon(){
        System.out.println("-------Silahlar-------");
        System.out.println();
        for (Weapon w:Weapon.weapons()) {
            System.out.println( w.getId() +" - "+ w.getName()+" < Para : "+
                    w.getPrice()+", Hasar : "+
                    w.getDamage()+"> ");

        }


    }
}
