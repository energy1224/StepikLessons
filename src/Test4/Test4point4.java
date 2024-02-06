package Test4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;
import static java.util.Arrays.sort;


public class Test4point4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int index = sc.nextInt();
        Purchase[] purchases = new Purchase[index];



        for (int i = 0; i < purchases.length; i++) {
            Purchase purchase = new Purchase();
            purchase.setName(sc.next());
            purchase.setPrice(Integer.parseInt(sc.next()));
            purchase.setVolume(Integer.parseInt(sc.next()));
            purchases[i]=purchase;
        }
        //sort(purchases);
        Arrays.sort(purchases);
        for (Purchase purchase : purchases) System.out.println(purchase);
        System.out.println();

        Arrays.sort(purchases, (o1, o2) -> o1.getName().compareTo(o2.getName()));

        for (Purchase purchase : purchases) {
            System.out.println(purchase);
        }










    }

}

class Purchase implements Comparable<Purchase> {
    private String name;
    private int price;

    private int volume;

    public Purchase(String name, int price, int volume) {
        this.name = name;
        this.price = price;
        this.volume = volume;
    }

    public Purchase() {
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

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Purchase purchase)) return false;
        return price == purchase.price && volume == purchase.volume && Objects.equals(name, purchase.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, volume);
    }

    @Override
    public int compareTo(Purchase o) {
        if (price * volume > o.volume * o.price) return 1;
        if (price * volume < o.volume * o.price) return -1;

            return 0;
    }


    @Override
    public String toString() {
        return name + " " + price +" " + volume + " "+ price*volume;

    }
}
