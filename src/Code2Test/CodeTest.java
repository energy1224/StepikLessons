package Code2Test;

import java.util.ArrayList;
import java.util.Scanner;

public class CodeTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Purchase> list = new ArrayList<>();
        String buffer = scan.nextLine();
        while (!"end".equals(buffer)) {
            String[] data = buffer.split(" ");
            if (Integer.parseInt(data[0]) == 1) {
                list.add(new Purchase(data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3])));
            } else {
                list.add(new DiscountPurchase(data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4])));
            }
            buffer = scan.nextLine();
        }

            System.out.println("Total sum = " + getTotalSum(list));

    }

    public static <T extends Purchase> int getTotalSum(ArrayList<T> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
                sum += list.get(i).getCost();
            }

            return sum;

        }
    }


class Purchase {
    private String name;
    private int price;
    private int number;

    public Purchase(String name, int price, int number) {
        this.name = name;
        this.price = price;
        this.number = number;
    }

    public Purchase() {
    }

    int getCost() {
        return price * number;
    }
}

class DiscountPurchase extends Purchase {
    private int discount;

    public DiscountPurchase(String name, int price, int number, int discount) {
        super(name, price, number);
        this.discount = discount;
    }

    public DiscountPurchase() {
        this.discount = 0;
    }

    @Override
    int getCost() {
        return super.getCost() - super.getCost() * discount / 100;
    }
}

