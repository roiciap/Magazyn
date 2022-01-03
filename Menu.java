package projekt;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Menu {

     public static void dodawanie_pracownikow() {
        System.out.println("dodawania pracownikow");
    }

    public static void dodawanie_produktow() {
        System.out.println("dodawanie produktu");
    }

    public static void usuwanie_produktow() {
        System.out.println("usuwanie produktu");
    }

    public static void modyfikacja_produktu() {
        System.out.println("modyfikacja_produktu");
    }

    public static void wysylka() {
        System.out.println("wysylka tu bedzie");
    }

    public static void dostawa() {
        System.out.println("dostawa");
    }

    public static void inwetaryzacja() {
        System.out.println("inwentaryzacja");
    }

    public static void cofka_magazynu() {
        System.out.println("cofka_magazynu");
    }

    public static int menu() {
        System.out.println();
        System.out.println("     ****************************************");
        System.out.println("    *Wci�nij wybrany przycick o numerze aby:*");
        System.out.println("     ****************************************");
        System.out.println("     1. dodawanie_pracownikow");
        System.out.println("     ----------------------------------------");
        System.out.println("     2. dodawanie_produktow");
        System.out.println("     ----------------------------------------");
        System.out.println("     3. usuwanie_produktow");
        System.out.println("     ----------------------------------------");
        System.out.println("     4. modyfikowanie_produktow");
        System.out.println("     ----------------------------------------");
        System.out.println("     5. wysylka");
        System.out.println("     ----------------------------------------");
        System.out.println("     6. dostawa");
        System.out.println("     ----------------------------------------");
        System.out.println("     7. inwentaryzacja");
        System.out.println("     ----------------------------------------");
        System.out.println("     8. cofka_magazynu");
        System.out.println("     ----------------------------------------");
        System.out.println("     0. Koniec");
        System.out.println("     ****************************************");

        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }


    public static int menu_pracownik() {
        System.out.println();
        System.out.println("     ****************************************");
        System.out.println("    *Wci�nij wybrany przycick o numerze aby:*");
        System.out.println("     ****************************************");
        System.out.println("     1. wysylka");
        System.out.println("     ----------------------------------------");
        System.out.println("     2. dostawa");
        System.out.println("     ----------------------------------------");
        System.out.println("     3. inwentaryzacja");
        System.out.println("     ----------------------------------------");
        System.out.println("     0. Koniec");
        System.out.println("     ****************************************");

        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }



    public static void main(String[] args) throws IOException {

         File file = new File("text.txt");

        PrintWriter zapis = new PrintWriter("text.txt");
        System.out.println("podaj swoj login");
        zapis.println("inzynieria");
        System.out.println("podaj swoje haslo");
        zapis.println("123");
        System.out.println("podaj czy jeste� kierownikiem 0 nie 1 tak ");
        zapis.println("1");
        zapis.close();

        Scanner in = new Scanner(file);

        String login = in.nextLine();
        System.out.println(login);

        String password = in.nextLine();
        System.out.println(password);

        String stanowisko = in.nextLine();
        System.out.println(stanowisko);


                Scanner input_login = new Scanner(System.in);
                System.out.println("Prosze podaj login");
                String wprowadzony_login = input_login.next();
                Scanner input_passoword = new Scanner(System.in);
                System.out.println("Prosze podaj haslo");
                String wprowadzone_haslo = input_passoword.next();
                if (wprowadzony_login.equals(login) && wprowadzone_haslo.equals(password) && stanowisko == "0") {

                    int wybor = menu_pracownik();

                    while (wybor != 0) {
                        switch (wybor) {
                            case 1 -> wysylka();
                            case 2 -> dostawa();
                            case 3 -> inwetaryzacja();
                        }

                        System.out.println("\n Wci�nij Enter, aby wr�ci� do menu...");
                        System.in.read();

                        wybor = menu_pracownik();

                    }
                } else if (wprowadzony_login.equals(login)) {
                    System.out.println("bledne haslo");
                } else if (wprowadzone_haslo.equals(password)) {
                    System.out.println("bledny login");
                } else {
                    System.out.println("bledne haslo oraz login");
                }

                if (wprowadzony_login.equals(login) && wprowadzone_haslo.equals(password) && stanowisko.equals("1")) {

                    int wybor = menu();

                    while (wybor != 0) {
                        switch (wybor) {
                            case 1 -> dodawanie_pracownikow();
                            case 2 -> dodawanie_produktow();
                            case 3 -> usuwanie_produktow();
                            case 4 -> modyfikacja_produktu();
                            case 5 -> wysylka();
                            case 6 -> dostawa();
                            case 7 -> inwetaryzacja();
                            case 8 -> cofka_magazynu();
                        }

                        System.out.println("\n Wci�nij Enter, aby wr�ci� do menu...");
                        System.in.read();

                        wybor = menu();
                    }


                    System.out.println("****************************************");
                    System.out.println("\n Koniec programu\n\n");
                } else if (wprowadzony_login.equals(login)) {
                    System.out.println("bledne haslo");
                } else if (wprowadzone_haslo.equals(password)) {
                    System.out.println("bledny login");
                } else {
                    System.out.println("bledne haslo oraz login");
                }
     }
     
}
