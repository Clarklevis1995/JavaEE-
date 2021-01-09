import java.util.Formatter;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2020-12-30 08:30
 **/
public class Receipt {
    private double total = 0;
    private Formatter f = new Formatter(System.out);

    public void printTitle() {
        f.format("%-15s %5s %10s\n","Item","Qty","Price");
        f.format("%-15s %5s %10s\n","---","---","-----");
    }


    public void print(String name,int qty,double price) {
        //%-15.15s：字符串左对齐，最小长度为15，最大长度也为15
        //%10.2f：最小长度为10,其中小数占两位
        f.format("%-15.15s %5d %10.2f\n",name,qty,price);
        total += price;
    }

    public void printTotal() {
        f.format("%-15s %5s %10.2f\n","Tax","",total*0.06);
        f.format("%-15s %5s %10s\n","","","-----");
        f.format("%-15s %5s %10.2f\n","Total","",total*1.06);
    }

    public static void main(String[] args) {
        Receipt receipt = new Receipt();
        receipt.printTitle();
        receipt.print("Jack's Magic Beans",4, 4.25);
        receipt.print("Princess Peas",3, 5.1);
        receipt.print("Three Bears Porridge",1,14.29);
        receipt.printTotal();
    }
}
