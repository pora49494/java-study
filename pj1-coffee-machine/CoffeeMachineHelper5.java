package machine;
import java.util.Scanner;

class CoffeeMachineHelper5 {
    int water = 400;
    int milk = 540;
    int coffeeBean = 120;
    int cups = 9;
    int money = 550;
    Coffee espresso = new Coffee(250, 16, 0, 4);
    Coffee latte = new Coffee(350, 20, 75, 7);
    Coffee cappuccino = new Coffee(200, 12, 100, 6);

    public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String op = sc.next();
            if ("buy".equals(op)) {
                buy();
            } else if ("fill".equals(op)) {
                fill();
            } else if ("take".equals(op)) {
                take();
            } else if ("remaining".equals(op)) {
                remaining();
            } else if ("exit".equals(op)) {
                break;
            }
        }
    }
    private void remaining() {
        System.out.println("The coffee machine has: ");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBean + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println("$" + money + " of money");
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

    private void take() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    private void buy() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        String option = sc.next();
        switch (option) {
            case "1":
                espresso.buyCoffee(this);
                break;
            case "2":
                latte.buyCoffee(this);
                break;
            case "3":
                cappuccino.buyCoffee(this);
                break;
            default:
                break;
        }
    }
}

class Coffee {
    int neededWater;
    int neededBean;
    int neededMilk;
    int neededCup = 1;
    int price;

    public Coffee(int water, int bean, int milk, int price) {
        this.neededWater = water;
        this.neededBean = bean;
        this.neededMilk = milk;
        this.price = price;
    }

    boolean buyCoffee(CoffeeMachineHelper5 cm) {
        if (cm.water < neededWater) {
            System.out.println("Sorry, not enough water!");
            return false;
        } else if (cm.coffeeBean < neededBean) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        } else if (cm.milk < neededMilk) {
            System.out.println("Sorry, not enough milk!");
            return false;
        } else if (cm.cups < neededCup) {
            System.out.println("Sorry, not enough disposable cups!");
            return false;
        }
        System.out.println("I have enough resources, making you a coffee!");
        cm.money += price;
        cm.water -= neededWater;
        cm.milk -= neededMilk;
        cm.cups -= neededCup;
        cm.coffeeBean -= neededBean;
        return true;
    }
}
