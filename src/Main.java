import java.util.Scanner;

public class Main {
    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        menu();
    }

    public static void menu() {
        boolean flag = true;

        States choosingACoffee = States.CHOOSING_A_COFFEE;
        States fillingMachine = States.FILLING_THE_MACHINE;
        States takeMoney = States.TAKING_MONEY;
        States remaining =  States.REMAINING;

        CoffeeMachine coffeeMachine = new CoffeeMachine();

        while (flag) {

            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.next();

            switch (action) {
                case "buy":
                    System.out.println();
                    coffeeMachine.stateManager(choosingACoffee);
                    System.out.println();
                    break;

                case "fill":
                    System.out.println();
                    coffeeMachine.stateManager(fillingMachine);
                    System.out.println();
                    break;

                case "take":
                    System.out.println();
                    coffeeMachine.stateManager(takeMoney);
                    System.out.println();
                    break;

                case "remaining":
                    System.out.println();
                    coffeeMachine.stateManager(remaining);
                    System.out.println();
                    break;

                case "exit":
                    flag = false;
                    break;

                default:
                    break;
            }
        }
    }
}
