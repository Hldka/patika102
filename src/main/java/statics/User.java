package statics;

public class User {
    public String name;

    public  static  int counter=0;
    public  User(String name){
        this.name=name;
        counter++;
    }

    {
        System.out.println("ben bir static kod blogum ");
    }
static {
    System.out.println("2. Static kod blogu");
        int random= (int) (Math.random()*10);
    System.out.println("3. random sayi :"+random);
    counter=random;
    System.out.println("4.counter :"+counter);

}
}
