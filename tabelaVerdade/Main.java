import java.util.Scanner;


public class Main {

    // Alisson de Oliveira Lima

    Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Main var = new Main();
        var.menu();
    }

    public void menu(){
        Calculo var = new Calculo();

        System.out.println("1- Utilizar o programa");
        System.out.println("2- Sair");
        int menuOption = scan.nextInt();
        if(menuOption > 2 || menuOption < 1){
            menu();
        }

        switch(menuOption){
            case 1:
                var.inserirValores();
                break;
            case 2:
                System.out.println("2");
                break;
        }
    }
}
