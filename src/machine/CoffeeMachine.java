package machine;
import java.util.Scanner;

enum CoffeeMachineState{
    BYING, FILLING, TAKING, REMAINING, EXIT
}

public class CoffeeMachine {
    static CoffeeMachineState state = CoffeeMachineState.EXIT;
    static Scanner scanner = new Scanner(System.in);
    private static int water = 400;
    private static int milk = 540;
    private static int beans = 120;
    private static int disposableCups = 9;
    private static int money = 550;

    // reading input

    public static String inputReader() {
        return scanner.nextLine();
    }

    // buying coffee

    private static void buyEspresso(){
        if (water < 250) {
            System.out.println("Sorry, not enough water!");
        } else if (beans < 16) {
            System.out.println("Sorry, not enough beans!");
        }
        else {
            System.out.println("I have enough resources, making you a coffee!");
            water -= 250;
            beans -= 16;
            money += 4;
            disposableCups--;
        }
    }
    private static void buyLatte() {
        if (water < 350) {
            System.out.println("Sorry, not enough water!");
        } else if (milk < 75 ) {
            System.out.println("Sorry, not enough milk!");
        } else if (beans < 20) {
            System.out.println("Sorry, not enough beans!");
        }
        else {
            System.out.println("I have enough resources, making you a coffee!");
            water -= 350;
            milk -= 75;
            beans -= 20;
            money += 7;
            disposableCups--;
        }
    }
    private static void buyCappuccino() {
        if (water < 200) {
            System.out.println("Sorry, not enough water!");
        } else if (milk < 100) {
            System.out.println("Sorry, not enough milk!");
        } else if (beans < 12) {
            System.out.println("Sorry, not enough beans!");
        }
        else {
            System.out.println("I have enough resources, making you a coffee!");
            water -= 200;
            milk -= 100;
            beans -= 12;
            money += 6;
            disposableCups--;
        }
    }
    private static void buySwitchPanel() {
        System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        switch (inputReader()) {
            case "1":
                buyEspresso();
                System.out.println();
                break;
            case "2":
                buyLatte();
                System.out.println();
                break;
            case "3":
                buyCappuccino();
                System.out.println();
                break;
            case "back":
                break;
            default: {
                System.out.println("There is no such action!");
                break;
            }
        }
    }

    // filling resources

    private static void fillWater(int amount) {
        water += amount;
    }
    private static void fillMilk(int amount) {
        milk += amount;
    }
    private static void fillBeans(int amount) {
        beans += amount;
    }
    private static void fillDisposableCups(int amount) {
        disposableCups += amount;
    }
    private static void fillSwitchPanel() {
        System.out.print("Write how many ml of water do you want to add: ");
        fillWater(Integer.parseInt(inputReader()));

        System.out.print("Write how many ml of milk do you want to add: ");
        fillMilk(Integer.parseInt(inputReader()));

        System.out.print("Write how many grams of coffee beans do you want to add: ");
        fillBeans(Integer.parseInt(inputReader()));

        System.out.print("Write how many disposable cups of coffee do you want to add ");
        fillDisposableCups(Integer.parseInt(inputReader()));
    }

    // taking money

    private static void takeMoney() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    // remaining

    private static String getWaterStatus() {
        return water + " of water";
    }
    private static String getMilkStatus() {
        return  milk + " of milk";
    }
    private static String getBeansStatus() {
        return beans + " of coffee beans";
    }
    private static String getDisposableCupsStatus() {
        return disposableCups + " of disposable cups";
    }
    private static String getMoneyStatus() {
        return  money + " of money";
    }
    public static void getStatus() {
        System.out.println("The coffee machine has:");
        System.out.println(getWaterStatus());
        System.out.println(getMilkStatus());
        System.out.println(getBeansStatus());
        System.out.println(getDisposableCupsStatus());
        System.out.println(getMoneyStatus());
        System.out.println();
    }


    private static void stateSwitcher() {

        System.out.println("Write action (buy, fill, take, remaining, exit):");

        switch (inputReader()) {
            case "buy":
                state = CoffeeMachineState.BYING;
                break;
            case "fill":
                state = CoffeeMachineState.FILLING;
                break;
            case "take":
                state = CoffeeMachineState.TAKING;
                break;
            case "remaining":
                state = CoffeeMachineState.REMAINING;
                getStatus();
                break;
            case "exit":
                state = CoffeeMachineState.EXIT;
                break;
            default: {
                System.out.println("There is no such action!");
                state = CoffeeMachineState.EXIT;
                break;
            }
        }
    }

    public static void mainMenu (){
        do {
            stateSwitcher();

            switch (state) {
                case BYING:
                    buySwitchPanel();
                    break;
                case FILLING:
                    fillSwitchPanel();
                    break;
                case TAKING:
                    takeMoney();
                    break;
                case REMAINING:

                case EXIT:
                    break;
                default: {
                    break;
                }
            }
        } while (state != CoffeeMachineState.EXIT);
    }

    public static void main(String[] args) {
        CoffeeMachine.mainMenu();
    }
}

