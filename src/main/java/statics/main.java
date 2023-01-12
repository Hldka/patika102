package statics;

public class main {
    public static void main(String[] args) {
        System.out.println("1.Program basladi ");
        User u1=new User("Ahmet a");
        User u2=new User("Alperen a");
        System.out.println("Counter Son Deger : "+User.counter);
        System.out.println("Program bitti");


    }
}
