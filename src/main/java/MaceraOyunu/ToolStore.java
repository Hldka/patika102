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

    public void printWeapon(){
        System.out.println("Silahlar");
        System.out.println();
    }
}
