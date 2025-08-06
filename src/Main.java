import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Personagem enemy = new Personagem("Demonio", 40, 300);
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int opt = 0;

        Personagem character = null;

        while (opt != 2) {
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("Jogo Dim Luta!");
            System.out.println("1 - Create your character.");
            System.out.println("2 - Start play.");

            System.out.print("Choose your options:");
            opt = scanner.nextInt();
            switch (opt) {
                case 1:
                    System.out.println("Type your main character: ");
                    String name = scanner.next();
                    System.out.println("Type your life: ");
                    int life = scanner.nextInt();
                    while (life < 1 || life > 350) {
                        System.out.println("Invalid life, try again: ");
                        life = scanner.nextInt();
                    }
                    System.out.println("Type your attack: ");
                    int attack = scanner.nextInt();
                    while (attack < 1 || attack > 80) {
                        System.out.println("Invalid attack, try again: ");
                        attack = scanner.nextInt();
                    }
                    character = new Personagem(name, attack, life);
                    System.out.println("Name: " + name + ", Life: " + life + ", Attack: " + attack + ".");
                    break;

                case 2:
                    if (character == null){
                        System.out.println("Create your character first!");
                        break;
                    }
                    Scanner scanner2 = new Scanner(System.in);
                    String optionName;

                    System.out.println("Começou a luta!");

                    int option = 0;
                    while ((option != 3) && (enemy.getLife() > 0) && (character.getLife() > 0)) {
                        System.out.println("--------------------------------------------------------------------------------------");
                        System.out.println("Opção 1 - attack!");
                        System.out.println("Opção 2 - critical attack! (30%)");
                        System.out.println("Opção 3 - fugir!");
                        System.out.print("Escolha sua ação: ");
                        option = scanner.nextInt();
                        switch (option) {
                            case 1:
                                optionName = "attack!";
                                System.out.println("Attack!!");
                                System.out.println("--------------------------------------------------------------------------------------");

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
                                    System.out.println("");
                                }
                                break;
                            case 2:
                                optionName = "Crit!";
                                System.out.println("Ataque critico!");
                                System.out.println("--------------------------------------------------------------------------------------");

                                character.critDamage(enemy);
                                System.out.println("Vida do " + enemy.getName() + ": " + enemy.getLife());
                                System.out.println("--------------------------------------------------------------------------------------");
                                if (enemy.getLife() > 0) {
                                    enemy.doDamage(character);
                                    System.out.println("Vida do " + character.getName() + ": " + character.getLife());
                                }
                                if (enemy.getLife() <= 0 ){
                                    System.out.println(enemy.getName() + " morreu enquanto enfrentava o " + character.getName() + "!");
                                    System.out.println(character.getName() + " sobreviveu com " + character.getLife() + " de vida!");
                                }else if (character.getLife() <= 0){
                                    System.out.println(character.getName() + " morreu enquanto enfrentava o " + enemy.getName() + "!");
                                    System.out.println(enemy.getName() + "sobreviveu com " + enemy.getLife() + " de vida!");
                                }else{
                                    System.out.println("continuando");
                                }
                                break;
                            case 3:
                                optionName = "run!";
                                System.out.println(character.getName() + " fugiu do " + enemy.getName() + "!");
                                break;

                            default:
                                System.out.println("Invalid option!");
                        }
                    }
                    break;
                default:
                    System.out.println("Opção indisponivel.");
            }
        }

    }

}