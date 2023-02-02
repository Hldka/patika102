package MaceraOyunu;

import java.util.Scanner;

public class Game {
    private Scanner input=new Scanner(System.in);
    public void start(){
        System.out.println("Macera oyununa Hosgeldiniz !");
        System.out.println("lütfen bir isim giriniz : ");
        //String playerName=input.nextLine();
        Player player=new Player("Ayse");
        System.out.println("Sayin "+player.getName()+"  Bu karanlik ve sisili adaya hos geldiniz.... burada yasanlarin hepsi gercek  !");
        System.out.println("Lütfen oyuna baslamak icin bir karakter seciniz ");
        player.selectChar();
        Location location=null;
while (true){
    player.printInfo();
    System.out.println();
    System.out.println("######################## Bölgeler ############################");
    System.out.println();
    System.out.println("1 - Güvenli Ev--> Burasi sizin icin güvenli bir ev Düsman yoktur !");
    System.out.println("2 -  Magaza --> Silah veya zirh satinalabilirsiniz ");
    System.out.println("0 -Cikis Yap --> Oyunu sonlandir  ");
    int selectLoc=input.nextInt();
    switch (selectLoc){
        case 0:location=null;
            break;
        case 1:location=new SafeHouse(player);
            break;
        case  2:location=new ToolStore(player);
            break;
        default:location=new SafeHouse(player);
    }if (location==null){
        System.out.println(" Bu sisli ve karanlik adaadn hemen vazgectin ");
        break;}
    if (!location.onLocation()){
        System.out.println("GAME OVER");
        break;
    }

    }
}}
