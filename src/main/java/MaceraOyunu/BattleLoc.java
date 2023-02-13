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
        if (selectcase.equals("S")){
            System.out.println(" savas islemi olacak");
        }
        return true;
    }
}
