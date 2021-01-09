package BookManager.bean;

import BookManager.viewing.View;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Formatter;


/**
 * 书
 */
public class Book implements Serializable {
    private String name;
    private double price;
    LocalDate date;

    public Book(String name, double price, int year, int month, int day) {
        this.name = name;
        this.price = price;
        this.date = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(int year, int month, int day) {
        this.date = LocalDate.of(year, month, day);
    }

    public String toString(){
        return name+"\t"+price+"\t"+date.toString();
    }

    public void printBook(){
        System.out.printf("%-20.20s\t%5.2f\t%10s",name,price,date.toString()+"\n");
    }

    public static void main(String[] args) {
        Book book1 = new Book("if give me three day",19.99,1930,11,12);
        Book book2 = new Book("if give me",19.99,1930,11,12);
        Book book3 = new Book("if",19.99,1930,11,12);

        View view = new View();
        view.browse("按照升序排序");
        book1.printBook();
        book2.printBook();
        book3.printBook();

//        Formatter f = new Formatter(System.out);
//        f.format("%-15s %5.2f %10s \n",book1.getName(),book1.getPrice(), book1.getDate().toString());
//        f.format("%-15s %5.2f %10s \n",book2.getName(),book2.getPrice(), book2.getDate().toString());
//        f.format("%-15s %5.2f %10s \n",book3.getName(),book3.getPrice(), book3.getDate().toString());


    }


}
