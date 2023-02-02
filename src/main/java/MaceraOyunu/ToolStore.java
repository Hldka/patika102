package MaceraOyunu;

public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player, "Magaza");
    }

    @Override
    boolean onLocation() {
        System.out.println("---------Magaza'ya Hosgeldiniz----------- ");
        boolean showmenu=true;
        while (showmenu){
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
            buyArmor();
            break;
            case 3:
                System.out.println("Bir daha bekleriz...");
                showmenu=false;
                break;

        }

    } return true;
    }

    private void buyArmor() {  System.out.println("Bir Zirh seciniz : ");
        int selectArmorID =scan.nextInt();
        while (selectArmorID <1 || selectArmorID >Armor.armors().length){
            System.out.println("Gecersiz deger , tekarr giriniz : ");
            selectArmorID =scan.nextInt();
    }Armor selectedArmor=Armor.getArmorObjById(selectArmorID);
        if (selectedArmor!=null){
            if (selectedArmor.getPrice()>this.getPlayer().getMoney()){
                System.out.println(" Yeterli bakiyeniz yoktur");
            }else {
                System.out.println(selectedArmor.getName()+" Zirhini satin aldiniz");
                int balance=this.getPlayer().getMoney()-selectedArmor.getPrice();
                this.getPlayer().getInventory().setArmor(selectedArmor);
                System.out.println("Kalan bakiye : "+this.getPlayer().getMoney());
            }
        }
    }


    public void buyweapon(){
    System.out.println("Bir silah seciniz : ");
    int selectWeaponID =scan.nextInt();
    while (selectWeaponID<0 || selectWeaponID>Weapon.weapons().length){
        System.out.println("Gecersiz deger , tekarr giriniz : ");
        selectWeaponID=scan.nextInt();
    }
    if (selectWeaponID!=0){
    if (selectWeaponID!=0){
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
        }}
    }}
}
    public void printWeapon(){
        System.out.println("-------Silahlar-------");
        System.out.println();
        for (Weapon w:Weapon.weapons()) {
            System.out.println( w.getId() +" - "+ w.getName()+" < Para : "+
                    w.getPrice()+", Hasar : "+
                    w.getDamage()+"> ");

        }
        System.out.println("0 - Cikis yap");

        }
    public void printArmor() {

        System.out.println("-------Zirhlar-------");
        System.out.println();
        for ( Armor a:Armor.armors()) {
            System.out.println(a.getId()+"- "+a.getName()+" < Para : "+a.getPrice()+" Zirh : "+a.getBlock()+" >");

    } System.out.println("0 - Cikis yap");
}}
