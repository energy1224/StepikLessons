package EmployeeTask;

import java.util.Scanner;

public class EmployeeTask {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int index = scan.nextInt();
        if (index <= 0) {
            System.out.println("ERROR");
        } else {
            Employee[] employees = new Employee[index];
            for (int i = 0; i < employees.length; i++) {
                employees[i] = new Employee();
                employees[i].setSurname(scan.next());
                employees[i].setSex(scan.next());
                employees[i].setAge(scan.nextInt());
                employees[i].setSalary(scan.nextInt());
                if (employees[i].isPensioner()) employees[i].changeSalary(90000);
            }
            for (Employee e: employees) {
                e.show();
            }
        }

    }
}

class Employee {
    private String surname;
    private String sex;
    private int age;
    private int salary;

    public Employee(String surname, String sex, int age, int salary) {
        this.surname = surname;
        this.sex = sex;
        this.age = age;
        this.salary = salary;
    }
    public Employee() {
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public boolean isPensioner() {
        if (sex.equals("male")) return age > 63;
        else return age > 58;
    }
    public void changeSalary(double koef) {
        salary *=koef;
    }

    public void show() {
        System.out.println(surname + ";" + sex + ";" + age + ";" + salary);

    }
}
class Programmer extends Employee{

    System status;

    String specialization;





}
