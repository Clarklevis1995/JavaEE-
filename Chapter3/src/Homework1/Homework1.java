package Homework1;

/*
编写Car类,游戏类，员工类+测试
 */
public class Homework1 {
    public static void main(String[] args) {
        Employee e1 = new Employee("Jack", "1001", 5000, 0.2);
        System.out.println(
                "员工姓名：" + e1.getName() + "\n" +
                        "员工号码：" + e1.geteNum() + "\n" +
                        "基本薪水：" + e1.getBaseSalary() + "\n" +
                        "薪水增长额："+e1.growth()+"\n"+
                        "工资总额："+e1.totalSalary()
        );
    }
}

class Car {
    String brand;
    String color;

    public Car() {
    }

    public void show() {
        System.out.println("Brand is: " + brand + ", Color is: " + color);
    }
}

class Game {
    String name;
    String type;
    int storage;
    int star;
    String introduction;

    public Game() {
    }

    public void getIntroduction() {
        System.out.println(introduction);
    }
}

class Employee {
    String name;
    String eNum;
    double baseSalary;
    double salaryGrowRate;

    public Employee(String name, String eNum, double baseSalary, double salaryGrowRate) {
        this.name = name;
        this.eNum = eNum;
        this.baseSalary = baseSalary;
        this.salaryGrowRate = salaryGrowRate;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public String geteNum() {
        return eNum;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double growth() {
        return baseSalary * salaryGrowRate;
    }

    public double totalSalary() {
        return baseSalary + growth();
    }
}
