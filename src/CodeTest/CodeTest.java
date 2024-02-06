package CodeTest;

import java.util.ArrayList;
import java.util.Scanner;

public class CodeTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Purchase> list = new ArrayList<>();
        ArrayList<DiscountPurchase> list2 = new ArrayList<DiscountPurchase>();
        int type = scan.nextInt();  //читаем тип покупок, которые далее будут в списке
        scan.nextLine(); //очищаем буфер

        String buffer = scan.nextLine();
        while (!"end".equals(buffer)) {
            String[] data = buffer.split(" ");
            if (type == 1) {
                list.add(new Purchase(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2])));
            } else {
                list2.add(new DiscountPurchase(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3])));
            }
            buffer = scan.nextLine();
        }

        if (type == 1) {
            System.out.println("Total sum = " + getTotalSum(list));
        } else {
            System.out.println("Total sum = " + getTotalSum(list2));
        }
    }

    public static <T extends Purchase > int getTotalSum(ArrayList<T> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum +=  list.get(i).getCost();

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

