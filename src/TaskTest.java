public class TaskTest {
    public static void main(String[] args) {
        Test item1 = new Test(1,34);
        System.out.println();
        Test item2 = new Test(2,18);

    }
}

class Test{
    {
        System.out.println("Логический блок 1");
        System.out.println("a = " + a + " b= " + b + " id= " + this.id + " age= " +this.age);
    }

    //статический блок
    static {
        System.out.println("Статический блок 1");
    }

    //статические поля
    static int a = 3;
    static int b;

    //поля экземпляра
    private int id = 7;
    private int age;

    public Test(int id, int age) {
        this.id = id;
        this.age = age;
        System.out.println("Конструктор");
        System.out.println("a = " + a + " b = " + b + " id = " + this.id + " age = " +this.age);
    }

    static void method() { //статический метод
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    //статический блок
    static {
        System.out.println("Статический блок 2 начало");
        System.out.println("a = " + a + " b = " + b );
        b=a*4;
        System.out.println("Статический блок 2 конец");
        System.out.println("a = " + a + " b = " + b );
    }

    //нестатический блок - плохое расположение
    {
        System.out.println("Логический блок 2");
        System.out.println("a = " + a + " b = " + b + " id = " + this.id + " age = " +this.age);
    }
}