package machine;
import java.util.Scanner;

class CoffeeMachineHelper4 {
    private int water = 400;
    private int milk = 540;
    private int coffeeBean = 120;
    private int cups = 9;
    private int money = 550;

    public void run() {
        summary();
        Scanner sc = new Scanner(System.in);
        String op = sc.next();
        if ("buy".equals(op)) {
            buy();
        } else if ("fill".equals(op)) {
            fill();
        } else if ("take".equals(op)) {
            take();
        }
        summary();
    }
    private void summary() {
        System.out.println("The coffee machine has: ");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBean + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
    }

    private void fill() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add: ");
        water += sc.nextInt();
        System.out.println("Write how many ml of milk do you want to add: ");
        milk += sc.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        coffeeBean += sc.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        cups += sc.nextInt();
    }

    private int take() {
        int returnMoney = money;
        money = 0;
        return returnMoney;
    }

    private void buy() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        int option = sc.nextInt();
        cups -= 1;
        switch (option) {
            case 1:
                water -= 250;
                coffeeBean -= 16;
                money += 4;
                break;
            case 2:
                water -= 350;
                milk -= 75;
                coffeeBean -= 20;
                money += 7;
                break;
            case 3:
                water -= 200;
                milk -= 100;
                coffeeBean -= 12;
                money += 6;
                break;
            default:
                break;
        }
    }
}