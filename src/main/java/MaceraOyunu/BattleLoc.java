package MaceraOyunu;

import java.util.Random;

abstract class BattleLoc extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxMonsterNum;
    private Random randomNumber = new Random();

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxMonsterNum) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxMonsterNum = maxMonsterNum;
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

    public int getMaxMonsterNum() {
        return maxMonsterNum;
    }

    public void setMaxMonsterNum(int maxMonsterNum) {
        this.maxMonsterNum = maxMonsterNum;
    }

    @Override
    public boolean onLocation() {

        int monsterNumber =  randomMonsterNumber();
        System.out.println("Şuan buradasınız: "+this.getName());
        System.out.println("Dikkatli ol! Burada "+monsterNumber+" tane "+this.getObstacle().getName()+" yaşıyor!");
        System.out.println("<S>avaş veya <K>aç");
        String selectCase = scan.nextLine().toUpperCase();
        if(selectCase.equals("S") && combat(monsterNumber)){
            System.out.println(this.getName()+"deki tüm düşmanları yendiniz. ");
            return true;
        }

        if(this.getPlayer().getHealth() <= 0){
            System.out.println("Öldünüz.");
            return false;
        }

        return true;


    }


    public int randomMonsterNumber(){

        return randomNumber.nextInt(this.getMaxMonsterNum()) + 1 ;

    }

    public boolean isStart(){
        return randomNumber.nextBoolean();
    }



    public boolean combat(int monsterNumber){
        for(int i = 1;i <= monsterNumber;i++){

            boolean randomCase = isStart();

            this.getObstacle().setHealth(this.getObstacle().getOrjinalHealth());
            playerStats();
            obstacleStats(i);

            if(randomCase){
                System.out.println("Savaşa "+this.getObstacle().getName()+" başlayacak ! ");
                System.out.println("---------------------------------------");
                System.out.println("<K>aç ya da <D>evam et");
                String selectCase = scan.nextLine().toUpperCase();

                if(selectCase.equals("K")){
                    return false;
                }


            }
            else{
                System.out.println("Savaşa siz başlayacaksınız !");
            }

            while(this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0){
                int monsterDamage;


                if(randomCase){
                    obstacleAttack();
                    System.out.println(this.getObstacle().getName()+" size vurdu!");
                    this.getPlayer().setHealth( this.getPlayer().getHealth() - obstacleAttack());
                    afterHit();

                    if(this.getPlayer().getHealth() > 0){
                        System.out.println("<V>ur ya da <K>aç");
                        String selectCase = scan.nextLine().toUpperCase();

                        if(selectCase.equals("V")){
                            playerAttack();
                            afterHit();
                        }
                        else{
                            return true;
                        }


                    }
                }



                else{
                    System.out.println("<V>ur ya da <K>aç");
                    String selectCase = scan.nextLine().toUpperCase();

                    if(selectCase.equals("V")){
                        playerAttack();
                        afterHit();
                        if(this.getObstacle().getHealth() > 0){
                            obstacleAttack();
                            System.out.println(this.getObstacle().getName()+" size vurdu!");
                            System.out.println("-----------------------------------------");
                            this.getPlayer().setHealth( this.getPlayer().getHealth() - obstacleAttack());
                            afterHit();
                        }
                    }
                    else{
                        return true;
                    }


                }


            }

        }

        if(this.getObstacle().getHealth() < this.getPlayer().getHealth() && !(this.getName().equals("Maden"))){
            System.out.println("Düşmanı yendiniz.");
            System.out.println(this.getObstacle().getAward()+ " para kazandınız.");
            this.getPlayer().setMoney(
                    this.getPlayer().getMoney() + this.getObstacle().getAward()
            );
            System.out.println("Güncel paranız: "+this.getPlayer().getMoney());
        }

        else if(this.getObstacle().getHealth() < this.getPlayer().getHealth() && this.getName().equals("Maden")){
            Mine mine = new Mine(getPlayer());
            System.out.println("Düşmanı yendiniz");
            mine.itemDrop(getPlayer());
            System.out.println();

        }
        else{
            return false;
        }



        if(this.getName()=="Nehir"){
            this.getPlayer().getInventory().setWater(true);
        }

        if(this.getName()=="Mağara"){
            this.getPlayer().getInventory().setFood(true);
        }

        if(this.getName()=="Orman"){
            this.getPlayer().getInventory().setFirewood(true);
        }



        return true;
    }


    public void playerAttack(){
        System.out.println("Siz vurdunuz.");
        this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
    }

    public int obstacleAttack(){
        return  this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();

    }

    public void afterHit(){
        System.out.println("Canınız: "+this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName()+" canı: "+this.getObstacle().getHealth());
        System.out.println();


    }

    public void obstacleStats(int i) {
        System.out.println(i + ". "+this.getObstacle().getName()+" değerleri:");
        System.out.println("------------------------------------");
        System.out.println("Sağlık: "+this.getObstacle().getHealth());
        System.out.println("Hasar: "+this.getObstacle().getDamage());
        System.out.println("Ödül: "+this.getObstacle().getAward());
    }

    public void playerStats() {
        System.out.println("Oyuncu değerleri");
        System.out.println("------------------------------------");
        System.out.println("Sağlık: "+this.getPlayer().getHealth());
        System.out.println("Silah: "+this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Zırh: "+this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Bloklama: "+this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Hasar: "+this.getPlayer().getTotalDamage());
        System.out.println("Para: "+this.getPlayer().getMoney());





    }


}