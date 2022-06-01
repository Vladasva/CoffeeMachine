import java.util.Scanner;

public class CoffeeMachine {
    final static int waterEspresso = 250;
    final static int coffeeEspresso = 16;
    final static int priceEspresso = 4;
    final static int waterLatte = 350;
    final static int milkLatte = 75;
    final static int coffeeLatte = 20;
    final static int priceLatte = 7;
    final static int waterCappuccino = 200;
    final static int milkCappuccino = 100;
    final static int coffeeCappuccino = 12;
    final static int priceCappuccino = 6;

    final static Scanner scanner = new Scanner(System.in);
    States state;


    static int[] inventories = new int[5];

    public CoffeeMachine() {
        this.inventories = inventories;
        this.inventories[0] = 400;
        this.inventories[1] = 540;
        this.inventories[2] = 120;
        this.inventories[3] = 9;
        this.inventories[4] = 550;
        this.state = state;

    }

    public static void stateManager(States state) {

        switch (state) {
            case CHOOSING_A_COFFEE:
                buyCoffee(inventories);
                break;

            case FILLING_THE_MACHINE:
                fillMachine(inventories);
                break;

            case TAKING_MONEY:
                takeMoney(inventories);
                break;

            case  REMAINING:
                printInventories(inventories);
                break;
        }

    }
    public static void buyCoffee(int[] inventories) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String coffeeKind = scanner.next();

        switch (coffeeKind) {
            case "1":
                calculateIngredientsEspresso(inventories);
                break;

            case "2":
                calculateIngredientsLatte(inventories);
                break;

            case "3":
                calculateIngredientsCappuccino(inventories);
                break;

            case "back":
                break;

            default:
                break;
        }
    }

    public static void fillMachine(int[] inventories) {
        System.out.println("Write how many ml of water you want to add:");
        int water = scanner.nextInt();

        System.out.println("Write how many ml of milk you want to add:");
        int milk = scanner.nextInt();

        System.out.println("Write how many grams of coffee beans you want to add:");
        int coffee = scanner.nextInt();

        System.out.println("Write how many disposable cups of coffee you want to add:");
        int disposableCups = scanner.nextInt();

        inventories[0] += water;
        inventories[1] += milk;
        inventories[2] += coffee;
        inventories[3] += disposableCups;
    }

    public static void takeMoney(int[] inventories) {
        System.out.println("I gave you $" + inventories[4]);
        inventories[4] = 0;
    }

    public static void printInventories(int[] inventories) {
        System.out.println("The coffee machine has:");
        System.out.println(inventories[0] + " ml of water");
        System.out.println(inventories[1] + " ml of milk");
        System.out.println(inventories[2] + " g of coffee beans");
        System.out.println(inventories[3] + " disposable cups");
        System.out.println("$" + inventories[4] + " of money");
    }

    public static void calculateIngredientsEspresso(int[] inventories) {

        if (inventories[0] >= 0 && inventories[2] >= 0 && inventories[3] >= 0) {
            if (inventories[0] - waterEspresso >= 0
                    && inventories[2] - coffeeEspresso >= 0
                    && inventories[3] - 1 >= 0) {
                inventories[0] -= waterEspresso;
                inventories[2] -= coffeeEspresso;
                inventories[3] -= 1;
                inventories[4] += priceEspresso;
                System.out.println("I have enough resources, making you a coffee!");

            } else if (inventories[0] < waterEspresso
                    || inventories[2] < coffeeEspresso
                    || inventories[3] < 1) {

                if (inventories[0] <= inventories[2]) {
                    System.out.println("Sorry, not enough water!");
                } else if (inventories[2] <= inventories[0]) {
                    System.out.println("Sorry, not enough coffee!");
                } else if (inventories[3] < 1) {
                    System.out.println("Sorry, not enough disposable cups!");
                }
            }
        }
    }




    public static void calculateIngredientsLatte(int[] inventories) {

        if (inventories[0] >= 0 && inventories[1] >= 0 && inventories[2] >= 0 && inventories[3] >= 0) {
            if (inventories[0] - waterLatte >= 0
                    && inventories[1] - milkLatte >= 0
                    && inventories[2] - coffeeLatte >= 0
                    && inventories[3] - 1 >= 0) {
                inventories[0] -= waterLatte;
                inventories[1] -= milkLatte;
                inventories[2] -= coffeeLatte;
                inventories[3] -= 1;
                inventories[4] += priceLatte;
                System.out.println("I have enough resources, making you a coffee!");

            } else if (inventories[0] < waterLatte
                    || inventories[1] < milkLatte
                    || inventories[2] < coffeeLatte
                    || inventories[3] < 1) {

                if (inventories[0] <= inventories[1] && inventories[0] <= inventories[2]) {
                    System.out.println("Sorry, not enough water!");
                } else if (inventories[1] <= inventories[0] && inventories[1] <= inventories[2]) {
                    System.out.println("Sorry, not enough milk!");
                } else if (inventories[2] <= inventories[0] && inventories[2] <= inventories[1]) {
                    System.out.println("Sorry, not enough coffee!");
                } else if (inventories[3] < 1) {
                    System.out.println("Sorry, not enough disposable cups!");
                }
            }
        }
    }


    public static void calculateIngredientsCappuccino(int[] inventories) {

        if (inventories[0] >= 0 && inventories[1] >= 0 && inventories[2] >= 0 && inventories[3] >= 0) {
            if (inventories[0] - waterCappuccino >= 0
                    && inventories[1] - milkCappuccino >= 0
                    && inventories[2] - coffeeCappuccino >= 0
                    && inventories[3] - 1 >= 0) {
                inventories[0] -= waterCappuccino;
                inventories[1] -= milkCappuccino;
                inventories[2] -= coffeeCappuccino;
                inventories[3] -= 1;
                inventories[4] += priceCappuccino;
                System.out.println("I have enough resources, making you a coffee!");

            } else if (inventories[0] < waterCappuccino
                    || inventories[1] < milkCappuccino
                    || inventories[2] < coffeeCappuccino
                    || inventories[3] < 1) {

                if (inventories[0] <= inventories[1] && inventories[0] <= inventories[2]) {
                    System.out.println("Sorry, not enough water!");
                } else if (inventories[1] <= inventories[0] && inventories[1] <= inventories[2]) {
                    System.out.println("Sorry, not enough milk!");
                } else if (inventories[2] <= inventories[0] && inventories[2] <= inventories[1]) {
                    System.out.println("Sorry, not enough coffee!");
                } else if (inventories[3] < 1) {
                    System.out.println("Sorry, not enough disposable cups!");
                }
            }
        }
    }
}
