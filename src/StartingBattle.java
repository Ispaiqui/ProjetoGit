import java.util.Scanner;

public class StartingBattle {
    public static void main(String[] args) {
        Personagem character = new Personagem("Heroi", 70, 160);
        Personagem enemy = new Personagem("Demonio", 50, 150);

        Scanner scanner = new Scanner(System.in);
        String optionName;

        System.out.println("Começou a luta!");

        int option = 0;
        while ((option != 2) && (enemy.getLife() > 0) && (character.getLife() > 0)) {
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("Opção 1 - attack!");
            System.out.println("Opção 2 - fugir!");
            System.out.print("Escolha sua ação: ");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    optionName = "attack!";
                    System.out.println("Attack!!");
                    character.doDamage(enemy);
                    System.out.println("Vida do " + enemy.getName() + ": " + enemy.getLife());
                    System.out.println("--------------------------------------------------------------------------------------");
                    if (enemy.getLife() > 0) {
                        enemy.doDamage(character);
                        System.out.println("Vida do " + character.getName() + ": " + character.getLife());
                    }
                    if (enemy.getLife() <= 0 ){
                        System.out.println(enemy.getName() + " morreu enquanto enfrentava o " + character.getName() + "!");
                    }else if (character.getLife() <= 0){
                        System.out.println(character.getName() + " morreu enquanto enfrentava o " + enemy.getName() + "!");
                    }else{
                        System.out.println("continuando");
                    }
                    break;
                case 2:
                    optionName = "run!";
                    System.out.println(character.getName() + " fugiu do " + enemy.getName() + "!");
                    break;

                default:
                    System.out.println("Fight is Over!!");
            }
        }


    }
}
