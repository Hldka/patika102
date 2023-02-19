package patikaMagaza;

import java.util.Scanner;

public class PatikaStore {

    public  void start(){
        System.out.println("**********PATIKA STORE HOSGELDINIZ***************");
        System.out.println("Magazamizin ayricaliklarina bakmak istermisiniz.....");
        System.out.println("1 - Notebook İşlemleri\n" +
                "2 - Cep Telefonu İşlemleri\n" +
                "3 - Marka Listele\n" +
                "0 - Çıkış Yap");
        Scanner scan =new Scanner(System.in);
        int secim=scan.nextInt();

        switch (secim) {
            case 1:
                notebookislemleri();
                break;
            case 2:

                break;
            case 3:

                break;
            case 0:break;
        }
    }

    private void notebookislemleri() {

    }
}
