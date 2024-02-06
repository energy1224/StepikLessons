package DogTask;

import java.util.Scanner;

public class DogTask  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            String[] lineArray = line.split(" ");
            Dog juchka = new Dog(lineArray[0],lineArray[1],lineArray[2],Double.parseDouble(lineArray[3]));
        String line2 = scanner.nextLine();
        String[] lineArray2 = line2.split(" ");
            Dog muhtar = new Dog(lineArray2[0],lineArray2[1],lineArray2[2],Double.parseDouble(lineArray2[3]));
        System.out.println(juchka);
        System.out.println(muhtar);

        System.out.println(juchka.compareTo(muhtar));

        int result = juchka.compareTo(muhtar);

        System.out.println(result);
    }
}
class Dog implements Comparable<Dog>{
   private String name;
  private   String breed;
private Collar collar;

    public Dog(String name, String breed, String colour, double size) {
        this.name = name;
        this.breed = breed;
        this.collar = new Collar(colour, size);
    }

    public Dog() {
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", collar=" + collar +
                '}';
    }

    @Override
    public int compareTo(Dog o) {
        if(collar.getSize()>o.collar.getSize())return 1;
        if(collar.getSize()<o.collar.getSize())return -1;
        return 0;
    }

   private class Collar {

    private String colour;
    private double size;

    public Collar(String colour, double size) {
        this.colour = colour;
        this.size = size;

    }

        @Override
        public String toString() {
            return "Collar{" +
                    "colour='" + colour + '\'' +
                    ", size=" + size +
                    '}';
        }

        public double getSize() {
            return size;
        }

//        @Override
//        public int compareTo(Collar o) {
//            if(this.getSize()>getSize())return 1;
//            if(this.getSize()<getSize())return -1;
//            return 0;
//        }
    }

}


