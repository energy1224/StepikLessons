import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.Flow;

public class TaskCommodity {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int index = scan.nextInt();
        Purchase[] purchases = new Purchase[index];
        double discont = scan.nextDouble();
        FlowDiscountPurchase.setDiscount(discont);
        FixDiscountPurchase.setDiscount(discont);
        int minValue = scan.nextInt();
        FlowDiscountPurchase.setMinAmount(minValue);
        for (int i = 0; i < purchases.length; i++) {
            int purshase = scan.nextInt();
            if (purshase == 1) {
                purchases[i] = new Purchase();
            } else if (purshase == 3) {
                purchases[i] = new FlowDiscountPurchase();
            } else {
                purchases[i] = new FixDiscountPurchase();
            }
            Commodity commodity = new Commodity();
            commodity.setName(scan.next());
            commodity.setPrice(scan.nextInt());
            purchases[i].setCommodity(commodity);
            purchases[i].setAmount(scan.nextInt());

        }
        System.out.println(discont);
        int x= (int) discont;
        System.out.println(x);

        for (int i = 0; i < purchases.length; i++) {
            System.out.println(purchases[i]);

        }




    }


}


class Commodity {
    private String name;
    private int price;

    public Commodity() {
    }

    public Commodity(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Commodity commodity)) return false;
        return price == commodity.price && Objects.equals(name, commodity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + ";" + price;
    }

    public void show() {
        System.out.println(
                "Наименование товара: " + name + "\n" +
                        "Цена товара: " + price);
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
}

class Purchase {
    private Commodity commodity;
    private int amount;

    public int getCost() {
        return amount * commodity.getPrice();
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Purchase() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Purchase purchase)) return false;
        return Objects.equals(commodity, purchase.commodity);

    }

    @Override
    public int hashCode() {
        return Objects.hash(commodity, amount);
    }

    public Purchase(Commodity commodity, int amount) {
        this.commodity = commodity;
        this.amount = amount;
    }

    public Purchase(Commodity commodity) {
        this.commodity = commodity;
    }

    @Override
    public String toString() {
        return commodity.toString() + ";" + amount + ";" + getCost();
    }

    public void show() {
        commodity.show();
        System.out.println(
                "Количество: " + amount + "\n" +
                        "Стоимость покупки: " + getCost());
    }
}

class FixDiscountPurchase extends Purchase {
    private static double discount;

    public FixDiscountPurchase(Commodity commodity, int amount) {
        super(commodity, amount);
    }

    public FixDiscountPurchase() {
    }

    public static double getDiscount() {
        return discount;
    }

    public static void setDiscount(double discount) {
        FixDiscountPurchase.discount = discount;
    }

    @Override
    public int getCost() {
        double discount = FixDiscountPurchase.discount * super.getCost();
        int x = (int)discount;
        return super.getCost()-x;
    }

    @Override
    public String toString() {
        return getCommodity().toString() + ";" + getAmount() + ";" + getDiscount() + ";" + getCost();
    }
}

class FlowDiscountPurchase extends Purchase {

    private static double discount;
    private static int minAmount;

    public FlowDiscountPurchase(Commodity commodity, int amount) {
        super(commodity, amount);
    }

    public FlowDiscountPurchase() {
    }

    public static double getDiscount() {
        return discount;
    }

    public static void setDiscount(double discount) {
        FlowDiscountPurchase.discount = discount;
    }

    public static int getMinAmount() {
        return minAmount;
    }

    public static void setMinAmount(int minAmount) {
        FlowDiscountPurchase.minAmount = minAmount;
    }

    @Override
    public int getCost() {
        //  int disc;
        if (minAmount < getAmount()) {
            return super.getCost();
        } else {
            double discount = FlowDiscountPurchase.discount * super.getCost();
            int x = (int) discount;
            return super.getCost() - x;
            // disc = super.getCost()-((int) FlowDiscountPurchase.getDiscount() * super.getCost());


        }
    }

    @Override
    public String toString() {
        return getCommodity().toString() + ";" + getAmount() + ";" + getDiscount() + ";" + getMinAmount() + ";" + getCost();

    }
}
