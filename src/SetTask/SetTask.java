package SetTask;

import java.sql.Array;
import java.util.Objects;
import java.util.Scanner;

public class SetTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        MySet<SetPurchase> set = new MySet<SetPurchase>(3);

        String buffer = scan.nextLine();
        while (!"end".equals(buffer)) {
            String[] parts = buffer.split(" "); //разделяем на слова
            set.add(new SetPurchase(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
            buffer = scan.nextLine();
        }

        set.print();


    }
}

class Purchase {
    //put your code here
}

class MySet<E> {
    private E[] list;

    public MySet(int n) {
        //  list= new E[10];
        list = (E[]) new Object[10];
    }

    public MySet() {
        list = (E[]) new Object[10];
    }

    void add(E e) {
        if (e == null) throw new IllegalArgumentException("e not null");
        if (list[list.length - 1] != null) {
            E[] tmp = (E[]) new Object[list.length / 2 + list.length + 1];
            for (int i = 0; i < list.length; i++) {
                tmp[i] = list[i];
            }
            list = tmp;

        }
        if (list[0] == null) {
            list[0] = e;
            return;
        }
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                if (list[i].equals(e)) break;
            } else {
                list[i] = e;
                break;
            }

        }
    }


void print() {
    for (E e : list) {
        if(e!=null)
        System.out.println(e);
    }


}
}

class SetPurchase {

    private String name;
    private int price;

    private int amount;

    public SetPurchase(String name, int price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return name + ";" + price + ";" + amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SetPurchase that)) return false;
        return price == that.price && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, amount);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
