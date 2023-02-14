package MaceraOyunu;

import java.util.Random;

public abstract class BattleLoc extends Location{
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.award=award;
        this.obstacle=obstacle;
        this.maxObstacle=maxObstacle;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }
public int randomObstacleNumber(){
    Random r=new Random();
    return r.nextInt(this.getMaxObstacle())+1;
}
    @Override
    boolean onLocation() {
        int obsNumber=this.randomObstacleNumber();
        System.out.println("Suan Buradasiniz : "+this.getName());
        System.out.println("Dikkatli ol! burada  "+obsNumber+" "+this.getObstacle().getName()+" Yasiyor! ");
        System.out.println("<S>avas veya <K>ac  : ");
        String selectcase=scan.nextLine();
        selectcase=selectcase.toUpperCase();
        if (selectcase.equals("S")&& combat(obsNumber)){


                System.out.println(this.getName()+"tüm düsmanlari yendin ");
                return true;

        }
        if (this.getPlayer().getHealth()<=0){
            System.out.println("Öldünüz ! ");return false;}
        return true;
    }
    public boolean combat(int obsNumber){

        for (int i=1;i<=obsNumber;i++){
            this.getObstacle().setHealth(this.getObstacle().getOrjinalHealth());
            playerStats();
            obstacleStats( i);

            while (this.getPlayer().getHealth()>0&& this.getObstacle().getHealth()>0){

                System.out.println("<V>ur veya <K>ac : ");
                String selectCombat=scan.nextLine().toUpperCase();
                if (selectCombat.equals("V")){
                    System.out.println("Siz vurdunuz ! ");
                    this.getObstacle().setHealth(this.getObstacle().getHealth()-this.getPlayer().getTotalDamage());
                    afterHit();
                    if (this.getObstacle().getHealth()>0){
                        System.out.println();
                        System.out.println("Canavar Size vurdu");

                 int obstacleDamage=  this.getObstacle().getDamage()-this.getPlayer().getInventory().getArmor().getBlock();
                 if (obstacleDamage<0){obstacleDamage=0;}
                    this.getPlayer().setHealth(this.getPlayer().getHealth()-obstacleDamage);

afterHit();
                    }
                }else {return false;}
            }if (this.getObstacle().getHealth()<this.getPlayer().getHealth()){
                System.out.println("Düsmani Yendiniz ");
                System.out.println(this.getObstacle().getAward()+" para kazandiniz");
                this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getObstacle().getAward());
                System.out.println("Güncel paraniz : "+this.getPlayer().getMoney());
            }else {return  false;}
        
        }
        return  true;}


    private void afterHit() {
        System.out.println("Caniniz : "+this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName()+" Cani "+this.getObstacle().getHealth());
        System.out.println();
    }

    private void obstacleStats(int i) {
        System.out.println(i+"."+this.getObstacle().getName()+" Degerleri ");
        System.out.println("--------------------");
        System.out.println("Saglik : "+this.getObstacle().getHealth());
        System.out.println("Hasar : "+this.getObstacle().getDamage());
        System.out.println("Ödül"+this.getObstacle().getAward());

    }

    private void playerStats() {
        System.out.println("Oyuncu Degerleri");
        System.out.println("................");
        System.out.println("Saglik : "+this.getPlayer().getHealth());
        System.out.println("Silah : "+this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Zirh : "+this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Bloklama : "+this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Hasar : "+this.getPlayer().getTotalDamage());
        System.out.println("Para : "+this.getPlayer().getMoney());

    }
}
