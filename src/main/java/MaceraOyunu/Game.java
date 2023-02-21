package MaceraOyunu;

import java.util.Scanner;

public class Game {
    private Scanner input=new Scanner(System.in);
    public void start(){
        System.out.println("Macera oyununa Hosgeldiniz !");
        System.out.println("lütfen bir isim giriniz : ");
        String playerName=input.nextLine();
        Player player=new Player(playerName);
        System.out.println("Sayin "+player.getName()+"  Bu karanlik ve sisili adaya hos geldiniz.... burada yasanlarin hepsi gercek  !");
        System.out.println("*****************************");
        System.out.println("Lütfen oyuna baslamak icin bir karakter seciniz ");
        System.out.println("*****************************");
        player.selectChar();
        Location location=null;
while (true){
    player.printInfo();
    System.out.println();
    System.out.println("######################## Bölgeler ############################");
    System.out.println();
    System.out.println("1 - Güvenli Ev--> Burasi sizin icin güvenli bir ev Düsman yoktur !");
    System.out.println("2 -  Esya Dükkani --> Silah veya zirh satinalabilirsiniz ");
    System.out.println("3 -  Magara --> Ödül<Yemek> ,Dikkatli ol karsina Zombi cikabilir  ");
    System.out.println("4 -  Orman --> Ödül<Odun> ,Dikkatli ol Vampir cikabilir  ");
    System.out.println("5 -  Nehir --> Ödül <Su> ,Dikkatli ol Ayi cikabilir  ");
    System.out.println("6 -  Maden --> Ödül <maden> ,Dikkatli ol Yilan cikabilir  ");
    System.out.println("0 -Cikis Yap --> Oyunu sonlandir  ");
    System.out.println("Lütfen gitmek istediğiniz bölgeyi seçiniz.");


    int selectLocation = input.nextInt();

    if(player.getInventory().isWater() &&
            player.getInventory().isFood() &&
            player.getInventory().isFirewood()
            && selectLocation == 1
    ){
        System.out.println("Tüm ödüller toplandı oyunu bitirdiniz. Tebrikler :)");
        break;

    }

    if(selectLocation==0){
        System.out.println("Çıkış yapıldı");
        break;
    }

    if( ( selectLocation==3 && player.getInventory().isFood() ) ||
            (selectLocation==4 && player.getInventory().isFirewood())  ||
            (selectLocation==5 && player.getInventory().isWater())
    ){

        System.out.println("Ödül kazandığınız bölgeye giriş yapamazsınız");
        continue;

    }


    int selectLoc=input.nextInt();
    switch (selectLoc){
        case 0:location=null;
            break;
        case 1:location=new SafeHouse(player);
            break;
        case  2:location=new ToolStore(player);
            break;
        case 3:location=new Cave(player);
            break;
        case 4:location=new Forest(player);
            break;
        case 5:location=new River(player);
             break;
        case 6:location=new Mine(player);
        break;
        default:location=new SafeHouse(player);
    }if (location==null){
        System.out.println(" Bu sisli ve karanlik ada'dan hemen vazgectin ");
        break;}
    if (!location.onLocation()){
        System.out.println("GAME OVER");
        break;
    }

    }
}}
