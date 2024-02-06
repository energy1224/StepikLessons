import java.util.Arrays;
import java.util.Scanner;

public class StackTask {

    public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            Stack stack = new Stack(scan.nextInt());
            int choice;
            char sim;
            while (true) {
                choice = scan.nextInt();
                switch (choice) {
                    case 1:
                        sim = scan.next().charAt(0);
                        stack.push(sim);
                        break;
                    case 2:
                        sim = stack.pop();
                        System.out.println("Извлечено: " + sim);
                        break;
                    case 3:
                        stack.print();
                        break;
                    case 4:
                        stack.clear();
                        break;
                    default:
                        return;
                }

            }

        }
    }

class Stack {
    char[] chars;

    public Stack(int num) {
        this.chars = new char[num];
    }

    void push(char c) {
        if(chars[0] !=0){
            System.out.println("Стек заполнен");
        }
            for (int i = chars.length-1; i >= 0; i--)
                if (chars[i] == 0) {
                    chars[i] = c;
                    break;
                }
    }

    @Override
    public String toString() {
        return "Stack{" +
                "chars=" + Arrays.toString(chars) +
                '}';
    }

    char pop() {
        char l = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[0] != 0) {
                l = chars[0];
                chars[0] = 0;
                break;
            }
        }
        return l;
    }

    void print() {
        for (char aChar : chars) {
            System.out.print(aChar + " ");
        }
    }

    void clear() {
        for (int i = 0; i < chars.length; i++) {
            chars[i] = 0;

        }
    }
}






//put your code here