import java.util.Scanner;

public class Batalha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String optionName;

        System.out.println("Começou a luta!");
        System.out.println("Opção 1 - attack!");
        System.out.println("Opção 2 - fugir!");
        System.out.print("Escolha sua ação: ");
        int option = scanner.nextInt();
        switch (option){
            case 1:
                optionName = "attack";
                System.out.println("Attack");
                break;
            case 2:
                optionName = "run";
                System.out.println("Fugiu");
                break;
        }

    }
}
